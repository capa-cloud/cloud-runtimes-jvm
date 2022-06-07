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
 * The Native list commands.
 *
 * @see <a href="http://redisdoc.com/list/index.html">list</a>
 */
public interface NativeListCommands {

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
     * Inserts values at the head of the list stored at key, only if key already exists and holds a list.
     * In contrary to LPUSH, no operation will be performed when key does not yet exist.
     *
     * @param key      the key
     * @param elements the elements
     * @return The length of the list after the push operation.
     */
    Long lpushx(String key, String... elements);

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
     * Inserts value at the tail of the list stored at key, only if key already exists and holds a list.
     * In contrary to RPUSH, no operation will be performed when key does not yet exist.
     *
     * @param key      the key
     * @param elements the elements
     * @return The length of the list after the push operation.
     */
    Long rpushx(String key, String... elements);

    /**
     * Removes and returns the first element of the list stored at key.
     *
     * @param key the key
     * @return The value of the first element, or nil when key does not exist.
     */
    String lpop(String key);

    /**
     * Removes and returns the last element of the list stored at key.
     *
     * @param key the key
     * @return The value of the last element, or nil when key does not exist.
     */
    String rpop(String key);

    /**
     * The RPOPLPUSH command performs the following two actions in an atomic time:<br>
     * 1. Pops the last element (tail element) in the list source and returns it to the client.<br>
     * 2. Insert the element that pops up from source into the list Destination as the header element of the Destination list.
     *
     * @param src source
     * @param dst destination
     * @return The ejected element
     */
    String rpoplpush(String src, String dst);

    /**
     * Removes the first count occurrences of elements equal to value from the list stored at key.
     * The count argument influences the operation in the following ways:
     * <pre>
     * count more than 0: Remove elements equal to value moving from head to tail.
     * count less than 0: Remove elements equal to value moving from tail to head.
     * count = 0: Remove all elements equal to value.
     * </pre>
     *
     * @param key     the key
     * @param count   the count
     * @param element the element
     * @return The number of removed elements.
     */
    Long lrem(String key, long count, String element);

    /**
     * Gets the length of the list stored at key.
     *
     * @param key the key
     * @return The length of the list at key. 0 if list is not exist.
     */
    Long llen(String key);

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
     * Inserts value in the list stored at key either before|after the reference value pivot.
     * When key does not exist, it is considered an empty list and no operation is performed.
     *
     * @param key           the key
     * @param beforeORafter BEFORE|AFTER
     * @param pivot         the pivot
     * @param value         the value
     * @return The length of the list after the insert operation, or -1 when the value pivot was not found.
     */
    Long linsert(String key, String beforeORafter, String pivot, String value);

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
     * Blpop list.
     *
     * @param timeout the timeout
     * @param keys    the keys
     * @return the list
     */
    List<String> blpop(int timeout, String... keys);

    /**
     * Brpop list.
     *
     * @param timeout the timeout
     * @param keys    the keys
     * @return the list
     */
    List<String> brpop(int timeout, String... keys);

    /**
     * BRPOPLPUSH is a blocked version of RPOPLPUSH source destination, and behaves like RPOPLPUSH
     * source destination when the given list source is not empty.
     * When the list source is empty, the BRPOPLPUSH command blocks the connection until either a
     * timeout occurs or another client executes LPUSH key value [value...] on the source. Or RPUSH key
     * value [value...] Until ordered.
     *
     * @param src     source
     * @param dst     destination
     * @param timeout a number in seconds as a value. A timeout of 0 means you can block indefinitely.
     * @return If no element is popped within the specified time, return nil and wait time. Instead, return a list of two elements, the first being the value of the ejected element and the second being the wait time.
     */
    String brpoplpush(String src, String dst, int timeout);
}
