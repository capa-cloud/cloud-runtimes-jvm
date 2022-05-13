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
package group.rxcloud.cloudruntimes.capa;

import group.rxcloud.capa.component.pubsub.PubSubConfig;
import group.rxcloud.capa.pubsub.CapaPubSubClient;
import group.rxcloud.capa.pubsub.CapaPubSubClientBuilder;
import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.capa.rpc.CapaRpcClientBuilder;

public class CapaClientProvider {

    public static final CapaRpcClient CAPA_RPC_CLIENT = new CapaRpcClientBuilder()
            .build();

    public static final CapaPubSubClient CAPA_PUB_SUB_CLIENT = new CapaPubSubClientBuilder(new PubSubConfig())
            .build();
}
