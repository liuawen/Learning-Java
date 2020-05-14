package com.atguigu.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * java8内置的4个基本的函数式接口
 * 1.消费型接口： Consumer<T>  : void accept(T t)
 * 2.供给型接口：Supplier<T>  : T get()
 * 3.函数型接口： Function<T,R> : R apply(T t)
 * 4.断定型接口： Predicate<T>  : boolean test(T t)
 * 
 * 说明：lambda表达式就充当了函数式接口的实例。
 * 
 * 总结：1.当我们编写代码时，调用现成的方法中，发现需要实例化函数式接口，那么此时可以考虑使用lambda表达式
 *     2.当我们编写代码时，如果我们需要定义函数式接口，则考虑现成的java.util.function包下，是否已经
 *     有定义好的接口可以用。如果有，则不用再自定义。
 * 
 */
public class LambdaTest2 {
	
	//4. Predicate<T> : 断定型接口
    //boolean test(T t)
    @Test
    public void test4(){
        List<String> list = Arrays.asList("北京","南京","东京","西京","普京","上海","深圳");
        List<String> data = getStrings(list, s -> s.contains("京"));
        System.out.println(data);
    }

    public List<String> getStrings(List<String> list, Predicate<String> pre){
        List<String> data = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                data.add(s);
            }
        }
        return data;
    }
	
	//3. Function<T,R> : 函数型接口
    //R apply(T t)
    @Test
    public void test3(){
        strHandler("    hel   lo   ",str -> str.trim());

        strHandler("世界那么大，我想去看看",str -> str.substring(2,5));
    }

    public void strHandler(String str, Function<String,String> func){
        String s = func.apply(str);
        System.out.println(s);
    }
	
	@Test
	public void testGetRandomNumber(){
		List<Double> list = getRandomNumber(10,() -> Math.random() * 100);
		
		//迭代器
		//增强for循环
//		for(Double d : list){
//			System.out.println(d);
//		}
		//普通for
		//集合中的方法
		list.forEach(System.out::println);
	}
	
	public List<Double> getRandomNumber(int num,Supplier<Double> s){
		ArrayList<Double> list = new ArrayList<>();
		for(int i = 0;i < num;i++){
			list.add(s.get());
		}
		return list;
	}
	
	@Test
	public void testHappyTime(){
		happyTime(300.00,t -> System.out.println("学习比较累，下课后去海曼大浴场洗澡，花费：" + t));
	}
	
	public void happyTime(Double money,Consumer<Double> con){
		con.accept(money);
	}
	
}
