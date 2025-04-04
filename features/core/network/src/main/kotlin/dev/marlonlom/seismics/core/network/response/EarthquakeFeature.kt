/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.response

import kotlinx.serialization.Serializable

/**
 * Data class representing a single earthquake feature, including its properties, geometry, and ID.
 * @author marlonlom
 *
 * @property properties The properties of the earthquake feature. See [EarthquakeFeatureProperties] for details.
 * @property geometry The geometry of the earthquake feature. See [EarthquakeFeatureGeometry] for details.
 * @property id A unique identifier for the earthquake feature.
 */
@Serializable
data class EarthquakeFeature(
  val properties: EarthquakeFeatureProperties,
  val geometry: EarthquakeFeatureGeometry,
  val id: String,
)
