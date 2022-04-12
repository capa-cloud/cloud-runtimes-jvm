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

import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.domain.core.invocation.InvokeMethodRequest;
import group.rxcloud.cloudruntimes.domain.core.invocation.RegisterServerRequest;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Service-to-Service Invocation Runtimes standard API defined.
 */
public interface InvocationRuntimes {

    // -- Runtime as Client

    /**
     * Invoke a service method, using serialization.
     *
     * @param <T>           The Type of the return, use byte[] to skip serialization.
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param request       The request to be sent to invoke the service, use byte[] to skip serialization.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param metadata      Metadata (in GRPC) or headers (in HTTP) to be sent in data.
     * @param type          The Type needed as return for the call.
     * @return A Mono Plan of type T.
     */
    <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension,
                             Map<String, String> metadata, TypeRef<T> type);

    /**
     * Invoke a service method, using serialization.
     *
     * @param <T>           The Type of the return, use byte[] to skip serialization.
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param request       The request to be sent to invoke the service, use byte[] to skip serialization.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param metadata      Metadata (in GRPC) or headers (in HTTP) to be sent in request.
     * @param clazz         The type needed as return for the call.
     * @return A Mono Plan of type T.
     */
    <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension,
                             Map<String, String> metadata, Class<T> clazz);

    /**
     * Invoke a service method, using serialization.
     *
     * @param <T>           The Type of the return, use byte[] to skip serialization.
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param request       The request to be sent to invoke the service, use byte[] to skip serialization.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param type          The Type needed as return for the call.
     * @return A Mono Plan of type T.
     */
    <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension,
                             TypeRef<T> type);

    /**
     * Invoke a service method, using serialization.
     *
     * @param <T>           The Type of the return, use byte[] to skip serialization.
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param request       The request to be sent to invoke the service, use byte[] to skip serialization.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param clazz         The type needed as return for the call.
     * @return A Mono Plan of type T.
     */
    <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension,
                             Class<T> clazz);

    /**
     * Invoke a service method, using serialization.
     *
     * @param <T>           The Type of the return, use byte[] to skip serialization.
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param metadata      Metadata (in GRPC) or headers (in HTTP) to be sent in request.
     * @param type          The Type needed as return for the call.
     * @return A Mono Plan of type T.
     */
    <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata,
                             TypeRef<T> type);

    /**
     * Invoke a service method, using serialization.
     *
     * @param <T>           The Type of the return, use byte[] to skip serialization.
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param metadata      Metadata (in GRPC) or headers (in HTTP) to be sent in request.
     * @param clazz         The type needed as return for the call.
     * @return A Mono Plan of type T.
     */
    <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata,
                             Class<T> clazz);

    /**
     * Invoke a service method, using serialization.
     *
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param request       The request to be sent to invoke the service, use byte[] to skip serialization.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param metadata      Metadata (in GRPC) or headers (in HTTP) to be sent in request.
     * @return A Mono Plan of type Void.
     */
    Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension,
                            Map<String, String> metadata);

    /**
     * Invoke a service method, using serialization.
     *
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param request       The request to be sent to invoke the service, use byte[] to skip serialization.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @return A Mono Plan of type Void.
     */
    Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension);

    /**
     * Invoke a service method, using serialization.
     *
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param metadata      Metadata (in GRPC) or headers (in HTTP) to be sent in request.
     * @return A Mono Plan of type Void.
     */
    Mono<Void> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata);

    /**
     * Invoke a service method, without using serialization.
     *
     * @param appId         The Application ID where the service is.
     * @param methodName    The actual Method to be call in the application.
     * @param request       The request to be sent to invoke the service, use byte[] to skip serialization.
     * @param httpExtension Additional fields that are needed if the receiving app is listening on                      HTTP, {@link HttpExtension#NONE} otherwise.
     * @param metadata      Metadata (in GRPC) or headers (in HTTP) to be sent in request.
     * @return A Mono Plan of type byte[].
     */
    Mono<byte[]> invokeMethod(String appId, String methodName, byte[] request, HttpExtension httpExtension,
                              Map<String, String> metadata);

    /**
     * Invoke a service method.
     *
     * @param <T>                 The Type of the return, use byte[] to skip serialization.
     * @param invokeMethodRequest Request object.
     * @param type                The Type needed as return for the call.
     * @return A Mono Plan of type T.
     */
    <T> Mono<T> invokeMethod(InvokeMethodRequest invokeMethodRequest, TypeRef<T> type);

    // -- Runtime as Server

    /**
     * Register onInvoke method when runtime as server.
     *
     * @param <T>            The Type of the request type, use byte[] to skip serialization.
     * @param <R>            The Type of the response type, use byte[] to skip serialization.
     * @param methodName     The actual Method to be call in the application.
     * @param httpExtensions Additional fields that are needed if the receiving app is listening on                       HTTP, {@link HttpExtension#NONE} otherwise.
     * @param onInvoke       the on invoke
     * @param metadata       Metadata (in GRPC) or headers (in HTTP) to be received in request.
     * @return A Mono Plan of register result.
     */
    <T, R> Mono<Boolean> registerMethod(String methodName, List<HttpExtension> httpExtensions,
                                        Function<T, R> onInvoke,
                                        Map<String, String> metadata);

    /**
     * Register controller class when runtime as server.
     *
     * @param registerServerRequest the register server request
     * @return A Mono Plan of register result.
     */
    Mono<Boolean> registerServer(RegisterServerRequest registerServerRequest);
}
