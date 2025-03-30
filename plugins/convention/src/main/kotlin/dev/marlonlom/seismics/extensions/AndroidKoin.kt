/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.seismics.extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Extension function for configuring koin in android modules.
 * @author marlonlom
 *
 * @param extension Common extension instance.
 */
internal fun Project.configureAndroidKoin(
  extension: CommonExtension<*, *, *, *, *, *>,
) {
  extension.apply {
    dependencies {
      val composeBom = platform(versionCatalog().findLibrary("koin-bom").get())
      add("implementation", composeBom)
      add("implementation", versionCatalog().findBundle("koin").get())
    }
  }
}
