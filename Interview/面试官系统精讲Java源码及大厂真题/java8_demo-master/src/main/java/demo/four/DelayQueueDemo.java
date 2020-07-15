package demo.four;
import com.google.common.collect.ImmutableList;

import	java.util.ArrayList;
import java.util.List;
import	java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * DelayQueueDemo
 * author  wenhe
 * date 2019/8/19
 */
@Slf4j
public class DelayQueueDemo {

  static class Product implements Runnable {

    private final BlockingQueue queue;

    public Product(BlockingQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      try {
        log.info("begin put");
        long beginTime = System.currentTimeMillis();
        queue.put(new DelayedDTO(System.currentTimeMillis() + 2000L,beginTime));//延迟 2 秒执行
        queue.put(new DelayedDTO(System.currentTimeMillis() + 5000L,beginTime));//延迟 5 秒执行
        queue.put(new DelayedDTO(System.currentTimeMillis() + 1000L * 10,beginTime));//延迟 10 秒执行
        log.info("end put");
      } catch (InterruptedException e) {
        log.error("" + e);
      }
    }
  }

  static class Consumer implements Runnable {

    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      try {
        log.info("Consumer begin");
        ((DelayedDTO) queue.take()).run();
        ((DelayedDTO) queue.take()).run();
        ((DelayedDTO) queue.take()).run();
        log.info("Consumer end");
      } catch (InterruptedException e) {
        log.error("" + e);
      }
    }
  }

  @Data
  static class DelayedDTO implements Delayed {
    Long s;
    Long beginTime;
    public DelayedDTO(Long s,Long beginTime) {
      this.s = s;
      this.beginTime =beginTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
      return unit.convert(s - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
      return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    public void run(){
      log.info("延迟了{}秒钟才执行",(System.currentTimeMillis() - beginTime)/1000);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue q = new DelayQueue();
    DelayQueueDemo.Product p = new DelayQueueDemo.Product(q);
    DelayQueueDemo.Consumer c = new DelayQueueDemo.Consumer(q);
//    new Thread(c).start();
//    new Thread(p).start();

    log.info("1,{}",(1 - 1) >>> 1);
    log.info("2,{}",(2 - 1) >>> 1);
    log.info("10,{}",(10 - 1) >>> 1);
    log.info("15,{}",(15 - 1) >>> 1);
    log.info("200,{}",(200 - 1) >>> 1);
  }

  @Test
  public void testInit(){
    List<String> list = ImmutableList.of("a","b","c");
    ArrayBlockingQueue q =
    new ArrayBlockingQueue(1,true,list);
  }

}
