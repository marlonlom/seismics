/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network

import dev.marlonlom.seismics.core.network.config.UsgsEarthquakesApi
import dev.marlonlom.seismics.core.network.response.EarthquakesResponse

/**
 * Implementation of the [NetworkDataSource] interface for fetching earthquake data from the USGS API.
 * @author marlonlom
 *
 * @property usgsApi The USGS Earthquakes API service used to fetch data.
 */
class NetworkDataSourceImpl(private val usgsApi: UsgsEarthquakesApi) : NetworkDataSource {

  /**
   * Retrieves a list of earthquakes from the USGS API within a calculated time range.
   *
   * @return An [EarthquakesResponse] object containing the earthquake data.
   * @throws Exception If an error occurs during the API request.
   */
  override suspend fun getEarthquakes(): EarthquakesResponse = usgsApi.getLatestEarthquakes()
}
