/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  id("seismics.android.application")
  id("seismics.android.app.compose")
  id("seismics.android.koin")
  id("seismics.spotless")
  id(libs.plugins.google.secrets.get().pluginId)
}

secrets {
  propertiesFileName = "secrets.properties"
  defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
  implementation(project(":features:mobile:designsystem"))
  implementation(project(":features:core:preferences"))

  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.maps.compose)
  implementation(libs.play.services.maps)
}
