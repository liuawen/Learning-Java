package com.dalaoyang.repository;

import com.dalaoyang.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.repository
 * @email yangyang@dalaoyang.cn
 * @date 2018/9/1
 */
public interface UserRepository extends ReactiveMongoRepository<User,Long> {
}
