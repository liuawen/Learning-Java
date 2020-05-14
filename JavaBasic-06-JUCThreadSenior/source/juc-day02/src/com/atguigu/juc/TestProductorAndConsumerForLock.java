package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 生产者消费者案例：
 */
public class TestProductorAndConsumerForLock {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Productor pro = new Productor(clerk);
		Consumer con = new Consumer(clerk);

		new Thread(pro, "生产者 A").start();
		new Thread(con, "消费者 B").start();

//		 new Thread(pro, "生产者 C").start();
//		 new Thread(con, "消费者 D").start();
	}

}

class Clerk {
	private int product = 0;

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	// 进货
	public void get() {
		lock.lock();

		try {
			if (product >= 1) { // 为了避免虚假唤醒，应该总是使用在循环中。
				System.out.println("产品已满！");

				try {
					condition.await();
				} catch (InterruptedException e) {
				}

			}
			System.out.println(Thread.currentThread().getName() + " : "
					+ ++product);

			condition.signalAll();
		} finally {
			lock.unlock();
		}

	}

	// 卖货
	public void sale() {
		lock.lock();

		try {
			if (product <= 0) {
				System.out.println("缺货！");

				try {
					condition.await();
				} catch (InterruptedException e) {
				}
			}

			System.out.println(Thread.currentThread().getName() + " : "
					+ --product);

			condition.signalAll();

		} finally {
			lock.unlock();
		}
	}
}

// 生产者
class Productor implements Runnable {

	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			clerk.get();
		}
	}
}

// 消费者
class Consumer implements Runnable {

	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}

}