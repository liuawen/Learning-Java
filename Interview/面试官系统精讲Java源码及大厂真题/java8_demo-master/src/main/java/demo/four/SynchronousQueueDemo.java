package demo.four;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

import lombok.extern.slf4j.Slf4j;

/**
* SynchronousQueueDemo
*author  wenhe
*date 2019/8/18
*/
@Slf4j
public class SynchronousQueueDemo {

  static class Product implements Runnable{

    private final BlockingQueue queue;

    public Product(BlockingQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      try {
        log.info("begin put");
        queue.put(producy("nihao"));
        log.info("end put");
      } catch (InterruptedException e) {
      }
    }

  }

  static class Consumer implements Runnable{

    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      try {
        log.info("Consumer begin");
        String name = (String) queue.take();
        log.info("Consumer end :{}",name);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  static String producy(String name){
    return name;
  }

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue q = new SynchronousQueue(true);
    Product p = new Product(q);
    Consumer c = new Consumer(q);
    new Thread(c).start();
    log.info("sleeping");
    Thread.sleep(5000L);
    log.info("sleepEnd");
    new Thread(p).start();
  }

  @Test
  public void testRelQueue(){
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " is run"));
    
  }

}
