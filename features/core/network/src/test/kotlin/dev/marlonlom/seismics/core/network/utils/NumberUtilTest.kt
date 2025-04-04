/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
internal class NumberUtilTest {

  @Test
  fun testIsFloatBetween() {
    assertTrue(NumberUtil.isFloatBetween(1.0f, 2.0f, 3.0f))
    assertFalse(NumberUtil.isFloatBetween(1.0f, 0.5f, 3.0f))
    assertFalse(NumberUtil.isFloatBetween(1.0f, 4.0f, 3.0f))
    assertFalse(NumberUtil.isFloatBetween(1.0f, 1.0f, 3.0f))
    assertFalse(NumberUtil.isFloatBetween(1.0f, 3.0f, 3.0f))
  }

  @Test
  fun testIsDoubleBetweenInclusive() {
    assertTrue(NumberUtil.isDoubleBetweenInclusive(1.0, 2.0, 3.0))
    assertFalse(NumberUtil.isDoubleBetweenInclusive(1.0, 0.5, 3.0))
    assertFalse(NumberUtil.isDoubleBetweenInclusive(1.0, 4.0, 3.0))
    assertTrue(NumberUtil.isDoubleBetweenInclusive(1.0, 1.0, 3.0))
    assertTrue(NumberUtil.isDoubleBetweenInclusive(1.0, 3.0, 3.0))
  }

  @Test
  fun testRoundTwoDecimals() {
    assertEquals(1.23, NumberUtil.roundTwoDecimals(1.2345), 0.0)
    assertEquals(1.23, NumberUtil.roundTwoDecimals(1.2399), 0.0)
    assertEquals(1.0, NumberUtil.roundTwoDecimals(1.0), 0.0)
    assertEquals(1.23, NumberUtil.roundTwoDecimals(1.230000001), 0.0)
  }

  @Test
  fun testRoundOneDecimal() {
    assertEquals(1.2, NumberUtil.roundOneDecimal(1.2345), 0.0)
    assertEquals(1.2, NumberUtil.roundOneDecimal(1.2999), 0.0)
    assertEquals(1.0, NumberUtil.roundOneDecimal(1.0), 0.0)
    assertEquals(1.2, NumberUtil.roundOneDecimal(1.200000001), 0.0)
  }
}
