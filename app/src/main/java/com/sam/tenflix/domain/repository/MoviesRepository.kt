package com.sam.tenflix.domain.repository

import com.sam.tenflix.data.remote.dto.NowPlayingMoviesDTO

interface MoviesRepository {

    suspend fun getCurrentMovies(): NowPlayingMoviesDTO


}