package com.itheima_07;

public class SellTicket implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        //相同的票出现了多次
//        while (true) {
//            //tickets = 100;
//            //t1,t2,t3
//            //假设t1线程抢到CPU的执行权
//            if (tickets > 0) {
//                //通过sleep()方法来模拟出票时间
//                try {
//                    Thread.sleep(100);
//                    //t1线程休息100毫秒
//                    //t2线程抢到了CPU的执行权，t2线程就开始执行，执行到这里的时候，t2线程休息100毫秒
//                    //t3线程抢到了CPU的执行权，t3线程就开始执行，执行到这里的时候，t3线程休息100毫秒
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //假设线程按照顺序醒过来
//                //t1抢到CPU的执行权，在控制台输出：窗口1正在出售第100张票
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                //t2抢到CPU的执行权，在控制台输出：窗口2正在出售第100张票
//                //t3抢到CPU的执行权，在控制台输出：窗口3正在出售第100张票
//                tickets--;
//                //如果这三个线程还是按照顺序来，这里就执行了3次--的操作，最终票就变成了97
//            }
//        }

        //出现了负数的票
        while (true) {
            //tickets = 1;
            //t1,t2,t3
            //假设t1线程抢到CPU的执行权
            if (tickets > 0) {
                //通过sleep()方法来模拟出票时间
                try {
                    Thread.sleep(100);
                    //t1线程休息100毫秒
                    //t2线程抢到了CPU的执行权，t2线程就开始执行，执行到这里的时候，t2线程休息100毫秒
                    //t3线程抢到了CPU的执行权，t3线程就开始执行，执行到这里的时候，t3线程休息100毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //假设线程按照顺序醒过来
                //t1抢到了CPU的执行权，在控制台输出：窗口1正在出售第1张票
                //假设t1继续拥有CPU的执行权，就会执行tickets--;操作，tickets = 0;
                //t2抢到了CPU的执行权，在控制台输出：窗口1正在出售第0张票
                //假设t2继续拥有CPU的执行权，就会执行tickets--;操作，tickets = -1;
                //t3抢到了CPU的执行权，在控制台输出：窗口3正在出售第-1张票
                //假设t2继续拥有CPU的执行权，就会执行tickets--;操作，tickets = -2;
                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                tickets--;
            }
        }
    }
}
