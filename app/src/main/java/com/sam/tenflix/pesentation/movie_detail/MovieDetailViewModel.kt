package com.sam.tenflix.pesentation.movie_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sam.tenflix.common.NetworkResource
import com.sam.tenflix.domain.model.MovieDetail
import com.sam.tenflix.domain.use_case.MovieDetailUseCase
import com.sam.tenflix.pesentation.navigation.MOVIE_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val movieDetailUseCase: MovieDetailUseCase
) : ViewModel() {

    data class MovieDetailUIState(
        var isLoading: Boolean = false,
        var movieDetail: MovieDetail = MovieDetail(),
        var errorMessage: String = ""
    )

    private val movieId: Int = checkNotNull(savedStateHandle[MOVIE_ID])

    var movieDetailState = MutableStateFlow(MovieDetailUIState())
        private set


    init {
        getMovieDetail()
    }


    private fun getMovieDetail() {
        movieDetailUseCase(movieId = movieId).onEach {
            when (it) {
                is NetworkResource.Success -> {
                    if (it.data != null)
                        movieDetailState.update { state ->
                            state.copy(
                                movieDetail = it.data,
                                isLoading = false
                            )
                        }
                }

                is NetworkResource.Error -> {
                    movieDetailState.update { state ->
                        state.copy(
                            errorMessage = it.error ?: "",
                            isLoading = false
                        )
                    }
                }

                is NetworkResource.Loading -> {
                    movieDetailState.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}