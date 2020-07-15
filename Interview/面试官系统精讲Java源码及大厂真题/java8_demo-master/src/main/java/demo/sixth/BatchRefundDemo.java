package demo.sixth;
import	java.util.concurrent.Callable;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * 批量退款场景
 * 双 11，小明在网上买了 50 个商品，一个订单，第二天小明觉得自己买了很多不需要的东西，挑选了一下，一共了 30 个商品是自己暂时不需要的
 * 于是小明想把 30 个商品给推掉，于是在页面上选择了这 30 个商品，发起了批量退款
 */
@Slf4j
public class BatchRefundDemo {

  public static final ExecutorService EXECUTOR_SERVICE =
      new ThreadPoolExecutor(10, 10, 0L,
                                TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<>(20));
  @Test
  public void batchRefund() throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(30);
    RefundDemo refundDemo = new RefundDemo();

    // 准备 30 个商品
    List<Long> items = Lists.newArrayListWithCapacity(30);
    for (int i = 0; i < 30; i++) {
      items.add(Long.valueOf(i+""));
    }

    long begin = System.currentTimeMillis();
    // 准备开始批量退款
    List<Future> futures = Lists.newArrayListWithCapacity(30);
    for (Long item : items) {
      Future<Boolean> future = EXECUTOR_SERVICE.submit(new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
          boolean result = refundDemo.refundByItem(item);
          countDownLatch.countDown();
          return result;
        }
      });
      futures.add(future);
    }

    log.info("30 个商品已经在退款中");
    countDownLatch.await();
    log.info("30 个商品已经退款完成");
    List<Boolean> result = futures.stream().map(fu-> {
      try {
        return (Boolean) fu.get(1,TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (TimeoutException e) {
        e.printStackTrace();
      }
      return false;
    }).collect(Collectors.toList());
    long success = result.stream().filter(r->r.equals(true)).count();
    log.info("执行结果成功{},失败{}",success,result.size()-success);
    log.info("耗时{}",System.currentTimeMillis()-begin);

    long begin1 = System.currentTimeMillis();
    for (Long item : items) {
      refundDemo.refundByItem(item);
    }
    log.info("for 循环单个退款耗时{}",System.currentTimeMillis()-begin1);
  }
}
