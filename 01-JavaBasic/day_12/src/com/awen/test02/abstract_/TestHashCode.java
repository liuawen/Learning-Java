package com.awen.test02.abstract_;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.IdentityHashMap;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 */
public class TestHashCode {
    public static void main(String[] args) {
        String s1 = "Aa";
        String s2 = "BB";
        System.out.println(s1.hashCode());//2112
        System.out.println(s2.hashCode());//2112
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(System.identityHashCode(s1));//460141958
        System.out.println(System.identityHashCode(s2));//1163157884

        String s3 = "java";
        String s4 = "java";
        String s5 = new String("java");

        System.out.println(s3 == s4);//true
        System.out.println(s3.equals(s4));//true
        System.out.println(s3 == s5);//false
        System.out.println(s5.equals(s3));//true
        System.out.println(s3.hashCode());//3254818
        System.out.println(s4.hashCode());//3254818
        System.out.println(s5.hashCode());//3254818
        System.out.println(System.identityHashCode(s3));//1956725890
        System.out.println(System.identityHashCode(s4));//1956725890
        System.out.println(System.identityHashCode(s5));//356573597
    }
}