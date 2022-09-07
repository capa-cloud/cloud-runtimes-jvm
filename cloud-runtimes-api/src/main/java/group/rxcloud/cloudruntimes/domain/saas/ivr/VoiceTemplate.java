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

import java.util.Map;

public class VoiceTemplate {

    // Required
    private String templateId;

    // Required
    private Map<String, String> templateParams;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Map<String, String> getTemplateParams() {
        return templateParams;
    }

    public void setTemplateParams(Map<String, String> templateParams) {
        this.templateParams = templateParams;
    }

    @Override
    public String toString() {
        return "VoiceTemplate{" +
                "templateId='" + templateId + '\'' +
                ", templateParams=" + templateParams +
                '}';
    }
}
