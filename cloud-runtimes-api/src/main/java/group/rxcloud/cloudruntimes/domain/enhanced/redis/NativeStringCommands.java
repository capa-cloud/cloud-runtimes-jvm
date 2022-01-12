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


import java.util.List;

/**
 * The interface Native string commands.
 */
public interface NativeStringCommands {

    /**
     * Append a value to a key.<br>
     * If key already exists and is a String, this command appends the value at the end of the String. If key does not exist it is created and set as an empty String,
     * so APPEND will be similar to SET in this special case.
     *
     * @param key   the key
     * @param value the value
     * @return The length of the String after the append operation.
     */
    Long append(String key, String value);

    /**
     * Append long.
     *
     * @param key   the key
     * @param value the value
     * @return the long
     */
    Long append(byte[] key, byte[] value);

    /**
     * Get the value of a key
     *
     * @param key the key
     * @return Bulk String reply: the value of key, or nil when key does not exist.
     */
    String get(String key);

    /**
     * Get byte [ ].
     *
     * @param key the key
     * @return byte [ ]
     */
    byte[] get(byte[] key);

    /**
     * Getbyte byte [ ].
     *
     * @param key the key
     * @return the byte [ ]
     */
    byte[] getbyte(String key);

    /**
     * Return a subset of the String from offset start to offset end (both
     * offsets are inclusive). Negative offsets can be used in order to provide
     * an offset starting from the end of the String. So -1 means the last char,
     * -2 the penultimate and so forth.
     * <p>
     * The function handles out of range requests without raising an error, but
     * just limiting the resulting range to the actual length of the String.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return Bulk String reply
     */
    String substr(String key, int start, int end);

    /**
     * Substr byte [ ].
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the byte [ ]
     */
    byte[] substr(byte[] key, int start, int end);

    /**
     * Set the String value of a key and return its old value
     *
     * @param key   the key
     * @param value the value
     * @return Atomically sets key to value and returns the old value stored at key.<br> Returns an error when key exists but does not hold a String value.
     */
    String getSet(String key, String value);

    /**
     * Get set byte [ ].
     *
     * @param key   the key
     * @param value the value
     * @return the byte [ ]
     */
    byte[] getSet(byte[] key, byte[] value);

    /**
     * Gets .
     *
     * @param key    the key
     * @param offset the offset
     * @return the
     */
    Boolean getbit(String key, long offset);

    /**
     * Gets .
     *
     * @param key    the key
     * @param offset the offset
     * @return the
     */
    Boolean getbit(byte[] key, long offset);

    /**
     * Bitcount long.
     *
     * @param key the key
     * @return the long
     */
    Long bitcount(final String key);

    /**
     * Bitcount long.
     *
     * @param key the key
     * @return the long
     */
    Long bitcount(final byte[] key);

    /**
     * Bitcount long.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the long
     */
    Long bitcount(final String key, long start, long end);

    /**
     * Bitcount long.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the long
     */
    Long bitcount(final byte[] key, long start, long end);

    /**
     * Get the length of the value stored in a key
     *
     * @param key the key
     * @return The length of the String at key, or 0 when key does not exist.
     */
    Long strlen(String key);

    /**
     * Strlen long.
     *
     * @param key the key
     * @return the long
     */
    Long strlen(byte[] key);

    /**
     * Get a subString of the String stored at a key
     *
     * @param key         the key
     * @param startOffset the start offset
     * @param endOffset   the end offset
     * @return Returns the subString of the String value stored at key, d etermined by the offsets start and end (both are inclusive). <br> Negative offsets can be used in order to provide an offset starting from the end of the String. So -1 means the last character, -2 the penultimate and so forth.<br> The function handles out of range requests by limiting the resulting range to the actual length of the String.
     */
    String getrange(String key, long startOffset, long endOffset);

    /**
     * Getrange byte [ ].
     *
     * @param key         the key
     * @param startOffset the start offset
     * @param endOffset   the end offset
     * @return the byte [ ]
     */
    byte[] getrange(byte[] key, long startOffset, long endOffset);

    /**
     * Set the String value of a key
     *
     * @param key   the key
     * @param value the value
     * @return true ifset successfully, or will return false
     */
    Boolean set(String key, String value);

    /**
     * Set value for special key
     *
     * @param key   the key
     * @param value the value
     * @return boolean boolean
     */
    Boolean set(byte[] key, byte[] value);

    /**
     * set the String value of a key by nxxx
     * set the String value of a key by nxxx
     *
     * @param key   the key
     * @param value the value
     * @param nxxx  NX|XX, NX -- Only set the key if it does not already exist. XX              -- Only set the key if it already exist.
     * @return true if set successfully,or will return false
     */
    Boolean set(String key, String value, String nxxx);


    /**
     * set the String value of a key
     *
     * @param key   the key
     * @param value the value
     * @param nxxx  NX|XX, NX -- Only set the key if it does not already exist. XX -- Only set the key if it already exist.
     * @param expx  EX|PX, EX seconds – Set the specified expire time, in seconds. PX -- Only set the key if it already exist.
     * @param time  the time
     * @return true if set successfully  or will return false
     */
    Boolean set(String key, String value, String nxxx, String expx, long time);

    /**
     * Set boolean.
     *
     * @param key   the key
     * @param value the value
     * @param nxxx  the nxxx
     * @param expx  the expx
     * @param time  the time
     * @return the boolean
     */
    Boolean set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time);

    /**
     * set the String value of a key
     *
     * @param key   the key
     * @param value the value
     * @param nxxx  NX|XX, NX -- Only set the key if it does not already exist. XX -- Only set the key if it already exist.
     * @param expx  EX|PX, EX seconds – Set the specified expire time, in seconds. PX -- Set the specified expire time, in milliseconds.
     * @param time  the time
     * @return true if set successfully  or will return false
     */
    Boolean set(String key, String value, String nxxx, String expx, int time);

    /**
     * Set boolean.
     *
     * @param key   the key
     * @param value the value
     * @param nxxx  the nxxx
     * @param expx  the expx
     * @param time  the time
     * @return the boolean
     */
    Boolean set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time);

    /**
     * Sets .
     *
     * @param key   the key
     * @param value the value
     * @return
     */
    Boolean setbyte(String key, byte[] value);

    /**
     * Sets .
     *
     * @param key    the key
     * @param offset the offset
     * @param value  the value
     * @return the
     */
    Boolean setbit(String key, long offset, boolean value);

    /**
     * Sets .
     *
     * @param key    the key
     * @param offset the offset
     * @param value  the value
     * @return the
     */
    Boolean setbit(byte[] key, long offset, boolean value);

    /**
     * Sets .
     *
     * @param key    the key
     * @param offset the offset
     * @param value  the value
     * @return the
     */
    Boolean setbit(String key, long offset, String value);

    /**
     * Sets .
     *
     * @param key    the key
     * @param offset the offset
     * @param value  the value
     * @return the
     */
    Boolean setbit(byte[] key, long offset, byte[] value);

    /**
     * Set the value and expiration of a key
     *
     * @param key     the key
     * @param seconds the seconds
     * @param value   the value
     * @return SETEX is atomic, true if set successfully.
     */
    Boolean setex(String key, int seconds, String value);

    /**
     * Set byte array value for the key, and set expire time(unit is Millisecond).
     * This operation is atomic.
     *
     * @param key     the key
     * @param seconds the seconds
     * @param value   the value
     * @return
     */
    Boolean setex(byte[] key, int seconds, byte[] value);

    /**
     * Sets .
     *
     * @param key   the key
     * @param value the value
     * @return the
     */
    Boolean setnx(String key, String value);

    /**
     * Sets .
     *
     * @param key   the key
     * @param value the value
     * @return the
     */
    Boolean setnx(byte[] key, byte[] value);

    /**
     * Overwrite part of a String at key starting at the specified offset
     *
     * @param key    the key
     * @param offset the offset
     * @param value  the value
     * @return The Length of the String after it was modified by the command.
     */
    Long setrange(String key, long offset, String value);

    /**
     * Sets .
     *
     * @param key    the key
     * @param offset the offset
     * @param value  the value
     * @return the
     */
    Long setrange(byte[] key, long offset, byte[] value);

    /**
     * Decrements the number stored at key by decrement. If the key does not exist, it is set to 0 before performing the operation.
     *
     * @param key the key
     * @return The value of key after the decrement
     */
    Long decr(String key);

    /**
     * Decrement the integer value of a key by one.
     *
     * @param key the key
     * @return the value of key after decrement
     */
    Long decr(byte[] key);

    /**
     * Decrement the integer value of a key by the given number
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of key after the decrement
     */
    Long decrBy(String key, long amount);

    /**
     * Decrement the integer value of the key by the given amount.
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of key after decrement
     */
    Long decrBy(byte[] key, long amount);

    /**
     * Increment the integer value of a key by one, If the key does not exist, it is set to 0 before performing the operation.
     *
     * @param key the key
     * @return The value of key after the increment
     */
    Long incr(String key);

    /**
     * Increment integer value of the key by on
     *
     * @param key the key
     * @return The value of the key after increment
     */
    Long incr(byte[] key);

    /**
     * Increment the integer value of a key by the given amount. If the key does not exist, it is set to 0 before performing the operation.
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of key after the increment
     */
    Long incrBy(String key, long amount);

    /**
     * Increment integer value of the key by the given amount.
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of key after increment
     */
    Long incrBy(byte[] key, long amount);

    /**
     * Increment float value of the key by given amount
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of the key after increment
     */
    Double incrByFloat(String key, double amount);

    /**
     * Increment float value of the key by given amount
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of the key after increment
     */
    Double incrByFloat(byte[] key, double amount);

    //************************************** Multi *************************************************

    /**
     * Mget list.
     *
     * @param keys the keys
     * @return list list
     */
    List<String> mget(String... keys);

    /**
     * Mget list.
     *
     * @param keys the keys
     * @return list list
     */
    List<byte[]> mget(byte[]... keys);

    /**
     * Mset string.
     *
     * @param keysvalues the keysvalues
     * @return the string
     */
    String mset(String... keysvalues);

    /**
     * Mset string.
     *
     * @param keysvalues the keysvalues
     * @return the string
     */
    String mset(byte[]... keysvalues);

    /**
     * Msetnx boolean.
     *
     * @param keysvalues the keysvalues
     * @return the boolean
     */
    Boolean msetnx(String... keysvalues);

    /**
     * Msetnx boolean.
     *
     * @param keysvalues the keysvalues
     * @return the boolean
     */
    Boolean msetnx(byte[]... keysvalues);
}
