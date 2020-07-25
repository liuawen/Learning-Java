package com.dalaoyang.repository;

import com.dalaoyang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.repository
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/9
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);
}
