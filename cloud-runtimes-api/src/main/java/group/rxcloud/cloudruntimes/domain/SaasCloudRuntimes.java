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

import group.rxcloud.cloudruntimes.domain.saas.SaasCryptionRuntimes;
import group.rxcloud.cloudruntimes.domain.saas.SaasEmailRuntimes;
import group.rxcloud.cloudruntimes.domain.saas.SaasIMRuntimes;
import group.rxcloud.cloudruntimes.domain.saas.SaasIvrRuntimes;
import group.rxcloud.cloudruntimes.domain.saas.SaasProxyRuntimes;
import group.rxcloud.cloudruntimes.domain.saas.SaasSMSRuntimes;
import group.rxcloud.cloudruntimes.domain.saas.cryption.CryptRequest;
import group.rxcloud.cloudruntimes.domain.saas.cryption.CryptResponse;
import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailRequest;
import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailResponse;
import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailWithTemplateRequest;
import group.rxcloud.cloudruntimes.domain.saas.email.SendEmailWithTemplateResponse;
import group.rxcloud.cloudruntimes.domain.saas.im.SendIMRequest;
import group.rxcloud.cloudruntimes.domain.saas.im.SendIMResponse;
import group.rxcloud.cloudruntimes.domain.saas.ivr.SendVoiceWithTemplateRequest;
import group.rxcloud.cloudruntimes.domain.saas.ivr.SendVoiceWithTemplateResponse;
import group.rxcloud.cloudruntimes.domain.saas.proxy.ProxyRequest;
import group.rxcloud.cloudruntimes.domain.saas.proxy.ProxyResponse;
import group.rxcloud.cloudruntimes.domain.saas.sms.SendSMSRequest;
import group.rxcloud.cloudruntimes.domain.saas.sms.SendSMSResponse;
import reactor.core.publisher.Mono;

public interface SaasCloudRuntimes extends
        SaasCryptionRuntimes,
        SaasEmailRuntimes,
        SaasIMRuntimes,
        SaasIvrRuntimes,
        SaasProxyRuntimes,
        SaasSMSRuntimes {

    @Override
    default Mono<CryptResponse> encrypt(CryptRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<CryptResponse> decrypt(CryptRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<SendEmailResponse> sendEmail(SendEmailRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<SendEmailWithTemplateResponse> sendEmailWithTemplate(SendEmailWithTemplateRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<SendIMResponse> sendIM(SendIMRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<SendVoiceWithTemplateResponse> sendVoiceWithTemplate(SendVoiceWithTemplateRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<ProxyResponse> getProxyInfo(ProxyRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<SendSMSResponse> sendSMS(SendSMSRequest request) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }
}
