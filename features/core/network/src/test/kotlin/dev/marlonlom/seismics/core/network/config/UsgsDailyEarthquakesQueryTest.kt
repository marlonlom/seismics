/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.config

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
internal class UsgsDailyEarthquakesQueryTest {

  private val baseUrl = "https://earthquakes.dunny.com/query"
  private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

  @Test
  fun `Should build query url for 2024-01-02`() {
    val calendar = Calendar.getInstance().also {
      it.set(Calendar.YEAR, 2024)
      it.set(Calendar.MONTH, Calendar.JANUARY)
      it.set(Calendar.DAY_OF_MONTH, 2)
    }
    val queryUrl = usgsDailyEarthquakesQuery(baseUrl) { duringToday(calendar) }

    assertNotNull(queryUrl)
    assertTrue(queryUrl.isNotEmpty())
    assertTrue(queryUrl.contains("&starttime=2024-01-02"))
    assertTrue(queryUrl.contains("&endtime=2024-01-03"))
    assertTrue(queryUrl.contains("&orderBy=time"))
  }

  @Test
  fun `Should build query url for current date`() {
    val today = Calendar.getInstance()
    val tomorrow = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 1) }

    val expectedStartDate = simpleDateFormat.format(today.time)
    val expectedEndDate = simpleDateFormat.format(tomorrow.time)

    val queryUrl = usgsDailyEarthquakesQuery(baseUrl) { duringToday() }

    assertNotNull(queryUrl)
    assertTrue(queryUrl.isNotEmpty())
    assertTrue(queryUrl.contains("&starttime=$expectedStartDate"))
    assertTrue(queryUrl.contains("&endtime=$expectedEndDate"))
    assertTrue(queryUrl.contains("&orderBy=time"))
  }
}
