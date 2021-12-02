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
public class GetBulkSecretRequest {

    private final String storeName;

    private Map<String, String> metadata;

    public GetBulkSecretRequest(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public GetBulkSecretRequest setMetadata(Map<String, String> metadata) {
        this.metadata = metadata == null ? null : Collections.unmodifiableMap(metadata);
        return this;
    }

    @Override
    public String toString() {
        return "GetBulkSecretRequest{" +
                "storeName='" + storeName + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
