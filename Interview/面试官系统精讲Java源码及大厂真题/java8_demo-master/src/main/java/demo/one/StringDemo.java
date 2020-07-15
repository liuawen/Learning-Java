package demo.one;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
* StringDemo
*author  wenhe
*date 2019/7/28
*/
@Slf4j
public class StringDemo {

  @Test
  public void testFinal(){
    String s ="hello";
    s ="world";
    log.info(s);
  }

  @Test
  public void testGibberish() throws UnsupportedEncodingException {
    String str  ="nihao 你好 喬亂";
    byte[] bytes = str.getBytes("ISO-8859-1");
    String s2 = new String(bytes,"ISO-8859-1");
    log.info(s2);
  }

  @Test
  public void testReplace(){
    String str ="hello word !!";
    log.info("替换之前 :{}",str);
    str = str.replace('l','d');
    log.info("替换所有字符 :{}",str);
    str = str.replaceAll("d","l");
    log.info("替换全部 :{}",str);
    str = str.replaceFirst("l","");
    log.info("替换第一个 :{}",str);
  }

  @Test
  public void testSplit(){
    String s ="boo:and:foo";
    log.info("s.split(\":\") 结果:{}", JSON.toJSONString( s.split(":") ));
    log.info("s.split(\":\",2) 结果:{}", JSON.toJSONString( s.split(":",2) ));
    log.info("s.split(\":\",5) 结果:{}", JSON.toJSONString( s.split(":",5) ));
    log.info("s.split(\":\",-2) 结果:{}", JSON.toJSONString( s.split(":",-2) ));
    log.info("s.split(\"o\") 结果:{}", JSON.toJSONString( s.split("o") ));
    log.info("s.split(\"o\",2) 结果:{}", JSON.toJSONString( s.split("o",2) ));


    String a1 =",a, ,  b  c ,null";
    log.info("a.split(\",\") 结果:{}", JSON.toJSONString( a1.split(",") ));

    String a =",a, ,  b  c ,";
    List<String> list = Splitter.on(',')
        .trimResults()// 去掉空格
        .omitEmptyStrings()// 去掉空值
        .splitToList(a);
    log.info("Guava 去掉空格的分割方法：{}",JSON.toJSONString(list));
  }

  @Test
  public void testJoin(){
    String s ="hello";
    String s1 ="china";
    s.replace("nihao","sss");
//    log.info(s.join(",",s1).join(",","null"));


    // 依次  join 多个字符串
    Joiner joiner = Joiner.on(",").skipNulls();
    String result = joiner.join("hello",null,"china");
    log.info("依次  join 多个字符串:{}",result);

    List<String> list = Lists.newArrayList(new String[]{"hello","china",null});
    log.info("自动删除 list 中空值:{}",joiner.join(list));

    String r1 = String.join(",",list);
//    log.info("结果为:{}",r1);
  }

  @Test
  public void testLong128(){
    Long.valueOf(128);
    Long.valueOf(129);
  }

  @Test
  public void testReplaceAndAll(){
    StringBuffer strb = new StringBuffer();
    int size =1000;
    for (int i = 0; i < size; i++)
      strb.append("o");
    String s = strb.toString();
    String s1 = strb.toString();
    long begin = System.currentTimeMillis();
    s.replace('o','l');
    log.info("循环{}次， replace 耗时{}",size, (System.currentTimeMillis() - begin));
    begin = System.currentTimeMillis();
    s1.replaceAll("o","l");
    log.info("循环{}次， replace 耗时{}",size, (System.currentTimeMillis() - begin));
  }

  @Test
  public void testSplit2(){
    String s ="   i   ";
    char ch = '-';
    String[] sArrt = s.split("i",1);
    System.out.println(sArrt);
  }

  @Test
  public void test(){
    new String("123123").substring(1,3);
    String a ="123";
    String s ="123";
    System.out.println(a==s);
    System.out.println(a==s);
    System.out.println("123"=="123");
  }


}
