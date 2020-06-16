package cn.liuawen.dao;

import cn.liuawen.domain.Role;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-13
 */
public interface RoleDao {
    public List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(long id);
}
