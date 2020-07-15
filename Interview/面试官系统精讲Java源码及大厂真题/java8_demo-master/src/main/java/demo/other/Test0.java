package demo.other;

import java.math.BigDecimal;

/**
* 简单的递归
* n! = 1*2*3*……(n-1)*n
*author  wenhe
*date 2019/9/8
*/
public class Test0 {

  public static BigDecimal recursion(long begin, long end, BigDecimal total) {
    if (begin == end) {
      return total;
    }
    return recursion(++begin, end, total.multiply(new BigDecimal(begin)));
  }

  public static BigDecimal recursion1(long begin, long end, BigDecimal total) {
    if (begin == end) {
      return total;
    }
    ++begin;
    total = total.multiply(new BigDecimal(begin));
    return recursion1(begin, end, total);//在方法的最后直接返回，叫做尾调用
  }

  public static void main(String[] args) {
    BigDecimal total = recursion(1, 9000, BigDecimal.ONE);
    System.out.println(total);
  }


}
