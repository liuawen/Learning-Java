package com.springboot.service;

import com.springboot.entity.Role;

import java.util.List;


public interface RoleService {

    Role findRoleByRoleId(Long roleId);

    List<Role> findAllByIsEnable();
}
