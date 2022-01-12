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
package group.rxcloud.cloudruntimes.domain.enhanced.redis;


import java.util.List;

/**
 * The interface Native key commands.
 */
public interface NativeKeyCommands {

    /**
     * del keys
     *
     * @param keys need del key array
     * @return Future what contain result
     */
    Long del(String... keys);

    /**
     * Del long.
     *
     * @param keys the keys
     * @return the long
     */
    Long del(byte[]... keys);

    /**
     * Delete a key-value pair specified by the key
     *
     * @param key the key
     * @return True if key is removed.
     */
    Boolean del(String key);

    /**
     * Del boolean.
     *
     * @param key the key
     * @return the boolean
     */
    Boolean del(byte[] key);

    /**
     * Determine if a key exists
     *
     * @param key the key
     * @return True if the key exists, false if the key does not exist.
     */
    Boolean exists(String key);

    /**
     * Exists boolean.
     *
     * @param key the key
     * @return the boolean
     */
    Boolean exists(byte[] key);

    /**
     * Expire boolean.
     *
     * @param key     the key
     * @param seconds the seconds
     * @return the boolean
     */
    Boolean expire(String key, long seconds);

    /**
     * Expire boolean.
     *
     * @param key     the key
     * @param seconds the seconds
     * @return the boolean
     */
    Boolean expire(byte[] key, long seconds);

    /**
     * Set a key's time to live in seconds
     *
     * @param key     the key
     * @param seconds the seconds
     * @return True if the timeout was set false if key does not exist or the timeout could not be set.
     */
    @Deprecated
    Boolean expire(String key, int seconds);

    /**
     * Expire boolean.
     *
     * @param key     the key
     * @param seconds the seconds
     * @return the boolean
     */
    @Deprecated
    Boolean expire(byte[] key, int seconds);

    /**
     * Expire at boolean.
     *
     * @param key      the key
     * @param unixtime the unixtime
     * @return the boolean
     */
    Boolean expireAt(String key, long unixtime);

    /**
     * Expire at boolean.
     *
     * @param key      the key
     * @param unixtime the unixtime
     * @return the boolean
     */
    Boolean expireAt(byte[] key, long unixtime);

    /**
     * Remove the expiration from a key turning the key from volatile (a key with an expire set)
     * to persistent (a key that will never expire as no timeout is associated).
     *
     * @param key the key
     * @return True if the timeout was removed, false if key does not exist or does not have an associated timeout.
     */
    Boolean persist(String key);

    /**
     * Persist boolean.
     *
     * @param key the key
     * @return the boolean
     */
    Boolean persist(byte[] key);

    /**
     * Pexpire boolean.
     *
     * @param key          the key
     * @param milliseconds the milliseconds
     * @return the boolean
     */
    Boolean pexpire(String key, long milliseconds);

    /**
     * Pexpire boolean.
     *
     * @param key          the key
     * @param milliseconds the milliseconds
     * @return the boolean
     */
    Boolean pexpire(byte[] key, long milliseconds);

    /**
     * Determine the type stored at key
     *
     * @param key the key
     * @return Simple String reply: type of key, or none when key does not exist.
     */
    String type(String key);

    /**
     * Type string.
     *
     * @param key the key
     * @return the string
     */
    String type(byte[] key);

    /**
     * Get the time to live for a key
     *
     * @param key the key
     * @return TTL in seconds, or a negative value in order to signal an error<br> The command returns -2 if the key does not exist.<br> The command returns -1 if the key exists but has no associated expire.
     */
    Long ttl(String key);

    /**
     * Ttl long.
     *
     * @param key the key
     * @return the long
     */
    Long ttl(byte[] key);

    /**
     * Returns or stores the elements contained in the list, set or sorted set at key.
     * By default, sorting is numeric and elements are compared by their value interpreted as double precision floating point number.
     *
     * @param key the key
     * @return List of sorted elements.
     */
    List<String> sort(String key);

    /**
     * Sort list.
     *
     * @param key the key
     * @return the list
     */
    List<byte[]> sort(byte[] key);

    /**
     * Move key from the currently selected database to the specified destination database.
     * When key already exists in the destination database, or it does not exist in the source database, it does nothing.
     *
     * @param key     the key
     * @param dbIndex the db index
     * @return True if the key was removed in the db.
     */
    Boolean move(String key, int dbIndex);
}
