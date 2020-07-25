package com.springboot.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -7362371894429216969L;

    @NotEmpty(message="用户名不能为空")
    @Length(min=6,max = 12,message="用户名长度必须位于6到12之间")
    private String userName;


    @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String passWord;

    @Email(message="邮箱格式错误")
    private String email;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idCard;

    @Pattern(regexp = "^((13[0-9]{1})|159|153)+\\d{8}$",message = "手机号格式错误")
    private String phone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(@NotEmpty(message = "用户名不能为空") @Length(min = 6, max = 12, message = "用户名长度必须位于6到12之间") String userName, @NotEmpty(message = "密码不能为空") @Length(min = 6, message = "密码长度不能小于6位") String passWord, @Email(message = "请输入正确的邮箱") String email, @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误") String idCard, @Pattern(regexp = "^((13[0-9]{1})|159|153)+\\d{8}$", message = "手机号格式错误") String phone) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.idCard = idCard;
        this.phone = phone;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
