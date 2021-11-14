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

import group.rxcloud.cloudruntimes.domain.core.secrets.GetBulkSecretRequest;
import group.rxcloud.cloudruntimes.domain.core.secrets.GetSecretRequest;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Secrets Runtimes standard API defined.
 */
public interface SecretsRuntimes {

    /**
     * Fetches a secret from the configured vault.
     *
     * @param storeName  Name of vault component in CloudRuntimes.
     * @param secretName Secret to be fetched.
     * @param metadata   Optional metadata.
     * @return Key-value pairs for the secret.
     */
    Mono<Map<String, String>> getSecret(String storeName, String secretName, Map<String, String> metadata);

    /**
     * Fetches a secret from the configured vault.
     *
     * @param storeName  Name of vault component in CloudRuntimes.
     * @param secretName Secret to be fetched.
     * @return Key-value pairs for the secret.
     */
    Mono<Map<String, String>> getSecret(String storeName, String secretName);

    /**
     * Fetches a secret from the configured vault.
     *
     * @param request Request to fetch secret.
     * @return Key-value pairs for the secret.
     */
    Mono<Map<String, String>> getSecret(GetSecretRequest request);

    /**
     * Fetches all secrets from the configured vault.
     *
     * @param storeName Name of vault component in CloudRuntimes.
     * @return Key-value pairs for all the secrets in the state store.
     */
    Mono<Map<String, Map<String, String>>> getBulkSecret(String storeName);

    /**
     * Fetches all secrets from the configured vault.
     *
     * @param storeName Name of vault component in CloudRuntimes.
     * @param metadata  Optional metadata.
     * @return Key-value pairs for all the secrets in the state store.
     */
    Mono<Map<String, Map<String, String>>> getBulkSecret(String storeName, Map<String, String> metadata);

    /**
     * Fetches all secrets from the configured vault.
     *
     * @param request Request to fetch secret.
     * @return Key-value pairs for the secret.
     */
    Mono<Map<String, Map<String, String>>> getBulkSecret(GetBulkSecretRequest request);
}
