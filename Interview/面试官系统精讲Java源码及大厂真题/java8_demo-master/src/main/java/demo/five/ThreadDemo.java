package demo.five;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
* ThreadDemo
*author  wenhe
*date 2019/9/5
*/
@Slf4j
public class ThreadDemo {

  class MyThread extends Thread{
    @Override
    public void run() {
      log.info(Thread.currentThread().getName());
    }
  }
  @Test
  public void extendThreadInit(){
    new MyThread().start();
  }

  @Test
  public void init(){
    log.info("{} is run。",Thread.currentThread().getName());
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("{} begin run",Thread.currentThread().getName());
      }
    });
    // 开一个子线程去执行
    thread.start();
    // 不会新起线程，是在当前主线程上继续运行
    thread.run();
  }

  @Test
  public void join() throws Exception {
    Thread main = Thread.currentThread();
    log.info("{} is run。",main.getName());
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("{} begin run",Thread.currentThread().getName());
        try {
          Thread.sleep(30000L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        log.info("{} end run",Thread.currentThread().getName());
      }
    });
    // 开一个子线程去执行
    thread.start();
    thread.join();

    log.info("{} is end", Thread.currentThread());
  }

  @Test
  public void testWait() throws InterruptedException {
    String s ="nihao";
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("{} begin run",Thread.currentThread().getName());
        try {
          Thread.sleep(3000L);
          synchronized (s){
           s.notify();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        log.info("{} end run",Thread.currentThread().getName());
      }
    });
    // 开一个子线程去执行
    thread.start();
    synchronized (s){
      s.wait();
    }
    log.info("{} is end", Thread.currentThread());
  }


  @Test
  public void testInterrupt() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("{} begin run",Thread.currentThread().getName());
        try {
          log.info("子线程开始沉睡 30 s");
          Thread.sleep(30000L);
        } catch (InterruptedException e) {
          log.info("子线程被打断");
          e.printStackTrace();
        }
        log.info("{} end run",Thread.currentThread().getName());
      }
    });
    // 开一个子线程去执行
    thread.start();
    Thread.sleep(10000000L);
    log.info("主线程等待 1s 后，发现子线程还没有运行成功，打断子线程");
    thread.interrupt();
  }

  @Test
  public void testStackTrace()  {
    try {
      throw new RuntimeException("nihao");
    } catch (Exception e) {
      StackTraceElement[]  stackTraceElements = Thread.currentThread().getStackTrace();
      e.printStackTrace();
    }
  }

  @Test
  public void testYield(){
    boolean stop = false;
    while (!stop){
      // dosomething
      Thread.yield();
    }
  }

  @Test
  public void testJoin2() throws Exception {

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("我是子线程 2,开始沉睡");
        try {
          Thread.sleep(2000L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        log.info("我是子线程 2，执行完成");
      }
    });

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("我是子线程 1，开始运行");
        try {
        log.info("我是子线程 1，我在等待子线程 2");
        thread2.join();
        log.info("我是子线程 1，子线程 2 执行完成，我继续执行");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        log.info("我是子线程 1，执行完成");
      }
    });
    thread1.start();
    thread2.start();
    Thread.sleep(100000);
  }

  // 共享变量 1
  private static final Object share1 = new Object();
  // 共享变量 2
  private static final Object share2 = new Object();
  @Test
  public void testDeadLock() throws InterruptedException {
    // 初始化线程 1，线程 1 需要在锁定 share1 共享资源的情况下再锁定 share2
    Thread thread1 = new Thread(() -> {
      synchronized (share1){
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (share2){
          log.info("{} is run",Thread.currentThread().getName());
        }
      }
    });

    // 初始化线程 2，线程 2 需要在锁定 share2 共享资源的情况下再锁定 share1
    Thread thread2 = new Thread(() -> {
      synchronized (share2){
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (share1){
          log.info("{} is run",Thread.currentThread().getName());
        }
      }
    });
    // 当线程 1、2 启动后，都在等待对方锁定的资源，但都得不到，造成死锁
    thread1.start();
    thread2.start();
    Thread.sleep(1000000000);
  }

}
