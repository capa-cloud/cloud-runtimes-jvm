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
 * The interface Native list commands.
 */
public interface NativeListCommands {

    /**
     * Gets the specified elements of the list stored at key.
     * The offsets start and stop are zero-based indexes, <br>
     * These offsets can also be negative numbers indicating offsets starting at the end of the list.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return List of elements in the specified range.
     */
    List<String> lrange(String key, long start, long end);

    /**
     * Lrange list.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the list
     */
    List<byte[]> lrange(byte[] key, long start, long end);

    /**
     * Inserts value in the list stored at key either before the reference value pivot.
     * When key does not exist, it is considered an empty list and no operation is performed.
     *
     * @param key   the key
     * @param pivot the pivot
     * @param value the value
     * @return The length of the list after the insert operation, or -1 when the value pivot was not found.
     */
    Long linsertbefore(String key, String pivot, String value);

    /**
     * Inserts value in the list stored at key either after the reference value pivot.
     * When key does not exist, it is considered an empty list and no operation is performed.
     *
     * @param key   the key
     * @param pivot the pivot
     * @param value the value
     * @return The length of the list after the insert operation, or -1 when the value pivot was not found.
     */
    Long linsertafter(String key, String pivot, String value);

    /**
     * Removes and returns the first element of the list stored at key.
     *
     * @param key the key
     * @return The value of the first element, or nil when key does not exist.
     */
    String lpop(String key);

    /**
     * Lpop byte [ ].
     *
     * @param key the key
     * @return the byte [ ]
     */
    byte[] lpop(byte[] key);

    /**
     * Blpop list.
     *
     * @param timeout the timeout
     * @param keys    the keys
     * @return the list
     */
    List<String> blpop(int timeout, String... keys);

    /**
     * Blpop list.
     *
     * @param timeout the timeout
     * @param keys    the keys
     * @return the list
     */
    List<byte[]> blpop(int timeout, byte[]... keys);

    /**
     * Insert all the specified values at the head of the list stored at key. If key does not exist,
     * it is created as empty list before performing the push operations.
     *
     * @param key      the key
     * @param elements the elements
     * @return The length of the list after the push operations.
     */
    Long lpush(String key, String... elements);

    /**
     * Lpush long.
     *
     * @param key      the key
     * @param elements the elements
     * @return the long
     */
    Long lpush(byte[] key, byte[]... elements);

    /**
     * Inserts values at the head of the list stored at key, only if key already exists and holds a list.
     * In contrary to LPUSH, no operation will be performed when key does not yet exist.
     *
     * @param key     the key
     * @param element the element
     * @return The length of the list after the push operation.
     */
    Long lpushx(String key, String element);

    /**
     * Lpushx long.
     *
     * @param key      the key
     * @param elements the elements
     * @return the long
     */
    Long lpushx(byte[] key, byte[]... elements);

    /**
     * Removes and returns the last element of the list stored at key.
     *
     * @param key the key
     * @return The value of the last element, or nil when key does not exist.
     */
    String rpop(String key);

    /**
     * Rpop byte [ ].
     *
     * @param key the key
     * @return the byte [ ]
     */
    byte[] rpop(byte[] key);

    /**
     * Brpop list.
     *
     * @param timeout the timeout
     * @param keys    the keys
     * @return the list
     */
    List<String> brpop(int timeout, String... keys);

    /**
     * Brpop list.
     *
     * @param timeout the timeout
     * @param keys    the keys
     * @return the list
     */
    List<byte[]> brpop(int timeout, byte[]... keys);

    /**
     * Insert all the specified values at the tail of the list stored at key. If key does not exist,
     * it is created as empty list before performing the push operation.
     *
     * @param key      the key
     * @param elements the elements
     * @return The length of the list after the push operation.
     */
    Long rpush(String key, String... elements);

    /**
     * Rpush long.
     *
     * @param key      the key
     * @param elements the elements
     * @return the long
     */
    Long rpush(byte[] key, byte[]... elements);

    /**
     * Inserts value at the tail of the list stored at key, only if key already exists and holds a list.
     * In contrary to RPUSH, no operation will be performed when key does not yet exist.
     *
     * @param key     the key
     * @param element the element
     * @return The length of the list after the push operation.
     */
    Long rpushx(String key, String element);

    /**
     * Rpushx long.
     *
     * @param key      the key
     * @param elements the elements
     * @return the long
     */
    Long rpushx(byte[] key, byte[]... elements);

    /**
     * Gets the element at index index in the list stored at key.
     * Negative indices can be used to designate elements starting at the tail of the list.
     *
     * @param key   the key
     * @param index the index
     * @return The requested element, or nil when index is out of range.
     */
    String lindex(String key, long index);

    /**
     * Lindex byte [ ].
     *
     * @param key   the key
     * @param index the index
     * @return the byte [ ]
     */
    byte[] lindex(byte[] key, long index);

    /**
     * Gets the length of the list stored at key.
     *
     * @param key the key
     * @return The length of the list at key. 0 if list is not exist.
     */
    Long llen(String key);

    /**
     * Llen long.
     *
     * @param key the key
     * @return the long
     */
    Long llen(byte[] key);

    /**
     * Removes the first count occurrences of elements equal to value from the list stored at key.
     * The count argument influences the operation in the following ways:<br>
     * count > 0: Remove elements equal to value moving from head to tail.<br>
     * count < 0: Remove elements equal to value moving from tail to head.<br>
     * count = 0: Remove all elements equal to value.
     *
     * @param key     the key
     * @param count   the count
     * @param element the element
     * @return The number of removed elements.
     */
    Long lrem(String key, long count, String element);

    /**
     * Lrem long.
     *
     * @param key     the key
     * @param count   the count
     * @param element the element
     * @return the long
     */
    Long lrem(byte[] key, long count, byte[] element);

    /**
     * Sets the list element at index to value.
     *
     * @param key     the key
     * @param index   the index
     * @param element the element
     * @return True if successfully.
     */
    Boolean lset(String key, long index, String element);

    /**
     * Lset boolean.
     *
     * @param key     the key
     * @param index   the index
     * @param element the element
     * @return the boolean
     */
    Boolean lset(byte[] key, long index, byte[] element);

    /**
     * Trim an existing list so that it will contain only the specified range of elements specified.
     * start and end can also be negative numbers indicating offsets from the end of the list,
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return True if successfully, or it will return false
     */
    Boolean ltrim(String key, long start, long end);

    /**
     * Ltrim boolean.
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return the boolean
     */
    Boolean ltrim(byte[] key, long start, long end);
}
