package cn.liuawen.dao.impl;

import cn.liuawen.dao.UserDao;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 */
public class UserDaoImpl implements UserDao {
    private String company;
    private int age;
    public void setCompany(String company) {
        this.company = company;
    }
    public void setAge(int age) {
        this.age = age;
    }

    private List<String> strList;
    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建...");
    }
    public void init(){
        System.out.println("初始化方法...");
    }
    public void destroy(){
        System.out.println("销毁方法...");
    }
    @Override
    public void save() {

        System.out.println(company+"==="+age);
//        System.out.println(strList);
        System.out.println("UserDao save method running....");


    }
}
