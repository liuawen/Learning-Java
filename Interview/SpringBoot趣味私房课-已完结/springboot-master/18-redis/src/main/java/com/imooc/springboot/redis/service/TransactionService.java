package com.imooc.springboot.redis.service;

import com.imooc.springboot.redis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void batchInsert() {
        User user1 = new User();
        user1.setName("user2222");
        user1.setAge(2222);
        user1.setEmail("user1@imooc.com");
        userService.insertNested(user1);

        User user2 = new User();
        user2.setName("user2");
        user2.setAge(1);
        user2.setEmail("user2@imooc.com");
        userService.insertNested(user2);
    }
}
