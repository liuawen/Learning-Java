package demo.two;


import com.alibaba.fastjson.JSON;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * TreeMapDemo
 * author  wenhe
 */
@Slf4j
public class TreeMapDemo {

  @Data
  class DTO implements Comparable<DTO> {

    private Integer id;

    public DTO(Integer id) {
      this.id = id;
    }

    @Override
    public int compareTo(DTO o) {
      //默认从小到大排序
      return id - o.getId();
    }
  }


  @Test
  public void testIterator() {
    TreeMap<String,String> m = new TreeMap<>();
    m.put("asdf","nihao");
    m.put("sdf","nihao");
    m.put("df","nihao");
    m.keySet().iterator();
  }

  @Test
  public void testTwoComparable() {
    // 第一种排序，从小到大排序，实现 Comparable 的 compareTo 方法进行排序
    List<DTO> list = new ArrayList<>();
    for (int i = 5; i > 0; i--) {
      list.add(new DTO(i));
    }
    Collections.sort(list);
    log.info(JSON.toJSONString(list));

    // 第二种排序，从大到小排序，利用外部排序器 Comparator 进行排序
    Comparator comparator = (Comparator<DTO>) (o1, o2) -> o2.getId() - o1.getId();
    List<DTO> list2 = new ArrayList<>();
    for (int i = 5; i > 0; i--) {
      list2.add(new DTO(i));
    }
    Collections.sort(list,comparator);
    log.info(JSON.toJSONString(list2));
  }


}
