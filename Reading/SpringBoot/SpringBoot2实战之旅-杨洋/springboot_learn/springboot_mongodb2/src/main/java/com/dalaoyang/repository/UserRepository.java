package com.dalaoyang.repository;

import com.dalaoyang.entity.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<UserInfo,Long> {
}
