package com.sam.tenflix.di

import com.sam.tenflix.BuildConfig
import com.sam.tenflix.common.Constants
import com.sam.tenflix.data.repository.MoviesRepositoryImpl
import com.sam.tenflix.domain.repository.MoviesRepository
import com.sam.tenflix.domain.use_case.NowPlayingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideClient(): HttpClient = HttpClient() {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(DefaultRequest) {
            url(Constants.BASE_URL)
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header("X-Api-Key", BuildConfig.API_KEY)
        }
        install(ContentNegotiation) {
            json(Json)
        }

//        install(JsonFeature) {
//            serializer = KotlinSerializer(kotlinx.serialization.json.Json {
//                prettyPrint = true
//                isLenient = true
//                ignoreUnknownKeys = true
//            })
//
//            engine {
//                connectTimeout = TIME_OUT
//                socketTimeout = TIME_OUT
//            }
//        }

//        install(Logging) {
//            logger = object : Logger {
//                override fun log(message: String) {
//                    Log.v(TAG_KTOR_LOGGER, message)
//                }
//
//            }
//            level = LogLevel.ALL
//        }
//
//        install(ResponseObserver) {
//            onResponse { response ->
//                Log.d(TAG_HTTP_STATUS_LOGGER, "${response.status.value}")
//            }
//        }
    }


    companion object {
        private const val TIME_OUT = 10_000
        private const val TAG_KTOR_LOGGER = "ktor_logger:"
        private const val TAG_HTTP_STATUS_LOGGER = "http_status:"
    }


    @Provides
    @Singleton
    fun provideMoviesRepository(httpClient: HttpClient): MoviesRepository = MoviesRepositoryImpl(httpClient)

    @Provides
    @Singleton
    fun providesNowPlayingUseCase(moviesRepository: MoviesRepository) = NowPlayingMoviesUseCase(moviesRepository)
}