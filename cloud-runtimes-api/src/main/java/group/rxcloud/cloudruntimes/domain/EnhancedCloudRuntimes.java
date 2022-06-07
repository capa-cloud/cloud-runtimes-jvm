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

import group.rxcloud.cloudruntimes.domain.enhanced.DatabaseRuntimes;
import group.rxcloud.cloudruntimes.domain.enhanced.FileRuntimes;
import group.rxcloud.cloudruntimes.domain.enhanced.LockRuntimes;
import group.rxcloud.cloudruntimes.domain.enhanced.ScheduleRuntimes;
import group.rxcloud.cloudruntimes.domain.enhanced.TelemetryRuntimes;
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

import java.util.Map;

/**
 * Enhanced Cloud Runtimes standard API defined.
 */
public interface EnhancedCloudRuntimes extends
        TelemetryRuntimes,
        DatabaseRuntimes,
        ScheduleRuntimes,
        FileRuntimes,
        LockRuntimes {

    @Override
    default Mono<GetConnectionResponse> getConnection(GetConnectionRequest req) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<CreateTableResponse> createTable(CreateTableRequest req) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<DeleteTableResponse> deleteTable(DeleteTableRequest req) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<InsertResponse> insert(InsertRequest req) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<InsertResponse> insert(String dbName, String tableName, Object data) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<QueryResponse<T>> query(QueryRequest req, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default <T> Mono<QueryResponse<T>> query(String dbName, String tableName, Object data, TypeRef<T> type) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<UpdateResponse> update(UpdateRequest req) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<UpdateResponse> update(String dbName, String tableName, Object data) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> BeginTransaction() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> UpdateTransaction() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> QueryTransaction() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> CommitTransaction() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> RollbackTransaction() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<GetFileResponse> getFile(GetFileRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> putFile(Flux<PutFileRequest> requests) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<ListFileResp> listFile(ListFileRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Void> delFile(DelFileRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<TryLockResponse> tryLock(TryLockRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<UnlockResponse> unlock(UnlockRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Flux<Object> invokeSchedule(String appId, String jobName, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Tracer> buildTracer(String tracerName) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Tracer> buildTracer(String tracerName, String version) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Tracer> buildTracer(String tracerName, String version, String schemaUrl) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<ContextPropagators> getContextPropagators() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Meter> buildMeter(String meterName) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Meter> buildMeter(String meterName, String version) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<Meter> buildMeter(String meterName, String version, String schemaUrl) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }
}
