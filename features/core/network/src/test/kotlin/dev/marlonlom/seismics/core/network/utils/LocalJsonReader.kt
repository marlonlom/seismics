/*
 * Copyright 2025 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.seismics.core.network.utils

/**
 * Local json reader single object.
 *
 * @author marlonlom
 */
object LocalJsonReader {

  /**
   * Reads the content of the non empty daily results json.
   *
   * @return Json text as String.
   */
  fun readNonEmptyJson(): String = this.javaClass
    .classLoader!!.getResourceAsStream("success_nonempty.json")!!
    .bufferedReader(Charsets.UTF_8)
    .readText()

  /**
   * Reads the content of the empty daily results json.
   *
   * @return Json text as String.
   */
  fun readEmptyJson(): String = this.javaClass
    .classLoader!!.getResourceAsStream("success_empty.json")!!
    .bufferedReader(Charsets.UTF_8)
    .readText()
}
