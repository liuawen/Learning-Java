package com.atguigu.test02;

import java.util.Arrays;

/*
 * MyArrayList我们自己设计的一种数据结构，一种逻辑结构，当别人用我这个MyArrayList的对象时，就是一个容器对象，
 * 可以用来装对象。
 */
public class MyArrayList {
    //为什么使用Object，因为只是说这个容器是用来装对象的，但是不知道用来装什么对象。
    private Object[] data;
    //需要额外的变量来记录数组的有效元的个数，例如：total 实际存储了多少个
    private int total;

    //5个
    public MyArrayList() {
        data = new Object[5];
    }

    //添加一个元素
    public void add(Object obj) {
        //检查是否需要扩容
        checkCapacity();
        data[total++] = obj;
    }

    private void checkCapacity() {
        //如果data满了，就扩容为原来的2倍
        if (total >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    //返回实际元素的个数
    public int size() {
        return total;
    }

    //返回数组的实际容量
    public int capacity() {
        return data.length;
    }

    //获取[index]位置的元素
    public Object get(int index) {
        //校验index的合理性范围
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= total) {
            throw new RuntimeException(index + "对应位置的元素不存在");
//			throw new IndexOutOfBoundsException(index+"越界");
        }
    }

    //替换[index]位置的元素
    public void set(int index, Object value) {
        //校验index的合理性范围
        checkIndex(index);

        data[index] = value;
    }

    //在[index]位置插入一个元素value
    public void insert(int index, Object value) {
        /*
         * (1)考虑下标的合理性
         * (2)总长度是否够
         * (3)[index]以及后面的元素往后移动，把[index]位置腾出来
         * (4)data[index]=value  放入新元素
         * (5)total++  有效元素的个数增加
         */

        //(1)考虑下标的合理性：校验index的合理性范围
        checkIndex(index);

        //(2)总长度是否够：检查是否需要扩容
        checkCapacity();

        //(3)[index]以及后面的元素往后移动，把[index]位置腾出来
        /*
         * 假设total = 5, data.length= 10, index= 1
         * 有效元素的下标[0,4]
         * 移动：[1]->[2],[2]->[3],[3]->[4],[4]->[5]
         * 移动元素的个数：total-index
         * [index]这个也往后移动的
         */
        System.arraycopy(data, index, data, index + 1, total - index);

        //(4)data[index]=value  放入新元素
        data[index] = value;

        //(5)total++  有效元素的个数增加
        total++;
    }

    //返回所有实际存储的元素
    public Object[] getAll() {
        //返回total个
        return Arrays.copyOf(data, total);
    }

    //删除[index]位置的元素
    public void remove(int index) {
        /*
         * (1)校验index的合理性范围
         * (2)移动元素，把[index+1]以及后面的元素往前移动
         * (3)把data[total-1]=null  让垃圾回收器尽快回收
         * (4)总元素个数减少 total--
         */

        //(1)考虑下标的合理性：校验index的合理性范围
        checkIndex(index);

        //(2)移动元素，把[index+1]以及后面的元素往前移动
        /*
         * 假设total=8, data.length=10, index = 3
         * 有效元素的范围[0,7]
         * 移动：[4]->[3],[5]->[4],[6]->[5],[7]->[6]
         * 移动了4个：total-index-1
         */
        System.arraycopy(data, index + 1, data, index, total - index - 1);

        //(3)把data[total-1]=null  让垃圾回收器尽快回收
        data[total - 1] = null;

//		(4)总元素个数减少 total--
        total--;
    }

    //查询某个元素的下标
/*	public int indexOf(Object obj){
		for (int i = 0; i < total; i++) {
		//这两种写法都有风险
			if(obj.equals(data[i])){
				//if(data[i].equals(obj)){
				return i;//找到，返回第一个找到的
			}
		}
		return -1;//没找到返回-1
	}*/

    //查询某个元素的下标
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < total; i++) {
                if (data[i] == null) {//等价于 if(data[i] == obj)
                    return i;
                }
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                if (obj.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //删除数组中的某个元素
    //如果有重复的，只删除第一个
    public void remove(Object obj) {
        /*
         * (1)先查询obj的[index]
         * (2)如果存在，就调用remove(index)删除就可以
         */

        //(1)先查询obj的[index]
        int index = indexOf(obj);

        if (index != -1) {
            remove(index);
        }
        //不存在，可以什么也不做
        //不存在，也可以抛异常
        //throw new RuntimeException(obj + "不存在");
    }

    public void set(Object old, Object value) {
        /*
         * (1)查询old的[index]
         * (2)如果存在，就调用set(index, value)
         */

//		(1)查询old的[index]
        int index = indexOf(old);
        if (index != -1) {
            set(index, value);
        }

        //不存在，可以什么也不做
        //不存在，也可以抛异常
        //throw new RuntimeException(old + "不存在");
    }
}
