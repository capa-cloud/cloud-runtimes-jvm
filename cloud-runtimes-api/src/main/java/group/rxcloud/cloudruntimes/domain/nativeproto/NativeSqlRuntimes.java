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

import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Native SQL API defined.
 */
public interface NativeSqlRuntimes {

    /**
     * Invokes a SQL operation.
     *
     * @param storeName The name of the sql store to call.
     * @param sql       The sql to be processed.
     * @param metadata  The metadata map.
     * @return a Mono plan of type byte[].
     */
    Mono<byte[]> invokeSql(String storeName, String sql, Map<String, String> metadata);
}
