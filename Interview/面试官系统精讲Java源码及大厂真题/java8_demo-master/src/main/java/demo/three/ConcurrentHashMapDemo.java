package demo.three;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;

/**
* ConcurrentHashMapDemo
*author  wenhe
*date 2019/8/7
*/
@Slf4j
public class ConcurrentHashMapDemo {

  @Test
  public void testTransfer(){
    ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>(2);
    map.put(1,1);
    map.put(2,2);
    map.put(3,3);
    map.put(4,4);
    map.put(5,5);
    map.put(6,6);
    map.put(57,58);
    map.put(51,51);
    map.put(52,52);
    map.put(53,53);
    map.put(54,54);
    map.put(55,55);
    map.put(56,56);
    map.put(57,57);
    map.put(58,58);
    map.put(59,59);
  }

  ConcurrentHashMap<Integer,Integer> MAP_1 = new ConcurrentHashMap<>(2);

  @Test
  public void testInit(){
    new Thread(() -> MAP_1.put(1, 1)).start();
    new Thread(() -> MAP_1.put(1, 1)).start();
    System.out.println("nihao");
  }

  @Test
  public void test33(){
    Map<String,String> map = new ConcurrentHashMap<>(10);
    map.put("nihao","nihao");
  }

}
