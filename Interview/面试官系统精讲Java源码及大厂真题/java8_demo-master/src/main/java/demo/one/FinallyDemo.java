package demo.one;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * FinallyDemo
 * author  wenhe
 * date 2019/7/29
 */
@Slf4j
public class FinallyDemo {

  @Test
  public void testCatchFinally() {
    try {
      log.info("try is run");
      if (true) {
        throw new RuntimeException("try exception");
      }
    } catch (Exception e) {
      log.info("catch is run");
      if (true) {
        throw new RuntimeException("catch exception");
      }
    } finally {
      log.info("finally is run");
    }
  }

}
