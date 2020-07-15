package demo.sixth;
import	java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import lombok.extern.slf4j.Slf4j;

/**
* 非公平共享锁
*author  wenhe
*date 2019/9/28
*/
@Slf4j
public class ShareLock implements Serializable{

  private final Sync sync;
  // 用于确保不能超过最大值
  private final int maxCount;

  /**
   * 初始化时给同步器 sync 赋值
   * count 代表可以获得共享锁的最大值
   */
  public ShareLock(int count) {
    this.sync = new Sync(count);
    maxCount = count;
  }

  /**
   * 获得锁
   * @return
   */
  public boolean lock(){
    return sync.acquireByShared(1);
  }

  /**
   * 失去锁
   * @return
   */
  public boolean unLock(){
    return sync.releaseShared(1);
  }

  class Sync extends AbstractQueuedSynchronizer {

    // 表示最多有 count 个共享锁可以获得
    public Sync(int count) {
      setState(count);
    }

    // 获得 i 个锁
    public boolean acquireByShared(int i) {
      // 自旋保证 CAS 一定可以成功
      for(;;){
        if(i<=0){
          return false;
        }
        int state = getState();
        // 如果没有锁可以获得，直接返回 false
        if(state <=0 ){
          return false;
        }
        int expectState = state - i;
        // 如果要得到的锁不够了，直接返回 false
        if(expectState < 0 ){
          return false;
        }
        // CAS 尝试得到锁,CAS 成功获得锁，失败继续 for 循环
        if(compareAndSetState(state,expectState)){
          return true;
        }
      }
    }

    // 释放 i 个锁
    @Override
    protected boolean tryReleaseShared(int arg) {
      for(;;){
        if(arg<=0){
          return false;
        }
        int state = getState();
        int expectState = state + arg;
        // 超过了 int 的最大值
        if(expectState < 0 || expectState > maxCount){
          log.error("state 超过预期，当前 state is {},计算出的 state is {}",state
          ,expectState);
          return false;
        }
        if(compareAndSetState(state, expectState)){
          return true;
        }
      }
    }
  }



}
