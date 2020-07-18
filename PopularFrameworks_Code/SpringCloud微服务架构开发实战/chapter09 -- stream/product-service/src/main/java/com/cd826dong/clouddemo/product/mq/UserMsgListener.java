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
package com.cd826dong.clouddemo.product.mq;


import com.cd826dong.clouddemo.product.redis.repository.UserRedisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


/**
 * 用户消息监听器
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@EnableBinding(SpringCloudBookChannels.class)
public class UserMsgListener {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected UserRedisRepository userRedisRepository;

    @StreamListener("inboundUserMsg")
    public void onUserMsgSink(UserMsg userMsg) {
        if (UserMsg.UA_UPDATE.equalsIgnoreCase(userMsg.getAction())) {
            this.logger.debug("收到用户更新消息，所要更新用户的ID: {}", userMsg.getUserId());
            this.userRedisRepository.delete(userMsg.getUserId());
        } else if (UserMsg.UA_DELETE.equalsIgnoreCase(userMsg.getAction())) {
            this.logger.debug("收到用户删除消息，所删除用户的ID: {}", userMsg.getUserId());
            this.userRedisRepository.delete(userMsg.getUserId());
        } else {
            this.logger.debug("收到未知用户消息，用户的ID: {}", userMsg.getUserId());
        }
    }
}
