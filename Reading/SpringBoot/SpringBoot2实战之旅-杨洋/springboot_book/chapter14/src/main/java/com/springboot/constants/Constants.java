package com.springboot.constants;

import com.springboot.entity.Role;

import java.util.List;
import java.util.Optional;

public class Constants {
    public static final Integer YES = 1;
    public static final Integer NO = 0;
    //起始页下标
    public static final int startPage = 0;
    //默认每页大小
    public static final int defaultPageSize = 10;


    //菜单标示
    public static final Integer INDEX_MENU_FLAG = 1;
    public static final Integer ARTICLE_MENU_FLAG = 2;
    public static final Integer TAG_MENU_FLAG = 3;
    public static final Integer LINK_MENU_FLAG = 4;
    public static final Integer USER_MENU_FLAG = 5;
    public static final Integer MESSAGE_MENU_FLAG = 6;
    public static final Integer SYSTEM_MENU_FLAG = 7;


    //权限
    public static final String ROLE_USER = "ROLE_NAME";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_SYSTEMADMIN = "ROLE_SYSTEMADMIN";
    public static final String ROLE_SUPERADMIN = "ROLE_SUPERADMIN";

    //权限列表
    public static final Integer[] ROLE_USER_LIST = {INDEX_MENU_FLAG, ARTICLE_MENU_FLAG, TAG_MENU_FLAG};
    public static final Integer[] ROLE_ADMIN_LIST = {INDEX_MENU_FLAG, ARTICLE_MENU_FLAG, TAG_MENU_FLAG, LINK_MENU_FLAG, USER_MENU_FLAG, MESSAGE_MENU_FLAG};
    public static final Integer[] ROLE_SYSTEMADMIN_LIST = {INDEX_MENU_FLAG, SYSTEM_MENU_FLAG};
    public static final Integer[] ROLE_SUPERADMIN_LIST = {INDEX_MENU_FLAG, ARTICLE_MENU_FLAG, TAG_MENU_FLAG, LINK_MENU_FLAG, USER_MENU_FLAG, MESSAGE_MENU_FLAG, SYSTEM_MENU_FLAG};

    public static Integer[] getUserRoleList(List<Role> roleList) {
        Optional<Role> superAdminOptional = roleList.stream().filter(role -> ROLE_SUPERADMIN.equals(role.getRoleName())).findFirst();
        Optional<Role> adminOptional = roleList.stream().filter(role -> ROLE_ADMIN.equals(role.getRoleName())).findFirst();
        Optional<Role> systemadminOptional = roleList.stream().filter(role -> ROLE_SYSTEMADMIN.equals(role.getRoleName())).findFirst();
        Optional<Role> userOptional = roleList.stream().filter(role -> ROLE_USER.equals(role.getRoleName())).findFirst();
        if (superAdminOptional.isPresent()) {
            return ROLE_SUPERADMIN_LIST;
        } else if (adminOptional.isPresent() && systemadminOptional.isPresent()) {
            return ROLE_SUPERADMIN_LIST;
        } else if (adminOptional.isPresent()) {
            return ROLE_ADMIN_LIST;
        } else if (userOptional.isPresent() && systemadminOptional.isPresent()) {
            return ROLE_SUPERADMIN_LIST;
        } else if (adminOptional.isPresent()) {
            return ROLE_ADMIN_LIST;
        } else if (systemadminOptional.isPresent()) {
            return ROLE_SYSTEMADMIN_LIST;
        } else {
            return ROLE_USER_LIST;
        }
    }
}
