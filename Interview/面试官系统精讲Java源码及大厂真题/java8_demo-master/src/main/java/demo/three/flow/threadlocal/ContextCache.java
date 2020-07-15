package demo.three.flow.threadlocal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextCache implements Serializable {

  private static final long serialVersionUID = 2136539028591849277L;

  // 使用 ThreadLocal 缓存上下文信息
  public static final ThreadLocal<Map<String,String>> CACHE = new InheritableThreadLocal<>();

  /**
   * 放数据
   * @param sourceKey
   */
  public static final void putAttribute(String sourceKey,String value){
    Map<String,String> cacheMap = CACHE.get();
    if(null == cacheMap){
      cacheMap = new HashMap<>();
    }
//    log.info("putAttribute HashMap 内存地址 is {}",System.identityHashCode(cacheMap));
    cacheMap.put(sourceKey,value);
    CACHE.set(cacheMap);
  }


  /**
   * 拿数据
   * @param sourceKey
   */
  public static final String getAttribute(String sourceKey){
    Map<String,String> cacheMap = CACHE.get();
//    log.info("getAttribute HashMap 内存地址 is {}",System.identityHashCode(cacheMap));
    if(null == cacheMap){
      return null;
    }
    return cacheMap.get(sourceKey);
  }

  /**
   * 得到 Map
   * @return
   */
  public static final Map<String,String> getMap(){
    return CACHE.get();
  }

  /**
   *
   * @param map
   */
  public static final void putAllAttribute(Map<String,String> map){
    Map<String,String> cacheMap = CACHE.get();
    if(null == cacheMap){
      cacheMap = new HashMap<>();
    }
    cacheMap.putAll(map);
    CACHE.set(cacheMap);
  }

  /**
   * 清空ThreadLocal的数据
   */
  public static void clean() {
    CACHE.remove();
  }
}
