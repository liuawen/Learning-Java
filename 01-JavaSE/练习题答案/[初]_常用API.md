# 每日作业 - JavaSE第8天

## 题目1（训练）

现已知工人（Worker）类，属性包含姓名（name）、工龄（year），请编写该类，提供构造方法和get、set方法。在测试类中，请查看键盘录入Scanner类的API，创建工人类对象，属性值由键盘录入，打印对象的属性值。输出效果如下：

~~~java
请录入工人姓名：
张三
请录入工人工龄：
5
该工人对象的属性信息如下：
姓名：张三
工龄：5
~~~

### 训练目标

编写简单的java类，创建对象，查询API。

### 训练提示

1、怎样编写一个标准的描述工人的类？

2、创建工人对象时需要两个属性信息，由键盘录入，该使用哪个API？

3、创建对象之后，显示对象的属性信息，该调用哪个方法？

### 参考方案



### 训练步骤

1、创建Worker类，成员变量私有修饰，提供空参和全参构造方法，提供get和set方法。

2、创建Test01类，在主方法中，创建键盘录入Scanner对象。

​	2.1、姓名信息为字符串，使用Scanner的nextLine()方法。

​	2.2、工龄信息为整数，使用Scanner的nextInt()方法。

3、创建Worker类对象，并输出对象的成员变量值。

​	3.1、可以在创建对象时使用构造方法为成员变量赋值，也可以创建对象后使用set方法赋值。

​	3.2、获取成员变量的值，使用get方法。

### 参考答案

~~~java
public class Worker {
    // 成员变量
    private String name;
    private int year;

    // 构造方法
    public Worker() {

    }
    public Worker(String name, int age) {
        this.name = name;
        this.year = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

import java.util.Scanner;
public class Test01 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入工人姓名：");
        String name = sc.nextLine();
        System.out.println("请输入工人工龄：");
        int year = sc.nextInt();
        // 创建对象
        Worker w = new Worker(name, year);
        // 输出信息
        System.out.println("该工人对象的信息如下：");
        System.out.println("姓名：" + w.getName());
        System.out.println("工龄：" + w.getYear());
    }
}
~~~

## 题目2（应用）

在登录注册页面中，除了用户名和密码外，通常也会包含验证码。验证码是用来区分用户是计算机还是人，防止恶意破解密码、刷票、灌水等行为。请查看Random、StringBuilder相关API，定义方法，获取一个包含4个字符的验证码，每一位字符是随机选择的字母和数字，可包含a-z,A-Z,0-9。例如：

~~~java
7Kt5
~~~

### 训练目标

随机数类Random相关API、可变的字符序列StringBuilder相关API

### 训练提示

1、功能需要定义方法实现，方法的返回值是什么？需要参数列表吗？

2、先将可选择的字符都放到一个StringBuilder对象中。

3、怎样随机获取其中的四个字符呢？如果能随机获取一个，再获取四次，就可以了。那么怎样随机获取一个呢？我们知道，字符串中的字符是有索引的，如果可以随机获取到一个索引，就相当于随机获取到了该索引上的字符。

### 参考方案



### 训练步骤

1、定义方法，返回值是String，参数列表为空。

2、定义StringBuilder对象，将可选择的字符都放到StringBuilder对象中。

​	2.1、定义循环从a-z，使用StringBuilder的append方法依次添加所有小写字母

​	2.2、定义循环从A-Z，使用StringBuilder的append方法依次添加所有大写字母

​	2.3、定义循环从0-9，使用StringBuilder的append方法依次添加所有数字字符

3、创建Random对象。定义一个空字符串用于保存验证码。

4、定义一个执行4次的循环，用于获取4个字符。

​	4.1、在循环中，使用Random的nextInt方法，随机获取一个从索引0（包含）到字符串的长度（不包含）的索引。

​	4.2、使用StringBuilder的charAt方法，获取该索引上的字符，将其拼接到验证码字符串中。

5、返回结果，并在主方法中调用方法查看结果。

### 参考答案

~~~java
import java.util.Random;

public class Test02 {
    public static void main(String[] args) {
        String code = getRandomCode();
        System.out.println(code);
    }
    public static String getRandomCode() {
        // 准备数据，将可选择的字符都放入StringBuilder中
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            sb.append(ch);
        }
        for (char ch = '0'; ch <= '9'; ch++) {
            sb.append(ch);
        }
        // 随机获取四位
        Random r = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            // 字符串中的字符有索引，随机获取一个索引即相当于随机获取到了该索引的字符
            int index = r.nextInt(sb.length()); // 从索引0（包含）到字符串的长度（不包含）
            code += sb.charAt(index); // 获取该索引上的字符
        }
        // 返回结果
        return code;
    }
}
~~~

## 题目3（应用）

在登录注册页面中，除了用户名和密码外，通常也会包含验证码。验证码是用来区分用户是计算机还是人，防止恶意破解密码、刷票、灌水等行为。在判断验证码时一般不区分大小写。请编写程序模拟验证码的判断过程，如果输入正确，给出提示，结束程序。如果输入错误，给出提示，验证码刷新，重新输入，直至正确为止。

生成4位随机验证码的功能在之前的题目中已经完成，可以直接使用。《定义方法，获取一个包含4个字符的验证码，每一位字符是随机选择的字母和数字，可包含a-z,A-Z,0-9。》

运行效果如下：

~~~java
生成的验证码为：BkhD
请输入验证码
abcd
输入错误，请重新输入...
生成的验证码为：n1wX
请输入验证码
aaaa
输入错误，请重新输入...
生成的验证码为：Fm1a
请输入验证码
fm1a
输入正确
~~~

### 训练目标

字符串的判断功能

### 训练提示

1、先定义获取验证码的方法，完成获取验证码的功能。

2、根据题目要求，判断需要一直到输入正确为止，所以需要使用循环。

3、用户输入由键盘录入，需要创建键盘录入对象。

4、判断是否正确需要将用户输入的字符串与生成的验证码比较，但不区分大小写，所以该使用哪个方法呢？

5、判断相等，给出提示，结束循环。判断不相等，给出提示，进入下一次循环。

### 参考方案



### 训练步骤

1、定义方法，实现获取包含4个字符的随机验证码。（参考以前的练习）

2、创建键盘录入Scanner对象。

3、定义while循环，循环条件为true。

4、在循环内，获取程序生成的验证码，提示用户输入，调用Scanner对象的nextLine方法获取用户输入。

5、使用String的equalsIgnoreCase方法比较生成的验证码和用户输入，因为不区分大小写。

​	5.1、如果相等，给出输入正确的提示，使用break语句跳出循环。

​	5.2、如果不相等，给出输入错误的提示，继续下一次循环。

### 参考答案

```java
import java.util.Random;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        // 键盘录入对象
        Scanner sc = new Scanner(System.in);
        while (true) { // 不清楚输入多少次，定义死循环，输入正确时跳出即可。
            String code = getRandomCode();
            System.out.println("生成的验证码为：" + code);
            System.out.println("请输入验证码");
            String line = sc.nextLine();
            // 不区分大小写比较是否相等
            if (code.equalsIgnoreCase(line)) {
                System.out.println("输入正确");
                break; // 跳出循环，结束程序
            } else {
                System.out.println("输入错误，请重新输入...");
            }
        }
    }
    public static String getRandomCode() {
        // 准备数据
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            sb.append(ch);
        }
        for (char ch = '0'; ch <= '9'; ch++) {
            sb.append(ch);
        }
        // 随机获取四位
        Random r = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            // 字符串中的字符有索引，随机获取一个索引即相当于随机获取到了该索引的字符
            int index = r.nextInt(sb.length()); // 从索引0（包含）到字符串的长度（不包含）
            code += sb.charAt(index); // 获取该索引上的字符
        }
        // 返回结果
        return code;
    }
}
```

## 题目4（训练）

请编写程序，由键盘录入一个字符串，统计字符串中英文字母和数字分别有多少个。比如：Hello12345World中字母：10个，数字：5个。

### 训练目标

字符串遍历

### 训练提示

1、键盘录入一个字符串，用 Scanner 实现
2、要统计两种类型的字符个数，需定义两个统计变量，初始值都为0
3、遍历字符串，得到每一个字符
4、判断该字符属于哪种类型，然后对应类型的统计变量+1，判断字母时需要考虑大小写，条件比较复杂，怎样做才能使判断更简单呢？

### 参考方案

为方便判断并统计，可将字符串中的字符都转为大写或者都转为小写。

### 训练步骤

1、创建键盘录入Scanner对象，使用nextLine方法接收输入的字符串。

2、为方便后续判断，使用String的toLowerCase方法，将字符串中的字符都转为小写。

3、需定义两个统计变量，初始值都为0

4、遍历字符串，得到每一个字符

5、判断该字符属于哪种类型，然后对应类型的统计变量+1，次数判断英文字母时只需判断小写即可。

### 参考答案

~~~java
import java.util.Scanner;

public class Test07 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        // 为方便统计，将字符串中的字母都转为小写
        line = line.toLowerCase();
        //要统计两种类型的字符个数，需定义两个统计变量，初始值都为0
        int letterCount = 0;
        int numberCount = 0;
        // 遍历字符串，得到每一个字符
        for(int i=0; i<line.length(); i++) {
            char ch = line.charAt(i);
            // 判断该字符属于哪种类型，然后对应类型的统计变量+1
            if (ch >= 'a' && ch <= 'z') {
                letterCount++;
            } else if (ch >= '0' && ch <= '9') {
                numberCount++;
            }
        }
        //输出两种类型的字符个数
        System.out.println("英文字母：" + letterCount + "个");
        System.out.println("数字：" + numberCount + "个");
    }
}
~~~

## 题目5（应用）

请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。例如："abcba"、"上海自来水来自海上"均为对称字符串。

### 训练目标

字符串的反转功能，判断是否相等功能

### 训练提示

1、判断是否对称，方法的返回值是什么类型？参数列表是什么？

2、怎样判断对称呢？如果可以将字符串反转，反转后发现跟原来的字符串完全一样，不就可以判断出来了吗，那么哪个类有字符串的反转功能呢？

### 参考方案



### 训练步骤

1、定义方法，返回值类型为boolean，参数列表为String类型的一个参数。

2、将字符串转换为StringBuilder类型，调用StringBuilder的reverse()方法将字符串反转。

3、将反转后的字符串再转回String类型，并与原字符串比较，如果相等，返回true，否则返回false

4、在主方法中，定义一个字符串，调用方法测试结果。

### 参考答案

~~~java
public class Test05 {
    public static void main(String[] args) {
        String str = "上海自来水来自海上";
        System.out.println(isSym(str));
    }

    public static boolean isSym(String str) {
        // 为了程序的健壮，如果传递的是空值，返回false
        if (str == null) {
            return false;
        }
        // 转换为StringBuilder
        StringBuilder sb = new StringBuilder(str);
        // 反转，再转成String
        String reStr = sb.reverse().toString();
        // 比较与原字符串是否相等
        // 相等返回true，不相等返回false，正好与equals的返回值一致，直接返回即可。
        return reStr.equals(str);
    }
}
~~~

## 题目6（应用）

我国的居民身份证号码，由由十七位数字本体码和一位数字校验码组成。请定义方法判断用户输入的身份证号码是否合法，并在主方法中调用方法测试结果。规则为：号码为18位，不能以数字0开头，前17位只可以是数字，最后一位可以是数字或者大写字母X。

### 训练目标

字符串的遍历、判断

### 训练提示

1、要判断字符串是否符合规则，方法的返回值类型是什么？参数列表是什么？

2、使用String的API，对每种不符合条件的情况作出判断，一旦发现不符合条件就可以结束方法的执行，返回结果了。

3、在主方法中创建键盘录入，调用方法，输入各种数据测试结果。

### 参考方案

针对每种不符合条件的情况作出判断

### 训练步骤

1、定义方法，返回值类型为boolean表示是否合法，参数列表为String类型的id，表示要判断的数据。

2、对每种不符合条件的情况作出判断

​	2.1、如果字符串长度不是18，返回false。

​	2.2、如果字符串以数字"0"开头，返回false。

​	2.3、遍历字符串，获取每一位字符，判断前17位，如果不是数字，返回false，判断最后一位如果不是数字或者X，返回false

​	2.4、所以的不符合条件都筛选完成，返回true

3、在主方法中创建键盘录入Scanner对象，调用nextLine()方法，获取用户输入，调用方法，传递参数，查看结果。要多运行几次，判断各种不符合条件的数据。

### 参考答案

~~~java
import java.util.Scanner;
public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入身份证号：");
        String id = sc.nextLine();
        System.out.println(check(id));
    }

    // 返回值boolean类型，表示是否符合规则。参数列表：需要判断的字符串
    public static boolean check(String id) {
        // 如果传递了空参数，返回false
        if (id == null) {
            return false;
        }
        // 如果是数字0开头，返回false
        if (id.startsWith("0")) {
            return false;
        }
        // 如果不是18位，返回false
        if (id.length() != 18) {
            return false;
        }
        // 遍历判断每一位
        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);
            // 前17位都是数字,最后一位可以是数字或者大写字母X
            if (i == id.length() - 1) { // 最后一位
                if (ch < '0' || ch > '9' && ch != 'X') { // 不是数字或者X
                    return false;
                }
            } else { // 其他位
                if (ch < '0' || ch > '9') { // 不是数字
                    return false;
                }
            }
        }
        // 所有的规则都符合，返回true
        return true;
    }
}
~~~

## 题目7（练习）

定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，并在控制台输出结果。

要求：

​	1、如果传递的参数为空，返回null

​	2、如果传递的数组元素个数为0，返回[]

​	3、如果数组为int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]

### 训练目标

字符串的拼接

### 训练提示

1、定义方法的返回值是什么？参数列表是什么？

2、如果不做判断就对数组进行遍历，那么如果数组对象为空，会报出异常，怎样避免空指针异常呢？

3、拼接字符串必然涉及到频繁改变，该采用可变的字符序列StringBuilder比较好

4、遍历数组，按照题目格式拼接数组中的元素。

5、将字符串返回

6、在主方法中定义数组，并调用方法，打印结果

### 参考方案

使用StringBuilder拼接字符串

### 训练步骤

1、定义方法返回值类型：String，参数：int[] arr

2、判断对象如果为null，直接返回null

3、创建StringBuilder对象

4、遍历数组，按照要求进行拼接数组元素，如果是不是最后一个元素，还要拼接逗号和空格

5、将StringBuilder转为String返回

6、在主方法中定义数组，并调用方法，打印结果

### 参考答案

~~~java
public class Test07 {
    public static void main(String[] args) {
        // 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};
        // 调用方法，输出结果
        System.out.println(arrayToString(arr));
    }

    /*定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
		返回值类型：String
		参数：int[] arr
     */
    public static String arrayToString(int[] arr) {
        // 健壮性判断
        if (arr == null) {
            return null;
        }
        //在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            // 拼接元素
            sb.append(arr[i]);
            // 如果不是最后一个元素，再拼接逗号和空格
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
~~~



## 题目8（扩展）

在String类的API中，有如下两个方法：

~~~java
// 查找参数字符串str在调用方法的字符串中第一次出现的索引，如果不存在，返回-1
public int indexOf(String str)

// 截取字符串，从索引beginIndex（包含）开始到字符串的结尾
public String substring(int beginIndex)
~~~

请仔细阅读API中这两个方法的解释，完成如下需求。

现有如下文本："Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的"。请编写程序，统计该文本中"Java"一词出现的次数。

### 训练目标

String类API的灵活使用

### 训练提示

1、要找的子串是否存在，如果存在获取其出现的位置。这个可以使用indexOf完成。
2、如果找到了，那么就记录出现的位置并在剩余的字符串中继续查找该子串，而剩余字符串的起始位是出现位置再加上子串的长度。

3、以此类推，通过循环完成查找，如果找不到就是-1，每次找到用计数器记录次数。

### 参考方案

从左至右依次查找，将已查找的部分截取掉。

### 训练步骤

1、定义方法，返回值int表示次数，参数列表两个字符串，第一个表示在哪个字符串中查找，第二个表示要查找的目标子串

2、定义统计变量表示次数。

3、定义索引变量，表示每次找到子串出现的索引。

4、定义循环，判断条件为在字符串中找到了目标子串，使用indexOf实现。

5、如果找到的索引不是-1，在循环中，统计变量累加。

6、把查找过的部分剪切掉，从找到的索引+子串长度的位置开始截取，使用substring实现。

7、将次数返回

8、在主方法中，定义字符串表示题目中的文本，定义字符串表示要查找的子串，调用方法，获取结果。

### 参考答案

```java
public class Test08 {
    public static void main(String[] args) {
        String str = "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的";
        String tar = "Java";
        // 调用方法并输出
        System.out.println(search(str, tar));

    }
    // 返回值int表示次数，参数列表str表示在哪个字符串中查找，tar表示要查找的目标子串
    public static int search(String str, String tar) {
        // 定义统计变量表示次数
        int count = 0;
        // 定义索引变量，表示每次找到子串出现的索引
        int index = -1;
        // 定义循环，判断条件为在字符串中找到了目标子串
        while ((index = str.indexOf(tar)) != -1) { // 将找到的索引赋值给变量并判断
            // 次数累加
            count++;
            // 把查找过的部分剪切掉，从找到的索引+子串长度的位置开始截取。
            str = str.substring(index + tar.length());
        }
        return count;
    }
}
```

### 
