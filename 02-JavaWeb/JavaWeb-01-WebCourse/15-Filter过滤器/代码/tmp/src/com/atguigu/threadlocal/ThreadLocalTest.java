package com.atguigu.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {

//    public static Map<String,Object> data = new Hashtable<String,Object>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){
        // 默认值
    @Override
    protected Object initialValue() {
        return "童伟的默认值";
    }
};

    private static Random random = new Random();


    public static class Task implements  Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("在线程[" +name + "]保存的值是：bbj"  );
            threadLocal.set("bbj");

            /*
            // 在Run方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);
            // 获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程["+name+"]生成的随机数是：" + i);
//            data.put(name,i);
            threadLocal.set(i);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOrder();

            // 在Run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
//            Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程["+name+"]快结束时取出关联的数据是：" + o);

             */
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++){
//            new Thread(new Task()).start();
//        }

        Map<String,Object> map = new HashMap<>();
        System.out.println(map.get("key"));

        System.out.println( threadLocal.get() ); // 不保存，也想取一个有效的值。怎么办，需要你事务准备这个值。

    }


}
