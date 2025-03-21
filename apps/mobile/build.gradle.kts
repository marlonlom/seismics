/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "dev.marlonlom.seismics"
  compileSdk = 35

  defaultConfig {
    applicationId = "dev.marlonlom.seismics"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isShrinkResources = true
      isMinifyEnabled = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }

  buildFeatures {
    compose = true
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  val composeBom = platform(libs.androidx.compose.bom)
  implementation(composeBom)
  androidTestImplementation(composeBom)

  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.material3)
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.maps.compose)
  implementation(libs.play.services.maps)

  testImplementation(libs.junit)

  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(libs.androidx.ui.test.junit4)

  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}
