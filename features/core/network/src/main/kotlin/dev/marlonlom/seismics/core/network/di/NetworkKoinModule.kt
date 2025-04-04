/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.di

import dev.marlonlom.seismics.core.network.NetworkDataSource
import dev.marlonlom.seismics.core.network.NetworkDataSourceImpl
import dev.marlonlom.seismics.core.network.config.UsgsEarthquakesApi
import dev.marlonlom.seismics.core.network.config.ktorHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Koin module for network-related dependencies.
 *
 * This module is responsible for providing dependencies related to network operations,
 * such as HTTP clients, API services, and network configurations.
 *
 * @author marlonlom
 *
 */
val networkKoinModule = module {
  single<UsgsEarthquakesApi> {
    UsgsEarthquakesApi(
      baseUrl = get(named("USGS_BASE_URL")),
      httpClient = ktorHttpClient,
    )
  } bind UsgsEarthquakesApi::class
  single<NetworkDataSource> {
    NetworkDataSourceImpl(
      get<UsgsEarthquakesApi>(),
    )
  } bind NetworkDataSource::class
}
