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
package group.rxcloud.cloudruntimes.domain.core.state;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A request to save states to state store.
 */
public class SaveStateRequest {

    private final String storeName;

    private List<State<?>> states;

    public SaveStateRequest(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public List<State<?>> getStates() {
        return states;
    }

    public SaveStateRequest setStates(List<State<?>> states) {
        this.states = states == null ? null : Collections.unmodifiableList(states);
        return this;
    }

    public SaveStateRequest setStates(State<?>... states) {
        this.states = Collections.unmodifiableList(Arrays.asList(states));
        return this;
    }

    @Override
    public String toString() {
        return "SaveStateRequest{" +
                "storeName='" + storeName + '\'' +
                ", states=" + states +
                '}';
    }
}
