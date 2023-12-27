package com.sam.tenflix.domain.use_case

import com.sam.tenflix.common.NetworkResource
import com.sam.tenflix.data.remote.mapper.toMovies
import com.sam.tenflix.domain.model.MoviesModel
import com.sam.tenflix.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {


    operator fun invoke(): Flow<NetworkResource<List<MoviesModel>>> = flow {
        emit(NetworkResource.Loading())

        try {

            val movies = moviesRepository.getPopularMovies().results.map { it.toMovies() }
            emit(NetworkResource.Success(movies))

        } catch (e: Exception) {
            e.printStackTrace()
            emit(NetworkResource.Error(e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(NetworkResource.Error(it.localizedMessage))
        }
}