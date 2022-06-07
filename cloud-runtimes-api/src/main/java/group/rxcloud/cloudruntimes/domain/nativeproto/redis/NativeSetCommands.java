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
import java.util.Set;

/**
 * The Native set commands.
 *
 * @see <a href="http://redisdoc.com/set/index.html">set</a>
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
     * Determine if a given value is a member of a set
     *
     * @param key    the key
     * @param member the member
     * @return True if the element is a member of the set. false if the element is not a member of the set, or if key does not exist.
     */
    Boolean sismember(String key, String member);

    /**
     * Remove a random element from a Set returning it as return value. If the Set is empty or the key
     * does not exist, a nil object is returned.
     * <p>
     * The {@link #srandmember(String, long)} command does a similar work but the returned element is
     * not removed from the Set.
     * <p>
     * Time complexity O(1)
     *
     * @param key   the key
     * @param count the count
     * @return Bulk reply
     */
    Set<String> spop(String key, long count);

    /**
     * Return a random elements from a Set, without removing the elements. If the Set is empty or the
     * key does not exist, an empty list is returned.
     * <p>
     * The SPOP command does a similar work but the returned elements is popped (removed) from the Set.
     * <p>
     * Time complexity O(1)
     *
     * @param key   the key
     * @param count if positive, return an array of distinct elements.              If negative the behavior changes and the command is allowed to              return the same element multiple times
     * @return A list of randomly selected elements
     */
    List<String> srandmember(String key, long count);

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
     * Move the specified member from the set at srckey to the set at dstkey. This operation is
     * atomic, in every given moment the element will appear to be in the source or destination set
     * for accessing clients.
     * <p>
     * If the source set does not exist or does not contain the specified element no operation is
     * performed and zero is returned, otherwise the element is removed from the source set and added
     * to the destination set. On success one is returned, even if the element was already present in
     * the destination set.
     * <p>
     * An error is raised if the source or destination keys contain a non Set value.
     * <p>
     * Time complexity O(1)
     *
     * @param srckey source key
     * @param dstkey destination key
     * @param member set member
     * @return 1 if the element was moved, 0 if the element was not found on the first set and no operation was performed
     */
    long smove(String srckey, String dstkey, String member);

    /**
     * Returns the set cardinality (number of elements) of the set stored at key.
     *
     * @param key the key
     * @return The cardinality (number of elements) of the set, or 0 if key does not exist.
     */
    Long scard(String key);

    /**
     * Gets all the members of the set value stored at key.
     *
     * @param key the key
     * @return All elements of the set.
     */
    Set<String> smembers(String key);

    // TODO: 2022/5/27 SSCAN

    /**
     * Return the members of a set resulting from the intersection of all the sets hold at the
     * specified keys. Like in {@link NativeListCommands#lrange(String, long, long)} LRANGE} the result is sent to
     * the connection as a multi-bulk reply (see the protocol specification for more information). If
     * just a single key is specified, then this command produces the same result as
     * {@link #smembers(String) SMEMBERS}. Actually SMEMBERS is just syntax sugar for SINTER.
     * <p>
     * Non existing keys are considered like empty sets, so if one of the keys is missing an empty set
     * is returned (since the intersection with an empty set always is an empty set).
     * <p>
     * Time complexity O(N*M) worst case where N is the cardinality of the smallest set and M the
     * number of sets
     *
     * @param keys the keys
     * @return A set with members of the resulting set
     */
    Set<String> sinter(String... keys);

    /**
     * This command works exactly like {@link #sinter(String[]) SINTER} but instead of being
     * returned the resulting set is stored as dstkey.
     * <p>
     * Time complexity O(N*M) worst case where N is the cardinality of the smallest set and M the
     * number of sets
     *
     * @param dstkey destination key
     * @param keys   the keys
     * @return The number of elements in the resulting set
     */
    long sinterstore(String dstkey, String... keys);

    /**
     * Sunion set.
     *
     * @param keys the keys
     * @return set set
     */
    Set<String> sunion(String... keys);

    /**
     * This command works exactly like {@link #sunion(String...) SUNION} but instead of being
     * returned the resulting set is stored as dstkey. Any existing value in dstkey will be
     * over-written.
     * <p>
     * Time complexity O(N) where N is the total number of elements in all the provided sets
     *
     * @param dstkey destination key
     * @param keys   the keys
     * @return The number of elements in the resulting set
     */
    long sunionstore(String dstkey, String... keys);

    /**
     * Return the difference between the Set stored at key1 and all the Sets key2, ..., keyN
     * <p>
     * <b>Example:</b>
     *
     * <pre>
     * key1 = [x, a, b, c]
     * key2 = [c]
     * key3 = [a, d]
     * SDIFF key1,key2,key3 =&gt; [x, b]
     * </pre>
     * <p>
     * Non existing keys are considered like empty sets.
     * <p>
     * <b>Time complexity:</b>
     * <p>
     * O(N) with N being the total number of elements of all the sets
     *
     * @param keys the keys
     * @return A set with members of the resulting set
     */
    Set<String> sdiff(String... keys);

    /**
     * This command works exactly like {@link #sdiff(String...) SDIFF} but instead of being
     * returned the resulting set is stored in dstkey.
     *
     * @param dstkey destination key
     * @param keys   the keys
     * @return The number of elements in the resulting set
     */
    long sdiffstore(String dstkey, String... keys);
}
