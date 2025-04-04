/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.di

import dev.marlonlom.seismics.BuildConfig
import dev.marlonlom.seismics.core.network.di.networkKoinModule
import dev.marlonlom.seismics.core.preferences.di.preferencesKoinModule
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Main mobile application Koin module.
 *
 * @author marlonlom
 */
val appKoinModule = module {
  single<String>(named("USGS_BASE_URL")) { BuildConfig.USGS_BASE_URL }
  includes(networkKoinModule, preferencesKoinModule)
}
