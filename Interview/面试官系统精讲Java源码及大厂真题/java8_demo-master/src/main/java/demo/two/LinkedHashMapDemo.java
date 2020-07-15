package demo.two;

import com.alibaba.fastjson.JSON;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * ArrayListDemo
 * author  wenhe
 */
@Slf4j
public class LinkedHashMapDemo {

  @Test
  public void testInsertOrder() {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>() {{
      put(10, 10);
      put(9, 9);
      put(20, 20);
      put(1, 1);
    }};
    Assert.assertNotNull(map.get(9));
    Assert.assertNotNull(map.get(20));
    Assert.assertNotNull(map.get(9));
    log.info(JSON.toJSONString(map));

  }

  @Test
  public void testAccessOrder() {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(4,0.75f,true) {
      {
        put(10, 10);
        put(9, 9);
        put(20, 20);
        put(1, 1);
      }

      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > 3;
      }
    };

    log.info("初始化：{}",JSON.toJSONString(map));
    Assert.assertNotNull(map.get(9));
    log.info("map.get(9)：{}",JSON.toJSONString(map));
    Assert.assertNotNull(map.get(20));
    log.info("map.get(20)：{}",JSON.toJSONString(map));

  }

  @Test
  public void testIterator(){
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(4,0.75f,true) {
      {
        put(10, 10);
        put(9, 9);
        put(20, 20);
        put(1, 1);
      }
    };

    log.info("迭代访问 start");
    Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry<Integer,Integer> entry = iterator.next();
      log.info(JSON.toJSONString(entry));
    }
    log.info("迭代访问 end");
  }

  public static void main(String[] args) {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(4,0.75f,true);
    map.put(1,1);
  }

}
