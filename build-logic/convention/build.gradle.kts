/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  `kotlin-dsl`
}

group = "dev.marlonlom.seismics.buildlogic"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
  compileOnly(libs.compose.compiler.gradlePlugin)
  compileOnly(libs.spotless.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("androidApp") {
      id = "seismics.android.application"
      implementationClass = "dev.marlonlom.seismics.plugins.AndroidAppConventionPlugin"
    }
    register("androidAppCompose") {
      id = "seismics.android.app.compose"
      implementationClass = "dev.marlonlom.seismics.plugins.AndroidAppComposeConventionPlugin"
    }
    register("androidKoin") {
      id = "seismics.android.koin"
      implementationClass = "dev.marlonlom.seismics.plugins.AndroidKoinConventionPlugin"
    }
    register("androidLibCompose") {
      id = "seismics.android.lib.compose"
      implementationClass = "dev.marlonlom.seismics.plugins.AndroidLibComposeConventionPlugin"
    }
    register("androidLib") {
      id = "seismics.android.library"
      implementationClass = "dev.marlonlom.seismics.plugins.AndroidLibConventionPlugin"
    }
    register("spotless") {
      id = "seismics.spotless"
      implementationClass = "dev.marlonlom.seismics.plugins.SpotlessConventionPlugin"
    }
  }
}
