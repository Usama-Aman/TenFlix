package com.sam.tenflix.di

import com.sam.tenflix.domain.repository.MoviesRepository
import com.sam.tenflix.domain.use_case.MovieDetailUseCase
import com.sam.tenflix.domain.use_case.NowPlayingMoviesUseCase
import com.sam.tenflix.domain.use_case.PopularMoviesUseCase
import com.sam.tenflix.domain.use_case.TopRatedMoviesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun bindsNowPlayingMoviesUseCase(moviesRepository: MoviesRepository) = NowPlayingMoviesUseCase(moviesRepository)

    @Provides
    fun bindsPopularMoviesUseCase(moviesRepository: MoviesRepository) = PopularMoviesUseCase(moviesRepository)

    @Provides
    fun bindsTopRatedMoviesUseCase(moviesRepository: MoviesRepository) = TopRatedMoviesUseCase(moviesRepository)

    @Provides
    fun bindsMovieDetailUseCase(moviesRepository: MoviesRepository) = MovieDetailUseCase(moviesRepository)

}