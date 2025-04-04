/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.response

import kotlinx.serialization.Serializable

/**
 * Data class representing the complete response of earthquakes data.
 * @author marlonlom
 *
 * @property metadata Metadata associated with the earthquakes response.
 * @property features List of earthquake features, each representing an individual earthquake.
 */
@Serializable
data class EarthquakesResponse(val metadata: EarthquakesResponseMetadata, val features: List<EarthquakeFeature>)
