package com.imooc.springboot.transaction.service;

import com.imooc.springboot.transaction.mapper.UserMapper;
import com.imooc.springboot.transaction.model.User;
import com.imooc.springboot.transaction.model.UserExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/10/14
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectByCondition(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(user)) {
            if (Objects.nonNull(user.getAge())) {
                criteria.andAgeEqualTo(user.getAge());
            }
            if (Objects.nonNull(user.getName())) {
                criteria.andNameEqualTo(user.getName());
            }
        }
        return userMapper.selectByExample(example);
    }

    public int updateById(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertRequired(User user) {
        return userMapper.insert(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public int insertRequiresNew(User user) {
        return userMapper.insert(user);
    }

    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public int insertNested(User user) {
        return userMapper.insert(user);
    }
}
