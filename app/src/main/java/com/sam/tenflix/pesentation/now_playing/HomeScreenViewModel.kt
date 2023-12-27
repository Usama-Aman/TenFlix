package com.sam.tenflix.pesentation.now_playing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sam.tenflix.common.NetworkResource
import com.sam.tenflix.domain.model.MoviesModel
import com.sam.tenflix.domain.use_case.NowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val nowPlayingMoviesUseCase: NowPlayingMoviesUseCase
) : ViewModel() {

    data class NowPlayingState(
        var movies: List<MoviesModel> = listOf(),
        var isLoading: Boolean = false,
        var errorMessage: String = ""
    )

    var nowPlayingState = MutableStateFlow(NowPlayingState())
        private set

    init {
        getNowPlayingMovies()
    }

    private fun getNowPlayingMovies() {
        nowPlayingMoviesUseCase().onEach {
            when (it) {
                is NetworkResource.Success -> {
                    if (it.data != null)
                        nowPlayingState.update { state ->
                            state.copy(
                                movies = it.data
                            )
                        }
                }

                is NetworkResource.Error -> {
                    nowPlayingState.update { state ->
                        state.copy(
                            errorMessage = it.error ?: ""
                        )
                    }
                }

                is NetworkResource.Loading -> {
                    nowPlayingState.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


}