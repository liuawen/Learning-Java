package cn.liuawen.mapper;

import cn.liuawen.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-15
 */
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
