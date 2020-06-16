package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleDao extends JpaRepository<Role,Long> ,JpaSpecificationExecutor<Role> {
}
