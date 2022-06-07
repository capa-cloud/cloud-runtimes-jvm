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


import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * The Native hash commands.
 *
 * @see <a href="http://redisdoc.com/hash/index.html">hash</a>
 */
public interface NativeHashCommands {

    /**
     * Sets field in the hash stored at key to value. If key does not exist, a new key holding a hash is created.
     * If field already exists in the hash, it is overwritten.
     *
     * @param key   the key
     * @param field the field
     * @param value the value
     * @return True if field is a new field in the hash and value was set. false if field already exists in the hash and the value was updated.
     */
    Boolean hset(String key, String field, String value);

    /**
     * Set the value of a hash field, only if the field does not exist
     *
     * @param key   the key
     * @param field the field
     * @param value the value
     * @return True if field is a new field in the hash and value was set. false if field already exists in the hash and no operation was performed.
     */
    Boolean hsetnx(String key, String field, String value);

    /**
     * Get the value of a hash field
     *
     * @param key   the key
     * @param field the field
     * @return The value associated with field, or nil when field is not present in the hash or key does not exist.
     */
    String hget(String key, String field);

    /**
     * Test for existence of a specified field in a hash.
     *
     * @param key   the key
     * @param field the field
     * @return True if the hash stored at key contains the specified field. false if the key is not found or the field is not present.
     */
    Boolean hexists(String key, String field);

    /**
     * Removes the specified fields from the hash stored at key.
     * Specified fields that do not exist within this hash are ignored.
     *
     * @param key    the key
     * @param fields the fields
     * @return The number of fields that were removed from the hash, not including specified but non existing fields.
     */
    Long hdel(String key, String... fields);

    /**
     * Get the number of fields contained in the hash stored at key.
     *
     * @param key the key
     * @return number of fields in the hash, or 0 when key does not exist.
     */
    Long hlen(String key);


    /**
     * Hstrlen long.
     *
     * @param key   the key
     * @param field the field
     * @return the long
     */
    Long hstrlen(String key, String field);

    /**
     * Increments the number stored at field in the hash stored at key by increment. If key does not exist, a new key holding a hash is created.
     * If field does not exist the value is set to 0 before the operation is performed.
     *
     * @param key       the key
     * @param field     the field
     * @param increment the increment
     * @return The value at field after the increment operation.
     */
    Long hincrBy(String key, String field, long increment);

    /**
     * Hincr by float double.
     *
     * @param key       the key
     * @param field     the field
     * @param increment the increment
     * @return the double
     */
    Double hincrByFloat(String key, String field, double increment);

    //************************************** Multi *************************************************

    /**
     * Set multiple hash fields to multiple values,
     * this command overwrites any existing fields in the hash. If key does not exist, a new key holding a hash is created.
     *
     * @param key       the key
     * @param keyValues the key values
     * @return True if set successfully, throw exception if hash is empty
     */
    Boolean hmset(String key, Map<String, String> keyValues);

    /**
     * Get the values of all the given hash fields<br>
     * For every field that does not exist in the hash, a nil value is returned. Because a non-existing keys are treated as empty hashes,
     * running HMGET against a non-existing key will return a list of nil values.
     *
     * @param key    the key
     * @param fields the fields
     * @return list of values associated with the given fields, in the same order as they are requested.
     */
    List<String> hmget(String key, String... fields);

    /**
     * Get all field names in the hash stored at key.
     *
     * @param key the key
     * @return set of fields in the hash, or an empty set when key does not exist.
     */
    Set<String> hkeys(String key);

    /**
     * Gets all values in the hash stored at key.
     *
     * @param key the key
     * @return List of values in the hash, or an empty list when key does not exist.
     */
    List<String> hvals(String key);

    /**
     * Gets all fields and values of the hash stored at key.
     *
     * @param key the key
     * @return Map of fields and their values stored in the hash, or an empty map when key does not exist.
     */
    Map<String, String> hgetAll(String key);

    // TODO: 2022/5/27 HSCAN
}
