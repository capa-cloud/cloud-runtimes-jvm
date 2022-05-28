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

import group.rxcloud.cloudruntimes.domain.nativeproto.redis.geo.GeoRadiusResponse;
import group.rxcloud.cloudruntimes.domain.nativeproto.redis.geo.GeoUnit;

import java.util.List;

/**
 * The Native geo commands.
 *
 * @link <a href="http://redisdoc.com/geo/index.html">geo</a>
 */
public interface NativeGeoCommands {

    /**
     * Geoadd.
     *
     * @param key       the key
     * @param longitude the longitude
     * @param latitude  the latitude
     * @param member    the member
     * @return the long
     */
    Long geoadd(String key, double longitude, double latitude, String member);

    // TODO: 2022/5/28 GEOPOS

    Double geodist(String key, String member1, String member2, GeoUnit unit);

    List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius,
                                      GeoUnit unit, String withX, String sortX, int count);

    List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius,
                                              GeoUnit unit, String withX, String sortX, int count);

    List<String> geohash(String key, String... members);
}
