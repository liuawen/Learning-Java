package com.dalaoyang.consts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Consts {
    private static List<String> urlList = Arrays.asList("login", "checkLogin", "logout");
    public final static List<String> ALLOW_URL_LIST = Collections.unmodifiableList(urlList);
    public final static Integer HASHMAP_DEFAULT_CAPACITY = 16;
}
