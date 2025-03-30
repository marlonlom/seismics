/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.seismics.plugins

import com.android.build.api.dsl.LibraryExtension
import dev.marlonlom.seismics.configs.Config
import dev.marlonlom.seismics.extensions.configureAndroidKotlin
import dev.marlonlom.seismics.extensions.configureBuildTypes
import dev.marlonlom.seismics.extensions.configureAndroidKoin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibConventionPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    with(project) {
      with(pluginManager) {
        apply("com.android.library")
        apply("kotlin-android")
      }
      extensions.configure<LibraryExtension> {
        configureAndroidKotlin(this)
        configureAndroidKoin(this)
        testOptions.apply {
          targetSdk = Config.android.targetSdkVersion
        }
        defaultConfig.apply {
          @Suppress("DEPRECATION")
          targetSdk = Config.android.targetSdkVersion
        }
        configureBuildTypes(this)
      }
    }
  }
}
