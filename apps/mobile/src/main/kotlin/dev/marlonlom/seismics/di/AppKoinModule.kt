/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.di

import dev.marlonlom.seismics.core.preferences.di.preferencesKoinModule
import org.koin.dsl.module

/**
 * Main mobile application Koin module.
 *
 * @author marlonlom
 */
val appKoinModule = module {
  includes(preferencesKoinModule)
}
