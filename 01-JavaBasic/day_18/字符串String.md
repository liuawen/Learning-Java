# 字符串String

[TOC]

java.lang.String



# 1、字符串的特点

1、字符串String类型本身是final声明的，意味着我们不能继承String。final类不能被继承。

2、字符串的对象也是不可变对象，意味着一旦进行修改，就会产生新对象

字符串的对象也是不可变对象

> 我们修改了字符串后，如果想要获得新的内容，必须重新接受。
>
> 如果程序中涉及到大量的字符串的修改操作，那么此时的时空（时间、空间 ）消耗比较高。可能需要考虑使用StringBuilder或StringBuffer。

3、String对象内部是用字符数组进行保存的

String对象底层的存储 

> JDK1.9之前有一个char[] value数组，JDK1.9之后byte[]数组

JDK8 `private final char value[];`

JDK11 `private final byte[] value;`

4、String类中这个char[] values数组也是final修饰的，意味着这个数组不可变，然后它是private修饰，外部不能直接操作它，String类型提供的所有的方法都是用新对象来表示修改后内容的，所以保证了String对象的不可变。

5、就因为字符串对象设计为不可变，String对象不可变的特性，使得我们可以把一些字符串存到常量池中，字符串有常量池来保存很多常量对象

常量池在方法区。字符串有常量池。常量池中的是可以共享的。

字符串常量池在哪里？Oracle官方虚拟机HotSpot

如果细致的划分：

（1）JDK1.6及其之前：方法区

（2）JDK1.7：堆  挪到堆中，即在堆中单独划分了一块来存字符串常量

（3）JDK1.8：元空间   从堆中挪出，挪到一个“元空间meta space”，即类似于方法区。

String对象怎么就不可变？

①底层char[]数组有final修饰，意味着这个数组不能扩容等，来达到存更多的字符。

②char[]数组是私有的，我们程序员无法直接操作这个char[]数组，而且String没有提供这样的方法，来修改char[]数组的元素的值。

String提供的所有的方法，对字符串的修改都是给你返回一个新的字符串对象。

保证了String对象的不可变。



```java
public class TestString01 {
	@Test
	public void test02(){
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);//true

		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3 == s4 );//false

	}
	
	@Test
	public void test01(){
		String s1 = "hello";
		System.out.println(s1);//hello
		s1 = "world";
		System.out.println(s1);//world
		s1 = s1 + "java";
		System.out.println(s1);//worldjava

		String s  = "";
		System.out.println(s);//
		change(s);
		System.out.println(s);//
	}
	
	public void change(String str){
		str = "hello";
	}
}

```



# 2 、字符串对象的比较

1、==：比较是对象的地址

> 只有两个字符串变量都是指向字符串的常量对象时，才会返回true,，其他的都是false

```java
@Test
    public void test01() {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);//true
    } 
```



```java
@Test
    public void test02() {
        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println(s1 == s2);//false
    }
```



```java
 @Test
    public void test03() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);//false
    }
```



2、equals：比较是字符串对象的内容，因为String类型重写equals，区分大小写

只要两个字符串的字符内容相同，就会返回true

```java
 public void test04() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.equals(s2));//true

        String s3 = "hello";
        System.out.println(s3.equals(s1));//true

        String s4 = "Hello";
        System.out.println(s3.equals(s4));//false
    }
```





3、equalsIgnoreCase：比较的是字符串对象的内容，不区分大小写

```java
 @Test
    public void test05() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.equalsIgnoreCase(s2));//true

        String s3 = "hello";
        System.out.println(s3.equalsIgnoreCase(s1));//true

        String s4 = "Hello";
        System.out.println(s3.equalsIgnoreCase(s4));//true
    }
```



4、compareTo：String类型实现了Comparable接口，重写了Comparable接口的抽象方法，自然排序，按照字符的Unicode编码值进行比较大小的，严格区分大小写

 依次比较对应位置的字符
 * 	hello和Hello，先[0]位置的h和H，h>H，就直接认定为hello>Hello
 *  hello和hella，先`[0][1][2][3]`比较，都一样，最后到[4]o>[4]a，认定hello>hella
 *  hello和helloworld，发现前面都一样，长的大

```java
@Test
    public void test06() {
        String s1 = new String("hello");
        String s2 = new String("helloworld");
		
	/*	if(s1 > s2){//不能直接使用比较运算符
			
		}*/

        if (s1.compareTo(s2) > 0) {
            System.out.println(s1 + ">" + s2);
        } else if (s1.compareTo(s2) < 0) {
            System.out.println(s1 + "<" + s2);//hello<helloworld
        } else {
            System.out.println(s1 + "=" + s2);
        }

		String str1 = "hello";
		String str2 = "world";
		System.out.println(str1.compareTo(str2) );//小于0的值 -15
    }
```





5、大小比较：不区分大小写

String类型提供了一个方法compareToIgnoreCase，可以忽略大小写比较大小

compareToIgnoreCase：不区分大小写，其他按照字符的Unicode编码值进行比较大小

```java
 @Test
    public void test07() {
        String s1 = new String("hello");
        String s2 = new String("Hello");

        if (s1.compareToIgnoreCase(s2) > 0) {
            System.out.println(s1 + ">" + s2);
        } else if (s1.compareToIgnoreCase(s2) < 0) {
            System.out.println(s1 + "<" + s2);
        } else {
            System.out.println(s1 + "=" + s2);//hello=Hello
        }
		System.out.println(s1.compareToIgnoreCase(s2));//等于0
    }

```

6、按照每个国家的语言校对顺序

java.text.Collator：Collator 类执行区分语言环境的 String 比较。使用此类可为自然语言文本构建搜索和排序例程。

Collator实现了Comparator接口 ，

Collator是抽象类，不能直接创建对象，它有一个直接子类RuleBasedCollator

Collator内部提供了一个静态方法，可以获取一个它的子类对象
 自然排序：实现java.lang.Comparable接口，int compareTo(Object obj)

定制排序

collator n. 整理器；核对人；校对机



```java
    @Test
    public void test08() {
        String[] arr = {"hello", "china", "Java", "World", "Hi"};
        //排序
        //按照字母的顺序排列
        Arrays.sort(arr);//按照元素的自然顺序排序
        System.out.println(Arrays.toString(arr));//小到大
		//[Hi, Java, World, china, hello]
    }
```



```java
@SuppressWarnings("all")
    @Test
    public void test09() {
        String[] arr = {"hello", "China","china", "java","Java", "World", "Hi"};
        //排序
        //按照字母的顺序排列，不区分大小写
        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                return s1.compareToIgnoreCase(s2);
            }

        });//按照元素的自然顺序排序
        System.out.println(Arrays.toString(arr));
    }
```



```java
    @Test
    public void test10() {
        String[] arr = {"菜鸡文", "张三", "李四", "柳小子", "牛菜鸟"};
        Arrays.sort(arr);//按照自然顺序，按照每一个字符的Unicode编码值排序的
        System.out.println(Arrays.toString(arr));
		System.out.println('柳' + 0 );//\u67f3  26611
		System.out.println('牛' + 0 );// \u725b 29275
    }
```



```java
    @Test
    public void test11() {
        String[] arr = {"张三", "张阿", "李四", "李八","王五", "柳柳"};
        //希望按照拼音顺序，字典顺序
        Arrays.sort(arr, Collator.getInstance());//默认语言环境，因为我现在的操作系统的平台是中文win
        System.out.println(Arrays.toString(arr));//[李八, 李四, 柳柳, 王五, 张阿, 张三]
    }
```



```java
    @Test
    public void test12() {
        String[] arr = {"张三", "张阿", "李四", "李八","王五", "柳柳"};
        //希望按照拼音顺序，字典顺序
        Arrays.sort(arr, Collator.getInstance(Locale.CHINA));//Locale.CHINA指定语言环境
        System.out.println(Arrays.toString(arr));//[李八, 李四, 柳柳, 王五, 张阿, 张三]
    }

```





# 3 、空字符的比较

1、哪些是空字符串

```java
String str1 = "";
String str2 = new String();
String str3 = new String("");
```

空字符串：长度为0

2、如何判断某个字符串是否是空字符串

```java
if("".equals(str))

if(str!=null  && str.isEmpty())

if(str!=null && str.equals(""))

if(str!=null && str.length()==0)
```



# 4、 字符串的对象的个数

1、字符串常量对象

```java
String str1 = "hello";//1个，在常量池中
```

2、字符串的普通对象

```java
String str2 = new String();
String str22 = new String("");
//两个对象，一个是常量池中的空字符串对象，一个是堆中的空字符串对象
```

3、字符串的普通对象和常量对象一起

```java
String str3 = new String("hello");
//str3首先指向堆中的一个字符串对象，然后堆中字符串的value数组指向常量池中常量对象的value数组
```

# 5、 字符串拼接结果

原则：

（1）常量+常量：结果是常量池

（2）常量与变量 或 变量与变量：结果是堆

（3）拼接后调用intern方法：结果在常量池

```java
	@Test
	public void test06(){
		String s1 = "hello";
		String s2 = "world";
		String s3 = "helloworld";
		
		String s4 = (s1 + "world").intern();//把拼接的结果放到常量池中
		String s5 = (s1 + s2).intern();
		
		System.out.println(s3 == s4);//true
		System.out.println(s3 == s5);//true
	}
	
	@Test
	public void test05(){
		final String s1 = "hello";
		final String s2 = "world";
		String s3 = "helloworld";
		
		String s4 = s1 + "world";//s4字符串内容也helloworld，s1是常量，"world"常量，常量+ 常量 结果在常量池中
		String s5 = s1 + s2;//s5字符串内容也helloworld，s1和s2都是常量，常量+ 常量 结果在常量池中
		String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果
		
		System.out.println(s3 == s4);//true
		System.out.println(s3 == s5);//true
		System.out.println(s3 == s6);//true
	}
	
	@Test
	public void test04(){
		String s1 = "hello";
		String s2 = "world";
		String s3 = "helloworld";
		
		String s4 = s1 + "world";//s4字符串内容也helloworld，s1是变量，"world"常量，变量 + 常量的结果在堆中
		String s5 = s1 + s2;//s5字符串内容也helloworld，s1和s2都是变量，变量 + 变量的结果在堆中
		String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果
		
		System.out.println(s3 == s4);//false
		System.out.println(s3 == s5);//false
		System.out.println(s3 == s6);//true
	}
```



# 6、 字符串的API

（1）boolean isEmpty()

（2）int length()

（3）String concat(xx)：拼接，等价于+

（4）boolean contanis(xx)

（5）int indexOf()：从前往后找，要是没有返回-1

（6）int lastIndexOf()：从后往前找，要是没有返回-1

（7）char charAt(index)

（8）new String(char[] ) 或new String(char[] ,int, int)

（9）char[] toCharArray()

（10）byte[] getBytes()：编码，把字符串变为字节数组，按照平台默认的字符编码进行编码

​	byte[] getBytes(字符编码方式)：按照指定的编码方式进行编码

（11）new String(byte[] ) 或 new String(byte[], int, int)：解码，按照平台默认的字符编码进行解码

​           new String(byte[]，字符编码方式 ) 或 new String(byte[], int, int，字符编码方式)：解码，按照指定的编码方式进行解码

（12）String subString(int begin)：从[begin]开始到最后

String subString(int begin,int end)：从[begin, end)

（13）boolean matchs(正则表达式)

（14）String replace(xx,xx)：不支持正则

String replaceFirst(正则，value)：替换第一个匹配部分

String repalceAll(正则， value)：替换所有匹配部分

（15）String[] split(正则)：按照某种规则进行拆分

（16）boolean startsWith(xx)：是否以xx开头

boolean endsWith(xx)：是否以xx结尾

（17）String trim()：去掉前后空白符，字符串中间的空白符不会去掉

（18）String toUpperCase()：转大写

（19）String  toLowerCase()：转小写

面试题：字符串的length和数组的length有什么不同？

字符串的length()，数组的length属性

# 可变字符序列

1、可变字符序列：StringBuilder和StringBuffer

StringBuffer：老的，线程安全的（因为它的方法有synchronized修饰）

StringBuilder：线程不安全的



2、面试题：String和StringBuilder、StringBuffer的区别？

String：不可变对象，不可变字符序列

StringBuilder、StringBuffer： 可变字符序列



3、常用的API，StringBuilder、StringBuffer的API是完全一致的

（1）append(xx)：拼接，追加

（2）insert(int index, xx)：插入

（3）delete(int start, int end)

deleteCharAt(int index)

（4）set(int index, xx)

（5）reverse()：反转

....  替换、截取、查找...



# 和数学相关的

1、java.lang.Math类

（1）sqrt()：求平方根

（2）pow(x,y)：求x的y次方

（3）random()：返回[0,1)范围的小数

（4）max(x,y)：找x,y最大值

​	  min(x,y)：找最小值

（5）round(x)：四舍五入

​         ceil(x)：进一

​         floor(x)：退一

.....



2、java.math包

BigInteger：大整数

BigDecimal：大小数

运算通过方法完成：add(),subtract(),multiply(),divide()....



#  日期时间API

## 1、 JDK1.8之前

1、java.util.Date

new  Date()：当前系统时间

long  getTime()：返回该日期时间对象距离1970-1-1 0.0.0 0毫秒之间的毫秒值

new Date(long 毫秒)：把该毫秒值换算成日期时间对象

2、java.util.Calendar：

（1）getInstance()：得到Calendar的镀锡

（2）get(常量)

3、java.text.SimpleDateFormat：日期时间的格式化

y：表示年

M：月

d：天

H： 小时，24小时制

h：小时，12小时制

m：分

s：秒

S：毫秒

E：星期

D：年当中的天数

```java
	@Test
	public void test10() throws ParseException{
		String str = "2019年06月06日 16时03分14秒 545毫秒  星期四 +0800";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒  E Z");
		Date d = sf.parse(str);
		System.out.println(d);
	}
	
	@Test
	public void test9(){
		Date d = new Date();

		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒  E Z");
		//把Date日期转成字符串，按照指定的格式转
		String str = sf.format(d);
		System.out.println(str);
	}
	
	@Test
	public void test8(){
		String[] all = TimeZone.getAvailableIDs();
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
	
	@Test
	public void test7(){
		TimeZone t = TimeZone.getTimeZone("America/Los_Angeles");
		
		//getInstance(TimeZone zone)
		Calendar c = Calendar.getInstance(t);
		System.out.println(c);
	}
	
	@Test
	public void test6(){
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month);
		
		//...
	}
	
	@Test
	public void test5(){
		long time = Long.MAX_VALUE;
		Date d = new Date(time);
		System.out.println(d);
	}
	
	@Test
	public void test4(){
		long time = 1559807047979L;
		Date d = new Date(time);
		System.out.println(d);
	}
	@Test
	public void test3(){
		Date d = new Date();
		long time = d.getTime();
		System.out.println(time);//1559807047979
	}
	
	@Test
	public void test2(){
		long time = System.currentTimeMillis();
		System.out.println(time);//1559806982971
		//当前系统时间距离1970-1-1 0:0:0 0毫秒的时间差，毫秒为单位
	}
	
	@Test
	public void test1(){
		Date d = new Date();
		System.out.println(d);
	}
```



## 2、 JDK1.8之后

java.time及其子包中。

1、LocalDate、LocalTime、LocalDateTime

（1）now()：获取系统日期或时间

（2）of(xxx)：或者指定的日期或时间

（3）运算：运算后得到新对象，需要重新接受

plusXxx()：在当前日期或时间对象上加xx

minusXxx() ：在当前日期或时间对象上减xx

| 方法                                                         | **描述**                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| now() / now(ZoneId zone)                                     | 静态方法，根据当前时间创建对象/指定时区的对象                |
| of()                                                         | 静态方法，根据指定日期/时间创建对象                          |
| getDayOfMonth()/getDayOfYear()                               | 获得月份天数(1-31) /获得年份天数(1-366)                      |
| getDayOfWeek()                                               | 获得星期几(返回一个 DayOfWeek 枚举值)                        |
| getMonth()                                                   | 获得月份, 返回一个 Month 枚举值                              |
| getMonthValue() / getYear()                                  | 获得月份(1-12) /获得年份                                     |
| getHours()/getMinute()/getSecond()                           | 获得当前对象对应的小时、分钟、秒                             |
| withDayOfMonth()/withDayOfYear()/withMonth()/withYear()      | 将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象 |
| with(TemporalAdjuster  t)                                    | 将当前日期时间设置为校对器指定的日期时间                     |
| plusDays(), plusWeeks(), plusMonths(), plusYears(),plusHours() | 向当前对象添加几天、几周、几个月、几年、几小时               |
| minusMonths() / minusWeeks()/minusDays()/minusYears()/minusHours() | 从当前对象减去几月、几周、几天、几年、几小时                 |
| plus(TemporalAmount t)/minus(TemporalAmount t)               | 添加或减少一个 Duration 或 Period                            |
| isBefore()/isAfter()                                         | 比较两个 LocalDate                                           |
| isLeapYear()                                                 | 判断是否是闰年（在LocalDate类中声明）                        |
| format(DateTimeFormatter  t)                                 | 格式化本地日期、时间，返回一个字符串                         |
| parse(Charsequence text)                                     | 将指定格式的字符串解析为日期、时间                           |

2、DateTimeFormatter：日期时间格式化

该类提供了三种格式化方法：

预定义的标准格式。如：ISO_DATE_TIME;ISO_DATE

本地化相关的格式。如：ofLocalizedDate(FormatStyle.MEDIUM)

自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

```java
	@Test
	public void test10(){
		LocalDateTime now = LocalDateTime.now();
		
//		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);//2019年6月6日 下午04时40分03秒
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);//19-6-6 下午4:40
		String str = df.format(now);
		System.out.println(str);
	}
	@Test
	public void test9(){
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE_TIME;//2019-06-06T16:38:23.756
		String str = df.format(now);
		System.out.println(str);
	}
	
	@Test
	public void test8(){
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒  SSS毫秒  E 是这一年的D天");
		String str = df.format(now);
		System.out.println(str);
	}
	
	@Test
	public void test7(){
		LocalDate now = LocalDate.now();
		LocalDate before = now.minusDays(100);
		System.out.println(before);//2019-02-26
	}
	
	@Test
	public void test06(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		LocalDate go = lai.plusDays(160);
		System.out.println(go);//2019-10-20
	}
	
	@Test
	public void test05(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		System.out.println(lai.getDayOfYear());
	}
	
	
	@Test
	public void test04(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		System.out.println(lai);
	}
	
	@Test
	public void test03(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}
	
	@Test
	public void test02(){
		LocalTime now = LocalTime.now();
		System.out.println(now);
	}
	
	@Test
	public void test01(){
		LocalDate now = LocalDate.now();
		System.out.println(now);
	}
```

