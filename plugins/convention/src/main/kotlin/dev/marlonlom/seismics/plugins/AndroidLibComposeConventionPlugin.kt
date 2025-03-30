/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.seismics.plugins

import com.android.build.api.dsl.LibraryExtension
import dev.marlonlom.seismics.extensions.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Android compose library convention plugin class.
 * @author marlonlom
 */
class AndroidLibComposeConventionPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    with(project) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.plugin.compose")
      }

      val extension = extensions.getByType<LibraryExtension>()
      configureAndroidCompose(extension)
    }
  }
}
