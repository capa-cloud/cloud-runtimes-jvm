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

public final class Metadata {

    /**
     * Retrieve the S3 access key, used to identify the user interacting with S3.
     */
    public static final String ACCESS_KEY = "accessKey";
    /**
     * Retrieve the S3 secret access key, used to authenticate the user interacting with S3.
     */
    public static final String SECRET_KEY = "secretKey";
    /**
     * Configure the endpoint with which the SDK should communicate.
     */
    public static final String ENDPOINT = "endpoint";

    private Metadata() {
    }
}
