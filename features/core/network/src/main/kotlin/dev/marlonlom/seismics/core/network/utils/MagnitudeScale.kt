/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

import dev.marlonlom.seismics.core.network.utils.NumberUtil.isDoubleBetweenInclusive
import dev.marlonlom.seismics.core.network.utils.NumberUtil.roundTwoDecimals

/**
 * Magnitude scalable interface definition.
 *
 * @author marlonlom
 */
interface MagnitudeScalable {
  /**
   * Returns true/false if provided number is in scale.
   *
   * @param num Number for being checked.
   *
   * @return true/false
   */
  fun isInScale(num: Double): Boolean
}

/**
 * Enum class representing the Magnitude Scale.
 *
 * This enum class includes a companion object with a utility function to find
 * a magnitude scale based on a given magnitude value.
 *
 * @author marlonlom
 */
enum class MagnitudeScale : MagnitudeScalable {

  /** Magnitude scale: Micro (2.9 or less) */
  MICRO {
    override fun isInScale(num: Double): Boolean = isDoubleBetweenInclusive(0.0, roundTwoDecimals(num), 2.9)
  },

  /** Magnitude scale: Minor (3.0 to 3.9) */
  MINOR {
    override fun isInScale(num: Double): Boolean = isDoubleBetweenInclusive(3.0, roundTwoDecimals(num), 3.9)
  },

  /** Magnitude scale: Light (4.0 to 4.9) */
  LIGHT {
    override fun isInScale(num: Double): Boolean = isDoubleBetweenInclusive(4.0, roundTwoDecimals(num), 4.9)
  },

  /** Magnitude scale: Moderate (5.0 to 5.9) */
  MODERATE {
    override fun isInScale(num: Double): Boolean = isDoubleBetweenInclusive(5.0, roundTwoDecimals(num), 5.9)
  },

  /** Magnitude scale: Strong (6.0 to 6.9) */
  STRONG {
    override fun isInScale(num: Double): Boolean = isDoubleBetweenInclusive(6.0, roundTwoDecimals(num), 6.9)
  },

  /** Magnitude scale: Major (7.0 to 7.9) */
  MAJOR {
    override fun isInScale(num: Double): Boolean = isDoubleBetweenInclusive(7.0, roundTwoDecimals(num), 7.9)
  },

  /** Magnitude scale: Great (8.0 or greater) */
  GREAT {
    override fun isInScale(num: Double): Boolean =
      isDoubleBetweenInclusive(8.0, roundTwoDecimals(num), Double.POSITIVE_INFINITY)
  }, ;

  /** Companion object containing utility functions for the MagnitudeScale enum. */
  companion object {

    /**
     * Finds the magnitude scale based on the provided magnitude value.
     *
     * @param magnitudeValue The magnitude value to check.
     * @return The name of the scale that corresponds to the magnitude value, or an empty string if no scale matches the magnitude value.
     */
    fun findByMagnitude(magnitudeValue: Double): String = entries.find { it.isInScale(magnitudeValue) }?.name ?: ""
  }
}
