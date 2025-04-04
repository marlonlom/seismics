/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
internal class MagnitudeScaleTest {

  @Test
  fun `Should return empty magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(-1.0)
    assertTrue(scaleName.isEmpty())
  }

  @Test
  fun `Should return micro magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(2.4)
    assertEquals(MagnitudeScale.MICRO.name, scaleName)
  }

  @Test
  fun `Should return minor magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(3.6)
    assertEquals(MagnitudeScale.MINOR.name, scaleName)
  }

  @Test
  fun `Should return light magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(4.4)
    assertEquals(MagnitudeScale.LIGHT.name, scaleName)
  }

  @Test
  fun `Should return moderate magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(5.6)
    assertEquals(MagnitudeScale.MODERATE.name, scaleName)
  }

  @Test
  fun `Should return strong magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(6.004)
    assertEquals(MagnitudeScale.STRONG.name, scaleName)
  }

  @Test
  fun `Should return major magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(7.613)
    assertEquals(MagnitudeScale.MAJOR.name, scaleName)
  }

  @Test
  fun `Should return great magnitude scale`() {
    val scaleName = MagnitudeScale.findByMagnitude(8.6)
    assertEquals(MagnitudeScale.GREAT.name, scaleName)
  }
}
