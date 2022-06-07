/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package group.rxcloud.cloudruntimes.domain.nativeproto;

import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeAdminCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeBitCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeDatabaseCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeDebugCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeGeoCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeHashCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeHyperLogCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeKeyCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeListCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeLuaCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativePersistCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativePubSubCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeSetCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeSortedSetCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeStringCommands;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.NativeTransactionCommands;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Native Redis API defined.
 */
public interface NativeRedisRuntimes extends
        NativeAdminCommands,
        NativeBitCommands,
        NativeDatabaseCommands,
        NativeDebugCommands,
        NativeGeoCommands,
        NativeHashCommands,
        NativeHyperLogCommands,
        NativeKeyCommands,
        NativeListCommands,
        NativeLuaCommands,
        NativePersistCommands,
        NativePubSubCommands,
        NativeSetCommands,
        NativeSortedSetCommands,
        NativeStringCommands,
        NativeTransactionCommands {

    /**
     * Invokes a Redis operation as `RESP protocol spec`.
     *
     * @param storeName The name of the redis store to call.
     * @param cmd       The cmd to be processed.
     * @param args      The args to be processed.
     * @param metadata  The metadata map.
     * @return a Mono plan of type byte[].
     * @see <a href="https://redis.io/docs/reference/protocol-spec/">RESP</a>
     */
    Mono<byte[]> invokeRedis(String storeName, String cmd, byte[] args, Map<String, String> metadata);
}
