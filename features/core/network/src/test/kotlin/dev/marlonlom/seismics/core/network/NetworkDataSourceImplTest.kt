/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network

import dev.marlonlom.seismics.core.network.utils.LocalJsonReader
import dev.marlonlom.seismics.core.network.utils.MockUsgsEarthquakesApiProvider.provide
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
internal class NetworkDataSourceImplTest {

  @Test
  fun `Should get daily results list with empty features`() = runBlocking {
    val usgsApi = provide(LocalJsonReader.readEmptyJson())
    val dataSource = NetworkDataSourceImpl(usgsApi)
    val results = dataSource.getEarthquakes()
    assertNotNull(results)
    assertEquals(1694975442000, results.metadata.generated)
    Assert.assertTrue(results.features.isEmpty())
  }

  @Test
  fun `Should get daily results list with non empty features`() = runBlocking {
    val usgsApi = provide(LocalJsonReader.readNonEmptyJson())
    val dataSource = NetworkDataSourceImpl(usgsApi)
    val results = dataSource.getEarthquakes()
    assertNotNull(results)
    assertEquals(8, results.features.size)
    assertEquals(1743740956000, results.metadata.generated)
  }

  @Test
  fun `Should get single daily result with id ak02546kb91j`() = runBlocking {
    val earthquakeId = "ak02546kb91j"
    val usgsApi = provide(LocalJsonReader.readNonEmptyJson())
    val dataSource = NetworkDataSourceImpl(usgsApi)
    val results = dataSource.getEarthquakes()
    when (val feature = results.features.find { it.id == earthquakeId }) {
      null -> {
        Assert.fail()
      }

      else -> {
        assertNotNull(results)
        assertNotNull(feature)
        assertNotNull(feature.properties)
        Assert.assertTrue(feature.properties.url.endsWith(earthquakeId))
        assertNotNull(feature.geometry)
        Assert.assertTrue(feature.geometry.coordinates.isNotEmpty())
      }
    }
  }
}
