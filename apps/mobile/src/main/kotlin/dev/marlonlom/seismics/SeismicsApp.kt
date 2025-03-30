/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics

import android.app.Application
import dev.marlonlom.seismics.di.appKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Seismics mobile application main class.
 *
 * @author marlonlom
 */
class SeismicsApp : Application() {

  override fun onCreate() {
    super.onCreate()
    this.setupKoin()
  }

  private fun setupKoin() {
    startKoin {
      androidContext(this@SeismicsApp)
      androidLogger(Level.DEBUG)
      modules(appKoinModule)
    }
  }
}
