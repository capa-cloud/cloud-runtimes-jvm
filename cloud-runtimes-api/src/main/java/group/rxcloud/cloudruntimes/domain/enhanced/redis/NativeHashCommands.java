package group.rxcloud.cloudruntimes.domain.enhanced.redis;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * The interface Native hash commands.
 */
public interface NativeHashCommands {

    /**
     * Get the value of a hash field
     *
     * @param key   the key
     * @param field the field
     * @return The value associated with field, or nil when field is not present in the hash or key does not exist.
     */
    String hget(String key, String field);

    /**
     * Return value of field in hash with byte array format.
     *
     * @param key   the key
     * @param field the field
     * @return Future byte [ ]
     */
    byte[] hget(byte[] key, byte[] field);

    /**
     * Gets all fields and values of the hash stored at key.
     *
     * @param key the key
     * @return Map of fields and their values stored in the hash, or an empty map when key does not exist.
     */
    Map<String, String> hgetAll(String key);

    /**
     * Return all fields and associated values with byte array format.
     *
     * @param key the key
     * @return Future map
     */
    Map<byte[], byte[]> hgetAll(byte[] key);

    /**
     * Removes the specified fields from the hash stored at key.
     * Specified fields that do not exist within this hash are ignored.
     *
     * @param key    the key
     * @param fields the fields
     * @return The number of fields that were removed from the hash, not including specified but non existing fields.
     */
    Long hdel(String key, String... fields);

    /**
     * Hdel long.
     *
     * @param key    the key
     * @param fields the fields
     * @return the long
     */
    Long hdel(byte[] key, byte[]... fields);

    /**
     * Increments the number stored at field in the hash stored at key by increment. If key does not exist, a new key holding a hash is created.
     * If field does not exist the value is set to 0 before the operation is performed.
     *
     * @param key       the key
     * @param field     the field
     * @param increment the increment
     * @return The value at field after the increment operation.
     */
    Long hincrBy(String key, String field, long increment);

    /**
     * Hincr by long.
     *
     * @param key       the key
     * @param field     the field
     * @param increment the increment
     * @return the long
     */
    Long hincrBy(byte[] key, byte[] field, long increment);

    /**
     * Hincr by float double.
     *
     * @param key       the key
     * @param field     the field
     * @param increment the increment
     * @return the double
     */
    Double hincrByFloat(String key, String field, double increment);

    /**
     * Hincr by float double.
     *
     * @param key       the key
     * @param field     the field
     * @param increment the increment
     * @return the double
     */
    Double hincrByFloat(byte[] key, byte[] field, double increment);

    /**
     * Set multiple hash fields to multiple values,
     * this command overwrites any existing fields in the hash. If key does not exist, a new key holding a hash is created.
     *
     * @param key       the key
     * @param keyValues the key values
     * @return True if set successfully, throw exception if hash is empty
     */
    Boolean hmset(String key, Map<String, String> keyValues);

    /**
     * Hmset boolean.
     *
     * @param key       the key
     * @param keyValues the key values
     * @return the boolean
     */
    Boolean hmset(byte[] key, Map<byte[], byte[]> keyValues);

    /**
     * Sets field in the hash stored at key to value. If key does not exist, a new key holding a hash is created.
     * If field already exists in the hash, it is overwritten.
     *
     * @param key   the key
     * @param field the field
     * @param value the value
     * @return True if field is a new field in the hash and value was set. false if field already exists in the hash and the value was updated.
     */
    Boolean hset(String key, String field, String value);

    /**
     * Hset long.
     *
     * @param key   the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    Long hset(byte[] key, byte[] field, byte[] value);

    /**
     * Hset boolean.
     *
     * @param key   the key
     * @param field the field
     * @param value the value
     * @return the boolean
     */
    Boolean hset(String key, String field, byte[] value);

    /**
     * Get the values of all the given hash fields<br>
     * For every field that does not exist in the hash, a nil value is returned. Because a non-existing keys are treated as empty hashes,
     * running HMGET against a non-existing key will return a list of nil values.
     *
     * @param key    the key
     * @param fields the fields
     * @return list of values associated with the given fields, in the same order as they are requested.
     */
    List<String> hmget(String key, String... fields);

    /**
     * Hmget list.
     *
     * @param key    the key
     * @param fields the fields
     * @return the list
     */
    List<byte[]> hmget(byte[] key, byte[]... fields);

    /**
     * Test for existence of a specified field in a hash.
     *
     * @param key   the key
     * @param field the field
     * @return True if the hash stored at key contains the specified field. false if the key is not found or the field is not present.
     */
    Boolean hexists(String key, String field);

    /**
     * Hexists boolean.
     *
     * @param key   the key
     * @param field the field
     * @return the boolean
     */
    Boolean hexists(byte[] key, byte[] field);

    /**
     * Get all field names in the hash stored at key.
     *
     * @param key the key
     * @return set of fields in the hash, or an empty set when key does not exist.
     */
    Set<String> hkeys(String key);

    /**
     * Hkeys set.
     *
     * @param key the key
     * @return the set
     */
    Set<byte[]> hkeys(byte[] key);

    /**
     * Get the number of fields contained in the hash stored at key.
     *
     * @param key the key
     * @return number of fields in the hash, or 0 when key does not exist.
     */
    Long hlen(String key);

    /**
     * Hlen long.
     *
     * @param key the key
     * @return the long
     */
    Long hlen(byte[] key);

    /**
     * Set the value of a hash field, only if the field does not exist
     *
     * @param key   the key
     * @param field the field
     * @param value the value
     * @return True if field is a new field in the hash and value was set. false if field already exists in the hash and no operation was performed.
     */
    Boolean hsetnx(String key, String field, String value);

    /**
     * Hsetnx boolean.
     *
     * @param key   the key
     * @param field the field
     * @param value the value
     * @return the boolean
     */
    Boolean hsetnx(byte[] key, byte[] field, byte[] value);

    /**
     * Gets all values in the hash stored at key.
     *
     * @param key the key
     * @return List of values in the hash, or an empty list when key does not exist.
     */
    List<String> hvals(String key);

    /**
     * Hvals collection.
     *
     * @param key the key
     * @return the collection
     */
    Collection<byte[]> hvals(byte[] key);
}
