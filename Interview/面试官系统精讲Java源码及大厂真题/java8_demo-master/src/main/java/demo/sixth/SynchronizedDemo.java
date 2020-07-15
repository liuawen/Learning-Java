package demo.sixth;

import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

/**
 * 共享资源初始化、注册、动态刷新等场景
 * 演示使用 synchronized 防止并发
 */
@Slf4j
@Component
public class SynchronizedDemo {

  // 共享资源
  private static final Map<String,String> SHARED_MAP = Maps.newConcurrentMap();
  // 有无加锁完成的标志位
  private static boolean loaded = false;

  /**
   * 初始化、注册
   */
  @PostConstruct
  public void init(){
    if(loaded){
      return;
    }
    synchronized (this){
      if(loaded){
        return;
      }
      log.info("SynchronizedDemo init begin");
      // 从数据库中捞取数据，组装成 SHARED_MAP 的数据格式
      loaded = true;
      log.info("SynchronizedDemo init end");
    }
  }

  /**
   * 刷新
   */
  public void refresh(){
    SHARED_MAP.clear();
    SHARED_MAP.putAll(new HashMap<>());
  }

}
