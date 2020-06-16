package cn.liuawen.repository;

import cn.liuawen.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-16
 */
//实体、类型
public interface UserRepository  extends JpaRepository<User,Long> {
    public List<User> findAll();
}
