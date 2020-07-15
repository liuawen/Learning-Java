package demo.sixth;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用锁实现了队列的逻辑
* 大家看看这个像那个队列的实现逻辑
*author  wenhe
*date 2019/11/1
*/
public class ConditionDemo {

  final Lock lock = new ReentrantLock();
  final Condition notFull  = lock.newCondition();
  final Condition notEmpty = lock.newCondition();

  final Object[] items = new Object[100];
  int putptr, takeptr, count;

  public void put(Object x) throws InterruptedException {
    try {
      lock.lock();
      while (count == items.length) {
        notFull.await();
      }
      items[putptr] = x;
      if (++putptr == items.length) {
        putptr = 0;
      }
      ++count;
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  public Object take() throws InterruptedException {
    try {
      lock.lock();
      while (count == 0) {
        notEmpty.await();
      }
      Object x = items[takeptr];
      if (++takeptr == items.length) {
        takeptr = 0;
      }
      --count;
      notFull.signal();
      return x;
    } finally {
      lock.unlock();
    }
  }

}
