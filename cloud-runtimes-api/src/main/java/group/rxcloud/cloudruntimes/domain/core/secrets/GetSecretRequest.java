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
package group.rxcloud.cloudruntimes.domain.core.secrets;

import java.util.Collections;
import java.util.Map;

/**
 * A request to get a secret by key.
 */
public class GetSecretRequest {

    private final String storeName;

    private final String key;

    public GetSecretRequest(String storeName, String key) {
        this.storeName = storeName;
        this.key = key;
    }

    private Map<String, String> metadata;

    public String getStoreName() {
        return storeName;
    }

    public String getKey() {
        return key;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public GetSecretRequest setMetadata(Map<String, String> metadata) {
        this.metadata = metadata == null ? null : Collections.unmodifiableMap(metadata);
        return this;
    }

    @Override
    public String toString() {
        return "GetSecretRequest{" +
                "storeName='" + storeName + '\'' +
                ", key='" + key + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
