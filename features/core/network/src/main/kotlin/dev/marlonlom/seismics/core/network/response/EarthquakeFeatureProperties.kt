/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.response

import kotlinx.serialization.Serializable

/**
 * Data class representing the properties of an earthquake feature.
 * @author marlonlom
 *
 * @property mag The magnitude of the earthquake.
 * @property magType The type of magnitude measurement (e.g., mb, ml, mw).
 * @property place The descriptive location of the earthquake, or null if not available.
 * @property time The timestamp (in milliseconds) when the earthquake occurred.
 * @property updated The timestamp (in milliseconds) when the earthquake information was last updated.
 * @property url The URL for more information about the earthquake.
 * @property tsunami An indicator of whether a tsunami was generated (1 = yes, 0 = no).
 * @property gap The largest azimuthal gap (in degrees) between stations, or null if not available.
 * @property dmin The horizontal distance (in degrees) from the nearest station, or null if not available.
 * @property rms The root-mean-square (RMS) residual, representing the misfit of the data to the location.
 */
@Serializable
data class EarthquakeFeatureProperties(
  val mag: Double,
  val magType: String,
  val place: String?,
  val time: Long,
  val updated: Long,
  val url: String,
  val tsunami: Int,
  val gap: Double?,
  val dmin: Double?,
  val rms: Double,
)
