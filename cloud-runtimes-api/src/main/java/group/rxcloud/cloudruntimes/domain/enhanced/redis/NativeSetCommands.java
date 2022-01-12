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


import java.util.Set;

/**
 * The interface Native set commands.
 */
public interface NativeSetCommands {

    /**
     * Add the specified members to the set stored at key.
     * Specified members that are already a member of this set are ignored. If key does not exist, a new set is created before adding the specified members.
     *
     * @param key     the key
     * @param members the members
     * @return The number of elements that were added to the set, not including all the elements already present into the set.
     */
    Long sadd(String key, String... members);

    /**
     * Sadd long.
     *
     * @param key     the key
     * @param members the members
     * @return the long
     */
    Long sadd(byte[] key, byte[]... members);

    /**
     * Returns the set cardinality (number of elements) of the set stored at key.
     *
     * @param key the key
     * @return The cardinality (number of elements) of the set, or 0 if key does not exist.
     */
    Long scard(String key);

    /**
     * Scard long.
     *
     * @param key the key
     * @return the long
     */
    Long scard(byte[] key);

    /**
     * Removes and returns a random element from the set value stored at key.
     *
     * @param key the key
     * @return The removed element, or nil when key does not exist.
     */
    String spop(String key);

    /**
     * Remove a random element from a Set returning it as return value. If the Set is empty or the key
     * does not exist, a nil object is returned.
     * <p>
     * The {@link #srandmember(byte[])} command does a similar work but the returned element is not
     * removed from the Set.
     * <p>
     * Time complexity O(1)
     *
     * @param key the key
     * @return Bulk reply
     */
    byte[] spop(byte[] key);

    /**
     * Remove a random element from a Set returning it as return value. If the Set is empty or the key
     * does not exist, a nil object is returned.
     * <p>
     * The {@link #srandmember(String)} command does a similar work but the returned element is not
     * removed from the Set.
     * <p>
     * Time complexity O(1)
     *
     * @param key   the key
     * @param count the count
     * @return Bulk reply
     */
    Set<String> spop(final String key, final long count);

    /**
     * Spop set.
     *
     * @param key   the key
     * @param count the count
     * @return the set
     */
    Set<byte[]> spop(byte[] key, long count);

    /**
     * Remove the specified members from the set stored at key.
     * Specified members that are not a member of this set are ignored. If key does not exist, it is treated as an empty set and this command returns 0.
     *
     * @param key     the key
     * @param members the members
     * @return The number of members that were removed from the set, not including non existing members.
     */
    Long srem(String key, String... members);

    /**
     * Srem long.
     *
     * @param key     the key
     * @param members the members
     * @return the long
     */
    Long srem(byte[] key, byte[]... members);

    /**
     * Determine if a given value is a member of a set
     *
     * @param key    the key
     * @param member the member
     * @return True if the element is a member of the set. false if the element is not a member of the set, or if key does not exist.
     */
    Boolean sismember(String key, String member);

    /**
     * Sismember boolean.
     *
     * @param key    the key
     * @param member the member
     * @return the boolean
     */
    Boolean sismember(byte[] key, byte[] member);

    /**
     * Gets all the members of the set value stored at key.
     *
     * @param key the key
     * @return All elements of the set.
     */
    Set<String> smembers(String key);

    /**
     * Smembers set.
     *
     * @param key the key
     * @return the set
     */
    Set<byte[]> smembers(byte[] key);

    /**
     * Get one random members from a set
     *
     * @param key the key
     * @return Bulk Reply with the randomly selected element, or nil when key does not exist.
     */
    String srandmember(String key);

    /**
     * Srandmember byte [ ].
     *
     * @param key the key
     * @return the byte [ ]
     */
    byte[] srandmember(byte[] key);

    /**
     * Sunion set.
     *
     * @param keys the keys
     * @return set set
     */
    Set<String> sunion(String... keys);
}
