package demo.one;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * StaticClass
 * author  wenhe
 * date 2019/7/28
 */
@Slf4j
public class StaticClass extends ParentStaticClass{

  public static List<String> LIST = new ArrayList(){{
    log.info("子类静态变量初始化");
  }};

  static {
    log.info("子类静态块初始化");
  }

  public StaticClass() {
    log.info("子类构造器初始化");
  }

   public static void testStatic() {
    log.info("子类静态方法被调用");
  }


  public static void main(String[] args) {
    log.info("main 方法执行");
    new StaticClass();
  }



}
