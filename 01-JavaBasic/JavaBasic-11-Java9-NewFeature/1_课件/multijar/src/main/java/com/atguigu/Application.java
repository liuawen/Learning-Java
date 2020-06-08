package com.atguigu;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
/**
 * Created by songhongkang on 2017/12/28 0028.
 */
public class Application {

   public static void testMultiJar(){
      Generator gen = new Generator();
      System.out.println("Generated strings: " + gen.createStrings());
   }

}
