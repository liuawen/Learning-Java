package demo.other;

import java.util.stream.Stream;


/**
 * 尾递归优化 递归延迟执行
 * author  wenhe
 * date 2019/9/8
 *
 */
@FunctionalInterface
public interface TailRecursion<T> {

  TailRecursion<T> apply();

  default Boolean isComplete() {
    return Boolean.FALSE;
  }

  default T getResult() {
    throw new RuntimeException("递归还没有结束，暂时得不到结果");
  }

  default T invoke() {
    return Stream.iterate(this, TailRecursion::apply)
        .filter(TailRecursion::isComplete)
        .findFirst()
        .get()//执行急方法
        .getResult();
  }


}
