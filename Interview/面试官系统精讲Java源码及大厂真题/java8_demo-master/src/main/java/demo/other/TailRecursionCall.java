package demo.other;

import org.junit.Test;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

/**
* 尾递归延迟执行通用类
* n! = 1*2*3*……(n-1)*n
*author  wenhe
*date 2019/9/8
*/
@Slf4j
public class TailRecursionCall<T> {

  public static <T> TailRecursion<T> call(final TailRecursion<T> nextRecursion) {
    return nextRecursion;
  }

  public static <T> TailRecursion<T> done(T value) {
    return new TailRecursion<T>() {
      @Override
      public TailRecursion<T> apply() {
        throw new RuntimeException("递归已经结束了");
      }

      @Override
      public Boolean isComplete() {
        return Boolean.TRUE;
      }

      @Override
      public T getResult() {
        return value;
      }
    };
  }

  public static TailRecursion<BigDecimal> recursion1(TestDTO testDTO) {
    if (testDTO.getBegin().equals(testDTO.getEnd())) {
    return TailRecursionCall.done(testDTO.getTotal());
    }
    testDTO.setBegin(1+testDTO.getBegin());
    testDTO.setTotal(testDTO.getTotal().multiply(new BigDecimal(testDTO.getBegin())));
    return TailRecursionCall.call(()->recursion1(testDTO));
  }

  // 阶乘计算
  public static String recursion(long begin, long end, BigDecimal total) {
    // begin 每次计算时都会递增，当 begin 和 end 相等时，计算结束，返回最终值
    if (begin == end) {
      return total.toString();
    }
    // recursion 第三个参数表示当前阶乘的结果
    return recursion(++begin, end, total.multiply(new BigDecimal(begin)));
  }

  @Test
  public void testRecursion() {
//    log.info("计算 10 的阶乘，结果为{}",recursion(1, 10, BigDecimal.ONE));
    log.info("计算 9k 的阶乘，结果为{}",recursion(1, 9000, BigDecimal.ONE));
  }

  @Test
  public void testRecursion1(){
    TestDTO testDTO = new TestDTO();
    testDTO.setBegin(1L);
    testDTO.setEnd(9000L);
    testDTO.setTotal(BigDecimal.ONE);
    log.info("计算 9k 的阶乘，结果为{}",recursion1(testDTO).invoke());
  }

}
