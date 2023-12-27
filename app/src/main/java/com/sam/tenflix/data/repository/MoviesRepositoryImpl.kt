package com.sam.tenflix.data.repository

import com.sam.tenflix.common.Constants
import com.sam.tenflix.data.remote.dto.MovieDetailDTO
import com.sam.tenflix.data.remote.dto.MoviesResponseDTO
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
        const val POPULAR_MOVIES_URL = "${Constants.BASE_URL}/popular"
        const val TOP_RATED_MOVIES_URL = "${Constants.BASE_URL}/top_rated"
        const val MOVIE_DETAIL_URL = Constants.BASE_URL
    }

    override suspend fun getNowPlayingMovies(): MoviesResponseDTO {
        return httpClient.get(NOW_PLAYING_MOVIES_URL).body()
    }

    override suspend fun getPopularMovies(): MoviesResponseDTO {
        return httpClient.get(POPULAR_MOVIES_URL).body()
    }

    override suspend fun getTopRatedMovies(): MoviesResponseDTO {
        return httpClient.get(TOP_RATED_MOVIES_URL).body()
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailDTO {
        return httpClient.get("${MOVIE_DETAIL_URL}/$movieId").body()
    }


}