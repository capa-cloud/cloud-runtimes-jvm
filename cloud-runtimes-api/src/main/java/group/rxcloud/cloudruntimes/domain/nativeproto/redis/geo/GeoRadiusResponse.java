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
package group.rxcloud.cloudruntimes.domain.nativeproto.redis.geo;

import java.util.Arrays;

public class GeoRadiusResponse {

    private byte[] member;
    private double distance;
    private GeoCoordinate coordinate;

    public byte[] getMember() {
        return member;
    }

    public void setMember(byte[] member) {
        this.member = member;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public GeoCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(GeoCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "GeoRadiusResponse{" +
                "member=" + Arrays.toString(member) +
                ", distance=" + distance +
                ", coordinate=" + coordinate +
                '}';
    }
}
