package com.dalaoyang.repository;

import com.dalaoyang.entity.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.repository
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/2
 */
public interface UserRepository extends CrudRepository<SysUser,Long> {

    SysUser findByUserName(String username);
}
