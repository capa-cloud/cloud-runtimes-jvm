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
package group.rxcloud.cloudruntimes.domain.saas;

import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailRequest;
import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailResponse;
import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailWithTemplateRequest;
import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailWithTemplateResponse;
import reactor.core.publisher.Mono;

/**
 * The Saas email notify API.
 */
public interface SaasEmailRuntimes {

    /**
     * Send email.
     */
    Mono<SendEmailResponse> sendEmail(SendEmailRequest request);

    /**
     * Send email with template.
     */
    Mono<SendEmailWithTemplateResponse> sendEmailWithTemplate(SendEmailWithTemplateRequest request);
}
