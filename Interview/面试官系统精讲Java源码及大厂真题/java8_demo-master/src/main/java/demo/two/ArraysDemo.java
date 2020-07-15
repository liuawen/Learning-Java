package demo.two;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
* ArraysDemo
*author  wenhe
*date 2019/8/3
*/
@Slf4j
public class ArraysDemo {

  @Test
  public void testSort(){
    List<SortDTO> list = ImmutableList.of(
        new SortDTO("300"),
        new SortDTO("50"),
        new SortDTO("200"),
        new SortDTO("220")
    );
    // 我们先把数组的大小初始化成 list 的大小
    SortDTO[] array = new SortDTO[list.size()];
    list.toArray(array);

    log.info("排序之前：{}", JSON.toJSONString(array));
    Arrays.sort(array, Comparator.comparing(SortDTO::getSortTarget));
    log.info("排序之后：{}", JSON.toJSONString(array));
  }
  
  @Test
  public void testBinarySearch(){
    List<SortDTO> list = ImmutableList.of(
        new SortDTO("300"),
        new SortDTO("50"),
        new SortDTO("200"),
        new SortDTO("220")
    );

    SortDTO[] array = new SortDTO[list.size()];
    list.toArray(array);

    log.info("搜索之前：{}", JSON.toJSONString(array));
    Arrays.sort(array, Comparator.comparing(SortDTO::getSortTarget));
    log.info("先排序，结果为：{}", JSON.toJSONString(array));
    int index = Arrays.binarySearch(array, new SortDTO("200"),
                        Comparator.comparing(SortDTO::getSortTarget));
    if(index<0){
      throw new RuntimeException("没有找到 200");
    }
    log.info("搜索结果：{}", JSON.toJSONString(array[index]));
  }

  @Data
  class SortDTO {

    private String sortTarget;

    public SortDTO(String sortTarget) {
      this.sortTarget = sortTarget;
    }
  }

  class SortDTO1 implements Comparable<SortDTO1> {

    private String sortTarget;

    public SortDTO1(String sortTarget) {
      this.sortTarget = sortTarget;
    }

    @Override
    public int compareTo(SortDTO1 o) {
      return o.sortTarget.compareTo(sortTarget);
    }
  }

  @Test
  public void testMax() {
    Collection<SortDTO1> list = ImmutableList.of(
        new SortDTO1("300"),
        new SortDTO1("50"),
        new SortDTO1("200"),
        new SortDTO1("220")
    );
    Collections.max(list);
  }

  @Test
  public void testSearch(){
    //0~10
    System.out.println("(0 + 10-1) >>> 1:"+((0 + 10-1) >>> 1));
    System.out.println("(0 + 11-1) >>> 1:"+((0 + 11-1) >>> 1));
    System.out.println("(1 + 11-1) >>> 1:"+((1 + 11-1) >>> 1));
    System.out.println("(1 + 10-1) >>> 1:"+((1 + 10-1) >>> 1));
  }










}
