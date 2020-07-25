package com.dalaoyang.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.entity
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/2
 */
@Entity
public class SysUser implements Serializable {

    @Id
    @GeneratedValue
    private Integer userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String passWord;

    //多对多关系
    @ManyToMany(fetch= FetchType.EAGER)
    //急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载
    //FetchType.LAZY：懒加载，加载一个实体时，定义懒加载的属性不会马上从数据库中加载
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
