package demo.eight;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * lambda 表达式 author  wenhe date 2019/10/12
 */
@Slf4j
public class LambdaExpressionDemo {

  private static final List<String> list = ImmutableList.of("hello", "world");

  @Data
  // 学生数据结构
  class StudentDTO implements Serializable {

    private static final long serialVersionUID = -7716352032236707189L;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String code, String name, String sex, Double scope,
                      List<Course> learningCources) {
      this.id = id;
      this.code = code;
      this.name = name;
      this.sex = sex;
      this.scope = scope;
      this.learningCources = learningCources;
    }

    /**
     * id
     */
    private Long id;
    /**
     * 学号 唯一标识
     */
    private String code;
    /**
     * 学生名字
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 分数
     */
    private Double scope;

    /**
     * 要学习的课程
     */
    private List<Course> learningCources;
  }

  @Data
  // 课程数据结构
  class Course implements Serializable {

    private static final long serialVersionUID = 2896201730223729591L;

    /**
     * 课程 ID
     */
    private Long id;

    /**
     * 课程 name
     */
    private String name;

    public Course(Long id, String name) {
      this.id = id;
      this.name = name;
    }
  }
  // 初始化数据
  private final List<StudentDTO> students = new ArrayList<StudentDTO>(){
    {
      // 添加学生数据
      add(new StudentDTO(1L,"W199","小美","WM",100D,new ArrayList<Course>(){
        {
          // 添加学生学习的课程
          add(new Course(300L,"语文"));
          add(new Course(301L,"数学"));
          add(new Course(302L,"英语"));
        }
      }));
      add(new StudentDTO(2L,"W25","小美","WM",100D,Lists.newArrayList()));
      add(new StudentDTO(3L,"W3","小名","M",90D,new ArrayList<Course>(){
        {
          add(new Course(300L,"语文"));
          add(new Course(304L,"体育"));
        }
      }));
      add(new StudentDTO(4L,"W1","小蓝","M",10D,new ArrayList<Course>(){
        {
          add(new Course(301L,"数学"));
          add(new Course(305L,"美术"));
        }
      }));
    }
  };


  @Test
  public void testFilter() {
    List<String> newList = list.stream()
        // 过滤掉我们希望留下来的值
        // StringUtils.equals(str,"hello") 表示我们希望字符串是 hello 能留下来
        // 其他的过滤掉
        .filter(str -> StringUtils.equals(str, "hello"))
        // Collectors.toList() 帮助我们构造最后的返回结果
        .collect(Collectors.toList());
    log.info("TestFilter result is {}", JSON.toJSONString(newList));
  }

  // map 方法可以让我们进行一些流的转化，比如原来流中的元素是 A，通过 map 操作，可以使返回的流中的元素是 B
  @Test
  public void testMap() {
    // 得到所有学生的学号
    // 这里 students.stream() 中的元素是 StudentDTO，通过 map 转化成 String 的流
    List<String> codes = students.stream()
        //StudentDTO::getCode 是 s->s.getCode() 的简写
        .map(StudentDTO::getCode)
        .collect(Collectors.toList());
    log.info("TestMap 所有学生的学号为 {}", JSON.toJSONString(codes));
  }

  // mapToInt 固定返回流的类型是 int，还有 mapToLong，mapToDouble
  @Test
  public void testMapToInt() {
    List<Integer> ids = students.stream()
        .mapToInt(s->Integer.valueOf(s.getId()+""))
        // 一定要有 mapToObj，因为 mapToInt 返回的是 IntStream，因为已经确定是 int 类型了
        // 所有没有泛型的，而 Collectors.toList() 强制要求有泛型的流，所以需要使用 mapToObj
        // 方法返回有泛型的流
        .mapToObj(s->s)
        .collect(Collectors.toList());
    log.info("TestMapToInt result is {}", JSON.toJSONString(ids));

    // 计算学生总分
    Double sumScope = students.stream()
        .mapToDouble(s->s.getScope())
        // IntStream 有许多 sum（求和）、min（求最小值）、max（求最大值）、average（求平均值）等方法
        .sum();
    log.info("TestMapToInt 学生总分为： is {}", sumScope);
  }

  // flatMap 方法和 map 方法不同，FlatMap 可以接受入参的类型为 Stream，比如这里的
  // s.getLearningCources().stream() 就是 Stream，可以用下面的 demo 比较一下差异
  @Test
  public void testFlatMap(){
    // 计算学生所有的学习课程，flatMap 返回 List<课程> 格式
    List<Course> courses = students.stream().flatMap(s->s.getLearningCources().stream())
        .collect(Collectors.toList());
    log.info("TestMapToInt flatMap 计算学生的所有学习课程如下 {}", JSON.toJSONString(courses));

    // 计算学生所有的学习课程，map 返回两层课程嵌套格式
    List<List<Course>> courses2 = students.stream().map(s->s.getLearningCources())
        .collect(Collectors.toList());
    log.info("TestMapToInt map 计算学生的所有学习课程如下 {}", JSON.toJSONString(courses2));

    List<Stream<Course>> courses3 = students.stream().map(s->s.getLearningCources().stream())
        .collect(Collectors.toList());
    log.info("TestMapToInt map 计算学生的所有学习课程如下  {}", JSON.toJSONString(courses3));
  }

  // 去重
  @Test
  public void testDistinct(){
    // 得到学生所有的名字，要求是去重过的
    List<String> beforeNames = students.stream().map(StudentDTO::getName).collect(Collectors.toList());
    log.info("TestDistinct 没有去重前的学生名单 {}",JSON.toJSONString(beforeNames));

    List<String> distinctNames = beforeNames.stream().distinct().collect(Collectors.toList());
    log.info("TestDistinct 去重后的学生名单 {}",JSON.toJSONString(distinctNames));

    // 连起来写
    List<String> names = students.stream()
        .map(StudentDTO::getName)
        .distinct()
        .collect(Collectors.toList());
    log.info("TestDistinct 去重后的学生名单 {}",JSON.toJSONString(names));
  }

  // 排序
  @Test
  public void testSorted(){
    // 学生按照学号排序
    List<String> beforeCodes = students.stream().map(StudentDTO::getCode).collect(Collectors.toList());
    log.info("TestSorted 按照学号排序之前 {}",JSON.toJSONString(beforeCodes));

    List<String> sortedCodes = beforeCodes.stream().sorted().collect(Collectors.toList());
    log.info("TestSorted 按照学号排序之后 is {}",JSON.toJSONString(sortedCodes));

    // 直接连起来写
    List<String> codes = students.stream()
        .map(StudentDTO::getCode)
        // 等同于 .sorted(Comparator.naturalOrder()) 自然排序
        .sorted()
        .collect(Collectors.toList());
    log.info("TestSorted 按照自然排序 is {}",JSON.toJSONString(codes));

    // 自定义排序器
    List<String> codes2 = students.stream()
        .map(StudentDTO::getCode)
        // 反自然排序
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    log.info("TestSorted 反自然排序 is {}",JSON.toJSONString(codes2));
  }

  // 干任何没有返回值的事情
  @Test
  public void testPeek(){
    students.stream().map(StudentDTO::getCode)
        .peek(s -> log.info("当前循环的学号是{}",s))
        .collect(Collectors.toList());
  }

  // 限制
  @Test
  public void testLimit(){
    List<String> beforeCodes = students.stream().map(StudentDTO::getCode).collect(Collectors.toList());
    log.info("TestLimit 限制之前学生的学号为 {}",JSON.toJSONString(beforeCodes));

    List<String> limitCodes = beforeCodes.stream()
        .limit(2L)
        .collect(Collectors.toList());
    log.info("TestLimit 限制最大限制 2 个学生的学号 {}",JSON.toJSONString(limitCodes));

    // 直接连起来写
    List<String> codes = students.stream()
        .map(StudentDTO::getCode)
        .limit(2L)
        .collect(Collectors.toList());
    log.info("TestLimit 限制最大限制 2 个学生的学号 {}",JSON.toJSONString(codes));
  }

  // 计算一下学生的总分数
  @Test
  public void testReduce(){
    // 计算一下学生的总分数
    Double sum = students.stream()
        .map(StudentDTO::getScope)
        // scope1 和 scope2 表示循环中的前后两个数
        .reduce((scope1,scope2) -> scope1+scope2)
        .orElse(0D);
    log.info("总成绩为 {}",sum);

    Double sum1 = students.stream()
        .map(StudentDTO::getScope)
        // 第一个参数表示成绩的基数，会从 100 开始加
        .reduce(100D,(scope1,scope2) -> scope1+scope2);
    log.info("总成绩为 {}",sum1);
  }


  // 找到第一个叫小美同学的 ID
  @Test
  public void testFindFirst(){
    Long id = students.stream()
        .filter(s->StringUtils.equals(s.getName(),"小美"))
        .findFirst()
        .get().getId();

    log.info("testFindFirst 小美同学的 ID {}",id);

    // 防止空指针
    Long id2 = students.stream()
        .filter(s->StringUtils.equals(s.getName(),"小天"))
        .findFirst()
        // orElse 表示如果 findFirst 返回 null 的话，就返回 orElse 里的内容
        .orElse(new StudentDTO()).getId();
    log.info("testFindFirst 小天同学的 ID {}",id2);

    Optional<StudentDTO> student= students.stream()
        .filter(s->StringUtils.equals(s.getName(),"小天"))
        .findFirst();
    // isPresent 为 true 的话，表示 value != null
    if(student.isPresent()){
      log.info("testFindFirst 小天同学的 ID {}",student.get().getId());
      return;
    }
    log.info("testFindFirst 找不到名为小天的同学");
  }

  @Test
  public void testListToMap(){
    // 学生根据名字进行分类
    Map<String, List<StudentDTO>> map1 = students.stream()
        .collect(Collectors.groupingBy(StudentDTO::getName));
    log.info("testListToMap groupingBy 学生根据名字进行分类 result is Map<String,List<StudentDTO>> {}",
             JSON.toJSONString(map1));

    // 统计有没有姓名重名的
    Map<String, Set<String>> map2 = students.stream()
        .collect(Collectors.groupingBy(StudentDTO::getName,
                                       Collectors.mapping(StudentDTO::getCode,Collectors.toSet())));
    log.info("testListToMap groupingBy 统计姓名重名结果 is {}",
             JSON.toJSONString(map2));

    // 学生转化成学号为 key 的 map
    Map<String, StudentDTO> map3 = students.stream()
        .collect(Collectors.toMap(s->s.getCode(),s->s,(s1,s2)->s1));
    log.info("testListToMap groupingBy 学生转化成学号为 key 的 map result is{}",
             JSON.toJSONString(map3));

  }












}
