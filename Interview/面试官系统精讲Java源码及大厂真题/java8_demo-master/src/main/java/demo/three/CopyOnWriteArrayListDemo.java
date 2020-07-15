package demo.three;


import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
* CopyOnWriteArrayListDemo
*author  wenhe
*date 2019/8/5
*/
@Slf4j
@Data
public class CopyOnWriteArrayListDemo {

  final transient ReentrantLock lock = new ReentrantLock();

  private transient volatile Object[] array;

  public void lockAndSleep(long millis){
    final ReentrantLock lock = this.lock;
    //加锁
    log.info(Thread.currentThread()+"等待锁");
    lock.lock();
    log.info(Thread.currentThread()+"得到锁");
    try {
      Thread.sleep(millis);
    } catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      log.info(Thread.currentThread()+"释放锁");
      lock.unlock();
    }
  }

  @Test
  public void testCopy() throws InterruptedException {
    new Thread(() -> {
      log.info(Thread.currentThread()+"开始运行");
      lockAndSleep(1000*60*5);
      log.info(Thread.currentThread()+"结束运行");
    }).start();

    new Thread(() -> {
      log.info(Thread.currentThread()+"开始运行");
      lockAndSleep(0);
      log.info(Thread.currentThread()+"结束运行");
    }).start();

    Thread.sleep(1000*60*8);
  }

  @Test
  public void testCopy2(){
    Object[] objects = new Object[]{"nihoa","cdcd"};
    setArray(objects);
    Object[] objects1 = getArray();
    System.out.println(objects[1]);
    objects1[1] ="222";
    System.out.println(objects[1]);
  }

  final Object[] getArray() {
    return array;
  }

  /**
   * Sets the array.
   */
  final void setArray(Object[] a) {
    array = a;
  }


  @Test
  public void testIterator(){
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
    list.add("10");
    list.add("20");
    list.add("30");
    Iterator<String> iterator = list.iterator();
    list.add("50");
    iterator.next();
    list.add("50");
  }


}
