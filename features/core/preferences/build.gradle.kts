/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  id("seismics.android.library")
  id("seismics.android.lib.compose")
  id("seismics.android.koin")
  id("seismics.spotless")
}

android {
  namespace = "dev.marlonlom.seismics.core.preferences"
}

dependencies {
  implementation(libs.androidx.datastore.preferences)
  testImplementation(libs.kotlinx.coroutines.test)
}
