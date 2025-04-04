/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  id("seismics.android.library")
  id("seismics.android.koin")
  id("seismics.spotless")
  id("kotlinx-serialization")
}

android {
  namespace = "dev.marlonlom.seismics.core.network"
  defaultConfig {
    consumerProguardFiles("consumer-rules.pro")
  }
  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.bundles.ktor.android.client)
  testImplementation(libs.kotlinx.coroutines.test)
  testImplementation(libs.ktor.client.mock)
}
