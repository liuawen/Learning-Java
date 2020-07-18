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
package com.cd826dong.clouddemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * SpringCloud示例工程 -- 商品服务
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@EnableFeignClients
@EnableDiscoveryClient
// @EnableBinding(Sink.class)
@SpringBootApplication
@RemoteApplicationEventScan
public class Application {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@StreamListener(Sink.INPUT)
    public void onUserMsgSink(UserMsg userMsg) {
        this.logger.debug("接收到用户变更消息: {}", userMsg);
    }*/
}
