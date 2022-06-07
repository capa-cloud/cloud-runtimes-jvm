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


import java.util.Set;

/**
 * The Native key commands.
 *
 * @see <a href="http://redisdoc.com/database/index.html">database</a>
 * @see <a href="http://redisdoc.com/expire/index.html">expire</a>
 */
public interface NativeKeyCommands {

    /**
     * Determine if a key exists
     *
     * @param key the key
     * @return True if the key exists, false if the key does not exist.
     */
    Boolean exists(String key);

    /**
     * Determine the type stored at key
     *
     * @param key the key
     * @return Simple String reply: type of key, or none when key does not exist.
     */
    String type(String key);

    /**
     * Atomically renames the key oldkey to newkey. If the source and destination name are the same an
     * error is returned. If newkey already exists it is overwritten.
     * <p>
     * Time complexity: O(1)
     *
     * @param oldkey old key
     * @param newkey new key
     * @return OK string
     */
    String rename(String oldkey, String newkey);

    /**
     * Rename oldkey into newkey but fails if the destination key newkey already exists.
     * <p>
     * Time complexity: O(1)
     *
     * @param oldkey old key
     * @param newkey new key
     * @return 1 if the key was renamed, 0 if the target key already exist
     */
    long renamenx(String oldkey, String newkey);

    /**
     * del keys
     *
     * @param keys need del key array
     * @return Future what contain result
     */
    Long del(String... keys);

    /**
     * Return a randomly selected key from the currently selected DB.
     * <p>
     * Time complexity: O(1)
     *
     * @return Randomly selected key or an empty string if the database is empty
     */
    String randomKey();

    /**
     * Returns all the keys matching the glob-style pattern as space separated strings. For example if
     * you have in the database the keys "foo" and "foobar" the command "KEYS foo*" will return
     * "foo foobar".
     * <p>
     * Note that while the time complexity for this operation is O(n) the constant times are pretty
     * low. For example Redis running on an entry level laptop can scan a 1 million keys database in
     * 40 milliseconds. <b>Still it's better to consider this one of the slow commands that may ruin
     * the DB performance if not used with care.</b>
     * <p>
     * In other words this command is intended only for debugging and special operations like creating
     * a script to change the DB schema. Don't use it in your normal code. Use Redis Sets in order to
     * group together a subset of objects.
     * <p>
     * Glob style patterns examples:
     * <ul>
     * <li>h?llo will match hello hallo hhllo
     * <li>h*llo will match hllo heeeello
     * <li>h[ae]llo will match hello and hallo, but not hillo
     * </ul>
     * <p>
     * Use \ to escape special chars if you want to match them verbatim.
     * <p>
     * Time complexity: O(n) (with n being the number of keys in the DB, and assuming keys and pattern
     * of limited length)
     *
     * @param pattern pattern
     * @return Multi bulk reply
     */
    Set<String> keys(String pattern);

    // TODO: 2022/5/28 SCAN

    // TODO: 2022/5/28 SORT

    /**
     * Expire boolean.
     *
     * @param key     the key
     * @param seconds the seconds
     * @return the boolean
     */
    Boolean expire(String key, long seconds);

    /**
     * Expire at boolean.
     *
     * @param key      the key
     * @param unixtime the unixtime
     * @return the boolean
     */
    Boolean expireAt(String key, long unixtime);

    /**
     * Get the time to live for a key
     *
     * @param key the key
     * @return TTL in seconds, or a negative value in order to signal an error<br> The command returns -2 if the key does not exist.<br> The command returns -1 if the key exists but has no associated expire.
     */
    Long ttl(String key);

    /**
     * Remove the expiration from a key turning the key from volatile (a key with an expire set)
     * to persistent (a key that will never expire as no timeout is associated).
     *
     * @param key the key
     * @return True if the timeout was removed, false if key does not exist or does not have an associated timeout.
     */
    Boolean persist(String key);

    /**
     * Pexpire boolean.
     *
     * @param key          the key
     * @param milliseconds the milliseconds
     * @return the boolean
     */
    Boolean pexpire(String key, long milliseconds);

    /**
     * This command works exactly like {@link #expireAt(String, long) EXPIREAT} but
     * Unix time at which the key will expire is specified in milliseconds instead of seconds.
     * <p>
     * Time complexity: O(1)
     *
     * @param key                   the key
     * @param millisecondsTimestamp time to expire
     * @return 1 if the timeout was set, 0 otherwise. e.g. key doesn't exist, or operation skipped due to the provided arguments.
     */
    long pexpireAt(final String key, final long millisecondsTimestamp);

    /**
     * Pttl long.
     *
     * @param key the key
     * @return the long
     */
    long pttl(final String key);
}
