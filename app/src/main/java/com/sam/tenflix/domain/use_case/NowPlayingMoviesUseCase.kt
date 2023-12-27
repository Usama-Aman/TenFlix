package com.sam.tenflix.domain.use_case

import com.sam.tenflix.common.NetworkResource
import com.sam.tenflix.data.remote.dto.toMovies
import com.sam.tenflix.domain.model.MoviesModel
import com.sam.tenflix.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NowPlayingMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {

    operator fun invoke(): Flow<NetworkResource<List<MoviesModel>>> = flow {
        emit(NetworkResource.Loading())

        try {

            val movies = moviesRepository.getCurrentMovies().results.map { it.toMovies() }
            emit(NetworkResource.Success(movies))

        } catch (e: Exception) {
            e.printStackTrace()
            emit(NetworkResource.Error(e.localizedMessage))
        }
    }

}