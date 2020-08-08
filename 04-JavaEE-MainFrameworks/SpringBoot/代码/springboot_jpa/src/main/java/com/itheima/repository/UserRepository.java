package com.itheima.repository;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{

    public List<User> findAll();

}
