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

import group.rxcloud.cloudruntimes.client.DefaultCloudRuntimesClient;
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
import group.rxcloud.cloudruntimes.domain.enhanced.database.CreateTableRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.database.CreateTableResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.database.DeleteTableRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.database.DeleteTableResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.database.GetConnectionRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.database.GetConnectionResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.database.InsertRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.database.InsertResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.database.QueryRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.database.QueryResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.database.UpdateRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.database.UpdateResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.file.DelFileRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.file.GetFileRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.file.GetFileResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.file.ListFileRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.file.ListFileResp;
import group.rxcloud.cloudruntimes.domain.enhanced.file.PutFileRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.lock.TryLockRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.lock.TryLockResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.lock.UnlockRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.lock.UnlockResponse;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.propagation.ContextPropagators;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CapaCloudRuntimesClient implements DefaultCloudRuntimesClient {

    @Override
    public List<String> registryNames() {
        return Collections.singletonList("capa");
    }

    @Override
    public Mono<Void> waitForSidecar(int timeoutInMilliseconds) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> invokeBinding(String bindingName, String operation, Object data) {
        return DefaultCloudRuntimesClient.super.invokeBinding(bindingName, operation, data);
    }

    @Override
    public Mono<byte[]> invokeBinding(String bindingName, String operation, byte[] data, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.invokeBinding(bindingName, operation, data, metadata);
    }

    @Override
    public <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.invokeBinding(bindingName, operation, data, type);
    }

    @Override
    public <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.invokeBinding(bindingName, operation, data, clazz);
    }

    @Override
    public <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, Map<String, String> metadata, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.invokeBinding(bindingName, operation, data, metadata, type);
    }

    @Override
    public <T> Mono<T> invokeBinding(String bindingName, String operation, Object data, Map<String, String> metadata, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.invokeBinding(bindingName, operation, data, metadata, clazz);
    }

    @Override
    public <T> Mono<T> invokeBinding(InvokeBindingRequest request, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.invokeBinding(request, type);
    }

    @Override
    public <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, request, httpExtension, metadata, type);
    }

    @Override
    public <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, request, httpExtension, metadata, clazz);
    }

    @Override
    public <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, request, httpExtension, type);
    }

    @Override
    public <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, request, httpExtension, clazz);
    }

    @Override
    public <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, httpExtension, metadata, type);
    }

    @Override
    public <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, httpExtension, metadata, clazz);
    }

    @Override
    public Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, request, httpExtension, metadata);
    }

    @Override
    public Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, request, httpExtension);
    }

    @Override
    public Mono<Void> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, httpExtension, metadata);
    }

    @Override
    public Mono<byte[]> invokeMethod(String appId, String methodName, byte[] request, HttpExtension httpExtension, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.invokeMethod(appId, methodName, request, httpExtension, metadata);
    }

    @Override
    public <T> Mono<T> invokeMethod(InvokeMethodRequest invokeMethodRequest, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.invokeMethod(invokeMethodRequest, type);
    }

    @Override
    public Mono<String> publishEvent(String pubsubName, String topicName, Object data) {
        return DefaultCloudRuntimesClient.super.publishEvent(pubsubName, topicName, data);
    }

    @Override
    public Mono<String> publishEvent(String pubsubName, String topicName, Object data, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.publishEvent(pubsubName, topicName, data, metadata);
    }

    @Override
    public Mono<String> publishEvent(PublishEventRequest request) {
        return DefaultCloudRuntimesClient.super.publishEvent(request);
    }

    @Override
    public Mono<Map<String, String>> getSecret(String storeName, String secretName, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.getSecret(storeName, secretName, metadata);
    }

    @Override
    public Mono<Map<String, String>> getSecret(String storeName, String secretName) {
        return DefaultCloudRuntimesClient.super.getSecret(storeName, secretName);
    }

    @Override
    public Mono<Map<String, String>> getSecret(GetSecretRequest request) {
        return DefaultCloudRuntimesClient.super.getSecret(request);
    }

    @Override
    public Mono<Map<String, Map<String, String>>> getBulkSecret(String storeName) {
        return DefaultCloudRuntimesClient.super.getBulkSecret(storeName);
    }

    @Override
    public Mono<Map<String, Map<String, String>>> getBulkSecret(String storeName, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.getBulkSecret(storeName, metadata);
    }

    @Override
    public Mono<Map<String, Map<String, String>>> getBulkSecret(GetBulkSecretRequest request) {
        return DefaultCloudRuntimesClient.super.getBulkSecret(request);
    }

    @Override
    public <T> Mono<State<T>> getState(String storeName, State<T> state, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getState(storeName, state, type);
    }

    @Override
    public <T> Mono<State<T>> getState(String storeName, State<T> state, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.getState(storeName, state, clazz);
    }

    @Override
    public <T> Mono<State<T>> getState(String storeName, String key, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getState(storeName, key, type);
    }

    @Override
    public <T> Mono<State<T>> getState(String storeName, String key, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.getState(storeName, key, clazz);
    }

    @Override
    public <T> Mono<State<T>> getState(String storeName, String key, StateOptions options, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getState(storeName, key, options, type);
    }

    @Override
    public <T> Mono<State<T>> getState(String storeName, String key, StateOptions options, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.getState(storeName, key, options, clazz);
    }

    @Override
    public <T> Mono<State<T>> getState(GetStateRequest request, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getState(request, type);
    }

    @Override
    public <T> Mono<List<State<T>>> getBulkState(String storeName, List<String> keys, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getBulkState(storeName, keys, type);
    }

    @Override
    public <T> Mono<List<State<T>>> getBulkState(String storeName, List<String> keys, Class<T> clazz) {
        return DefaultCloudRuntimesClient.super.getBulkState(storeName, keys, clazz);
    }

    @Override
    public <T> Mono<List<State<T>>> getBulkState(GetBulkStateRequest request, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getBulkState(request, type);
    }

    @Override
    public Mono<Void> executeStateTransaction(String storeName, List<TransactionalStateOperation<?>> operations) {
        return DefaultCloudRuntimesClient.super.executeStateTransaction(storeName, operations);
    }

    @Override
    public Mono<Void> executeStateTransaction(ExecuteStateTransactionRequest request) {
        return DefaultCloudRuntimesClient.super.executeStateTransaction(request);
    }

    @Override
    public Mono<Void> saveBulkState(String storeName, List<State<?>> states) {
        return DefaultCloudRuntimesClient.super.saveBulkState(storeName, states);
    }

    @Override
    public Mono<Void> saveBulkState(SaveStateRequest request) {
        return DefaultCloudRuntimesClient.super.saveBulkState(request);
    }

    @Override
    public Mono<Void> saveState(String storeName, String key, Object value) {
        return DefaultCloudRuntimesClient.super.saveState(storeName, key, value);
    }

    @Override
    public Mono<Void> saveState(String storeName, String key, String etag, Object value, StateOptions options) {
        return DefaultCloudRuntimesClient.super.saveState(storeName, key, etag, value, options);
    }

    @Override
    public Mono<Void> deleteState(String storeName, String key) {
        return DefaultCloudRuntimesClient.super.deleteState(storeName, key);
    }

    @Override
    public Mono<Void> deleteState(String storeName, String key, String etag, StateOptions options) {
        return DefaultCloudRuntimesClient.super.deleteState(storeName, key, etag, options);
    }

    @Override
    public Mono<Void> deleteState(DeleteStateRequest request) {
        return DefaultCloudRuntimesClient.super.deleteState(request);
    }

    @Override
    public <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getConfiguration(storeName, appId, keys, metadata, type);
    }

    @Override
    public <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getConfiguration(storeName, appId, keys, metadata, group, type);
    }

    @Override
    public <T> Mono<List<ConfigurationItem<T>>> getConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, String label, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getConfiguration(storeName, appId, keys, metadata, group, label, type);
    }

    @Override
    public <T> Mono<List<ConfigurationItem<T>>> getConfiguration(ConfigurationRequestItem configurationRequestItem, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.getConfiguration(configurationRequestItem, type);
    }

    @Override
    public Mono<Void> saveConfiguration(SaveConfigurationRequest saveConfigurationRequest) {
        return DefaultCloudRuntimesClient.super.saveConfiguration(saveConfigurationRequest);
    }

    @Override
    public Mono<Void> deleteConfiguration(ConfigurationRequestItem configurationRequestItem) {
        return DefaultCloudRuntimesClient.super.deleteConfiguration(configurationRequestItem);
    }

    @Override
    public <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.subscribeConfiguration(storeName, appId, keys, metadata, type);
    }

    @Override
    public <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.subscribeConfiguration(storeName, appId, keys, metadata, group, type);
    }

    @Override
    public <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(String storeName, String appId, List<String> keys, Map<String, String> metadata, String group, String label, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.subscribeConfiguration(storeName, appId, keys, metadata, group, label, type);
    }

    @Override
    public <T> Flux<SubConfigurationResp<T>> subscribeConfiguration(ConfigurationRequestItem configurationRequestItem, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.subscribeConfiguration(configurationRequestItem, type);
    }

    @Override
    public Mono<GetConnectionResponse> getConnection(GetConnectionRequest req) {
        return DefaultCloudRuntimesClient.super.getConnection(req);
    }

    @Override
    public Mono<CreateTableResponse> createTable(CreateTableRequest req) {
        return DefaultCloudRuntimesClient.super.createTable(req);
    }

    @Override
    public Mono<DeleteTableResponse> deleteTable(DeleteTableRequest req) {
        return DefaultCloudRuntimesClient.super.deleteTable(req);
    }

    @Override
    public Mono<InsertResponse> insert(InsertRequest req) {
        return DefaultCloudRuntimesClient.super.insert(req);
    }

    @Override
    public <T> Mono<QueryResponse<T>> query(QueryRequest req, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.query(req, type);
    }

    @Override
    public Mono<UpdateResponse> update(UpdateRequest req) {
        return DefaultCloudRuntimesClient.super.update(req);
    }

    @Override
    public Mono<InsertResponse> insert(String dbName, String tableName, Object data) {
        return DefaultCloudRuntimesClient.super.insert(dbName, tableName, data);
    }

    @Override
    public <T> Mono<QueryResponse<T>> query(String dbName, String tableName, Object data, TypeRef<T> type) {
        return DefaultCloudRuntimesClient.super.query(dbName, tableName, data, type);
    }

    @Override
    public Mono<UpdateResponse> update(String dbName, String tableName, Object data) {
        return DefaultCloudRuntimesClient.super.update(dbName, tableName, data);
    }

    @Override
    public Mono<Void> BeginTransaction() {
        return DefaultCloudRuntimesClient.super.BeginTransaction();
    }

    @Override
    public Mono<Void> UpdateTransaction() {
        return DefaultCloudRuntimesClient.super.UpdateTransaction();
    }

    @Override
    public Mono<Void> QueryTransaction() {
        return DefaultCloudRuntimesClient.super.QueryTransaction();
    }

    @Override
    public Mono<Void> CommitTransaction() {
        return DefaultCloudRuntimesClient.super.CommitTransaction();
    }

    @Override
    public Mono<Void> RollbackTransaction() {
        return DefaultCloudRuntimesClient.super.RollbackTransaction();
    }

    @Override
    public Mono<Tracer> buildTracer(String tracerName) {
        return DefaultCloudRuntimesClient.super.buildTracer(tracerName);
    }

    @Override
    public Mono<Tracer> buildTracer(String tracerName, String version) {
        return DefaultCloudRuntimesClient.super.buildTracer(tracerName, version);
    }

    @Override
    public Mono<Tracer> buildTracer(String tracerName, String version, String schemaUrl) {
        return DefaultCloudRuntimesClient.super.buildTracer(tracerName, version, schemaUrl);
    }

    @Override
    public Mono<ContextPropagators> getContextPropagators() {
        return DefaultCloudRuntimesClient.super.getContextPropagators();
    }

    @Override
    public Mono<Meter> buildMeter(String meterName) {
        return DefaultCloudRuntimesClient.super.buildMeter(meterName);
    }

    @Override
    public Mono<Meter> buildMeter(String meterName, String version) {
        return DefaultCloudRuntimesClient.super.buildMeter(meterName, version);
    }

    @Override
    public Mono<Meter> buildMeter(String meterName, String version, String schemaUrl) {
        return DefaultCloudRuntimesClient.super.buildMeter(meterName, version, schemaUrl);
    }

    @Override
    public Flux<Object> invokeSchedule(String appId, String jobName, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.invokeSchedule(appId, jobName, metadata);
    }

    @Override
    public Mono<GetFileResponse> getFile(GetFileRequest request) {
        return DefaultCloudRuntimesClient.super.getFile(request);
    }

    @Override
    public Mono<String> putFile(Flux<PutFileRequest> requests) {
        return DefaultCloudRuntimesClient.super.putFile(requests);
    }

    @Override
    public Mono<ListFileResp> listFile(ListFileRequest request) {
        return DefaultCloudRuntimesClient.super.listFile(request);
    }

    @Override
    public Mono<Void> delFile(DelFileRequest request) {
        return DefaultCloudRuntimesClient.super.delFile(request);
    }

    @Override
    public Mono<TryLockResponse> tryLock(TryLockRequest request) {
        return DefaultCloudRuntimesClient.super.tryLock(request);
    }

    @Override
    public Mono<UnlockResponse> unlock(UnlockRequest request) {
        return DefaultCloudRuntimesClient.super.unlock(request);
    }

    @Override
    public <T, R> Mono<Boolean> registerMethod(String methodName, List<HttpExtension> httpExtensions, Function<T, R> onInvoke, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.registerMethod(methodName, httpExtensions, onInvoke, metadata);
    }

    @Override
    public Mono<Boolean> registerServer(RegisterServerRequest registerServerRequest) {
        return DefaultCloudRuntimesClient.super.registerServer(registerServerRequest);
    }

    @Override
    public Flux<TopicEventRequest> subscribeEvents(String pubsubName, String topicName, Map<String, String> metadata) {
        return DefaultCloudRuntimesClient.super.subscribeEvents(pubsubName, topicName, metadata);
    }

    @Override
    public Flux<TopicEventRequest> subscribeEvents(TopicSubscription topicSubscription) {
        return DefaultCloudRuntimesClient.super.subscribeEvents(topicSubscription);
    }

    @Override
    public Mono<Void> shutdown() {
        return Mono.empty();
    }

    @Override
    public void close() {
    }
}
