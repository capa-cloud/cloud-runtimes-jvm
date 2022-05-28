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
