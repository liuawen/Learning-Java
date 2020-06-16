package cn.liuawen.service;

import cn.liuawen.domain.Role;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-13
 */
public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
