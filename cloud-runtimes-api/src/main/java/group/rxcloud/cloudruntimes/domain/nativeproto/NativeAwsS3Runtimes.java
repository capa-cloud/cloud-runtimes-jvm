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
package group.rxcloud.cloudruntimes.domain.nativeproto;

import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.DeleteObjectInput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.DeleteObjectOutput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.IsObjectExistInput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.IsObjectExistOutput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.GetObjectInput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.GetObjectOutput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.InitRequest;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.ListObjectsInput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.ListObjectsOutput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.PutObjectInput;
import group.rxcloud.cloudruntimes.domain.nativeproto.awss3.PutObjectOutput;
import reactor.core.publisher.Mono;

/**
 * Native OSS AWS S3 API defined.
 */
public interface NativeAwsS3Runtimes {

    /**
     * Initialize the s3 client.
     *
     * @param initRequest the init request
     */
    void initClient(InitRequest initRequest);

    /**
     * Put a object to oss。
     *
     * @param putObjectInput the put object input
     * @return mono of result
     */
    Mono<PutObjectOutput> putObject(PutObjectInput putObjectInput);

    /**
     * Get a object from oss.
     *
     * @param getObjectInput the get object input
     * @return mono of result
     */
    Mono<GetObjectOutput> getObject(GetObjectInput getObjectInput);

    /**
     * Delete the object from oss。
     *
     * @param deleteObjectInput the delete object input
     * @return mono of result
     */
    Mono<DeleteObjectOutput> deleteObject(DeleteObjectInput deleteObjectInput);

    /**
     * List objects from oss.
     *
     * @param listObjectsInput
     * @return
     */
    Mono<ListObjectsOutput> listObjects(ListObjectsInput listObjectsInput);

    /**
     * Check if an object exists.
     *
     * @param isObjectExistInput
     * @return
     */
    Mono<IsObjectExistOutput> isObjectExist(IsObjectExistInput isObjectExistInput);
}
