/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cd826dong.clouddemo.user.service;


import com.google.common.base.MoreObjects;

/**
 * 用户消息
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
public class UserMsg {
    /** 消息类型：更新，值为: {@value} */
    public static final String UA_UPDATE = "update";
    /** 消息类型：删除，值为: {@value} */
    public static final String UA_DELETE = "delete";

    private String action;
    private Long userId;
    private String traceId;

    public UserMsg() {  }

    public UserMsg(String action, Long userId, String traceId) {
        this.action = action;
        this.userId = userId;
        this.traceId = traceId;
    }


    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("action", this.getAction())
                .add("userId", this.getUserId())
                .add("traceId", this.getTraceId());
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTraceId() {
        return traceId;
    }
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
