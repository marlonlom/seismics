/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.config

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * A class for constructing and executing queries to the USGS Earthquake Hazards Program's daily earthquake feed.
 *
 * This class allows you to build URLs for retrieving earthquake data from the USGS API.
 *
 * @author marlonlom
 *
 * @property baseUrl The base URL for the USGS earthquake API
 */
class UsgsDailyEarthquakesQuery(private val baseUrl: String) {

  /** Simple date formatter */
  private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

  /** Calendar */
  private var today: Calendar = Calendar.getInstance()

  /**
   * Applies the provided calendar instance.
   *
   * @param today Calendar instance.
   */
  fun duringToday(today: Calendar = Calendar.getInstance()) = apply { this.today = today }

  /**
   * Builds the query url as string.
   *
   * @return query url as string.
   */
  fun buildUrl(): String = mutableListOf<String>().apply {
    buildParamsList()
  }.let { queryParams ->
    "$baseUrl?${queryParams.joinToString("&")}"
  }

  /** Builds query params into the mutable list. */
  private fun MutableList<String>.buildParamsList() {
    add("format=geojson")

    today.also { calendar ->
      calendar.set(Calendar.HOUR_OF_DAY, 0)
      calendar.set(Calendar.MINUTE, 0)
      calendar.set(Calendar.SECOND, 0)
      add("starttime=${simpleDateFormat.format(calendar.time)}")
    }

    (today.clone() as Calendar).also { calendar ->
      calendar.add(Calendar.DAY_OF_YEAR, 1)
      calendar.set(Calendar.HOUR_OF_DAY, 23)
      calendar.set(Calendar.MINUTE, 59)
      calendar.set(Calendar.SECOND, 59)
      add("endtime=${simpleDateFormat.format(calendar.time)}")
    }

    add("minmagnitude=0.1")
    add("orderBy=time")
  }
}

/**
 * Creates and configures a `UsgsDailyEarthquakesQuery` using a builder pattern.
 *
 * This inline function allows you to construct a USGS earthquake query URL in a concise and readable way.
 *
 * @param url The base URL for the USGS earthquake API.
 * @param block A lambda expression with receiver `UsgsDailyEarthquakesQuery` that allows you to configure the query.
 * @return The constructed query URL string.
 */
inline fun usgsDailyEarthquakesQuery(url: String, block: UsgsDailyEarthquakesQuery.() -> Unit): String =
  UsgsDailyEarthquakesQuery(url).apply(block).buildUrl()
