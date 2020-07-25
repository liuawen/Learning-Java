package com.dalaoyang.service;

import com.dalaoyang.model.User;
import com.dalaoyang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.service
 * @email yangyang@dalaoyang.cn
 * @date 2018/9/1
 */
@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    public Flux<User> allUser(){
        return repository.findAll();
    }

    public Mono<Void> saveUser(Mono<User> user){
        return repository.insert(user).then();
    }

    public Mono<User> getUser(Long id){
        return repository.findById(id);
    }
}
