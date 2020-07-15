package demo.two;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.ObjDoubleConsumer;

import lombok.extern.slf4j.Slf4j;

/**
* ArrayListDemo
*author  wenhe
*/
@Slf4j
public class HashMapDemo {

  @Test
  public void testRemove(){
    HashMap<String,String > map = Maps.newHashMap();
    map.put("1","1");
    map.put("2","2");

    map.forEach((s, s2) -> map.remove("1"));
  }

  class DemoDTO implements Serializable,Comparable<String>{
    private static final long serialVersionUID = -5222606202683030702L;

    private Integer i;

    public DemoDTO(Integer i) {
      this.i = i;
    }

    @Override
    public int hashCode() {
      return 2;
    }


    @Override
    public int compareTo(String o) {
      return 1;
    }
  }


  @Test
  public void testHashTreeNode(){
    Map<DemoDTO,Integer> map = new HashMap();
    for(int i=0;i<32;i++){
      map.put(new DemoDTO(i),i);
    }
    log.info(JSON.toJSONString(map));
  }

  @Test
  public void testArray(){
    String[] array = new String[]{"1", "2", "3"};
    String[] array1 = array;
    log.info("array[0] ={}",array[0]);
    log.info("array1[0] ={}",array1[0]);
    array[0] ="4";
    log.info("array[0] 的值被改变");
    log.info("array[0] ={}",array[0]);
    log.info("array1[0] ={}",array1[0]);
  }

  @Test
  public void compute(){
    HashMap<Integer,Integer> map = Maps.newHashMap();
    map.put(10,10);
    log.info("compute 之前值为：{}",map.get(10));
    map.compute(10,(key,value) -> key * value);
    log.info("compute 之后值为：{}",map.get(10));
    // 还原测试值
    map.put(10,10);

    // 如果为 11 的 key 不存在的话，需要注意 value 为空的情况
//    map.compute(11,(key,value) -> key * value);
    // 自己判断空指针
    map.compute(11,(key,value) -> null == value ? null : key * value);
    // computeIfPresent 方法里面判断
    map.computeIfPresent(11,(key,value) -> key * value);
    log.info("computeIfPresent 之后值为：{}",map.get(11));
  }

  @Test
  public void testInitMapByMaps(){
    Map<String,String> hashMap = Maps.newHashMap();
    Map<String,String> linkedHashMap = Maps.newLinkedHashMap();
    Map<String,String> withExpectedSizeHashMap = Maps.newHashMapWithExpectedSize(20);
  }


  @Test
  public void testDifference(){
    new HashMap<>(5);
    Map<String,String> leftMap = ImmutableMap.of("1","1","2","2","3","3");
    Map<String,String> rightMap = ImmutableMap.of("2","2","3","30","4","4");
    MapDifference difference = Maps.difference(leftMap, rightMap);
    log.info("左边 map 独有 key：{}",difference.entriesOnlyOnLeft());
    log.info("右边 map 独有 key：{}",difference.entriesOnlyOnRight());
    log.info("左右边 map 都有 key，并且 value 相等：{}",difference.entriesInCommon());
    log.info("左右边 map 都有 key，但 value 不等：{}",difference.entriesDiffering());
  }

  @Test
  public void testHash(){
    HashMap<Integer, Double> oldCountMap = new HashMap<>();
    HashMap<Integer, Double> newCountMap = new HashMap<>();
    for (int i = 0; i < 1000000; i++) {
      // 随机得到 16 位字符串
      String s = getRandomString(16);
      // 就是简单的 hash
      int oldIndex = (getTableLenth(oldCountMap)-1) & s.hashCode();
      // 使用 hashmap 的方法
      int newIndex = (newCountMap.size()-1) & (s.hashCode() ^ (s.hashCode() >>> 16));

      double oldValue = oldCountMap.getOrDefault(oldIndex,0d);
      oldCountMap.put(oldIndex, ++oldValue);

      double newValue = newCountMap.getOrDefault(newIndex,0d);
      newCountMap.put(newIndex, ++newValue);
    }
    HashMapDemo demo = new HashMapDemo();
    Double[] oldArry = new Double[oldCountMap.values().size()];
    oldCountMap.values().toArray(oldArry);

    Double[] newArry = new Double[newCountMap.values().size()];
    newCountMap.values().toArray(newArry);

    System.out.println(demo.variance(oldArry));
    System.out.println(demo.variance(newArry));
  }

  private int getTableLenth(HashMap map){
    try{
      Class clazz = Class.forName("java.util.HashMap");
      Field field = clazz.getDeclaredField("table");
      field.setAccessible(true);
      // 拿到 string 里面的数组
      Object table = field.get(map);
      return 0;
    }catch(Exception e){
    }
    return 0;
  }

  public  double variance(Double[] x) {
    int m = x.length;
    double sum = 0;
    for (int i = 0; i < m; i++) {//求和
      sum += x[i];
    }
    double dAve = sum / m;//求平均值
    double dVar = 0;
    for (int i = 0; i < m; i++) {//求方差
      dVar += (x[i] - dAve) * (x[i] - dAve);
    }
    return dVar / m;
  }

  public static String getRandomString(int length){
    String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random=new Random();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<length;i++){
      int number=random.nextInt(62);
      sb.append(str.charAt(number));
    }
    return sb.toString();
  }

  private Integer getI(int i){
    int sum =1;
    for(int l=0;l<i;l++){
      sum = sum * 2;
    }
    return sum;
  }

  @Test
  public void init(){
    Map<String,String> map = new HashMap<>(1);
    for(int i=0;i<67;i++){
      if(i ==0){
        map.put(i+"",i+"");
      }else if(i ==15){
        map.put(i+"",i+"");
      }else {
        map.put(i+"",i+"");
      }
    }
  }

  @Test
  public void test(){
    HashMap<String,String> map = new HashMap<>();
    map.put("key","value");
    Set<Map.Entry<String,String>> set = map.entrySet();
    Collection<String> values =  map.values();
  }


}
