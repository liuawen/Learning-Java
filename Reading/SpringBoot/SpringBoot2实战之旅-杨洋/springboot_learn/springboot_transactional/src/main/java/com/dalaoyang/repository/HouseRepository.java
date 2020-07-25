package com.dalaoyang.repository;

import com.dalaoyang.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.repository
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/28
 */
public interface HouseRepository extends JpaRepository<House,Integer> {
}
