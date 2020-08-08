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
package com.cd826dong.clouddemo.product.service.impl;

import com.cd826dong.clouddemo.product.api.UserDto;
import com.cd826dong.clouddemo.product.redis.repository.UserRedisRepository;
import com.cd826dong.clouddemo.product.service.UserRemoteClient;
import com.cd826dong.clouddemo.product.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * 用户服务缺省实现
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected UserRemoteClient userRemoteClient;
    @Autowired
    protected UserRedisRepository userRedisRepository;

    @Override
    public UserDto load(Long id) {
        UserDto userDto = this.userRedisRepository.findOne(id);
        if (null != userDto) {
            this.logger.debug("已从Redis缓存中获取到用户:{} 的信息", id);
            return userDto;
        }

        this.logger.debug("Redis缓存中不存在用户:{} 的信息，尝试从远程进行加载", id);
        userDto = this.userRemoteClient.load(id);
        if (null != userDto) {
            this.userRedisRepository.saveUser(userDto);
        }
        return userDto;
    }

    @Autowired(required = false)
    protected RestTemplate restTemplate;
    public UserDto loadByRestTemplate(Long userId) {
        // 首先从Redis中获取
        UserDto userDto = this.userRedisRepository.findOne(userId);
        if (null != userDto) {
            this.logger.debug("已从Redis缓存中获取到用户:{} 的信息", userId);
            return userDto;
        }

        // Redis中不存在，那么从远程获取
        ResponseEntity<UserDto> restExchange =
                this.restTemplate.exchange(
                        "http://userservice//users/{userId}",
                        HttpMethod.GET,
                        null,
                        UserDto.class,
                        userId);
        UserDto user = restExchange.getBody();
        if (null != user) {
            // 获取后将用户信息进行缓存
            this.userRedisRepository.saveUser(user);
        }
        return user;
    }
}
