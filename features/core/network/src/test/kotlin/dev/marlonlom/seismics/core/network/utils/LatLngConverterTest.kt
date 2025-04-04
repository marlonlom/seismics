/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
internal class LatLngConverterTest {

  @Test
  fun `Should success converting (-71,3854 , -30,8199) to DMS`() {
    val expectedResult = "30°49'11\" S, 71°23'7\" W"
    val coordinates = floatArrayOf(-71.3854f, -30.8199f)
    val dmsResult = LatLngConverter.convert(coordinates)
    assertNotNull(dmsResult)
    assertEquals(expectedResult, dmsResult)
  }

  @Test
  fun `Should success converting (-130,2988 , 50,7956) to DMS`() {
    val expectedResult = "50°47'44\" N, 130°17'55\" W"
    val coordinates = floatArrayOf(-130.2988f, 50.7956f)
    val dmsResult = LatLngConverter.convert(coordinates)
    assertNotNull(dmsResult)
    assertEquals(expectedResult, dmsResult)
  }

  @Test
  fun `Should success converting (127,8269 , -8,3135) to DMS`() {
    val expectedResult = "8°18'48\" S, 127°49'36\" E"
    val coordinates = floatArrayOf(127.8269f, -8.3135f)
    val dmsResult = LatLngConverter.convert(coordinates)
    assertNotNull(dmsResult)
    assertEquals(expectedResult, dmsResult)
  }

  @Test
  fun `Should success converting (90,6356 , 23,9566) to DMS`() {
    val expectedResult = "23°57'23\" N, 90°38'8\" E"
    val coordinates = floatArrayOf(90.6356f, 23.9566f)
    val dmsResult = LatLngConverter.convert(coordinates)
    assertNotNull(dmsResult)
    assertEquals(expectedResult, dmsResult)
  }

  @Test
  fun `Should success converting (0,0) to DMS`() {
    val expectedResult = "0°0'0\", 0°0'0\""
    val coordinates = floatArrayOf(0f, 0f)
    val dmsResult = LatLngConverter.convert(coordinates)
    assertNotNull(dmsResult)
    assertEquals(expectedResult, dmsResult)
  }

  @Test
  fun `Should success converting (180, 180) to DMS`() {
    val coordinates = floatArrayOf(180f, -181f)
    val dmsResult = LatLngConverter.convert(coordinates)
    assertNotNull(dmsResult)
    assertTrue(dmsResult.isEmpty())
  }
}
