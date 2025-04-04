/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.response

import kotlinx.serialization.Serializable

/**
 * Data class representing the geometry of an earthquake feature.
 * @author marlonlom
 *
 * @property type The type of geometry (e.g., "Point").
 * @property coordinates A list of coordinates representing the geometry. For a "Point" type,
 * it contains the longitude and latitude in that order.
 */
@Serializable
data class EarthquakeFeatureGeometry(val type: String, val coordinates: List<Double>)
