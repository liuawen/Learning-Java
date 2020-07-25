package com.dalaoyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -3683940652745738930L;
    private int id;
    private String userName;
    private String passWord;
    private String trueName;
    private String email;
    private String phone;
}
