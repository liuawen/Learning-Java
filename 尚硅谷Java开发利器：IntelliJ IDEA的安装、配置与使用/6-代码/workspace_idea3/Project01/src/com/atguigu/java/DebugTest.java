package com.atguigu.java;

import java.util.HashMap;

/**
 * @author shkstart
 * @date 2018/7/13 0013 - 下午 6:28
 */
public class DebugTest {

    public static void main(String[] args){

        for (int i = 0; i < 100; i++) {
            System.out.println(i);        }


        HashMap<String, String> map = new HashMap<>();
        map.put("name","Tom");
        map.put("age","12");
        map.put("school","Tsinghua");
        map.put("major","computer");

        String age = map.get("age");
        System.out.println("age = " + age);

        map.remove("major");
        System.out.println(map);

    }
}
