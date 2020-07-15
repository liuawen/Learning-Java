package demo.four;
import java.util.concurrent.LinkedBlockingQueue;
import	java.util.concurrent.TimeUnit;

import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;

/**
* 自定义队列测试类
* author  wenhe
* date 2019/9/1
*/
@Slf4j
public class DIYQueueDemo {

  private final static Queue<String> queue = new DIYQueue<>();

  class Product implements Runnable{
    private final String message;

    public Product(String message) {
      this.message = message;
    }

    @Override
    public void run() {
      try {
        boolean success = queue.put(message);
        if (success) {
          log.info("put {} success", message);
          return;
        }
        log.info("put {} fail", message);
      } catch (Exception e) {
        log.info("put {} fail", message);
      }
    }

  }

  class Consumer implements Runnable{
    @Override
    public void run() {
      try {
        String message = (String) queue.take();
        log.info("consumer message :{}",message);
      } catch (Exception e) {
        log.info("consumer message fail",e);
      }
    }
  }

  @Test
  public void testDIYQueue() throws InterruptedException {
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(10,10,0,TimeUnit.MILLISECONDS,
                               new LinkedBlockingQueue<>());
    for (int i = 0; i < 1000; i++) {
        if(i % 2 == 0){
          executor.submit(new Product(i+""));
          continue;
        }
        executor.submit(new Consumer());
    }
    Thread.sleep(10000000);
  }

















}
