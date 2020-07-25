package com.dalaoyang.entity;

import org.springframework.data.annotation.Id;


public class UserInfo {

    @Id
    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserInfo() {
    }
}
