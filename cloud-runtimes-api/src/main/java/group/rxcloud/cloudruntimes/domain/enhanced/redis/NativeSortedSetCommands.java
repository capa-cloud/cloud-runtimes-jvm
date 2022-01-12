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


import java.util.Map;
import java.util.Set;

/**
 * The interface Native sorted set commands.
 */
public interface NativeSortedSetCommands {

    /**
     * Add one or more members to a sorted set, or update its score if it already exists
     *
     * @param key    the key
     * @param score  the score
     * @param member the member
     * @return True if add successfully
     */
    Boolean zadd(String key, double score, String member);

    /**
     * Zadd boolean.
     *
     * @param key    the key
     * @param score  the score
     * @param member the member
     * @return the boolean
     */
    Boolean zadd(byte[] key, double score, byte[] member);

    /**
     * Add one or more members to a sorted set, or update its score if it already exists
     *
     * @param key              the key
     * @param scoresAndMembers the scores and members
     * @return The number of elements added to the sorted sets, not including elements already existing for which the score was updated.
     */
    Long zadd(String key, Map<String, Double> scoresAndMembers);

    /**
     * Zadd long.
     *
     * @param key              the key
     * @param scoresAndMembers the scores and members
     * @return the long
     */
    Long zadd(byte[] key, Map<byte[], Double> scoresAndMembers);

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
     * Zincrby double.
     *
     * @param key       the key
     * @param increment the increment
     * @param member    the member
     * @return the double
     */
    Double zincrby(byte[] key, double increment, byte[] member);

    /**
     * Remove one or more members from a sorted set
     *
     * @param key    the key
     * @param member the member
     * @return The number of members removed from the sorted set, not including non existing members.
     */
    Long zrem(String key, String... member);

    /**
     * Zrem long.
     *
     * @param key    the key
     * @param member the member
     * @return the long
     */
    Long zrem(byte[] key, byte[]... member);

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
     * Zremrange by rank long.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the long
     */
    Long zremrangeByRank(byte[] key, long start, long end);

    /**
     * Zremrange by score long.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    Long zremrangeByScore(byte[] key, double min, double max);

    /**
     * Removes all elements in the sorted set stored at key with a score between min and max (inclusive).
     * Score should be able to convert to double
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return The number of elements removed.
     */
    Long zremrangeByScore(String key, String min, String max);

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
     * Zremrange by score long.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the long
     */
    Long zremrangeByScore(byte[] key, byte[] start, byte[] end);

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
     * Zscore double.
     *
     * @param key    the key
     * @param member the member
     * @return the double
     */
    Double zscore(byte[] key, byte[] member);

    /**
     * Returns the sorted set cardinality (number of elements) of the sorted set stored at key.
     *
     * @param key the key
     * @return The cardinality (number of elements) of the sorted set, or 0 if key does not exist.
     */
    Long zcard(String key);

    /**
     * Zcard long.
     *
     * @param key the key
     * @return the long
     */
    Long zcard(byte[] key);

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
     * Zcount long.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    Long zcount(byte[] key, double min, double max);

    /**
     * Returns the number of elements in the sorted set at key with a score between min and max.
     * Score should can be converted into double
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return The number of elements in the specified score range.
     */
    Long zcount(String key, String min, String max);

    /**
     * Zcount long.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    Long zcount(byte[] key, byte[] min, byte[] max);

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
     * Zrange set.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the set
     */
    Set<byte[]> zrange(byte[] key, long start, long end);

    /**
     * Get the elements in the sorted set at key with a score between min and max.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return Set of elements in the specified score range (optionally with their scores).
     */
    Set<String> zrangeByScore(String key, double min, double max);

    /**
     * Zrange by score set.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the set
     */
    Set<byte[]> zrangeByScore(byte[] key, double min, double max);

    /**
     * Get the elements in the sorted set at key with a score between min and max.
     * Score should can be converted to double
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return Set of elements in the specified score range (optionally with their scores).
     */
    Set<String> zrangeByScore(String key, String min, String max);

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
     * Zrange by score set.
     *
     * @param key    the key
     * @param min    the min
     * @param max    the max
     * @param offset the offset
     * @param count  the count
     * @return the set
     */
    Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count);

    /**
     * Get number of count of the elements in the sorted set at key with a score between min and max,
     * with the offset.
     * Score should be able to convert to double
     *
     * @param key    the key
     * @param min    the min
     * @param max    the max
     * @param offset the offset
     * @param count  the count
     * @return Set of elements in the specified score range (optionally with their scores).
     */
    Set<String> zrangeByScore(String key, String min, String max, int offset, int count);

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
     * Zrank long.
     *
     * @param key    the key
     * @param member the member
     * @return the long
     */
    Long zrank(byte[] key, byte[] member);

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
     * Zrevrange set.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the set
     */
    Set<byte[]> zrevrange(byte[] key, long start, long end);

    /**
     * Get the elements in the sorted set at key with a score between max and min.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return Set of elements in the specified score range (optionally with their scores).
     */
    Set<String> zrevrangeByScore(String key, double max, double min);

    /**
     * Zrevrange by score set.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the set
     */
    Set<byte[]> zrevrangeByScore(byte[] key, double max, double min);

    /**
     * Get the elements in the sorted set at key with a score from max to min.
     * Score should can be converted to double
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return Set of elements in the specified score range (optionally with their scores).
     */
    Set<String> zrevrangeByScore(String key, String max, String min);

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
     * Zrevrange by score set.
     *
     * @param key    the key
     * @param max    the max
     * @param min    the min
     * @param offset the offset
     * @param count  the count
     * @return the set
     */
    Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count);

    /**
     * Zrange by lex set.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the set
     */
    Set<String> zrangeByLex(final String key, final String min, final String max);

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
    Set<String> zrangeByLex(final String key, final String min, final String max, final int offset,
                            final int count);

    /**
     * Zrevrange by lex set.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the set
     */
    Set<String> zrevrangeByLex(final String key, final String max, final String min);

    /**
     * Zrevrange by lex set.
     *
     * @param key    the key
     * @param max    the max
     * @param min    the min
     * @param offset the offset
     * @param count  the count
     * @return the set
     */
    Set<String> zrevrangeByLex(final String key, final String max, final String min,
                               final int offset, final int count);

    /**
     * Zremrange by lex long.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    Long zremrangeByLex(final String key, final String min, final String max);

    /**
     * Zrange by score set.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the set
     */
    Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max);

    /**
     * Zrevrange by score set.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the set
     */
    Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min);

    /**
     * Zrange by score set.
     *
     * @param key    the key
     * @param min    the min
     * @param max    the max
     * @param offset the offset
     * @param count  the count
     * @return the set
     */
    Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset,
                              int count);

    /**
     * Zrevrange by score set.
     *
     * @param key    the key
     * @param max    the max
     * @param min    the min
     * @param offset the offset
     * @param count  the count
     * @return the set
     */
    Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min,
                                 int offset, int count);

    /**
     * Zrange by lex set.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the set
     */
    Set<byte[]> zrangeByLex(final byte[] key, final byte[] min, final byte[] max);

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
    Set<byte[]> zrangeByLex(final byte[] key, final byte[] min, final byte[] max, int offset,
                            int count);

    /**
     * Zrevrange by lex set.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the set
     */
    Set<byte[]> zrevrangeByLex(final byte[] key, final byte[] max, final byte[] min);

    /**
     * Zrevrange by lex set.
     *
     * @param key    the key
     * @param max    the max
     * @param min    the min
     * @param offset the offset
     * @param count  the count
     * @return the set
     */
    Set<byte[]> zrevrangeByLex(final byte[] key, final byte[] max, final byte[] min, int offset,
                               int count);

    /**
     * Zremrange by lex long.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    Long zremrangeByLex(final byte[] key, final byte[] min, final byte[] max);

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
     * Zrevrank long.
     *
     * @param key    the key
     * @param member the member
     * @return the long
     */
    Long zrevrank(byte[] key, byte[] member);
}
