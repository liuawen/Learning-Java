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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


/**
 * 用户消息发送者
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Component
public class UserMsgSender {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private Source source;

    @Autowired
    public UserMsgSender(Source source) {
        this.source = source;
    }

    public void sendMsg(UserMsg userMsg) {
        this.logger.debug("发送用户变更消息:{} ", userMsg);

        // 发送消息
        this.source.output().send(MessageBuilder.withPayload(userMsg).build());
    }
}
