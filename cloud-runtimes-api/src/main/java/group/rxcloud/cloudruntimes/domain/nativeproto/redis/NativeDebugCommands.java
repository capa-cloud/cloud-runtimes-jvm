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
package group.rxcloud.cloudruntimes.domain.nativeproto.redis;

/**
 * The Native debugging commands.
 *
 * @see <a href="http://redisdoc.com/debug/index.html">debug</a>
 */
public interface NativeDebugCommands {

    /**
     * Ping string.
     *
     * @return <code>PONG</code>
     */
    String ping();

    // TODO: 2022/5/28 ECHO
    // TODO: 2022/5/28 OBJECT
    // TODO: 2022/5/28 SLOWLOG
    // TODO: 2022/5/28 MONITOR
    // TODO: 2022/5/28 DEBUG_OBJECT
    // TODO: 2022/5/28 DEBUG_SEGFAULT
}
