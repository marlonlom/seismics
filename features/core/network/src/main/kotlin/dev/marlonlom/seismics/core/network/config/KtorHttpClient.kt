/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.config

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Defines the timeout value for network connections and socket operations in milliseconds.
 *
 * This constant is set to 60,000 milliseconds, which is equivalent to 1 minute.
 * @author marlonlom
 */
private const val TIME_OUT = 60_000

/**
 * Configures and provides a Ktor HttpClient instance for Android.
 *
 * This client is configured with the following features:
 * - Content negotiation using JSON with lenient parsing, ignoring unknown keys, pretty printing, and disabling default encoding.
 * - Connection and socket timeouts set to [TIME_OUT].
 * - Response status logging to Logcat with tag "HTTP status:".
 * - Default request header setting Content-Type to application/json.
 *
 * @return A configured HttpClient instance.
 * @author marlonlom
 */
internal val ktorHttpClient = HttpClient(Android) {

  install(ContentNegotiation) {
    json(
      Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
        encodeDefaults = false
      },
    )
  }

  engine {
    connectTimeout = TIME_OUT
    socketTimeout = TIME_OUT
  }

  install(ResponseObserver) {
    onResponse { response ->
      Log.d("ktorHttpClient", "HTTP status: ${response.status.value}")
    }
  }

  install(DefaultRequest) {
    header(HttpHeaders.ContentType, ContentType.Application.Json)
  }
}
