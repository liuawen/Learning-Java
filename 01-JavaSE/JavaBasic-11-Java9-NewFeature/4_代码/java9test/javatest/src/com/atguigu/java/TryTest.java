package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by songhongkang on 2017/12/29 0029.
 */
public class TryTest {

    //举例1：
    @Test
    public void testTry1(){

        InputStreamReader reader = null;

        try{
            reader  = new InputStreamReader(System.in);
            //读取数据的过程：略
            reader.read();

        }catch (IOException e){
            e.printStackTrace();
        }finally{
            //资源的关闭操作
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //举例2：在举例1基础上，升级的写法。不用显式的处理资源的关闭
    //java 8 中：要求资源对象的实例化，必须放在try的一对()内完成。
    //java 9 中：可以在try()中调用已经实例化的资源对象
    @Test
    public void testTry2(){
        try(InputStreamReader reader = new InputStreamReader(System.in)){

            //读取数据的过程：略
            reader.read();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //如下的操作不可以在jdk 8 及之前的版本中使用
    @Test
    public void testTry3(){
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try(reader;writer){
            //此时的reader是final的，不可再被赋值
//            reader = null;

            //读取数据的过程：略
            reader.read();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
