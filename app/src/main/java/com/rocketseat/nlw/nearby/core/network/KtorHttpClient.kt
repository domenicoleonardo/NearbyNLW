package com.rocketseat.nlw.nearby.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//vai permitir construir clientes http dentro de Kotlin
object KtorHttpClient {
    private const val NETWORK_TIMEOUT = 5_000L

    val httpClientAndroid by lazy { //No momento da chamada dessa referência, é que essa primeira instância será definida
        HttpClient(Android) {
            install(ContentNegotiation) { //definir o formato de conteúdos
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        useAlternativeNames = true
                        ignoreUnknownKeys = true //se vier chave não mapeada, ignorar
                        explicitNulls = true
                        useArrayPolymorphism = true
                        encodeDefaults = false

                    }

                )

            }

            install(HttpTimeout) {
                requestTimeoutMillis = NETWORK_TIMEOUT
                connectTimeoutMillis = NETWORK_TIMEOUT
                socketTimeoutMillis = NETWORK_TIMEOUT

            }

            install(Logging) {
                level = LogLevel.ALL

            }


        }

    }

}