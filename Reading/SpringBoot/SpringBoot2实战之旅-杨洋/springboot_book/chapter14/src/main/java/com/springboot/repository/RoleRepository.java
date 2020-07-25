package com.springboot.repository;

import com.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role,Long> , JpaSpecificationExecutor<Role> {

    List<Role> findAllByIsEnable(Integer isEnable);
}
