package com.itheima_11;

/*
    Lock中提供了获得锁和释放锁的方法
        void lock()：获得锁
        void unlock()：释放锁

    Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化
        ReentrantLock​()：创建一个ReentrantLock的实例
 */
public class SellTicket implements Runnable {
    private int tickets = 100;
	
    @Override
    public void run() {
        while (true) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--;
				}
        }
    }
}
