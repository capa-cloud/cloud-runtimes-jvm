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
 * List objects from oss by bucket name
 */
public class ListObjectsInput {
    /**
     * Sets the maximum number of keys returned in the response. By default the action
     * returns up to 1,000 key names. The response might contain fewer keys but will
     * never contain more.
     */
    private Integer maxKeys;
    /**
     * Marker is where you want Amazon S3 to start listing from. Amazon S3 starts
     * listing after this specified key. Marker can be any key in the bucket.
     */
    private String marker;
    /**
     * Bucket name.
     */
    private String bucket;

    /**
     * Limits the response to keys that begin with the specified prefix.
     */
    private String prefix;

    public Integer getMaxKeys() {
        return maxKeys;
    }

    public void setMaxKeys(Integer maxKeys) {
        this.maxKeys = maxKeys;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
