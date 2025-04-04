/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network

import dev.marlonlom.seismics.core.network.response.EarthquakesResponse

/**
 * Interface defining the data source for network operations related to earthquakes.<br/>
 * This interface provides methods for fetching earthquake data from a remote source.
 *
 * @author marlonlom
 */
interface NetworkDataSource {

  /**
   * Retrieves a list of earthquakes from the network.
   *
   * @return An [EarthquakesResponse] object containing the earthquake data.
   * @throws Exception If an error occurs during the network request.
   */
  suspend fun getEarthquakes(): EarthquakesResponse
}
