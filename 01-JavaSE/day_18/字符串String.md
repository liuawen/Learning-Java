# 字符串String

[TOC]

java.lang.String



# 1、字符串的特点

1、字符串String类型本身是final声明的，意味着我们不能继承String。final类不能被继承。

2、字符串的对象也是不可变对象，意味着一旦进行修改，就会产生新对象

字符串的对象是不可变对象

> 我们修改了字符串后，如果想要获得新的内容，必须重新接受。
>
> 如果程序中涉及到大量的字符串的修改操作，那么此时的时空（时间、空间 ）消耗比较高。可能需要考虑使用StringBuilder或StringBuffer。

3、String对象内部是用字符数组进行保存的

String对象底层的存储 

> JDK1.9之前有一个char[] value数组，JDK1.9之后byte[]数组

JDK8 `private final char value[];`

JDK11 `private final byte[] value;`

4、String类中这个char[] values数组也是final修饰的，意味着这个数组不可变，然后它是private修饰，外部不能直接操作它，String类型提供的所有的方法都是用新对象来表示修改后内容的，所以保证了String对象的不可变。

5、就因为字符串对象设计为不可变，String对象不可变的特性，使得我们可以把一些字符串存到常量池中，字符串有常量池来保存很多常量对象。

常量池在方法区。字符串有常量池。常量池中的是可以共享的。共享？？？常量池共享同一个对象 节省内存 不用new新的

字符串常量池在哪里？比较大，Oracle官方虚拟机HotSpot

如果细致的划分：

（1）JDK1.6及其之前：方法区

（2）JDK1.7：堆  挪到堆中，即在堆中单独划分了一块来存字符串常量

（3）JDK1.8：元空间   从堆中挪出，挪到一个“元空间meta space”，即类似于方法区。 元空间 

String对象怎么就不可变？

JDK8 `private final char value[];`

JDK11 `private final byte[] value;`	 

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

简单的String面试题

面试题：

**Q1:String是最基本的数据类型吗?**

**A：**
　　不是，Java基本数据类型只有8种，byte、short、int、long、float、double、char、boolean。

String(确实最常用）

**Q2："String、StringBuilder、StringBuffer的区别是什么？"**

**参考答案：**

1、可变性。String不可变，StringBuilder与StringBuffer是可变的。

- String类中使用只读字符数组保存字符串，private final char value[]，所以是不可变的（Java 9 中底层把 char 数组换成了 byte 数组，占用更少的空间)。
- StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，char[]value，这两种对象都是可变的。

可变性 String不可变 StringBuilder与StringBuffer是可变的

2、线程安全性。String和StrinbBuffer是线程安全的，StringBuilder是非线程安全的。

- String线程安全是因为其对象是不可变的，StringBuffer线程安全是因为对方法加了同步锁或者对调用的方法加了同步锁。
- StringBuilder并没有对方法进行加同步锁，所以是非线程安全的。

线程安全性 String和StringBuffer是线程安全的 StringBuilder是非线程安全的

3、性能。

- String的性能较差，因为每次对String 类型进行改变的时候，都会生成一个新的String对象，然后将指针指向新的String 对象。
- 而StringBuffer/StringBuilder性能更高，是因为每次都是对对象本身进行操作，而不是生成新的对象并改变对象引用。一般情况下StringBuilder 相比StringBuffer 可获得10%~15% 左右的性能提升。

String StringBuilder StringBuffer

- 如果要操作少量的数据用String；
- 单线程操作字符串缓冲区下操作大量数据StringBuilder；
- 多线程操作字符串缓冲区下操作大量数据StringBuffer；

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

哪些是空字符串demo 

```java
    @Test
    public void test07() {
        String s1; //局部变量未初始化
        String s2 = null;//初始化null
        String s3 = "";//空字符串常量对象
        String s4 = new String();//空字符串对象
        String s5 = new String("");//两个对象，一个是常量池中的，一个是堆中

//		System.out.println(s1);//无法使用  没初始化 error Error:(77, 36) java: 可能尚未初始化变量s1
//		System.out.println(s2.length());//空指针异常 java.lang.NullPointerException

        System.out.println(s3.length());//0
        System.out.println(s4.length());//0
        System.out.println(s5.length());//0
    }

```





2、如何判断某个字符串是否是空字符串

```java
if("".equals(str)) 推荐

if(str!=null  && str.isEmpty())

if(str!=null && str.equals(""))

if(str!=null && str.length()==0)
```



```java
    @Test
    public void test08() {
        String str = null;
        System.out.println(test(str));//false

        String str2 = "";
        System.out.println(test(str2));//true

        String str3 = new String();
        System.out.println(test(str3));//true
        
        String str4 = new String("");
        System.out.println(test(str4));//true
    }

    //判断str是否是空字符串，是就返回true，不是返回false
    public boolean test(String str) {
        if (str != null && str.isEmpty()) {
            return true;
        }
        return false;
    }
//    "".equals(str)  常量在前
	/*public boolean test(String str){
		if("".equals(str)){//推荐
			return true;
		}
		return false;
	}*/
	/*public boolean test(String str){
		if(str != null && str.equals("")){
			return true;
		}
		return false;
	}*/
/*	public boolean test(String str){
		if(str != null && str.length() == 0){
			return true;
		}
		return false;
	}*/
```



# 4、 字符串的对象的个数

1、字符串常量对象

```java
String str1 = "hello";//1个，在常量池中
```



2、字符串的普通对象

```java
String str2 = new String();//堆中的空字符串对象
String str22 = new String("");//常量池中的空字符串对象
//两个对象，一个是常量池中的空字符串对象，一个是堆中的空字符串对象
```

3、字符串的普通对象和常量对象一起

```java
String str3 = new String("hello");
//str3首先指向堆中的一个字符串对象，然后堆中字符串的value数组指向常量池中常量对象的value数组
```

JDK8

堆中的这个字符串对象char[]的value数组，指向常量池中"hello"的char[]的value

1、面试题

（1）String str = new String("hello");几个对象

```java
    @Test
    public void test02() {
        String str = new String("hello");//两个字符串对象
        //一个在常量池中：hello
        //另一个在堆中，String的对象
        //堆中的这个字符串对象char[]的value数组，指向常量池中"hello"的char[]的value
        System.out.println(str == "hello");//false
    }

```



（2）String str1 = new String("hello");

​		 String str2 = new String("hello");几个对象

```java
    @Test
    public void test03() {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);//false
        //这两行代码，几个对象？3个
        //常量池一个 其他 俩个对象的
        //hello  hello共享的
    }
```





# 5、 字符串拼接结果

拼接的结果在堆还是在常量池？

因为只有常量池中才是共享，==比较才为true

原则：

（1）常量+常量：结果是常量池

（2）常量与变量 或 变量与变量：结果是堆

（3）拼接后调用intern方法：结果在常量池  xx.intern()

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

java.lang.string String 类代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。

# 方法序列一: 一些简单的方法



（1）boolean isEmpty() 是否为空字符串 为空字符串返回true，其他为false (如果 length() 为 0，则返回 true；否则返回 false。)

（2）int length()：返回字符串的长度，返回的是字符的个数。

因为String的内部（JDK1.9之前）用char[]实现，这个长度就是value数组的长度，JDK 1.9 `private final byte[] value;`

（3）String toLowerCase()  转换为小写   将此 String 中的所有字符都转换为小写。

String toUpperCase() 转换为大写 将此 String 中的所有字符都转换为大写。

Demo

```java
@Test
	public void test1(){
		String str = "hello";
		String str2 = "";
		String str4 = new String();
		String str5 = new String("");
		System.out.println(str.isEmpty());//false
		System.out.println(str2.isEmpty());//true
		System.out.println(str4.isEmpty());//true
		System.out.println(str5.isEmpty());//true
		
		System.out.println(str.length());//5
		System.out.println(str2.length());//

		System.out.println(str.toUpperCase());//HELLO
		System.out.println(str.toUpperCase().toLowerCase());//hello

		String str3 = "WORLD";
		System.out.println(str3.toLowerCase());//world
		System.out.println("AbC".toLowerCase());//abc
	}
```

（4）String trim() ：去掉字符串的前后空白符

Demo

```java
	@Test
	public void test2(){
		String str = "    hello   world    ";
		System.out.println(str);//    hello   world
		str = str.trim();
		System.out.println("[" + str + "]");//[hello   world]
		String str2 = "a1 2 3 bc";
		System.out.println(str2);//a1 2 3 bc
		str2 = str2.trim();//如果没有前导和尾部空白，则返回此字符串。
		System.out.println(str2);//a1 2 3 bc
		String str3 = "";
		System.out.println(str3.trim());//
		String str4 = new String();
		System.out.println(str4.trim());//
		String str5 = new String();
		System.out.println(str5.trim());//
	}
```



（5）String concat()：拼接，等价于+

 String concat(String str)将指定字符串连接到此字符串的结尾。 
如果参数字符串的长度为 0，则返回此 String 对象。否则，创建一个新的 String 对象，用来表示由此 String 对象表示的字符序列和参数字符串表示的字符序列连接而成的字符序列。

str - 连接到此 String 结尾的 String。

```java
@Test
	public void test3(){
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1 + s2;
		System.out.println(s3);//helloworld
		String s4 = s1.concat(s2);
		System.out.println(s4);//helloworld
		System.out.println(s3 == s4);//false
		System.out.println(s3.equals(s4));//true
	}
```

# 方法系列二：和char相关

（1）char[] toCharArray()  将此字符串转换为一个新的**字符数组**。

返回：一个新分配的字符数组，它的长度是此字符串的长度，它的内容被初始化为包含此字符串表示的字符序列。

```java
    @Test
    public void test01() {
        String str = "HelloWorld";

        //统计大写字母的个数
        char[] arr = str.toCharArray();//将此字符串转换为一个新的**字符数组**。
        System.out.println(arr.length == str.length());//true
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                count++;
            }
        }
        System.out.println("大写字母的个数：" + count);//大写字母的个数：2
    }
```



（2）char charAt(index)

返回指定索引处的 char 值。索引范围为从 0 到 length() - 1。第一个 char 值位于索引 0 处。 
抛出： IndexOutOfBoundsException - 如果 index 参数为负或小于此字符串的长度。

```java
    @Test
    public void test02() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("请输入性别：");
//        String str = input.next();
		String str = "菜鸟中";
        char c = str.charAt(0);
        System.out.println(c);//"菜"

        String str2 = new String("我好呀");
        char s = str2.charAt(-1);//java.lang.StringIndexOutOfBoundsException: index -1,length 3
        System.out.println(s);
    }
```

（3）String(char[] arr)

分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。该字符数组的内容已被复制；后续对字符数组的修改不会影响新创建的字符串。

```java
 @Test
    public void test04() {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        String string = new String(arr);
        System.out.println(string);//hello
        arr = new char[]{'w', 'o', 'r', 'l', 'd'};
		System.out.println(arr);//world
        System.out.println(string);//hello
        System.out.println("hello".equals(string));//true

    }
```



（4）String(char[] arr,int offset, int count)

分配一个新的 String，它包含取自字符数组参数一个子数组的字符。offset 参数是子数组第一个字符的索引，count 参数指定子数组的长度。该子数组的内容已被复制；后续对字符数组的修改不会影响新创建的字符串。 

arr 字符数组 offset - 初始偏移量。count - 长度。 

抛出： IndexOutOfBoundsException - 如果 offset 和 count 参数索引字符超出 value 数组的范围。

```java
    @Test
    public void test05() {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        String string = new String(arr, 2, 3);//从[2]开始，取3个
        System.out.println(string);//llo

//		String string2 = new String(arr,-1,5);
		//java.lang.StringIndexOutOfBoundsException: offset -1, count 5, length 5
//		System.out.println(string2);
    }
```

# 方式系列三：和byte相关，或者说和编码与解码相关

（1）byte[]  getBytes()：编码的方法，使用平台默认的字符编码进行编的。

byte[] getBytes(Charset charset)，使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。 

```java
	@Test
	public void test01() throws UnsupportedEncodingException {
		String str = "a";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));//[97]
		
		String str2 = "牛菜鸡";
		byte[] bytes2 = str2.getBytes("UTF-8");
		System.out.println(bytes2);//[B@23fe1d71
		System.out.println(Arrays.toString(bytes2));//[-25, -119, -101, -24, -113, -100, -23, -72, -95]
		String str3 =new String(bytes2,"UTF-8");
		System.out.println(str3);//牛菜鸡
	}
	@Test
	public void test02(){
		String str = "abc";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));//[97, 98, 99]
	}

```



byte[]  getBytes(编码方式)：编码：对于ASCII码范围内（0~127），无论用什么编码方式，结果都是一样的，一个字符对应一个字节的编码值。对于其他的字符，编码，结果不一定是几个字节，例如汉字：

UTF-8：变长的，但是大多数汉字都是3个字节

GBK、GB2312：固定2个字节

ISO8859-1：不支持中文，所有字符都变为1个字节

（2）new String(字节数组)

new String(字节数组，编码方式)

String(byte[] bytes) 
          通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。 
String(byte[] bytes, Charset charset) 
          通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。 

编码：

 * 编码：
 * 	 把字符-->字节的过程，编给计算机用的
 * 解码：
 * 	把字节-->字符的过程，解给人看的

乱码：

 * 乱码：
 * （1）编码与解码字符集不一致
 * （2）缺字节boolean isEmpty() 是否是空字符串

```java
	@Test
	public void test03() throws UnsupportedEncodingException{
		String str = "菜鸟中";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));//[-24, -113, -100, -23, -72, -97, -28, -72, -83]
	
		String string = new String(bytes,"UTF-8");
		System.out.println(string);//菜鸟中
	}
	@Test
	public void test04() throws UnsupportedEncodingException{
		String str = "菜鸟中";
		byte[] bytes = str.getBytes("GBK");
		System.out.println(bytes.length);//6
		System.out.println(Arrays.toString(bytes));//[-78, -53, -60, -15, -42, -48]

		String string = new String(bytes,"GBK");
		System.out.println(string.length());//3
		System.out.println(string);//菜鸟中
	}
	@Test
	public void test05() throws UnsupportedEncodingException{
		String str = "菜鸟中";
		byte[] bytes = str.getBytes("ISO8859-1");
		System.out.println(bytes.length);//3
		System.out.println(Arrays.toString(bytes));//[63, 63, 63]
		
		String string = new String(bytes,"ISO8859-1");
		System.out.println(string.length());//3
		System.out.println(string);//???

	}
	
```

# 方法系列（4）：startsWith 前缀、endsWith 后缀

（1）boolean startsWith(String prefix)测试此字符串是否以指定的前缀开始。参数：prefix - 前缀。

如果参数表示的字符序列是此字符串表示的字符序列的前缀，则返回 true；否则返回 false。还要注意，如果参数是空字符串，或者等于此 String 对象（用 equals(Object) 方法确定），则返回 true。

```java
	@Test
	public void test1(){
		String name = "菜鸡文";
		if(name.startsWith("菜")){
			System.out.println("菜鸡文是菜家的人");
		}else{
			System.out.println("菜鸡文不是菜家人");
		}
		//菜鸡文是菜家的人
		System.out.println(name.startsWith(""));//true
		System.out.println(name.startsWith("菜鸡文"));//true
	}
```



（2） boolean endsWith(String suffix)测试此字符串是否以指定的后缀结束。 

参数：suffix - 后缀。 
返回：如果参数表示的字符序列是此对象表示的字符序列的后缀，则返回 true；否则返回 false。注意，如果参数是空字符串，或者等于此 String 对象（用 equals(Object) 方法确定），则结果为 true。

```java
	@Test
	public void test3(){
		String fileName = "Hello.class";
		if(fileName.endsWith(".java")){
			System.out.println("Java的源文件");
		}else if(fileName.endsWith(".class")){
			System.out.println("字节码文件");
		}
		//字节码文件
		System.out.println(fileName.endsWith(""));//true
		System.out.println(fileName.endsWith("Hello.class"));//true
	}
```

# 方法系列（5）：和查找有关

（1）是否包含

boolean contains(CharSequence s)

当且仅当此字符串包含指定的 char 值序列时，返回 true。 

参数：
s - 要搜索的序列 
返回：
如果此字符串包含 s，则返回 true，否则返回 false 
抛出： 
NullPointerException - 如果 s 为 null

```java
	@Test
	public void test01(){
		String str = "123.45";
		
		if(str.contains(".")){
			System.out.println("是小数");
		}
		System.out.println(str.contains(""));//true
		System.out.println(str.contains("12345"));//false
		System.out.println(str.contains("123"));//true
		System.out.println(str.contains("54"));//false
//		System.out.println(str.contains(null));//java.lang.NullPointerException
	}
```



（2）int indexOf(int ch)、index indexOf(String str):如果存在返回下标，如果不存在返回-1

在此对象表示的字符序列中第一次出现该字符的索引；如果未出现该字符，则返回 -1。

如果在此 String 对象表示的字符序列中出现值为 ch 的字符，则返回第一次出现该字符的索引（以 Unicode 代码单元表示）。

```java
	@Test
	public void test02(){
		String str = "123.45";
//		String str = "123";
		int index = str.indexOf(".");
		System.out.println(index);//3
		int index2 = str.indexOf("12");//0
		System.out.println(index2);
		int index3 = str.indexOf("54");
		System.out.println(index3);//-1
		int index4 = str.indexOf("A");
		System.out.println(index4);//-1
		int index5 = str.indexOf(0);
		System.out.println(index5);//-1
		int index6 = str.indexOf('1');
		System.out.println(index6);//0
		int index7 = str.indexOf('5');
		System.out.println(index7);//5

	}
```

int indexOf(int ch,int fromIndex)、int indexOf(String str,int fromIndex)返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。

参数：
ch - 一个字符（Unicode 代码点）。
fromIndex - 开始搜索的索引。 
返回：
在此对象表示的字符序列中第一次出现的大于或等于 fromIndex 的字符的索引；如果未出现该字符，则返回 -1。

```java
	@Test
	public void test04(){
		String str = "123.45";
//		String str = "123";
		int index = str.indexOf(".");
		System.out.println(index);//3
		int index2 = str.indexOf(".",3);
		System.out.println(index2);//3
		int index3 = str.indexOf(".",4);
		System.out.println(index3);//-1
		int index4 = str.indexOf(1,0);
		System.out.println(index4);//-1
		int index5 = str.indexOf('1',0);
		System.out.println(index5);//0
	}
```



（3）int lastIndexOf(xx)：如果存在返回最后一个的下标，如果不存在返回-1

在此对象表示的字符序列中最后一次出现该字符的索引；如果未出现该字符，则返回 -1。

int lastIndexOf(xxx,int fromIndex)  在此对象表示的字符序列（小于等于 fromIndex）中最后一次出现该字符的索引；如果在该点之前未出现该字符，则返回 -1。

```java
	@Test
	public void test03(){
		String fileName = "Hello.java.txt";
		//文件的后缀名是什么
		//截取文件的后缀名
		//(1)第一步，找到最后一个.的位置
		int index = fileName.lastIndexOf(".");
		System.out.println(index);//10
	}
```

# 方法系列（6）：截取

* (1)String substring(int beginIndex)：从字符串的[beginIndex]截取到最后

返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。

参数：
beginIndex - 起始索引（包括）。 
返回：
指定的子字符串。 
抛出： 
IndexOutOfBoundsException - 如果 beginIndex 为负或大于此 String 对象的长度。

 * (2)String substring(int beginIndex, int endIndex)：截取字符串的[beginIndex,endIndex)部分

返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。 

参数：
beginIndex - 起始索引（包括）。
endIndex - 结束索引（不包括）。 
返回：
指定的子字符串。 
抛出： 
IndexOutOfBoundsException - 如果 beginIndex 为负，或 endIndex 大于此 String 对象的长度，或 beginIndex 大于 endIndex。



```java
	@Test
	public void test03(){
		String fileName = "Hello.java.txt";
		//文件的后缀名是什么  .txt 
		//截取文件的后缀名
		//(1)第一步，找到最后一个.的位置
		int index = fileName.lastIndexOf(".");

		//(2)截取
		String sub = fileName.substring(index);
		System.out.println(sub);
	}
```



```java
	@Test
	public void test04(){
		String str = "helloworldjava";
		String sub = str.substring(2, 6);
		System.out.println(sub);//llow
		String str2 = "你好呀最近怎么样呢";
		String sub2 = str2.substring(1,3);
		System.out.println(sub2);//好呀
	}
```



# 方法系列（7）：匹配规则

* boolean matches(正则表达式)

  告知此字符串是否匹配给定的正则表达式。 

  参数：
  regex - 用来匹配此字符串的正则表达式 
  返回：
  当且仅当此字符串匹配给定的正则表达式时，返回 true 
  抛出： 
  PatternSyntaxException - 如果正则表达式的语法无效

 * 正则表达式：用于检测文本的格式

 * 校验某个字符串是否符合xx规则

 * 例如：电话号码

 * 甚至可以校验是否是移动号...

 * 银行卡号

 * 邮箱格式

 * 		....



```java
	@Test
	public void test1(){
		String str = "123456789";
		
		//判断它是否全部由数字组成，并且第1位不能是0，长度为9位
		//第一位不能是0，那么数字[1-9]
		//接下来8位的数字，那么[0-9]{8}+
		boolean flag = str.matches("[1-9][0-9]{8}+");
		System.out.println(flag);//true
	}
```



```java
	@Test
	public void test2(){
		String str = "12a345";
		//简单判断是否全部是数字，这个数字可以是1~n位
		
		//正则不是Java的语法，它是独立与Java的规则
		//在正则中\是表示转义，
		//同时在Java中\也是转义
		boolean flag = str.matches("\\d+");
		System.out.println(flag);//false
	}
```





# 方法系列（8）：替换

* 方法系列（8）：替换
 * （1）String replace(target, replacement)

使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。该替换从字符串的开头朝末尾执行，例如，用 "b" 替换字符串 "aaa" 中的 "aa" 将生成 "ba" 而不是 "ab"。 

参数：
target - 要被替换的 char 值序列
replacement - char 值的替换序列 
返回：
所得 String 
抛出： 
NullPointerException - 如果 target 或 replacement 为 null。

 * （2）String replaceAll(String regex, String replacement)

使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。 

 * （3）String replaceFirst(String regex, String replacement)

使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。

参数：
regex - 用来匹配此字符串的正则表达式
replacement - 用来替换每个匹配项的字符串 
返回：
所得 String 
抛出： 
PatternSyntaxException - 如果正则表达式的语法无效

 

 * 其中（2）和（3）支持正则

replace

```java
	@Test
	public void test1(){
		String str = "飞出个未来，计算灵光点。";
		str = str.replace("未来", "**");
		System.out.println(str);//飞出个**，计算灵光点。
	}
```

replaceFirst

```java
	@Test
	public void test2(){
		String str = "飞出个未来，计算灵光点，码出个未来。";
		str = str.replaceFirst("未来", "***");
		System.out.println(str);
	}
	
```

replaceAll

```java
	@Test
	public void test3(){
		String str = "飞出个未来，计算灵光点，码出个未来。";
		str = str.replaceAll("未来", "***");
		System.out.println(str);//飞出个***，计算灵光点，码出个***。
	}
```

replaceAll("[^a-zA-Z]", "")

```java
	@Test
	public void test4(){
		String str = "ABC码出个未来abc;123";
		//把其中的非字母去掉
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println(str);
	}
```



# 方法系列（9）：拆分

String[] split(xx)

根据给定正则表达式的匹配拆分此字符串。 

参数：
regex - 定界正则表达式 
返回：
字符串数组，它是根据给定正则表达式的匹配拆分此字符串确定的 
抛出： 
PatternSyntaxException - 如果正则表达式的语法无效

```java
	@Test
	public void test1(){
		String str = "Hello World java 菜鸡 菜牛";
		String[] all = str.split(" ");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		//Hello
		//World
		//java
		//菜鸡
		//菜牛
	}
```



```java
	@Test
	public void test2(){
		String str = "1Hello2World3java4菜鸡";
		str = str.replaceFirst("\\d", "");
		System.out.println(str);
		String[] all = str.split("\\d");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		//Hello2World3java4菜鸡
		//Hello
		//World
		//java
		//菜鸡
	}
```



```java
	@Test
	public void test3(){
		String str = "1Hello2World3java4菜鸡5";
		str = str.replaceAll("^\\d|\\d$", "");
		String[] all = str.split("\\d");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		//Hello
		//World
		//java
		//菜鸡
	}
```



```java
/*
 * 方法系列（9）：拆分
 * String[] split(xx)
 */
public class TestMethod9 {
    @Test
    public void test4() {
        String str = "张三.23|李四.24|王五.25";
        //|在正则中是有特殊意义，我这里要把它当做普通的|
        String[] all = str.split("\\|");

        //转成一个一个学生对象
        Student[] students = new Student[all.length];
        for (int i = 0; i < students.length; i++) {
            //.在正则中是特殊意义，我这里想要表示普通的.
            String[] strings = all[i].split("\\.");//张三,  23
            String name = strings[0];
            int age = Integer.parseInt(strings[1]);
            students[i] = new Student(name, age);
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        //Student [name=张三, age=23]
        //Student [name=李四, age=24]
        //Student [name=王五, age=25]

    }

    @Test
    public void test3() {
        String str = "1Hello2World3java4菜鸡5";
        str = str.replaceAll("^\\d|\\d$", "");
        String[] all = str.split("\\d");
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //Hello
        //World
        //java
        //菜鸡
    }

    @Test
    public void test2() {
        String str = "1Hello2World3java4菜鸡";
        str = str.replaceFirst("\\d", "");
        System.out.println(str);
        String[] all = str.split("\\d");
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //Hello2World3java4菜鸡
        //Hello
        //World
        //java
        //菜鸡
    }


    @Test
    public void test1() {
        String str = "Hello World java 菜鸡 菜牛";
        String[] all = str.split(" ");
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //Hello
        //World
        //java
        //菜鸡
        //菜牛
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Student() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

}
```



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

字符串的兄弟类

String：不可变对象。一旦修改就会有新对象。

引入：可变字符序列，StringBuffer和StringBuilder

StringBuilder默认的char[]长度为16；不够了，扩容为原来的2倍+2

不够了 扩容为原来的2倍+2

1、可变字符序列：StringBuilder和StringBuffer

StringBuffer：老的，线程安全的（因为它的方法有synchronized修饰）

StringBuilder：线程不安全的 ，JDK1.5引入

2、面试题：String和StringBuilder、StringBuffer的区别？

String：不可变对象，不可变字符序列

StringBuilder、StringBuffer： 可变字符序列



3、常用的API，StringBuilder、StringBuffer的API是完全一致的



 * 方法：
 * （1）append(xx)：拼接，连接
 * （2）insert(index,xxx)：在index位置插入xx
 * （3）delete(int start, int end)：删除[start,end)范围内
 * （4）deleteCharAt(int index)：删除[index]位置
 * （5）reverse()：反转
 * （6）setCharAt(int index, char ch)：替换[index]位置的字符为ch
 * （7）setLength(int newLength) 
 * （8）substring(int start, int end)：截取
 * （9）indexOf(String str) 
 （10）lastIndexOf(String str)
 .....

StringBuilder

```java
	@Test
	public void test1(){
		StringBuilder s = new StringBuilder();
		s.append("hello").append(12345).append('a').append(false).append("菜鸡文");
		System.out.println(s);//hello12345afalse菜鸡文
		System.out.println(s.length());//19
	}
```



```java
	@Test
	public void test3(){
		StringBuilder s = new StringBuilder("helloworld");
		s.delete(1, 3);
		System.out.println(s);
		s.deleteCharAt(4);
		System.out.println(s);
	}
```

delete 移除此序列的子字符串中的字符。该子字符串从指定的 start 处开始，一直到索引 end - 1 处的字符，如果不存在这种字符，则一直到序列尾部。如果 start 等于 end，则不发生任何更改。 

start - 起始索引（包含）。
end - 结束索引（不包含）。 



```java
	@Test
	public void test4(){
		StringBuilder s = new StringBuilder("helloworld");
		s.reverse();
		System.out.println(s);//dlrowolleh
	}
```



```java
	@Test
	public void test5(){
		StringBuilder s = new StringBuilder("helloworld");
		System.out.println(s);//helloworld
		s.setCharAt(2, 'a');
		System.out.println(s);//healoworld
	}
```



```java
	@Test
	public void test6(){
		StringBuilder s = new StringBuilder("helloworld");
		System.out.println(s);//helloworld
		s.setLength(30);
		System.out.println(s);//helloworld
		System.out.println(s.length());//30
		s.setLength(5);
		System.out.println(s);//hello
	}
```



```java
/*
 * Runtime：JVM运行时环境
 * Runtime是一个单例的实现
 */
public class TestTime {
	public static void main(String[] args) {
//		testStringBuilder();
		testStringBuffer();
//		testString();
	}
	public static void testString(){
		long start = System.currentTimeMillis();
		String s = new String("0");
		for(int i=1;i<=10000;i++){
			s += i;
		}
		long end = System.currentTimeMillis();
		System.out.println("String拼接+用时："+(end-start));//444
		
		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("String拼接+memory占用内存: " + memory);//53185144字节
	}
	public static void testStringBuilder(){
		long start = System.currentTimeMillis();
		StringBuilder s = new StringBuilder("0");
		for(int i=1;i<=10000;i++){
			s.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("StringBuilder拼接+用时："+(end-start));//4
		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("StringBuilder拼接+memory占用内存: " + memory);//1950488
	}
	public static void testStringBuffer(){
		long start = System.currentTimeMillis();
		StringBuffer s = new StringBuffer("0");
		for(int i=1;i<=10000;i++){
			s.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("StringBuffer拼接+用时："+(end-start));//7
		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("StringBuffer拼接+memory占用内存: " + memory);//1950488
	}
}

```



```java
StringBuffer拼接+用时：3
StringBuffer拼接+memory占用内存: 3038560
```

StringBuilder  StringBuffer  拼接

单线程     共享多线程



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

