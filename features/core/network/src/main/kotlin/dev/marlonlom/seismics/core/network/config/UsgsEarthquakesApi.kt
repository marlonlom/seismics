/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.config

import dev.marlonlom.seismics.core.network.response.EarthquakesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * A class for interacting with the USGS Earthquakes API.
 *
 * This class provides methods to fetch earthquake data from the USGS API.
 *
 * @property baseUrl The base URL of the USGS Earthquakes API.
 * @property httpClient The HttpClient used for making HTTP requests. Defaults to [ktorHttpClient].
 */
class UsgsEarthquakesApi(private val baseUrl: String, private val httpClient: HttpClient = ktorHttpClient) {

  /**
   * Performs a query to retrieve the latest earthquakes.
   *
   * @return An instance of EarthquakesResponse containing the query results.
   */
  suspend fun getLatestEarthquakes(): EarthquakesResponse = usgsDailyEarthquakesQuery(baseUrl) {
    duringToday()
  }.let { httpClient.get(it).body() }
}
