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
package group.rxcloud.cloudruntimes.domain.saas.ivr;

import java.util.List;

public class SendVoiceWithTemplateRequest {

    // If your system uses multiple IVR services at the same time,
    // you can specify which service to use with this field.
    private String serviceName;

    private String settingId;

    // Required
    private VoiceTemplate template;

    // Required
    private List<String> toMobileList;

    // This field is required by some cloud providers.
    private String fromMobile;

    public String getSettingId() {
        return settingId;
    }

    public void setSettingId(String settingId) {
        this.settingId = settingId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public VoiceTemplate getTemplate() {
        return template;
    }

    public void setTemplate(VoiceTemplate template) {
        this.template = template;
    }

    public List<String> getToMobileList() {
        return toMobileList;
    }

    public void setToMobileList(List<String> toMobileList) {
        this.toMobileList = toMobileList;
    }

    public String getFromMobile() {
        return fromMobile;
    }

    public void setFromMobile(String fromMobile) {
        this.fromMobile = fromMobile;
    }

    @Override
    public String toString() {
        return "SendVoiceWithTemplateRequest{" +
                "serviceName='" + serviceName + '\'' +
                ", settingId='" + settingId + '\'' +
                ", template=" + template +
                ", toMobileList=" + toMobileList +
                ", fromMobile='" + fromMobile + '\'' +
                '}';
    }
}
