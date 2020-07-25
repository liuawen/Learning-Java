package com.dalaoyang.repository;

import com.dalaoyang.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.repository
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/5
 */
public interface UserRepository extends MongoRepository<UserInfo,Long> {
}
