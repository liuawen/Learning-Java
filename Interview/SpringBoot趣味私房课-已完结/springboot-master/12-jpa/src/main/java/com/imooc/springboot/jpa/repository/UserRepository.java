package com.imooc.springboot.jpa.repository;

import com.imooc.springboot.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/08/25
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByAge(Integer age);

    Page<User> findByNameContaining(String name, Pageable pageable);
}
