package com.imooc.jdbc.cache;

import com.imooc.jdbc.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO {file desc}
 *
 * @version 1.0
 */
public class UserLocalCache {

    private static Map<String, User> userMap;

    private UserLocalCache() {}

    public static void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public static void removeUser(String username) {
        userMap.remove(username);
    }

    public static int getOnlineUserCount() {
        return userMap.size();
    }

    public static void init() {
        userMap = new HashMap<>();
    }

    public static void destroy() {
        userMap = null;
    }

}
