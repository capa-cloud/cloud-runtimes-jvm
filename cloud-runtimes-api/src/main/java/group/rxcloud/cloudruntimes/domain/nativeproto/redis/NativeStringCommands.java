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


import java.util.List;

/**
 * The Native string commands.
 *
 * @see <a href="http://redisdoc.com/string/index.html">string</a>
 */
public interface NativeStringCommands {

    /**
     * Set the String value of a key
     *
     * @param key   the key
     * @param value the value
     * @param nxxx  NX|XX,              NX -- Only set the key if it does not already exist.              XX -- Only set the key if it already exist.
     * @param expx  EX|PX,              EX seconds – Set the specified expire time, in seconds.              PX -- Only set the key if it already exist.
     * @param time  the time
     * @return true if set successfully or will return false
     */
    Boolean set(String key, String value, String nxxx, String expx, long time);

    /**
     * SET if Not eXists.
     *
     * @param key   the key
     * @param value the value
     * @return true if set successfully or will return false
     */
    Boolean setnx(String key, String value);

    /**
     * Set the value and expiration of a key
     *
     * @param key     the key
     * @param seconds the seconds
     * @param value   the value
     * @return SETEX is atomic, true if set successfully.
     */
    Boolean setex(String key, long seconds, String value);

    /**
     * Set the value and expiration of a key
     *
     * @param key          the key
     * @param milliseconds the milliseconds
     * @param value        the value
     * @return PSETEX is atomic, true if set successfully.
     */
    Boolean psetex(String key, long milliseconds, String value);

    /**
     * Get the value of a key
     *
     * @param key the key
     * @return Bulk String reply: the value of key, or nil when key does not exist.
     */
    String get(String key);

    /**
     * Set the String value of a key and return its old value
     *
     * @param key   the key
     * @param value the value
     * @return Atomically sets key to value and returns the old value stored at key.<br> Returns an error when key exists but does not hold a String value.
     */
    String getSet(String key, String value);

    /**
     * Get the length of the value stored in a key
     *
     * @param key the key
     * @return The length of the String at key, or 0 when key does not exist.
     */
    Long strlen(String key);

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
     * Overwrite part of a String at key starting at the specified offset
     *
     * @param key    the key
     * @param offset the offset
     * @param value  the value
     * @return The Length of the String after it was modified by the command.
     */
    Long setrange(String key, long offset, String value);

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
     * Increment the integer value of a key by one, If the key does not exist, it is set to 0 before performing the operation.
     *
     * @param key the key
     * @return The value of key after the increment
     */
    Long incr(String key);

    /**
     * Increment the integer value of a key by the given amount. If the key does not exist, it is set to 0 before performing the operation.
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of key after the increment
     */
    Long incrBy(String key, long amount);

    /**
     * Increment float value of the key by given amount
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of the key after increment
     */
    Double incrByFloat(String key, double amount);

    /**
     * Decrements the number stored at key by decrement. If the key does not exist, it is set to 0 before performing the operation.
     *
     * @param key the key
     * @return The value of key after the decrement
     */
    Long decr(String key);

    /**
     * Decrement the integer value of a key by the given number
     *
     * @param key    the key
     * @param amount the amount
     * @return The value of key after the decrement
     */
    Long decrBy(String key, long amount);

    //************************************** Multi *************************************************

    /**
     * Mset.
     *
     * @param keysvalues the keysvalues
     * @return always return OK
     */
    String mset(String... keysvalues);

    /**
     * Msetnx.
     *
     * @param keysvalues the keysvalues
     * @return true if set successfully or will return false
     */
    Boolean msetnx(String... keysvalues);

    /**
     * Mget list.
     *
     * @param keys the keys
     * @return The list contains the values of all the given keys.
     */
    List<String> mget(String... keys);
}
