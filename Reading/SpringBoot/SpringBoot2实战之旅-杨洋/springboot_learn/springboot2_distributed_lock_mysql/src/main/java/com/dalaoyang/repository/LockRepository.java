package com.dalaoyang.repository;

import com.dalaoyang.entity.Lock;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LockRepository extends JpaRepository<Lock, Long> {

    Lock findByTag(String tag);

    void deleteByTag(String tag);
}
