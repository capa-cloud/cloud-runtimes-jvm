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
package group.rxcloud.cloudruntimes.domain.enhanced.database;

public class QueryResponse<T> {

    private int size;

    /**
     * it should be use json encode.  [{"id":2,"name":"jack"},{"id":4,"name":"anna"}]
     * if some dataType can't be recognized, we should use string types.
     * I think the component developer can decide the Serialize of this field , and the app develop should know
     * the deserialize of the field.
     */
    private T queryResult;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(T queryResult) {
        this.queryResult = queryResult;
    }
}
