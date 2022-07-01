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

import java.util.Arrays;
import java.util.Map;

/**
 * Put object to oss by bucket name and object key name。
 */
public class PutObjectInput {

    /**
     * Byte stream for the specified object.
     */
    private byte[] data;
    /**
     * The bucket name for the object.
     */
    private String bucket;
    /**
     * Key of the object to put.
     */
    private String key;
    /**
     * Metadata of the object.
     */
    private Map<String, String> metadata;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "PutObjectInput{" +
                "data=" + Arrays.toString(data) +
                ", bucket='" + bucket + '\'' +
                ", key='" + key + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
