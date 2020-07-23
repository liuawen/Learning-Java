package com.atguigu.test08;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import org.junit.Test;

/*
 * 2、字符串的比较
 * （1）==：比较对象的地址
 * 结论：只有两个字符串的常量对象比较时才会返回true，其他的都是false
 * （2）equals：比较字符串的内容，严格区分大小写
 * 	因为String类型重写了Object的equals
 * （3）equalsIgnoreCase(String anotherString) ：比较字符串内容，不区分大小写
 * （4）大小比较
 * String类型实现了Comparable接口，重写了compareTo方法，严格区分大小写
 * 	 依次比较对应位置的字符
 * 	hello和Hello，先[0]位置的h和H，h>H，就直接认定为hello>Hello
 *  hello和hella，先[0][1][2][3]比较，都一样，最后到[4]o>a，认定hello>hella
 *  hello和helloworld，发现前面都一样，长的大
 *
 *  （5）大小比较：不区分大小写
 *  String类型提供了一个方法compareToIgnoreCase，可以忽略大小写比较大小
 *
 *  （6）按照每个国家的语言校对顺序
 *  java.text.Collator：Collator 类执行区分语言环境的 String 比较。使用此类可为自然语言文本构建搜索和排序例程。
 *  	Collator实现了Comparator接口 ，
 *     Collator是抽象类，不能直接创建对象，它有一个直接子类RuleBasedCollator
 *     Collator内部提供了一个静态方法，可以获取一个它的子类对象
 *
 * 自然排序：实现java.lang.Comparable接口，int compareTo(Object obj)
 * 定制排序
 */
public class TestString02 {
    @Test
    public void test12() {
        String[] arr = {"张三", "张阿", "李四", "李八","王五", "柳柳"};
        //希望按照拼音顺序，字典顺序
        Arrays.sort(arr, Collator.getInstance(Locale.CHINA));//Locale.CHINA指定语言环境
        System.out.println(Arrays.toString(arr));//[李八, 李四, 柳柳, 王五, 张阿, 张三]
    }

    @Test
    public void test11() {
        String[] arr = {"张三", "张阿", "李四", "李八","王五", "柳柳"};
        //希望按照拼音顺序，字典顺序
        Arrays.sort(arr, Collator.getInstance());//默认语言环境，因为我现在的操作系统的平台是中文win
        System.out.println(Arrays.toString(arr));//[李八, 李四, 柳柳, 王五, 张阿, 张三]
    }


    @Test
    public void test10() {
        String[] arr = {"菜鸡文", "张三", "李四", "柳小子", "牛菜鸟"};
        Arrays.sort(arr);//按照自然顺序，按照每一个字符的Unicode编码值排序的
        System.out.println(Arrays.toString(arr));//[张三, 李四, 柳小子, 牛菜鸟, 菜鸡文]
        System.out.println('柳' + 0);//\u67f3  26611
        System.out.println('牛' + 0);// \u725b 29275
    }

    @SuppressWarnings("all")
    @Test
    public void test09() {
        String[] arr = {"hello", "China", "china", "java", "Java", "World", "Hi"};
        //排序
        //按照字母的顺序排列，不区分大小写
        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                return s1.compareToIgnoreCase(s2);
            }

        });//按照元素的自然顺序排序
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test08() {
        String[] arr = {"hello", "china", "Java", "World", "Hi"};
        //排序
        //按照字母的顺序排列
        Arrays.sort(arr);//按照元素的自然顺序排序
        System.out.println(Arrays.toString(arr));//小到大
        //[Hi, Java, World, china, hello]
    }

    @Test
    public void test07() {
        String s1 = new String("hello");
        String s2 = new String("Hello");

        if (s1.compareToIgnoreCase(s2) > 0) {
            System.out.println(s1 + ">" + s2);
        } else if (s1.compareToIgnoreCase(s2) < 0) {
            System.out.println(s1 + "<" + s2);
        } else {
            System.out.println(s1 + "=" + s2);//hello=Hello
        }
        System.out.println(s1.compareToIgnoreCase(s2));//0
    }

    @Test
    public void test06() {
        String s1 = new String("hello");
        String s2 = new String("helloworld");
		
	/*	if(s1 > s2){//不能直接使用比较运算符
			
		}*/

        if (s1.compareTo(s2) > 0) {
            System.out.println(s1 + ">" + s2);
        } else if (s1.compareTo(s2) < 0) {
            System.out.println(s1 + "<" + s2);//hello<helloworld
        } else {
            System.out.println(s1 + "=" + s2);
        }

        String str1 = "hello";
        String str2 = "world";
        System.out.println(str1.compareTo(str2));//小于0的值 -15
    }

    @Test
    public void test05() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.equalsIgnoreCase(s2));//true

        String s3 = "hello";
        System.out.println(s3.equalsIgnoreCase(s1));//true

        String s4 = "Hello";
        System.out.println(s3.equalsIgnoreCase(s4));//true
    }

    @Test
    public void test04() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.equals(s2));//true

        String s3 = "hello";
        System.out.println(s3.equals(s1));//true

        String s4 = "Hello";
        System.out.println(s3.equals(s4));//false
    }

    @Test
    public void test03() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);//false
    }

    @Test
    public void test02() {
        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println(s1 == s2);//false
    }

    @Test
    public void test01() {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);//true

        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3 == s4);//false
    }
}
