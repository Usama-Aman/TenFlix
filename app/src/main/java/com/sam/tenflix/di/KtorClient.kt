package com.sam.tenflix.di

import android.util.Log
import com.sam.tenflix.BuildConfig
import com.sam.tenflix.common.Constants
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Inject

class KtorClient @Inject constructor() {

    companion object {
        private const val TIME_OUT = 10_000
        private const val TAG_KTOR_LOGGER = "ktor_logger:"
        private const val TAG_HTTP_STATUS_LOGGER = "http_status:"
    }

    fun getHttpClient() = HttpClient(Android) {
        install(DefaultRequest) {
            url(Constants.BASE_URL)
            accept(ContentType.Application.Json)
            contentType(ContentType.Application.Json)
            header("api-key", BuildConfig.API_KEY)
            header(
                HttpHeaders.Authorization,
                "Bearer ${BuildConfig.TOKEN}"
            )
        }

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Log.i("HttpClient", message)
                }
            }
        }
        install(ContentNegotiation) {
            json()
        }

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }


//            install(Auth) {
//                bearer {
//                    refreshTokens {
//                        val token = client.get {
//                            markAsRefreshTokenRequest()
//                            url("refreshToken")
//                            parameter("refreshToken", localService.getRefreshToken())
//                        }.body<Token>()
//                        BearerTokens(
//                            accessToken = token.bearerToken,
//                            refreshToken = token.refreshToken
//                        )
//                    }
//                }
//            }
    }


}