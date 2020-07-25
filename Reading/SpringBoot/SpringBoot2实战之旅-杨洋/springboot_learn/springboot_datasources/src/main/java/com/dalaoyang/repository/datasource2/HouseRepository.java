package com.dalaoyang.repository.datasource2;

import com.dalaoyang.entity.datasource2.House;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.repository.datasource2
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/10
 */
public interface HouseRepository extends JpaRepository<House,Integer> {
}
