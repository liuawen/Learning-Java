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
public  class ParentStaticClass {

  public static List<String> PARENT_LIST = new ArrayList(){{
    log.info("父类静态变量初始化");
  }};

  static {
    log.info("父类静态块初始化");
  }

  public ParentStaticClass() {
    log.info("父类构造器初始化");
  }

  public static void testStatic() {
    log.info("父类静态方法被调用");
  }

  public final void testFinal(){

  }

}
