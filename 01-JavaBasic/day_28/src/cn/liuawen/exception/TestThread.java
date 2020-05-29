package cn.liuawen.exception;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-29
 */

public class TestThread {
    public static void main(String[] args) {
        System.out.println((int) '0');
//创建自定义线程对象
        MyThread mt = new MyThread();
//开启线程
        mt.start();
//在主方法中执行for循环
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println("主线程打印输出奇数：" + i);
            }
        }

    }
}
