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
package group.rxcloud.cloudruntimes.domain.saas.sms;

import java.util.Map;

public class SendSMSRequest {

    /**
     * The saas service name, like 'aliyun.sms'/'aws.pinpoint'/'...'
     * If your system uses multiple IM services at the same time,
     * you can specify which service to use with this field.
     */
    private String serviceName;

    private String settingId;

    private SMSContent content;

    private SMSAddress address;

    private Map<String, String> metadata;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSettingId() {
        return settingId;
    }

    public void setSettingId(String settingId) {
        this.settingId = settingId;
    }

    public SMSContent getContent() {
        return content;
    }

    public void setContent(SMSContent content) {
        this.content = content;
    }

    public SMSAddress getAddress() {
        return address;
    }

    public void setAddress(SMSAddress address) {
        this.address = address;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "SendSMSRequest{" +
                "serviceName='" + serviceName + '\'' +
                ", settingId='" + settingId + '\'' +
                ", content=" + content +
                ", address=" + address +
                ", metadata=" + metadata +
                '}';
    }
}
