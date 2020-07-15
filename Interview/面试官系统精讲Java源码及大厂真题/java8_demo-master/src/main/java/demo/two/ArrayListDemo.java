package demo.two;
import java.util.HashSet;
import	java.util.concurrent.locks.ReentrantLock;
import	java.lang.reflect.Field;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import lombok.extern.slf4j.Slf4j;

/**
* ArrayListDemo
*author  wenhe
*/
@Slf4j
public class ArrayListDemo {

  @Test
  public void initByCollection(){
    // Arrays.asList 返回的是具体的类型
    List<String> list = Arrays.asList("hello,world");
    Object[] objArray = list.toArray();
    log.info(objArray.getClass().getSimpleName());
    // objArray 元素的类型是 String，储存 Object 就会报错，因为 jvm 不清楚你存储的
    // Object 真实类型是不是 String
    objArray[0] = new Object();
  }

  @Test
  public void testRemove(){
    List<String> list = new ArrayList<String>() {{
      add("2");
      add("3");
      add("3");
      add("3");
      add("4");
    }};
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals("3")) {
        list.remove(i);
      }
    }
  }

  @Test
  public void testBatchInsert(){
    // 准备数据
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0;i<3000000;i++){
      list.add(i);
    }

    // for 循环 使用add方法新增
    ArrayList<Integer> list2 = new ArrayList<>();
    long start1 = System.currentTimeMillis();
    for(int i=0;i<list.size();i++){
      list2.add(list.get(i));
    }
    log.info("单个 for 循环新增 300 w 个，耗时{}",System.currentTimeMillis()-start1);

    // 使用 addAll 方法批量新增
    ArrayList<Integer> list3 = new ArrayList<>();
    long start2 = System.currentTimeMillis();
    list3.addAll(list);
    log.info("批量新增 300 w 个，耗时{}",System.currentTimeMillis()-start2);
  }

  @Test
  public void testArrayToList(){
    Integer[] array = new Integer[]{1,2,3,4,5,6};
    List<Integer> list = Arrays.asList(array);

    // 修改数组的值，会直接影响 list
    log.info("数组被修改之前，集合第一个元素为：{}",list.get(0));
    array[0] = 10;
    log.info("数组被修改之前，集合第一个元素为：{}",list.get(0));

    // 使用 add、remove 等操作 list 的方法时，
    // 会报 UnsupportedOperationException 异常
    list.add(7);
  }

  @Test
  public void testListToArray(){
    List<Integer> list = new ArrayList<Integer>(){{
      add(1);
      add(2);
      add(3);
      add(4);
    }};

    // 这样子无法转化，无参 toArray 返回的是 Object[],
    // 无法向下强转，编译无法通过，很麻烦
//    List<Integer> list2 = list.toArray();

    // 演示有参 toArray 方法，数组大小不够时，数组为 null 情况
    Integer[] array0 = new Integer[2];
    list.toArray(array0);
    log.info("toArray 数组大小不够，array0 数组[0] 值是{},数组[1] 值是{},",array0[0],array0[1]);

    Integer[] array1 = new Integer[list.size()];
    list.toArray(array1);
    log.info("toArray 数组大小正好，array1 数组[3] 值是{}",array1[3]);

    Integer[] array2 = new Integer[list.size()+2];
    list.toArray(array2);
    log.info("toArray 数组大小多了，array2 数组[3] 值是{}，数组[4] 值是{}",array2[3],array2[4]);
  }

  @Test
   public void testForEach(){
    List<Integer> list = new ArrayList<Integer>(){{
      add(1);
      add(3);
      add(2);
      add(4);
    }};

    list.forEach( value->log.info("当前值为：{}",value));
  }

  @Test
  public void testArrayParallel(){
     int size = 1 << 13;
     log.info(""+size);
     Integer[] array = new Integer[size+2];
     for(int i=0;i<size+1;i++){
       array[i] =i;
     }
     Arrays.parallelSort(array);
  }

  @Test
  public void testReverse(){
    List<String> list = new ArrayList<String>(){{
      add("10");
      add("20");
      add("30");
      add("40");
    }};
    log.info("反转之前："+JSON.toJSONString(list));
    list = Lists.reverse(list);
    log.info("反转之后："+JSON.toJSONString(list));
  }

  @Test
  public void testPartition(){
    List<String> list = new ArrayList<String>(){{
      add("10");
      add("20");
      add("30");
      add("40");
    }};
    log.info("分组之前："+JSON.toJSONString(list));
     List<List<String>> list2 = Lists.partition(list,3);
    log.info("分组之后："+JSON.toJSONString(list2));

    Long a =100L;
    a =10L;
  }

  @Test
  public void testMath(){
    int n =30;
    int i =n >>>3;
    log.info(i+"");
    int ii = n <<1;
    log.info(ii+"");
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<String> futureTask = new FutureTask<String>(() -> "nihao");
    Executors.newFixedThreadPool(10).submit(futureTask);
    futureTask.get();
    System.out.println("cdcd");
  }

  @Test
  public void string() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    String str = "hello world";
    Class clazz = Class.forName("java.lang.String");
    Field field = clazz.getDeclaredField("value");
    field.setAccessible(true);
    // 拿到 string 里面的数组
    char[] value = (char[]) field.get(str);
    log.info("修改之前{}",str);
    field.set(str,"hello java".toCharArray());
    log.info("修改之后{}",str);


  }

  @Test
  public void testFor(){
    List<Integer> list = new ArrayList<Integer> (5000);
    for (int i = 0; i < 5000; i++) {
      list.add(i);
    }
  }

  @Test
  public void testParse() throws InterruptedException {
    log.info("----");
    Thread.sleep(1000L);
    String s ="100";
    int valueOf = 0;
    int parseLong = 0;
    for(int y=0;y<100;y++){
      long beginTime = System.currentTimeMillis();
      for (int i = 0; i < 1000; i++) {
        Long.valueOf(s);
      }
      Long s11 = System.currentTimeMillis() - beginTime;
      long beginTime1 = System.currentTimeMillis();
      for (int i = 0; i < 1000; i++) {
        Long.parseLong(s);
      }
      Long s22 = System.currentTimeMillis() - beginTime1;

      if(s11>s22){
        parseLong++;
      }else {
        valueOf++;
      }
    }
     System.out.println("valueOf 累计"+valueOf);
     System.out.println("parseLong 累计"+parseLong);

  }


}
