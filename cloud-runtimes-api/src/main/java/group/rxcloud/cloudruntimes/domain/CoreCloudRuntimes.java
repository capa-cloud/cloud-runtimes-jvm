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
package group.rxcloud.cloudruntimes.domain;

import group.rxcloud.cloudruntimes.domain.core.InvocationRuntimes;
import group.rxcloud.cloudruntimes.domain.core.PubSubRuntimes;
import group.rxcloud.cloudruntimes.domain.core.BindingRuntimes;
import group.rxcloud.cloudruntimes.domain.core.StateRuntimes;
import group.rxcloud.cloudruntimes.domain.core.SecretsRuntimes;
import group.rxcloud.cloudruntimes.domain.core.ConfigurationRuntimes;
import group.rxcloud.cloudruntimes.domain.core.binding.InvokeBindingRequest;
import group.rxcloud.cloudruntimes.domain.core.configuration.ConfigurationItem;
import group.rxcloud.cloudruntimes.domain.core.configuration.ConfigurationRequestItem;
import group.rxcloud.cloudruntimes.domain.core.configuration.SaveConfigurationRequest;
import group.rxcloud.cloudruntimes.domain.core.configuration.SubConfigurationResp;
import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.domain.core.invocation.InvokeMethodRequest;
import group.rxcloud.cloudruntimes.domain.core.invocation.RegisterServerRequest;
import group.rxcloud.cloudruntimes.domain.core.pubsub.PublishEventRequest;
import group.rxcloud.cloudruntimes.domain.core.pubsub.TopicEventRequest;
import group.rxcloud.cloudruntimes.domain.core.pubsub.TopicSubscription;
import group.rxcloud.cloudruntimes.domain.core.secrets.GetBulkSecretRequest;
import group.rxcloud.cloudruntimes.domain.core.secrets.GetSecretRequest;
import group.rxcloud.cloudruntimes.domain.core.state.DeleteStateRequest;
import group.rxcloud.cloudruntimes.domain.core.state.ExecuteStateTransactionRequest;
import group.rxcloud.cloudruntimes.domain.core.state.GetBulkStateRequest;
import group.rxcloud.cloudruntimes.domain.core.state.GetStateRequest;
import group.rxcloud.cloudruntimes.domain.core.state.SaveStateRequest;
import group.rxcloud.cloudruntimes.domain.core.state.State;
import group.rxcloud.cloudruntimes.domain.core.state.StateOptions;
import group.rxcloud.cloudruntimes.domain.core.state.TransactionalStateOperation;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Core Cloud Runtimes standard API defined.
 */
public interface CoreCloudRuntimes extends
        InvocationRuntimes,
        PubSubRuntimes,
        BindingRuntimes,
        StateRuntimes,
        SecretsRuntimes,
        ConfigurationRuntimes {

    @Override
    default Mono<Void> invokeBinding(String bindingName, String operation, Object data) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<byte[]> invokeBinding(String bindingName, String operation, byte[] data, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, Map<String, String> metadata, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, Map<String, String> metadata, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeBinding(InvokeBindingRequest request, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, String label, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<List<ConfigurationItem<T>>> getConfiguration(ConfigurationRequestItem configurationRequestItem, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> saveConfiguration(SaveConfigurationRequest saveConfigurationRequest) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> deleteConfiguration(ConfigurationRequestItem configurationRequestItem) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, String label, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(ConfigurationRequestItem configurationRequestItem, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<byte[]> invokeMethod(String appId, String methodName, byte[] request, HttpExtension httpExtension, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<T> invokeMethod(InvokeMethodRequest invokeMethodRequest, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T, R> Mono<Boolean> registerMethod(String methodName, List<HttpExtension> httpExtensions, Function<T, R> onInvoke, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Boolean> registerServer(RegisterServerRequest registerServerRequest) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<String> publishEvent(String pubsubName, String topicName, Object data) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<String> publishEvent(String pubsubName, String topicName, Object data, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<String> publishEvent(PublishEventRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Flux<TopicEventRequest> subscribeEvents(String pubsubName, String topicName, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Flux<TopicEventRequest> subscribeEvents(TopicSubscription topicSubscription) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Map<String, String>> getSecret(String storeName, String secretName, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Map<String, String>> getSecret(String storeName, String secretName) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Map<String, String>> getSecret(GetSecretRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Map<String, Map<String, String>>> getBulkSecret(String storeName) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Map<String, Map<String, String>>> getBulkSecret(String storeName, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Map<String, Map<String, String>>> getBulkSecret(GetBulkSecretRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<State<T>> getState(String storeName, State<T> state, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<State<T>> getState(String storeName, State<T> state, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<State<T>> getState(String storeName, String key, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<State<T>> getState(String storeName, String key, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<State<T>> getState(String storeName, String key, StateOptions options, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<State<T>> getState(String storeName, String key, StateOptions options, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<State<T>> getState(GetStateRequest request, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<List<State<T>>> getBulkState(String storeName, List<String> keys, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<List<State<T>>> getBulkState(String storeName, List<String> keys, Class<T> clazz) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<List<State<T>>> getBulkState(GetBulkStateRequest request, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> executeStateTransaction(String storeName, List<TransactionalStateOperation<?>> operations) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> executeStateTransaction(ExecuteStateTransactionRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> saveBulkState(String storeName, List<State<?>> states) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> saveBulkState(SaveStateRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> saveState(String storeName, String key, Object value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> saveState(String storeName, String key, String etag, Object value, StateOptions options) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> deleteState(String storeName, String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> deleteState(String storeName, String key, String etag, StateOptions options) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> deleteState(DeleteStateRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }
}
