package demo.two;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import lombok.extern.slf4j.Slf4j;

/**
* LinkedListDemo
*author  wenhe
*/
@Slf4j
public class LinkedListDemo extends LinkedList<String>{

  @Override
  public String get(int index) {
    return super.get(index);
  }

  @Test
  public void testItertor(){
    List<String> list = new LinkedList<String>();
    list.add("s1");
    list.add("s3");
    list.add("s3");
    list.add(null);
    list.add("s4");

    for (String s:list){
      if(s == null){
        list.remove(s);
      }
    }

    for (int i = 0; i < list.size(); i++) {
      if(list.get(i).equals("s3")){
        list.remove(i);
      }
    }

    ListIterator<String> listIterator = list.listIterator();
    while (listIterator.hasNext()){
      String s = listIterator.next();
      log.info("从头到尾迭代顺序："+s);
    }

    while (listIterator.hasPrevious()){
      String s = listIterator.previous();
      if(s.equals("s5")){
        listIterator.remove();
      }
      log.info("从尾到头迭代顺序："+s);
    }
  }

}
