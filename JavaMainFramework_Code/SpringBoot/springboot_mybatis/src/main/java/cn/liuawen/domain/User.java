package cn.liuawen.domain;

import lombok.Data;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-15
 */
@Data
public class User {
    //主键
    private Long id;
    //姓名
    private String username;
    //密码
    private String password;
}
