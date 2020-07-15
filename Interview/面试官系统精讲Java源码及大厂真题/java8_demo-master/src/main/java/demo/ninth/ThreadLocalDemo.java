package demo.ninth;

import com.google.common.collect.Maps;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * ThreadLocal 演示
 * author  wenhe
 * date 2019/10/15
 */
@Slf4j
public class ThreadLocalDemo {

  /**
   * 上下文
   */
  static final ThreadLocal<Map<String, String>> context = new ThreadLocal<>();

  @Test
  public void testThread() {
    Map<String, String> contextMap = context.get();
    if (CollectionUtils.isEmpty(contextMap)) {
      contextMap = Maps.newHashMap();
    }

    contextMap.put("key1", "value1");
    context.set(contextMap);
    log.info("key1，value1被放到上下文中");

    getFromComtext();
  }

  private String getFromComtext() {
    String value1 = context.get().get("key1");
    log.info("从 ThreadLocal 中取出上下文，key1 对应的值为：{}", value1);
    return value1;
  }

}
