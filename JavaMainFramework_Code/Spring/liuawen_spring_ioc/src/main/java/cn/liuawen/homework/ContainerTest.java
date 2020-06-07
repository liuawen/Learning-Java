package cn.liuawen.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 */
public class ContainerTest {

    public static void main(String[] args) {
        Container container = new Container( 100 , 0.8f );

        //容器添加一波元素
        container.add("小菜");
        container.add(null);
        container.add(1);
        System.out.println(container);

        // 输出容器中元素个数
        System.out.println( container.size() );

        // 判断容器是否为空
        System.out.println( container.isEmpty() );

        // 判断指定的对象"小菜"是否存在于容器中
        System.out.println( container.contains("小菜") );

        // 获取容器内部的有效元素组成的数组
        System.out.println( Arrays.toString(container.toArray()) );


        // 移除容器中的 1024 元素
        System.out.println( container.remove( 1 ) );

        // 清空容器
        container.clear();
        System.out.println( container.size() );

        // 创建一个集合，并进行操作
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("小菜");

        // 如果此集合包含指定集合中的所有元素，则返回 true
        System.out.println( container.containsAll(arrayList) );

    }
}