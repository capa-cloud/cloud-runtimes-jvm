package group.rxcloud.cloudruntimes.domain.enhanced.redis;

/**
 * The interface Native geo commands.
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

    /**
     * Geoadd.
     *
     * @param key       the key
     * @param longitude the longitude
     * @param latitude  the latitude
     * @param member    the member
     * @return the long
     */
    Long geoadd(byte[] key, double longitude, double latitude, byte[] member);
}
