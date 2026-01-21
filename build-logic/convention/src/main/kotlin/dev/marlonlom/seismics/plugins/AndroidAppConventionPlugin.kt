/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.seismics.plugins

import com.android.build.api.dsl.ApplicationExtension
import dev.marlonlom.seismics.configs.Config
import dev.marlonlom.seismics.extensions.configureAndroidKotlin
import dev.marlonlom.seismics.extensions.configureBuildTypes
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Android app convention plugin class.
 * @author marlonlom
 */
class AndroidAppConventionPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    with(project) {
      with(pluginManager) {
        apply("com.android.application")
      }
      extensions.configure<ApplicationExtension> {
        defaultConfig.apply {
          targetSdk = Config.android.targetSdkVersion
          applicationId = Config.android.applicationId
          versionCode = Config.android.versionCode
          versionName = Config.android.versionName
          testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        buildFeatures {
          buildConfig = true
        }
        configureAndroidKotlin(this)
        configureBuildTypes(this)
      }
    }
  }
}
