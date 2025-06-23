/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.seismics.extensions

import com.android.build.api.dsl.CommonExtension
import dev.marlonlom.seismics.configs.Config
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

/**
 * Extension function for configuring android kotlin module.
 * @author marlonlom
 *
 * @param extension Common extension instance.
 */
internal fun Project.configureAndroidKotlin(
  extension: CommonExtension<*, *, *, *, *, *>,
) {
  with(extension) {
    namespace = Config.android.nameSpace
    compileSdk = Config.android.compileSdkVersion

    defaultConfig.apply {
      minSdk = Config.android.minSdkVersion
      testInstrumentationRunner = "androidx.test.runner.AndroidJunitRunner"
      vectorDrawables.useSupportLibrary = true
    }

    compileOptions {
      sourceCompatibility = Config.jvm.javaVersion
      targetCompatibility = Config.jvm.javaVersion
    }

    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"

    dependencies {
      add("implementation", versionCatalog().findLibrary("androidx-core-ktx").get())

      add("testImplementation", versionCatalog().findLibrary("junit").get())
      add("testImplementation", versionCatalog().findLibrary("kotlinx-coroutines-test").get())

      add("androidTestImplementation", versionCatalog().findLibrary("androidx-espresso-core").get())
      add("androidTestImplementation", versionCatalog().findLibrary("androidx-junit").get())
      add("androidTestImplementation", versionCatalog().findLibrary("google-truth").get())
    }
  }
  tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions {
      jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.fromTarget(Config.jvm.kotlinJvm))
    }
  }
}
