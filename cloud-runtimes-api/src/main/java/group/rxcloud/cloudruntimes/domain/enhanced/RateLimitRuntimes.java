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
package group.rxcloud.cloudruntimes.domain.enhanced;

import group.rxcloud.cloudruntimes.domain.enhanced.ratelimit.RateLimitToken;
import group.rxcloud.cloudruntimes.domain.enhanced.ratelimit.RateLimitResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * The Rate limit runtimes.
 */
public interface RateLimitRuntimes {

    /**
     * Try get rate limit token.
     *
     * @param storeName  the store name
     * @param resourceId the resource id
     * @param metadata   the metadata
     * @return the mono of tokens
     */
    Mono<RateLimitResponse> tryRateLimitToken(String storeName, String resourceId, Map<String, String> metadata);

    /**
     * Try and exec Rate limit stream.
     *
     * @param storeName  the store name
     * @param resourceId the resource id
     * @param metadata   the metadata
     * @return the flux of exec stream
     */
    Flux<RateLimitToken> tryRateLimit(String storeName, String resourceId, Map<String, String> metadata);
}
