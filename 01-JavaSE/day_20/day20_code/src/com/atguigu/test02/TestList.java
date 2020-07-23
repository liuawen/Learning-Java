package com.atguigu.test02;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/*
 * Collection是根接口，没有提供任何直接实现的。它有一些更具体的子接口，例如：List和Set。
 * 一、List：列表，接口
 * 1、List系列的集合：有序的、可重复的
 * 2、List系列的集合：ArrayList（动态数组）、Vector（动态数组，向量类）、
 * 			LinkedList（双向链表、双端队列、栈..）、Stack（栈）
 * 3、List的API
 * List接口比Collection接口多了一堆方法：
 * 下面列举的方法是比Collection接口多出来，和它一样的就不写了：
 * （1）void add(int index, Object element) ：在[index]位置添加一个元素，相当于插入
 *     boolean addAll(int index, Collection c) ：在[index]位置添加多个元素
 * （2） Object remove(int index) ：删除指定位置的元素
 * （3）Object get(int index) ：获取，返回[index]位置的元素
 * （4）Object set(int index, Object element) ：替换[index]位置的元素为element
 * （5）int indexOf(Object o)  ：在当前集合中查找o这个元素的下标，如果没有返回-1，如果有多个就返回找到的第一个的下标
 * （6） int lastIndexOf(Object o) ：在当前集合中查找o这个元素的下标，如果没有返回-1，如果有多个就返回找到的最后一个的下标
 * （7）List<E> subList(int fromIndex, int toIndex) ：截取一部分，[fromIndex, toIndex)
 * （8）ListIterator listIterator() ：获取一种迭代器
 * ListIterator是Iterator的子接口，它比Iterator增加了：从后往前遍历的方法，增加了遍历的同时添加和修改。
 *
 * Iterator：
 * （1）boolean hasNext()
 * （2）Object next()
 * （3）void remove()
 *
 * ListIterator：多出来的
 * （1）boolean hasPrevious() ：是否前面还有元素
 * （2）Object previous() ：获取前面的元素
 * （3）void add(E e) ：遍历的同时，添加元素
 * （4）void set(E e)  ：遍历的同时，替换元素
 * （5） int nextIndex()  ：返回下一个元素的索引
 * （6）int previousIndex() ：返回前一个元素的索引
 *
 *
 * 说明：虽然List系列的集合都是可以通过索引/下标进行操作的，但是像LinkedList这类的集合，其实不建议使用和索引相关的方法进行操作。
 * 因为它们的底层的物理结构不是数组，如果通过索引操作呢，会需要从头或尾遍历找到对应的索引，效率不高。
 */
public class TestList {
    @SuppressWarnings("all")
    @Test
    public void test8() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListIterator listIterator = list.listIterator(3);//把游标指定到任意位置
        while (listIterator.hasPrevious()) {
            Object obj = listIterator.previous();
            System.out.println(obj);
        }
        //Result
        //3
        //2
        //1
    }


    @SuppressWarnings("all")
    @Test
    public void test7() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//		ListIterator listIterator = list.listIterator();//默认游标在开头
        ListIterator listIterator = list.listIterator(list.size());//把游标指定到后面去
        while (listIterator.hasPrevious()) {
            Object obj = listIterator.previous();
            System.out.println(obj);
        }
        //Result
        //5
        //4
        //3
        //2
        //1
    }

    @SuppressWarnings("all")
    @Test
    public void test11() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);//[1, 2, 3, 4, 5]
        Object obj = list.get(1);
        System.out.println(obj);//2
        list.set(0, 10);
        System.out.println(list);//[10, 2, 3, 4, 5]
        List list2 = list.subList(1, 3);
        System.out.println(list2);//[2, 3]

        list.add(2);
        System.out.println(list);//[10, 2, 3, 4, 5, 2]
        int index1 = list.indexOf(2);
        System.out.println(index1);//1
        int index2 = list.lastIndexOf(2);
        System.out.println(index2);//5
    }

    @SuppressWarnings("all")
    @Test
    public void test10() {
        List list = new ArrayList();
        list.add(0);
        System.out.println(list.isEmpty());//false
        System.out.println(list.size());//1
        list.clear();
        System.out.println(list.size());//0
        System.out.println(list.isEmpty());//true
    }

    @SuppressWarnings("all")
    @Test
    public void test9() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.contains(1));//true

        List list2 = new ArrayList();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println(list.containsAll(list2));//true
        list2.remove(1);
        System.out.println(list2);//[1, 3, 4, 5]
        System.out.println(list.containsAll(list2));//true
        list.remove(new Integer(1));
        System.out.println(list);//[2, 3, 4, 5]
        System.out.println(list.containsAll(list2));//false

    }

    @SuppressWarnings("all")
    @Test
    public void test6() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object obj = listIterator.next();
            System.out.println(obj);
        }
        System.out.println("-------------------------");

        while (listIterator.hasPrevious()) {
            Object obj = listIterator.previous();
            System.out.println(obj);
        }

    }

    @SuppressWarnings("all")
    @Test
    public void test5() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.set(3, 100);
        System.out.println(list);

        Object obj = list.get(2);
        System.out.println(obj);
    }

    @SuppressWarnings("all")
    @Test
    public void test4() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Object object : list) {
            System.out.println(object + ":" + object.getClass());
        }
    }

    @SuppressWarnings("all")
    @Test
    public void test3() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        /*
         * 这里remove(1)它，调用的是remove(int index)这个方法
         * 为什么不是调用remove(Object obj)？因为1是基本数据类型，和int最匹配
         */
//		list.remove(1);//删除的是[1]的对象
        list.remove(new Integer(1));//删除的是对象
        System.out.println(list);//[2, 3, 4]

        list.remove(1);
        System.out.println(list);//[2, 4]
    }


    @SuppressWarnings("all")
    @Test
    public void test2() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add("张三");
        list.add(0, "李四");

        list.remove(1);
        System.out.println(list);//[李四]

        String str = (String) list.remove(0);
        System.out.println(str);//李四
        System.out.println(list);//[]
        list.add("王五");
        System.out.println(list);//[王五]
        list.remove("王五");
        System.out.println(list);//[]

        list.add("小白");
        list.add("小菜");
        System.out.println(list);//[小白, 小菜]
        List list2 = new ArrayList();
        list2.add("小菜");
        list2.add("小白");
        System.out.println(list2);//[小菜, 小白]
        list.removeAll(list2);
        System.out.println(list);//[]
    }


    @SuppressWarnings("all")
    @Test
    public void test1() {
        //这里左边用List多态引用的目的是为了关注List接口方法
        List list = new ArrayList();

        list.add("张三");
        list.add(0, "李四");
        System.out.println(list);// [李四, 张三]

        List list2 = new ArrayList();
        list2.add("小王吧");
        list2.add("你好吧");
        System.out.println(list2);//[小王吧, 你好吧]
        list2.addAll(1, list);
        System.out.println(list2);//[小王吧, 李四, 张三, 你好吧]
    }
}
