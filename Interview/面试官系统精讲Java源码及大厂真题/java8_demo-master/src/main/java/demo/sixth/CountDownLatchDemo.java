package demo.sixth;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
* 实现两个功能：
 * 1. 让一组线程在启动之后，先陷入等待状态，然后在某一时间被一起唤醒；
 * 2. 线程等待另外一组线程都执行完成之后，再继续执行。
*author  wenhe
*date 2019/9/21
*/
public class CountDownLatchDemo {

  // 线程任务
  class Worker implements Runnable {
    // 实现功能 1
    private final CountDownLatch startSignal;
    // 实现功能 2
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
      this.startSignal = startSignal;
      this.doneSignal = doneSignal;
    }

    public void run() {
      try {
        System.out.println(Thread.currentThread().getName()+" begin");
        // await 时有两点需要注意：await 时 state 不会发生变化，2：startSignal 的state初始化时 1，所以所有线程都会到同步队列中等待
        startSignal.await();
        doWork();
        // countDown 每次会使 state 减一，doneSignal 初始化为 9，countDown 前 8 次执行都会返回 false，执行第 9 次时，state 递减
        // 为 0，会 countDown 成功，表示所有子线程都执行完了，会释放 await 在 doneSignal 上的主线程
        doneSignal.countDown();
        System.out.println(Thread.currentThread().getName()+" end");
      } catch (InterruptedException ex) {
      } // return;
    }

    void doWork() throws InterruptedException {
      System.out.println(Thread.currentThread().getName()+"sleep 5s …………");
      Thread.sleep(5000l);
    }
  }

  @Test
  public void test() throws InterruptedException {
    // state 初始化为 1 很关键，子线程是不断的 await，await 时 state 是不会变化的，并且发现 state 都是 1，所有线程都获取不到锁
    // 造成所有线程都到同步队列中去等待，当主线程执行 countDown 时，就会一起把等待的线程给释放掉
    CountDownLatch startSignal = new CountDownLatch(1);
    // state 初始化成 9，表示最大可有 9 个线程获得锁，主线程会执行 await 阻塞住，子线程不断的执行 countDown，当最后一个子线程
    // 执行 countDown 时，发现 state 被递减成 0 了，就能唤醒主线程
    CountDownLatch doneSignal = new CountDownLatch(9);

    for (int i = 0; i < 9; ++i) // create and start threads
    {
      new Thread(new Worker(startSignal, doneSignal)).start();
    }
    System.out.println("main thread begin");
    // 这行代码唤醒 9 个子线程，开始执行
    startSignal.countDown();
    // 这行代码使主线程陷入沉睡，等待 9 个子线程执行完成之后才会继续执行
    doneSignal.await();
    System.out.println("main thread end");
  }
}
