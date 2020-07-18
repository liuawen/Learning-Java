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
import com.cd826dong.clouddemo.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 用户服务，使用Feign实现
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto load(Long id) {
        UserDto userDto = this.restTemplate.getForEntity("http://localhost:8280/userservice/users/{id}", UserDto.class, id).getBody();
        return userDto;
    }
}
