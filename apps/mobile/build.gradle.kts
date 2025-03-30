/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  id("seismics.android.application")
  id("seismics.android.app.compose")
  id("seismics.spotless")
}

dependencies {
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.maps.compose)
  implementation(libs.play.services.maps)
}
