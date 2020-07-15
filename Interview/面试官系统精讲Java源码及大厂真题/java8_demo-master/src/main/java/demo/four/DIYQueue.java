package demo.four;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import	java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
* 自定义队列
*author  wenhe
*date 2019/9/1
*/
@Slf4j
public class DIYQueue<T> implements Queue<T>{

  /**
   * 队列头
   */
  private volatile Node<T> head;

  /**
   * 队列尾
   */
  private volatile Node<T> tail;

  /**
   * 自定义队列元素
   */
  class DIYNode extends Node<T>{
    public DIYNode(T item) {
      super(item);
    }
  }

  /**
   * 队列的大小
   */
  private AtomicInteger size = new AtomicInteger(0);

  /**
   * 容量
   */
  private final Integer capacity;

  /**
   * 放数据锁
   */
  private ReentrantLock putLock = new ReentrantLock();

  /**
   * 拿数据锁
   */
  private ReentrantLock takeLock = new ReentrantLock();

  /**
   * 无参数构造器，默认最大容量是 Integer.MAX_VALUE
   */
  public DIYQueue() {
    capacity = Integer.MAX_VALUE;
    head = tail = new DIYNode(null);
  }

  /**
   * 有参数构造器，可以设定容量的大小
   * @param capacity
   */
  public DIYQueue(Integer capacity) {
    if(null == capacity || capacity < 0){
      throw new IllegalArgumentException();
    }
    this.capacity = capacity;
    head = tail = new DIYNode(null);
  }

  @Override
  public boolean put(T item) {
    if(null == item){
      return false;
    }
    try{
      // 尝试加锁
      boolean lockSuccess = putLock.tryLock(300, TimeUnit.MILLISECONDS);
      if(!lockSuccess){
        return false;
      }
      // 校验队列大小
      if(size.get() >= capacity){
        log.info("queue is full");
        return false;
      }
      // 追加到队尾
      tail = tail.next = new DIYNode(item);
      size.incrementAndGet();
      return true;
    } catch (InterruptedException e){
      log.info("put error", e);
      return false;
    } catch(Exception e){
      log.error("put error", e);
      return false;
    } finally {
      putLock.unlock();
    }
  }

  @Override
  public T take() {
    // 队列是空的
    if(size.get() == 0){
      return null;
    }
    try {
      // 拿数据我们设置的超时时间更短
      boolean lockSuccess = takeLock.tryLock(200,TimeUnit.MILLISECONDS);
      if(!lockSuccess){
        throw new RuntimeException("加锁失败");
      }
      // 把头结点的下一个元素拿出来
      Node expectHead = head.next;
      // 把头结点的值拿出来
      T result = head.item;
      // 把头结点的值置为 null，帮助 gc
      head.item = null;
      // 重新设置头结点的值
      head = (DIYNode) expectHead;
      size.decrementAndGet();
      // 返回头结点的值
      return result;
    } catch (InterruptedException e) {
      log.info(" tryLock 200 timeOut",e);
    } catch (Exception e) {
      log.info(" take error ",e);
    } finally {
      takeLock.unlock();
    }
    return null;
  }




}
