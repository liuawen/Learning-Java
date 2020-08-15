package com.itheima_03;

/*
    需求：
        通过程序实现斗地主过程中的洗牌，发牌和看牌。要求：对牌进行排序

    思路：
        1:创建HashMap，键是编号，值是牌
        2:创建ArrayList，存储编号
        3:创建花色数组和点数数组
        4:从0开始往HashMap里面存储编号，并存储对应的牌。同时往ArrayList里面存储编号
        5:洗牌(洗的是编号)，用Collections的shuffle()方法实现
        6:发牌(发的也是编号，为了保证编号是排序的，创建TreeSet集合接收)
        7:定义方法看牌(遍历TreeSet集合，获取编号，到HashMap集合找对应的牌)
        8:调用看牌方法
 */
public class PokerDemo {
    public static void main(String[] args) {
        
    }
}
