package com.sam.tenflix.data.repository

import com.sam.tenflix.common.Constants
import com.sam.tenflix.data.remote.dto.NowPlayingMoviesDTO
import com.sam.tenflix.domain.repository.MoviesRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : MoviesRepository {

    companion object {
        const val NOW_PLAYING_MOVIES_URL = "${Constants.BASE_URL}/now_playing"
    }

    override suspend fun getCurrentMovies(): NowPlayingMoviesDTO {
        return httpClient.get(NOW_PLAYING_MOVIES_URL).body()
    }


}