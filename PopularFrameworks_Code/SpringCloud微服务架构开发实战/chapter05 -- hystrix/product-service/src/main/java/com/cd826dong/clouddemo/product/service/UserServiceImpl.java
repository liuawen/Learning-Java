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
package com.cd826dong.clouddemo.product.service;

import com.cd826dong.clouddemo.product.api.UserDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 用户服务
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "findAllFallback")
    public List<UserDto> findAll() {
        UserDto[] userDtos = this.restTemplate.getForObject(
                "http://USERSERVICE/users/", UserDto[].class);
        return Arrays.asList(userDtos);
    }

    @Override
    @HystrixCommand(fallbackMethod = "loadFallback")
    public UserDto load(Long id) {
        return this.restTemplate.getForEntity(
                "http://USERSERVICE/users/" + id,
                UserDto.class).getBody();
    }

    protected List<UserDto> findAllFallback() {
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto(1L, "zhangSan_static", "/users/avatar/zhangsan.png"));
        userDtos.add(new UserDto(2L, "lisi_static", "/users/avatar/lisi.png"));
        userDtos.add(new UserDto(3L, "wangwu_static", "/users/avatar/wangwu.png"));
        userDtos.add(new UserDto(4L, "yanxiaoliu_static", "/users/avatar/yanxiaoliu.png"));
        return userDtos;
    }

    protected UserDto loadFallback(Long id) {
        return new UserDto(id, "Anonymous", "default.png");
    }

}
