package cn.liuawen.service.impl;

import cn.liuawen.dao.RoleDao;
import cn.liuawen.domain.Role;
import cn.liuawen.service.RoleService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-13
 * 业务层
 *
 */
//没用注解  我copy  cn.liuawen.service.impl.RoleServiceImpl 去Spring文件配置 applicationContext
public class RoleServiceImpl implements RoleService {
    //注Dao  applicationContext.xml
    //<!--配置RoleService-->
    //    <bean id="roleService" class="cn.liuawen.service.impl.RoleServiceImpl">
    //        <property name="roleDao" ref="roleDao"/>
    //    </bean>
    //<!--配置RoleDao-->
    //    <bean id="roleDao" class="cn.liuawen.dao.impl.RoleDaoImpl">
    //        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    //    </bean>
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
