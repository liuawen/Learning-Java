package com.springboot.repository;

import com.springboot.entity.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<UserInfo,Long> {
}
