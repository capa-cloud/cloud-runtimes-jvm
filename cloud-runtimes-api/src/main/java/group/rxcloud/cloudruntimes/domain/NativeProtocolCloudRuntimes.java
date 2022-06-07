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
package group.rxcloud.cloudruntimes.domain;

import group.rxcloud.cloudruntimes.domain.nativeproto.NativeAwsS3Runtimes;
import group.rxcloud.cloudruntimes.domain.nativeproto.NativeRedisRuntimes;
import group.rxcloud.cloudruntimes.domain.nativeproto.NativeSqlRuntimes;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.geo.GeoRadiusResponse;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.geo.GeoUnit;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Native Protocol Cloud Runtimes standard API defined.
 */
public interface NativeProtocolCloudRuntimes extends
        NativeRedisRuntimes,
        NativeSqlRuntimes,
        NativeAwsS3Runtimes {

    @Override
    default Mono<byte[]> invokeRedis(String storeName, String cmd, byte[] args, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Mono<byte[]> invokeSql(String storeName, String sql, Map<String, String> metadata) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean move(String key, int dbIndex) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long dbSize() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String flushDB() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String flushAll() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String select(final int index) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String swapDB(final int index1, final int index2) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String ping() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long geoadd(String key, double longitude, double latitude, String member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Double geodist(String key, String member1, String member2, GeoUnit unit) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, String withX, String sortX, int count) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, String withX, String sortX, int count) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> geohash(String key, String... members) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean hset(String key, String field, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean hsetnx(String key, String field, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String hget(String key, String field) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean hexists(String key, String field) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long hdel(String key, String... fields) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long hlen(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long hstrlen(String key, String field) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long hincrBy(String key, String field, long increment) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Double hincrByFloat(String key, String field, double increment) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean hmset(String key, Map<String, String> keyValues) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> hmget(String key, String... fields) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> hkeys(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> hvals(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Map<String, String> hgetAll(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean exists(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String type(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String rename(String oldkey, String newkey) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long renamenx(String oldkey, String newkey) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long del(String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String randomKey() {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> keys(String pattern) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean expire(String key, long seconds) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean expireAt(String key, long unixtime) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long ttl(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean persist(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean pexpire(String key, long milliseconds) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long pexpireAt(final String key, final long millisecondsTimestamp) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long pttl(final String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long lpush(String key, String... elements) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long lpushx(String key, String... elements) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long rpush(String key, String... elements) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long rpushx(String key, String... elements) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String lpop(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String rpop(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String rpoplpush(String src, String dst) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long lrem(String key, long count, String element) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long llen(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String lindex(String key, long index) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long linsert(String key, String beforeORafter, String pivot, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean lset(String key, long index, String element) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> lrange(String key, long start, long end) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean ltrim(String key, long start, long end) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> blpop(int timeout, String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> brpop(int timeout, String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String brpoplpush(String src, String dst, int timeout) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long sadd(String key, String... members) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean sismember(String key, String member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> spop(String key, long count) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> srandmember(String key, long count) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long srem(String key, String... members) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long smove(String srckey, String dstkey, String member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long scard(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> smembers(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> sinter(String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long sinterstore(String dstkey, String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> sunion(String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long sunionstore(String dstkey, String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> sdiff(String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long sdiffstore(String dstkey, String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zadd(String key, Map<String, Double> scoresAndMembers) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Double zscore(String key, String member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Double zincrby(String key, double increment, String member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zcard(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zcount(String key, double min, double max) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> zrange(String key, long start, long end) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> zrevrange(String key, long start, long end) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zrank(String key, String member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zrevrank(String key, String member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zrem(String key, String... member) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zremrangeByRank(String key, long start, long end) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zremrangeByScore(String key, double start, double end) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long zlexcount(String key, String min, String max) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long zremrangeByLex(String key, String min, String max) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long zunionstore(String dstkey, String... sets) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default long zinterstore(String dstkey, String... sets) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean set(String key, String value, String nxxx, String expx, long time) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean setnx(String key, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean setex(String key, long seconds, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean psetex(String key, long milliseconds, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String get(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String getSet(String key, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long strlen(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long append(String key, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long setrange(String key, long offset, String value) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String getrange(String key, long startOffset, long endOffset) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long incr(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long incrBy(String key, long amount) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Double incrByFloat(String key, double amount) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long decr(String key) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Long decrBy(String key, long amount) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default String mset(String... keysvalues) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default Boolean msetnx(String... keysvalues) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }

    @Override
    default List<String> mget(String... keys) {
        throw new UnsupportedOperationException("CloudRuntimes Operate Unsupported.");
    }
}
