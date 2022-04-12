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
package group.rxcloud.cloudruntimes.domain.core.invocation;

import java.util.List;
import java.util.Map;

/**
 * A request to register a server.
 */
public class RegisterServerRequest {

    private String appId;

    private String serverName;

    private Class controllerClass;

    private List<HttpExtension> httpExtensions;

    private String contentType;

    private Map<String, String> metadata;

    public String getAppId() {
        return appId;
    }

    public String getServerName() {
        return serverName;
    }

    public Class getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class controllerClass) {
        this.controllerClass = controllerClass;
    }

    public List<HttpExtension> getHttpExtensions() {
        return httpExtensions;
    }

    public void setHttpExtensions(List<HttpExtension> httpExtensions) {
        this.httpExtensions = httpExtensions;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
