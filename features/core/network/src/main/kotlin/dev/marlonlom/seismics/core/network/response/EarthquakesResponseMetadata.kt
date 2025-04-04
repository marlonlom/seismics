/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.response

import kotlinx.serialization.Serializable

/**
 * Data class representing the metadata of an earthquakes response.
 * @author marlonlom
 *
 * @property generated The timestamp (in milliseconds) when the response was generated.
 * @property url The URL of the request that generated the response.
 * @property title The title of the response.
 * @property status The HTTP status code of the response.
 * @property api The API version used to generate the response.
 * @property count The number of earthquakes included in the response.
 */
@Serializable
data class EarthquakesResponseMetadata(
  val generated: Long,
  val url: String,
  val title: String,
  val status: Int,
  val api: String,
  val count: Int,
)
