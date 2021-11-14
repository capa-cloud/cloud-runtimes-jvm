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
package group.rxcloud.cloudruntimes.domain.core;

import group.rxcloud.cloudruntimes.domain.core.configuration.ConfigurationItem;
import group.rxcloud.cloudruntimes.domain.core.configuration.ConfigurationRequestItem;
import group.rxcloud.cloudruntimes.domain.core.configuration.SaveConfigurationRequest;
import group.rxcloud.cloudruntimes.domain.core.configuration.SubConfigurationResp;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * Configuration Runtimes standard API defined.
 */
public interface ConfigurationRuntimes {

    /**
     * Gets configuration from configuration store
     *
     * @param <T>       The Type of the return.
     * @param storeName The name of configuration store.
     * @param appId     The application id which only used for admin, Ignored and reset for normal client.
     * @param keys      the keys to get.
     * @param metadata  The metadata which will be sent to configuration store components.
     * @param type      The Type needed as return for the call.
     * @return A Mono Plan of response with type T.
     */
    <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, TypeRef<T> type);

    /**
     * Gets configuration from configuration store
     *
     * @param <T>       The Type of the return.
     * @param storeName The name of configuration store.
     * @param appId     The application id which only used for admin, Ignored and reset for normal client.
     * @param keys      the keys to get.
     * @param metadata  The metadata which will be sent to configuration store components.
     * @param group     The group of keys.
     * @param type      The Type needed as return for the call.
     * @return A Mono Plan of response with type T.
     */
    <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, TypeRef<T> type);

    /**
     * Gets configuration from configuration store
     *
     * @param <T>       The Type of the return.
     * @param storeName The name of configuration store.
     * @param appId     The application id which only used for admin, Ignored and reset for normal client.
     * @param keys      the keys to get.
     * @param metadata  The metadata which will be sent to configuration store components.
     * @param group     The group of keys.
     * @param type      The Type needed as return for the call.
     * @param label     The label for keys.
     * @return A Mono Plan of response with type T.
     */
    <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, String label, TypeRef<T> type);

    /**
     * Gets configuration from configuration store
     *
     * @param <T>                      The Type of the return.
     * @param configurationRequestItem Request object.
     * @param type                     The Type needed as return for the call.
     * @return A Mono Plan of response with type T.
     */
    <T> Mono<List<ConfigurationItem<T>>> getConfiguration(ConfigurationRequestItem configurationRequestItem, TypeRef<T> type);

    /**
     * Saves configuration into configuration store.
     *
     * @param saveConfigurationRequest Request object.
     * @return A Mono Plan of invocation.
     */
    Mono<Void> saveConfiguration(SaveConfigurationRequest saveConfigurationRequest);

    /**
     * Deletes configuration from configuration store.
     *
     * @param configurationRequestItem Request object.
     * @return A Mono Plan of invocation.
     */
    Mono<Void> deleteConfiguration(ConfigurationRequestItem configurationRequestItem);

    /**
     * Gets configuration from configuration store and subscribe the updates.
     *
     * @param <T>       The Type of the return.
     * @param storeName The name of configuration store.
     * @param appId     The application id which only used for admin, Ignored and reset for normal client.
     * @param keys      the keys to get and subscribe the updates.
     * @param metadata  The metadata which will be sent to configuration store components.
     * @param type      The Type needed as return for the call.
     * @return A Flux Plan of response with type T. Subscribe update listener.
     */
    <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, TypeRef<T> type);

    /**
     * Gets configuration from configuration store and subscribe the updates.
     *
     * @param <T>       The Type of the return.
     * @param storeName The name of configuration store.
     * @param appId     The application id which only used for admin, Ignored and reset for normal client.
     * @param keys      the keys to get and subscribe the updates.
     * @param metadata  The metadata which will be sent to configuration store components.
     * @param group     The group of keys.
     * @param type      The Type needed as return for the call.
     * @return A Flux Plan of response with type T. Subscribe update listener.
     */
    <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, TypeRef<T> type);

    /**
     * Gets configuration from configuration store and subscribe the updates.
     *
     * @param <T>       The Type of the return.
     * @param storeName The name of configuration store.
     * @param appId     The application id which only used for admin, Ignored and reset for normal client.
     * @param keys      the keys to get and subscribe the updates.
     * @param metadata  The metadata which will be sent to configuration store components.
     * @param group     The group of keys.
     * @param label     The label for keys.
     * @param type      The Type needed as return for the call.
     * @return A Flux Plan of response with type T. Subscribe update listener.
     */
    <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, String label, TypeRef<T> type);

    /**
     * Gets configuration from configuration store and subscribe the updates.
     *
     * @param <T>                      The Type of the return.
     * @param configurationRequestItem Request object.
     * @param type                     The Type needed as return for the call.
     * @return A Flux Plan of response with type T. Subscribe update listener.
     */
    <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(ConfigurationRequestItem configurationRequestItem, TypeRef<T> type);
}
