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

import java.util.List;

/**
 * List objects from oss by bucket name
 */
public class ListObjectsOutput {
    /**
     * Key List.
     */
    private List<String> contents;
    /**
     * A flag that indicates whether Amazon S3 returned all of the results that satisfied the search criteria.
     */
    private Boolean isTruncated;

    /**
     * Indicates where in the bucket listing begins. Marker is included in the response
     * if it was sent with the request.
     */
    private String marker;

    /**
     * When response is truncated (the IsTruncated element value in the response is
     * true), you can use the key name in this field as marker in the subsequent
     * request to get next set of objects.
     */
    private String nextMarker;

    /**
     * Keys that begin with the indicated prefix.
     */
    private String prefix;

    /**
     * The maximum number of keys returned in the response body.
     */
    private Integer maxKeys;

    /**
     * The bucket name.
     */
    private String name;

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    public Boolean getTruncated() {
        return isTruncated;
    }

    public void setTruncated(Boolean truncated) {
        isTruncated = truncated;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getNextMarker() {
        return nextMarker;
    }

    public void setNextMarker(String nextMarker) {
        this.nextMarker = nextMarker;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getMaxKeys() {
        return maxKeys;
    }

    public void setMaxKeys(Integer maxKeys) {
        this.maxKeys = maxKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
