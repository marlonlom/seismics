/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

import dev.marlonlom.seismics.core.network.config.UsgsEarthquakesApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ByteReadChannel
import kotlinx.serialization.json.Json

/**
 * A singleton object that provides a mock implementation of the USGS Earthquakes API.
 *
 * This object is intended for testing or mocking purposes, where the real API calls
 * are not needed. It provides a method to convert a given JSON string into an instance
 * of the `UsgsEarthquakesApi`.
 *
 * @author marlonlom
 */
internal object MockUsgsEarthquakesApiProvider {

  /**
   * Provides a mock instance of the `UsgsEarthquakesApi` by parsing the given JSON string.
   *
   * This method can be used to simulate responses from the USGS Earthquakes API
   * based on the provided JSON input.
   *
   * @param jsonText A JSON string representing the earthquake data to be mocked.
   * @return An instance of [UsgsEarthquakesApi] that is generated from the provided JSON string.
   */
  fun provide(jsonText: String): UsgsEarthquakesApi {
    val mockEngine = MockEngine { _ ->
      respond(
        content = ByteReadChannel(jsonText),
        status = HttpStatusCode.OK,
        headers = headersOf(HttpHeaders.ContentType, "application/json"),
      )
    }

    val httpClient = HttpClient(mockEngine) {
      install(ContentNegotiation) {
        json(
          Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
          },
        )
      }
    }

    return UsgsEarthquakesApi(
      baseUrl = "https://seismicis.example.org/query",
      httpClient = httpClient,
    )
  }
}
