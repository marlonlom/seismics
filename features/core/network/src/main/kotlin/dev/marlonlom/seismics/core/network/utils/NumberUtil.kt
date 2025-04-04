/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

/**
 * Number utility functions single object.
 *
 * @author marlonlom
 */
object NumberUtil {

  /**
   * Checks if provided float number is between two values (first, last)
   *
   * @param first Initial value for range.
   * @param value Float number for range checks.
   * @param last Final value for range.
   *
   * @return True/False if provided number is between first and last numbers.
   */
  fun isFloatBetween(first: Float, value: Float, last: Float): Boolean = (value > first).and(value < last)

  /**
   * Checks if provided Double number is between two values (first, last)
   *
   * @param first Initial value for range.
   * @param value Double number for range checks.
   * @param last Double value for range.
   *
   * @return True/False if provided number is between first and last numbers.
   */
  fun isDoubleBetweenInclusive(first: Double, value: Double, last: Double): Boolean =
    (value >= first).and(value <= last)

  /**
   * Apply double formatting and rounds up to two decimals.
   *
   * @param num Double number for converting.
   *
   * @return Formatted number.
   */
  fun roundTwoDecimals(num: Double): Double {
    val df = DecimalFormat("#.##", DecimalFormatSymbols(Locale.US))
    df.roundingMode = RoundingMode.FLOOR
    return df.format(num).toDouble()
  }

  /**
   * Apply double formatting and rounds up to one decimal.
   *
   * @param num Double number for converting.
   *
   * @return Formatted number.
   */
  fun roundOneDecimal(num: Double): Double {
    val df = DecimalFormat("#.#", DecimalFormatSymbols(Locale.US))
    df.roundingMode = RoundingMode.FLOOR
    return df.format(num).toDouble()
  }
}
