package com.atguigu.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
 * java 8 中注解引入了重复注解和类型注解
 * 
 * 1.重复注解
 * 步骤：
 * ①在MyAnnotation上声明元注解：@Repeatable
 * ②@Repeatable的属性值为另一个注解，此注解内部声明MyAnnotation的数组，且两个注解@Retention和@Target一致
 * ③在需要使用重复注解的位置使用MyAnnotation即可
 * 
 * 2.类型注解
 *  在@target的值中添加可以修饰的结构：
 *  
    TYPE_PARAMETER,
    
    TYPE_USE
 * 
 */
//jdk 7及以前的写法
//@MyAnnotations({@MyAnnotation(value="hello"),@MyAnnotation(value="atguigu")})
@MyAnnotation(value="hello")
@MyAnnotation(value="atguigu")
public class Person {

}

class Student extends @MyAnnotation(value="hello") Person{
	
	
	public void method(@MyAnnotation(value="nonnull") String name){//第三方的Checker中声明了@NonNull
		
	}
}
