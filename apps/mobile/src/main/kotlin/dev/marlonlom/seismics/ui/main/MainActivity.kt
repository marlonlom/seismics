/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.marlonlom.seismics.ui.theme.SeismicsTheme

/**
 * Main activity for mobile application.
 *
 * @author marlonlom
 *
 */
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      SeismicsTheme {
        Scaffold(
          modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
        ) { innerPadding ->
          Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding),
          )
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    style = MaterialTheme.typography.bodyLarge,
    modifier = modifier,
  )
}
