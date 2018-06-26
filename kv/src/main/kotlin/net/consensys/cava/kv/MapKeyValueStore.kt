/*
 * Copyright 2018, ConsenSys Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.consensys.cava.kv

import net.consensys.cava.bytes.Bytes

/**
 * A key-value store backed by an in-memory Map.
 */
class MapKeyValueStore
@JvmOverloads constructor(
  private val map: MutableMap<Bytes, Bytes> = HashMap()
) : KeyValueStore {

  override suspend fun get(key: Bytes): Bytes? = map[key]

  override suspend fun put(key: Bytes, value: Bytes) {
    map[key] = value
  }

  /**
   * Has no effect in this KeyValueStore implementation.
   */
  override fun close() {}
}
