package demo.eight;

import com.google.common.collect.Lists;

/**
* Lambda
*author  wenhe
*date 2019/10/12
*/
public class Lambda {

  public static void simple() {
    Runnable runnable = () -> System.out.println("lambda is run");
    runnable.run();
  }
  public static void main(String[] args) throws Exception {
    simple();
  }
}
