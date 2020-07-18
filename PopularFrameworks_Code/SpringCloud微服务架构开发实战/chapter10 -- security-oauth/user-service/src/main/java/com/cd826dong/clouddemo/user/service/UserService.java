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

import com.cd826dong.clouddemo.user.api.UserDto;
import com.cd826dong.clouddemo.user.entity.User;
import com.cd826dong.clouddemo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 用户管理服务实现
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Service
public class UserService {
    @Value("${server.port}")
    protected int serverPort = 0;
    @Autowired
    protected UserRepository userRepository;

    public List<UserDto> findAll() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map((user) -> {
            return new UserDto(user, serverPort);
        }).collect(Collectors.toList());
    }

    public UserDto load(Long id) {
        User user = this.userRepository.findOne(id);
        if (null == user)
            return null;

        return new UserDto(user, serverPort);
    }

    public UserDto save(UserDto userDto) {
        User user = this.userRepository.findOne(userDto.getId());
        if (null == user) {
            user = new User();
        }
        user.setNickname(userDto.getNickname());
        user.setAvatar(userDto.getAvatar());
        this.userRepository.save(user);

        return new UserDto(user, serverPort);
    }

    public void delete(Long id) {
        this.userRepository.delete(id);
    }
}
