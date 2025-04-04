/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.config

import dev.marlonlom.seismics.core.network.utils.LocalJsonReader
import dev.marlonlom.seismics.core.network.utils.MockUsgsEarthquakesApiProvider.provide
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
internal class UsgsEarthquakesApiTest {

  @Test
  fun `Should get daily results list with empty features`() = runBlocking {
    val mockApi = provide(LocalJsonReader.readEmptyJson())
    val results = mockApi.getLatestEarthquakes()
    assertNotNull(results)
    assertEquals(1694975442000, results.metadata.generated)
    assertTrue(results.features.isEmpty())
  }

  @Test
  fun `Should get daily results list with non empty features`() = runBlocking {
    val mockApi = provide(LocalJsonReader.readNonEmptyJson())
    val results = mockApi.getLatestEarthquakes()
    assertNotNull(results)
    assertEquals(8, results.features.size)
    assertEquals(1743740956000, results.metadata.generated)
  }

  @Test
  fun `Should get single daily result with id us7000pp5t`() = runBlocking {
    val earthquakeCode = "us7000pp5t"
    val mockApi = provide(LocalJsonReader.readNonEmptyJson())
    val results = mockApi.getLatestEarthquakes()
    val feature = results.features.find { it.id == earthquakeCode }
    if (feature == null) {
      fail()
    } else {
      assertNotNull(results)
      assertNotNull(feature)
      assertNotNull(feature.properties)
      assertTrue(feature.properties.url.endsWith(earthquakeCode))
      assertNotNull(feature.geometry)
      assertEquals("Point", feature.geometry.type)
      assertTrue(feature.geometry.coordinates.isNotEmpty())
    }
  }
}
