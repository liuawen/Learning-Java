package com.atguigu.java2;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author shkstart
 * @create 2019 下午 5:09
 */
public class Java11Test {

    //java 11新特性一：String中新增的方法
    @Test
    public void test1(){
//        isBlank():判断字符串是否为空白
        System.out.println("  \t  \t  \n  ".isBlank());
//        strip():去除首尾空白
        System.out.println("-----" + "  \t abc \t  \n  ".strip() + "-------");
        System.out.println("-----" + "  \t abc \t  \n  ".trim() + "-------");
//        stripTrailing():去除尾部空格
        System.out.println("-----" + "  \t abc \t  \n  ".stripTrailing() + "-------");
//        stripLeading():去除首部空格
        System.out.println("-----" + "  \t abc \t  \n  ".stripLeading() + "-------");
//        repeat(int count):复制字符串
        String str1 = "abc";
        String str2 = str1.repeat(5);
        System.out.println(str2);

//        lines().count():行数统计
        String str3 = "abc\ndef\ng";
        System.out.println(str3.lines().count());


    }


    //java11新特性二：Optional新增的方法
    @Test
    public void test2(){

        var op = Optional.empty();
        System.out.println(op.isPresent());//判断内部的value是否存在
        System.out.println(op.isEmpty());//判断内部的value是否为空

        op = Optional.of("abc");
        //orElseThrow():value非空，返回value；否则抛异常NoSuchElementException
        var obj = op.orElseThrow();
        System.out.println(obj);

        Optional<String> op1 = Optional.of("hello");
//        op = Optional.empty();
        //or:value非空，返回对应的Optional；value为空，返回形参封装的Optional
        Optional<Object> op2 = op.or(() -> op1);
        System.out.println(op2);//

    }

    //java11新特性三：局部变量类型推断的升级
    @Test
    public void test3(){
        //错误的形式: 必须要有类型, 可以加上var
//        Consumer<String> con1 = (@Deprecated t) -> System.out.println(t.toUpperCase());
        // 正确的形式:
        // 使用var的好处是在使用lambda表达式时给参数加上注解。
         Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());

    }
    //java11新特性四：HttpClient替换原有的HttpURLConnection。
    @Test
    public void test4(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
            HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, responseBodyHandler);
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test5(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);


    }

}
