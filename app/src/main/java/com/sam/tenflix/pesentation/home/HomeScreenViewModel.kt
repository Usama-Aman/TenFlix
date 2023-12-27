package com.sam.tenflix.pesentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sam.tenflix.common.NetworkResource
import com.sam.tenflix.domain.model.MoviesModel
import com.sam.tenflix.domain.use_case.NowPlayingMoviesUseCase
import com.sam.tenflix.domain.use_case.PopularMoviesUseCase
import com.sam.tenflix.domain.use_case.TopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val nowPlayingMoviesUseCase: NowPlayingMoviesUseCase,
    private val popularMoviesUseCase: PopularMoviesUseCase,
    private val topRatedMoviesUseCase: TopRatedMoviesUseCase,
) : ViewModel() {

    data class MoviesState(
        var movies: List<MoviesModel> = listOf(),
        var isLoading: Boolean = false,
        var errorMessage: String = ""
    )

    var nowPlayingState = MutableStateFlow(MoviesState())
        private set

    var popularMoviesState = MutableStateFlow(MoviesState())
        private set

    var topRatedMoviesState = MutableStateFlow(MoviesState())
        private set


    init {
        getPopularMovies()
        getNowPlayingMovies()
        getTopRatedMovies()
    }

    private fun getNowPlayingMovies() {
        nowPlayingMoviesUseCase().onEach {
            when (it) {
                is NetworkResource.Success -> {
                    if (it.data != null)
                        nowPlayingState.update { state ->
                            state.copy(
                                movies = it.data,
                                isLoading = false
                            )
                        }
                }

                is NetworkResource.Error -> {
                    nowPlayingState.update { state ->
                        state.copy(
                            errorMessage = it.error ?: "",
                            isLoading = false
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

    private fun getPopularMovies() {
        popularMoviesUseCase().onEach {
            when (it) {
                is NetworkResource.Success -> {
                    if (it.data != null)
                        popularMoviesState.update { state ->
                            state.copy(
                                movies = it.data,
                                isLoading = false
                            )
                        }
                }

                is NetworkResource.Error -> {
                    popularMoviesState.update { state ->
                        state.copy(
                            errorMessage = it.error ?: "",
                            isLoading = false
                        )
                    }
                }

                is NetworkResource.Loading -> {
                    popularMoviesState.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getTopRatedMovies() {
        topRatedMoviesUseCase().onEach {
            when (it) {
                is NetworkResource.Success -> {
                    if (it.data != null)
                        topRatedMoviesState.update { state ->
                            state.copy(
                                movies = it.data,
                                isLoading = false
                            )
                        }
                }

                is NetworkResource.Error -> {
                    topRatedMoviesState.update { state ->
                        state.copy(
                            errorMessage = it.error ?: "",
                            isLoading = false
                        )
                    }
                }

                is NetworkResource.Loading -> {
                    topRatedMoviesState.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }



}