package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 3033545151355633270L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String email;
    private Integer isEnable;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "userRole", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;

    @Transient
    private List<Long> roleIdList;

    public User(Long userId,String username, String password, String email, Integer isEnable,List<Role> roleList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isEnable = isEnable;
        this.roleList = roleList;
    }
}
