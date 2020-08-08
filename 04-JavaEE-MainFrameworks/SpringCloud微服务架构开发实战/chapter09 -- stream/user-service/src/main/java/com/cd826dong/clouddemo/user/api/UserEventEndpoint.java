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
package com.cd826dong.clouddemo.user.api;

import com.cd826dong.clouddemo.bus.MyBusEvent;
import com.cd826dong.clouddemo.util.ApplicationContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 事件发布测试的Endpoint
 *
 * @author CD826
 * @since 1.0.0
 */
@RestController
@RequestMapping("/bus/events")
public class UserEventEndpoint {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 发布一个事件
     * @param eventType
     * @return
     */
    @RequestMapping(value = "/{eventType}", method = RequestMethod.POST)
    public Boolean publishEvent(@PathVariable String eventType){
        ApplicationContext applicationContext = ApplicationContextHolder.getApplicationContext();
        MyBusEvent myBusEvent = new MyBusEvent(this, applicationContext.getId(), "*:**", eventType);
        applicationContext.publishEvent(myBusEvent);
        this.logger.debug("publish remote application event = {}", myBusEvent);
        return Boolean.TRUE;
    }
}
