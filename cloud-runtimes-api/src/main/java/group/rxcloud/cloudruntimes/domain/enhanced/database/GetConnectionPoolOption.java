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

public class GetConnectionPoolOption {

    /**
     * Use the connection pool or forbid to create new connection
     */
    private boolean pooled;

    private int maxIdleConns;
    private int maxOpenConns;

    private long maxLifeTime;
    private long maxIdleTime;

    public boolean isPooled() {
        return pooled;
    }

    public void setPooled(boolean pooled) {
        this.pooled = pooled;
    }

    public int getMaxIdleConns() {
        return maxIdleConns;
    }

    public void setMaxIdleConns(int maxIdleConns) {
        this.maxIdleConns = maxIdleConns;
    }

    public int getMaxOpenConns() {
        return maxOpenConns;
    }

    public void setMaxOpenConns(int maxOpenConns) {
        this.maxOpenConns = maxOpenConns;
    }

    public long getMaxLifeTime() {
        return maxLifeTime;
    }

    public void setMaxLifeTime(long maxLifeTime) {
        this.maxLifeTime = maxLifeTime;
    }

    public long getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(long maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }
}
