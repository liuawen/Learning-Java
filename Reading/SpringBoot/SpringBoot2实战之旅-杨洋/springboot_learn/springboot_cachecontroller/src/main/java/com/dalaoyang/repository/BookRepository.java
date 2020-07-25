package com.dalaoyang.repository;


import com.dalaoyang.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dalaoyang
 * @project springboot_learn
 * @package com.dalaoyang.repository
 * @email yangyang@dalaoyang.cn
 * @date 2018/8/8
 */
public interface   BookRepository extends JpaRepository<Book,Long> {

}
