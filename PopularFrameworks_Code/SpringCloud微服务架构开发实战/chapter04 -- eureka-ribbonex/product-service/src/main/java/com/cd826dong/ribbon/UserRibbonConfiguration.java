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
package com.cd826dong.ribbon;


import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserRibbonConfiguration {
    String listOfServers = "http://192.168.0.12:2100," +
            "http://192.168.0.12:2110,http://192.168.0.16:2100";

    @Bean
    public ServerList<Server> ribbonServerList() {
        List<Server> list = Lists.newArrayList();
        if (!Strings.isNullOrEmpty(listOfServers)) {
            for (String s: listOfServers.split(",")) {
                list.add(new Server(s.trim()));
            }
        }
        return new StaticServerList<>(list.toArray(new Server[0]));
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl(false, "/cs/hostRunning");
    }

    @Bean
    public IRule ribbonRule() {
        return new ZoneAvoidanceRule();
    }
}
