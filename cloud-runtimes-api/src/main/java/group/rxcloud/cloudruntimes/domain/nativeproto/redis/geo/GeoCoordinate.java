package group.rxcloud.cloudruntimes.domain.nativeproto.redis.geo;

public class GeoCoordinate {

    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "GeoCoordinate{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
