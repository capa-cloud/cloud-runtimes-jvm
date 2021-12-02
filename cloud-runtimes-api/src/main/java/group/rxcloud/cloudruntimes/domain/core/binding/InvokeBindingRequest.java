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
package group.rxcloud.cloudruntimes.domain.core.binding;

import java.util.Collections;
import java.util.Map;

/**
 * A request to invoke binding.
 */
public class InvokeBindingRequest {

    private final String name;

    private final String operation;

    private Object data;

    private Map<String, String> metadata;

    public InvokeBindingRequest(String bindingName, String operation) {
        this.name = bindingName;
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public String getOperation() {
        return operation;
    }

    public Object getData() {
        return data;
    }

    public InvokeBindingRequest setData(Object data) {
        this.data = data;
        return this;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public InvokeBindingRequest setMetadata(Map<String, String> metadata) {
        this.metadata = metadata == null ? null : Collections.unmodifiableMap(metadata);
        return this;
    }

    @Override
    public String toString() {
        return "InvokeBindingRequest{" +
                "name='" + name + '\'' +
                ", operation='" + operation + '\'' +
                ", data=" + data +
                ", metadata=" + metadata +
                '}';
    }
}
