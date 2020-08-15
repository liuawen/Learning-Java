package com.itheima_06;

/*
    需求：
        某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票

    思路：
        1:定义一个类SellTicket实现Runnable接口，里面定义一个成员变量：private int tickets = 100;
        2:在SellTicket类中重写run()方法实现卖票，代码步骤如下
            A:判断票数大于0，就卖票，并告知是哪个窗口卖的
            B:卖了票之后，总票数要减1
            C:票没有了，也可能有人来问，所以这里用死循环让卖票的动作一直执行
        3:定义一个测试类SellTicketDemo，里面有main方法，代码步骤如下
            A:创建SellTicket类的对象
            B:创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
            C:启动线程
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        //创建SellTicket类的对象
        SellTicket st = new SellTicket();

        //创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
