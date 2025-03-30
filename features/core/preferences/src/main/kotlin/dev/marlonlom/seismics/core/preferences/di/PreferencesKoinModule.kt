/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.preferences.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dev.marlonlom.seismics.core.preferences.PreferencesRepository
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Instance of preferences datastore.
 *
 * @author marlonlom
 */
internal val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "seismics-settings")

/**
 * Preferences Koin module.
 *
 * @author marlonlom
 */
val preferencesKoinModule = module {
  single<PreferencesRepository> {
    PreferencesRepository(
      androidContext().dataStore,
      Dispatchers.IO,
    )
  } bind PreferencesRepository::class
}
