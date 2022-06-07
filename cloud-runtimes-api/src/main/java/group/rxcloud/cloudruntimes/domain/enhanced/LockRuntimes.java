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

import group.rxcloud.cloudruntimes.domain.enhanced.lock.TryLockRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.lock.TryLockResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.lock.UnlockRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.lock.UnlockResponse;
import reactor.core.publisher.Mono;

/**
 * Distributed Lock API defined.
 */
public interface LockRuntimes {

    /**
     * A non-blocking method trying to get a lock with ttl.
     *
     * @param request the request
     * @return the mono
     */
    Mono<TryLockResponse> tryLock(TryLockRequest request);

    /**
     * Unlock.
     *
     * @param request the request
     * @return the mono
     */
    Mono<UnlockResponse> unlock(UnlockRequest request);
}
