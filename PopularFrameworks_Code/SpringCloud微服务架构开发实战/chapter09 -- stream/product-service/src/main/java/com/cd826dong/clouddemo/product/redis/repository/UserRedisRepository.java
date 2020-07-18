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
package com.cd826dong.clouddemo.product.redis.repository;


import com.cd826dong.clouddemo.product.api.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;


/**
 * 用户的Redis数据库服务
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Repository
public class UserRedisRepository {
    public static final String USER_KEY_PRE = "user:";

    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate<String, UserDto> userRedisTemplate;
    private ValueOperations<String, UserDto> operations;

    @PostConstruct
    private void init() {
        this.operations = this.userRedisTemplate.opsForValue();
    }

    /**
     * 保存
     * @param userDto
     * @return
     */
    public void saveUser(UserDto userDto) {
        this.operations.set(this.buildKey(userDto.getId()), userDto);
    }

    /**
     * 加载
     * @param userId
     * @return
     */
    public UserDto findOne(Long userId) {
        String key = this.buildKey(userId);
        if (!this.userRedisTemplate.hasKey(key))
            return null;

        return this.operations.get(key);
    }

    /**
     * 删除
     * @param userId
     */
    public void delete(Long userId) {
        this.userRedisTemplate.delete(this.buildKey(userId));
    }

    /**
     * 构造存储的Key
     * @param userId
     * @return
     */
    protected String buildKey(Long userId) {
        return USER_KEY_PRE + String.valueOf(userId);
    }
}
