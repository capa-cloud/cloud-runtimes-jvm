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
package group.rxcloud.cloudruntimes.domain.enhanced.lock;

public class TryLockRequest {

    /**
     * Required. The lock store name,e.g. `redis`.
     */
    private String storeName;

    /**
     * Required. resource_id is the lock key. e.g. `order_id_111`
     * It stands for "which resource I want to protect"
     */
    private String resourceId;

    /**
     * Required. lock_owner indicate the identifier of lock owner.
     * You can generate a uuid as lock_owner.For example,in golang:
     * req.LockOwner = uuid.New().String()
     * This field is per request,not per process,so it is different for each request,
     * which aims to prevent multi-thread in the same process trying the same lock concurrently.
     * The reason why we don't make it automatically generated is:
     * 1. If it is automatically generated,there must be a 'my_lock_owner_id' field in the response.
     * This name is so weird that we think it is inappropriate to put it into the api spec
     * 2. If we change the field 'my_lock_owner_id' in the response to 'lock_owner',which means the current lock owner of this lock,
     * we find that in some lock services users can't get the current lock owner.Actually users don't need it at all.
     * 3. When reentrant lock is needed,the existing lock_owner is required to identify client and check "whether this client can reenter this lock".
     * So this field in the request shouldn't be removed.
     */
    private String lockOwner;

    /**
     * Required. expire is the time before expire.The time unit is second.
     */
    private int expire;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getLockOwner() {
        return lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "TryLockRequest{" +
                "storeName='" + storeName + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", lockOwner='" + lockOwner + '\'' +
                ", expire=" + expire +
                '}';
    }
}
