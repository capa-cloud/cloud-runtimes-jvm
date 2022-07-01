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
package group.rxcloud.cloudruntimes.domain.nativeproto.awss3;

/**
 * Delete object from oss by bucket name and object key name。
 */
public class DeleteObjectOutput {

    /**
     * Specifies whether the object retrieved was (true) or was not (false) a Delete Marker.
     */
    private boolean deleteMarker;
    /**
     * The value of the RequestCharged property for this object.
     */
    private String requestCharged;
    /**
     * Version of the object.
     */
    private String versionId;

    public boolean isDeleteMarker() {
        return deleteMarker;
    }

    public void setDeleteMarker(boolean deleteMarker) {
        this.deleteMarker = deleteMarker;
    }

    public String getRequestCharged() {
        return requestCharged;
    }

    public void setRequestCharged(String requestCharged) {
        this.requestCharged = requestCharged;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "DeleteObjectOutput{" +
                "deleteMarker=" + deleteMarker +
                ", requestCharged='" + requestCharged + '\'' +
                ", versionId='" + versionId + '\'' +
                '}';
    }
}
