package demo.seven;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadPoolExecutorDemo {

  private static final int COUNT_BITS = Integer.SIZE - 3;
  private static final int CAPACITY = (1 << COUNT_BITS) - 1;

  @Test
  public void test() {
    System.out.println(COUNT_BITS);
    System.out.println(CAPACITY);
    final int RUNNING = -1 << COUNT_BITS;//-536870912
    final int SHUTDOWN = 0 << COUNT_BITS;//0
    final int STOP = 1 << COUNT_BITS;//-536870912
    final int TIDYING = 2 << COUNT_BITS;//1073741824
    final int TERMINATED = 3 << COUNT_BITS;//1610612736
    log.info("RUNNING is {}",ctlOf(RUNNING,0));

  }
  private static int ctlOf(int rs, int wc) { return rs | wc; }
  private static int workerCountOf(int c)  { return c & CAPACITY; }
  private static int runStateOf(int c)     { return c & ~CAPACITY; }

  @Test
  public void forDebug() throws ExecutionException, InterruptedException {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS,
                                                         new LinkedBlockingQueue(1));
    String result ="";
    Callable<String> call = () -> result;
    List<Future> futures = Lists.newArrayList();
    for (int i = 0; i < 3; i++) {
      Future<String> future = executor.submit(call);
      futures.add(future);
    }
    for (Future future : futures) {
      System.out.println(future.get());
    }
  }

}
