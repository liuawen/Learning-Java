package com.springboot.service;

import com.springboot.entity.Pages;
import com.springboot.entity.User;
import org.springframework.data.domain.Page;


public interface UserService {

    Page<User> findAllBySearch(Pages pages, Long userId, String username);

    User findUserByUserId(Long userId);

    String saveOrUpdateUser(User user);

    void updateUserIsEnable(Long userId, Integer isEnable);

    void deleteUser(Long userId);

    User findByUsername(String username);

}
