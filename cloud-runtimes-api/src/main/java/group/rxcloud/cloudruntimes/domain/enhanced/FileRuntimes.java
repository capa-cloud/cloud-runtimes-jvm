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
package group.rxcloud.cloudruntimes.domain.enhanced;

import group.rxcloud.cloudruntimes.domain.enhanced.file.DelFileRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.file.GetFileRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.file.GetFileResponse;
import group.rxcloud.cloudruntimes.domain.enhanced.file.ListFileRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.file.ListFileResp;
import group.rxcloud.cloudruntimes.domain.enhanced.file.PutFileRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * File API defined.
 */
public interface FileRuntimes {

    /**
     * Get file
     *
     * @param request the request
     * @return the file
     */
    Mono<GetFileResponse> getFile(GetFileRequest request);

    /**
     * Put file with stream
     *
     * @param requests the requests
     * @return the mono
     */
    Mono<String> putFile(Flux<PutFileRequest> requests);

    /**
     * List all files
     *
     * @param request the request
     * @return the mono
     */
    Mono<ListFileResp> listFile(ListFileRequest request);

    /**
     * Delete specific file
     *
     * @param request the request
     * @return the mono
     */
    Mono<Void> delFile(DelFileRequest request);
}
