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
 * The Native admin commands.
 *
 * @see <a href="http://redisdoc.com/configure/index.html">configure</a>
 * @see <a href="http://redisdoc.com/client_and_server/index.html">client_and_server</a>
 * @see <a href="http://redisdoc.com/replication/index.html">replication</a>
 */
public interface NativeAdminCommands {

    // -- configure

    // TODO: 2022/5/28 CONFIG_SET
    // TODO: 2022/5/28 CONFIG_GET
    // TODO: 2022/5/28 CONFIG_RESETSTAT
    // TODO: 2022/5/28 CONFIG_REWRITE

    // -- client_and_server

    // TODO: 2022/5/28 AUTH
    // TODO: 2022/5/28 QUIT
    // TODO: 2022/5/28 INFO
    // TODO: 2022/5/28 SHUTDOWN
    // TODO: 2022/5/28 TIME
    // TODO: 2022/5/28 CLIENT_GETNAME
    // TODO: 2022/5/28 CLIENT_KILL
    // TODO: 2022/5/28 CLIENT_LIST
    // TODO: 2022/5/28 CLIENT_SETNAME

    // -- replication

    // TODO: 2022/5/28 SLAVEOF
    // TODO: 2022/5/28 ROLE
}
