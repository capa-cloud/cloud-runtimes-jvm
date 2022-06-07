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
 * The Native database commands.
 *
 * @see <a href="http://redisdoc.com/database/index.html">database</a>
 */
public interface NativeDatabaseCommands {

    /**
     * Move key from the currently selected database to the specified destination database.
     * When key already exists in the destination database, or it does not exist in the source database, it does nothing.
     *
     * @param key     the key
     * @param dbIndex the db index
     * @return True if the key was removed in the db.
     */
    Boolean move(String key, int dbIndex);

    /**
     * Return the number of keys in the currently selected database.
     *
     * @return The number of keys
     */
    long dbSize();

    /**
     * Delete all the keys of the currently selected DB. This command never fails.
     *
     * @return OK string
     */
    String flushDB();

    /**
     * Delete all the keys of all the existing databases, not just the currently selected one. This
     * command never fails.
     *
     * @return OK string
     */
    String flushAll();

    /**
     * Select the DB with having the specified zero-based numeric index. For default every new
     * connection connection is automatically selected to DB 0.
     *
     * @param index db index
     * @return OK string
     */
    String select(final int index);

    /**
     * Swap db string.
     *
     * @param index1 the index 1
     * @param index2 the index 2
     * @return the string
     */
    String swapDB(final int index1, final int index2);
}
