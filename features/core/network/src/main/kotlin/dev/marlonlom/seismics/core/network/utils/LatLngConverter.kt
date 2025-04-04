/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

import dev.marlonlom.seismics.core.network.utils.NumberUtil.isFloatBetween
import kotlin.math.abs

/**
 * Utility class for converting a coordinate into its DMS (degrees, minutes,
 * seconds) representation.
 *
 * @author marlonlom
 */
object LatLngConverter {

  /** Constant for latitude/longitude orientations. */
  private val ORIENTATIONS = arrayOf("N", "S", "E", "W")

  /**
   * Given a array of coordinates [longitude, latitude], returns the dms
   * (degrees, minutes, seconds) representation.
   *
   * @param coordinates array of coordinates, with 2+ elements
   * @return representation for given array
   */
  fun convert(coordinates: FloatArray): String {
    if (!isValidCoordinates(coordinates)) return ""

    var converted0: String = decimalToDMS(coordinates[1])
    val dmsLat = getLatitudeSignature(coordinates[1])
    converted0 = "$converted0 $dmsLat".trim()

    var converted1: String = decimalToDMS(coordinates[0])
    val dmsLng = getLongitudeSignature(coordinates[0])
    converted1 = "$converted1 $dmsLng".trim()

    return "$converted0, $converted1"
  }

  /**
   * Checks if coordinates in format [longitude, latitude] are valid.
   *
   * @param coordinates Coordinates array.
   * @return true/false.
   */
  private fun isValidCoordinates(coordinates: FloatArray): Boolean = isFloatBetween(-90f, coordinates[1], 90f).and(
    isFloatBetween(-180f, coordinates[0], 180f),
  )

  /**
   * Returns latitude signature for selected coordinates.
   *
   * @param coordinate coordinate value
   * @return latitude signature, or empty if zero
   */
  private fun getLatitudeSignature(coordinate: Float): String = when {
    isFloatBetween(-90f, coordinate, 0f)-> ORIENTATIONS[1]
    isFloatBetween(0f, coordinate, 90f) -> ORIENTATIONS[0]
    else -> ""
  }

  /**
   * Returns longitude signature for selected coordinates.
   *
   * @param coordinate coordinate value.
   * @return longitude signature, or empty if zero.
   */
  private fun getLongitudeSignature(coordinate: Float): String = when {
    isFloatBetween(-180f, coordinate, 0f) -> ORIENTATIONS[3]
    isFloatBetween(0f, coordinate, 180f) -> ORIENTATIONS[2]
    else -> ""
  }

  /**
   * Given a decimal longitudinal coordinate such as <i>-79.982195</i> it will
   * be necessary to know whether it is a latitudinal or longitudinal
   * coordinate in order to fully convert it.
   *
   * @param coordinates coordinate in decimal format
   * @return coordinate in D°M′S″ format
   * @see <a href='https://goo.gl/pWVp60'>Geographic coordinate conversion
   *      (wikipedia)</a>
   */
  private fun decimalToDMS(coordinates: Float): String {
    val degrees = coordinates.toInt()
    val minutes = ((abs(coordinates) - abs(degrees)) * 60).toInt()
    val seconds = (((abs(coordinates) - abs(degrees)) * 60 - minutes) * 60).toInt()
    return "${abs(degrees)}°${abs(minutes)}'${abs(seconds)}\""
  }
}
