package cn.liuawen;

import cn.liuawen.domain.User;
import cn.liuawen.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class JpaTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
}
