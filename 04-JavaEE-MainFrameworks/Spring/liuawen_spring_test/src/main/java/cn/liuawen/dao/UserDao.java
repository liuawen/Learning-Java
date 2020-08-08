package cn.liuawen.dao;

        import cn.liuawen.domain.User;

        import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-14
 */
public interface UserDao {

    List<User> findAll();
}
