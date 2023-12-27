package com.sam.tenflix.domain.repository

import com.sam.tenflix.data.remote.dto.MovieDetailDTO
import com.sam.tenflix.data.remote.dto.MoviesResponseDTO

interface MoviesRepository {

    suspend fun getNowPlayingMovies(): MoviesResponseDTO
    suspend fun getPopularMovies(): MoviesResponseDTO
    suspend fun getTopRatedMovies(): MoviesResponseDTO
    suspend fun getMovieDetail(movieId: Int): MovieDetailDTO


}