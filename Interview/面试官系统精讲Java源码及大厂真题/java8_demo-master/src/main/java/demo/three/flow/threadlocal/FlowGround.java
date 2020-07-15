package demo.three.flow.threadlocal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* FlowGround
*author  wenhe
*date 2019/10/16
*/
@Target(ElementType.METHOD)// 表示该注解应该打在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FlowGround {


  String requestKey();

  String responseKey();

}
