package com.sam.tenflix.di

import android.util.Log
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
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideKtorClient(ktorClient: KtorClient): HttpClient = ktorClient.getHttpClient()


    @Provides
    @Singleton
    fun provideMoviesRepository(httpClient: HttpClient): MoviesRepository = MoviesRepositoryImpl(httpClient)

}