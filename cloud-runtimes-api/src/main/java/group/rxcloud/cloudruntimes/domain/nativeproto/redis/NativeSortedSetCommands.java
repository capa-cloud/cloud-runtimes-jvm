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


import java.util.Map;
import java.util.Set;

/**
 * The Native sorted set commands.
 *
 * @link <a href="http://redisdoc.com/sorted_set/index.html">sorted set</a>
 */
public interface NativeSortedSetCommands {

    /**
     * Add one or more members to a sorted set, or update its score if it already exists
     *
     * @param key              the key
     * @param scoresAndMembers the scores and members
     * @return The number of elements added to the sorted sets, not including elements already existing for which the score was updated.
     */
    Long zadd(String key, Map<String, Double> scoresAndMembers);

    /**
     * Returns the score of member in the sorted set at key.
     * If member does not exist in the sorted set, or key does not exist, nil is returned.
     *
     * @param key    the key
     * @param member the member
     * @return The score of member (a double precision floating point number), represented as String.
     */
    Double zscore(String key, String member);

    /**
     * Increment the score of a member in a sorted set at key by increment.<br>
     * If member does not exist in the sorted set, it is added with increment as its score (as if its previous score was 0.0).<br>
     * If key does not exist, a new sorted set with the specified member as its sole member is created.
     *
     * @param key       the key
     * @param increment the increment
     * @param member    the member
     * @return The new score of member (a double precision floating point number), represented as String
     */
    Double zincrby(String key, double increment, String member);

    /**
     * Returns the sorted set cardinality (number of elements) of the sorted set stored at key.
     *
     * @param key the key
     * @return The cardinality (number of elements) of the sorted set, or 0 if key does not exist.
     */
    Long zcard(String key);

    /**
     * Returns the number of elements in the sorted set at key with a score between min and max.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return The number of elements in the specified score range.
     */
    Long zcount(String key, double min, double max);

    /**
     * Get the members in a sorted set specified with the index start and end ordered by
     * scores from lowest to highest.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return List of elements in the specified range (optionally with their scores).
     */
    Set<String> zrange(String key, long start, long end);

    /**
     * Get the members in a sorted set specified with the index start and end ordered by
     * scores from highest to lowest.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return List of elements in the specified range reversely (optionally with their scores).
     */
    Set<String> zrevrange(String key, long start, long end);

    /**
     * Get number of count of the elements in the sorted set at key with a score between min and max,
     * with the offset.
     *
     * @param key    the key
     * @param min    the min
     * @param max    the max
     * @param offset the offset
     * @param count  the count
     * @return Set of elements in the specified score range (optionally with their scores).
     */
    Set<String> zrangeByScore(String key, double min, double max, int offset, int count);

    /**
     * Get number of count of the elements in the sorted set at key with a score from max to min,
     * with the offset.
     *
     * @param key    the key
     * @param max    the max
     * @param min    the min
     * @param offset the offset
     * @param count  the count
     * @return Set of elements in the specified score range (optionally with their scores).
     */
    Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count);

    /**
     * Determine the index of a member in a sorted set,with the scores ordered from low to high.
     * The rank (or index) is 0-based, which means that the member with the lowest score has rank 0.
     *
     * @param key    the key
     * @param member the member
     * @return Integer reply or a nil bulk reply, specifically: the rank of the element as an integer reply if the element exists. A nil bulk reply if there is no such element.
     */
    Long zrank(String key, String member);

    /**
     * Determine the index of a member in a sorted set,with the scores ordered from low to high.
     * with the scores ordered from high to low.
     * The rank (or index) is 0-based, which means that the member with the highest score has rank 0.
     *
     * @param key    the key
     * @param member the member
     * @return Integer reply or a nil bulk reply, specifically: the rank of the element as an integer reply if the element exists. A nil bulk reply if there is no such element.
     */
    Long zrevrank(String key, String member);

    /**
     * Remove one or more members from a sorted set
     *
     * @param key    the key
     * @param member the member
     * @return The number of members removed from the sorted set, not including non existing members.
     */
    Long zrem(String key, String... member);

    /**
     * Removes all elements in the sorted set stored at key with rank between start and stop.
     * Both start and stop are 0 -based indexes with 0 being the element with the lowest score.
     * These indexes can be negative numbers, where they indicate offsets starting at the element with the highest score.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return The number of elements removed.
     */
    Long zremrangeByRank(String key, long start, long end);

    /**
     * Removes all elements in the sorted set stored at key with a score between min and max (inclusive).
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return The number of elements removed.
     */
    Long zremrangeByScore(String key, double start, double end);

    /**
     * Zrange by lex set.
     *
     * @param key    the key
     * @param min    the min
     * @param max    the max
     * @param offset the offset
     * @param count  the count
     * @return the set
     */
    Set<String> zrangeByLex(String key, String min, String max, int offset, int count);

    /**
     * For an ordered set key where all members have the same score, this command returns the number of elements in the set whose members are in the min and Max range.     * @param key
     *
     * @param min the min
     * @param max the max
     * @return Integer reply: The number of elements in the specified range.
     */
    long zlexcount(String key, String min, String max);

    /**
     * Zremrange by lex long.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    Long zremrangeByLex(String key, String min, String max);

    // TODO: 2022/5/27 ZSCAN

    /**
     * Creates a union or intersection of N sorted sets given by keys k1 through kN, and stores it at
     * dstkey. It is mandatory to provide the number of input keys N, before passing the input keys
     * and the other (optional) arguments.
     * <p>
     * As the terms imply, the {@link #zinterstore(String, String...) ZINTERSTORE} command
     * requires an element to be present in each of the given inputs to be inserted in the result. The
     * {@link #zunionstore(String, String...) ZUNIONSTORE} command inserts all elements across
     * all inputs.
     * <p>
     * Using the WEIGHTS option, it is possible to add weight to each input sorted set. This means
     * that the score of each element in the sorted set is first multiplied by this weight before
     * being passed to the aggregation. When this option is not given, all weights default to 1.
     * <p>
     * With the AGGREGATE option, it is possible to specify how the results of the union or
     * intersection are aggregated. This option defaults to SUM, where the score of an element is
     * summed across the inputs where it exists. When this option is set to be either MIN or MAX, the
     * resulting set will contain the minimum or maximum score of an element across the inputs where
     * it exists.
     * <p>
     * <b>Time complexity:</b> O(N) + O(M log(M)) with N being the sum of the sizes of the input
     * sorted sets, and M being the number of elements in the resulting sorted set
     *
     * @param dstkey destination key
     * @param sets   sets
     * @return The number of elements in the sorted set at dstkey
     * @see #zunionstore(String, String...)
     */
    long zunionstore(String dstkey, String... sets);


    /**
     * Creates a union or intersection of N sorted sets given by keys k1 through kN, and stores it at
     * dstkey. It is mandatory to provide the number of input keys N, before passing the input keys
     * and the other (optional) arguments.
     * <p>
     * As the terms imply, the {@link #zinterstore(String, String...) ZINTERSTORE} command
     * requires an element to be present in each of the given inputs to be inserted in the result. The
     * {@link #zunionstore(String, String...) ZUNIONSTORE} command inserts all elements across
     * all inputs.
     * <p>
     * Using the WEIGHTS option, it is possible to add weight to each input sorted set. This means
     * that the score of each element in the sorted set is first multiplied by this weight before
     * being passed to the aggregation. When this option is not given, all weights default to 1.
     * <p>
     * With the AGGREGATE option, it is possible to specify how the results of the union or
     * intersection are aggregated. This option defaults to SUM, where the score of an element is
     * summed across the inputs where it exists. When this option is set to be either MIN or MAX, the
     * resulting set will contain the minimum or maximum score of an element across the inputs where
     * it exists.
     * <p>
     * <b>Time complexity:</b> O(N) + O(M log(M)) with N being the sum of the sizes of the input
     * sorted sets, and M being the number of elements in the resulting sorted set
     *
     * @param dstkey destination key
     * @param sets   sets
     * @return The number of elements in the sorted set at dstkey
     * @see #zunionstore(String, String...)
     */
    long zinterstore(String dstkey, String... sets);
}
