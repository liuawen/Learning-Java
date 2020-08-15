# 知识点

方法

## 题目1（训练）

定义一个方法，该方法能够找出两个小数中的较小值并返回。在主方法中调用方法进行测试。

### 训练提示

1. 根据方法的功能描述，方法的参数应该是两个小数。
2. 要返回两个小数的较小值，所以返回值类型也是小数类型。

### 解题方案

### 操作步骤

1. 定义方法getMin()，方法的参数是double a ，double b。
2. 在方法中对两个数字进行判断，返回较小值。
3. 在主方法中调用getMin()方法并接受返回值。
4. 在主方法中打印结果。

### 参考代码

```java
public class Demo1 {
    public static void main(String[] args) {
        //调用方法
        double min = getMin(3.14, 4.13);
        //打印结果
        System.out.println("较小值是" + min);
    }

    //定义求较小值的方法
    public static double getMin(double a ,double b){
        //对两个小数进行判断
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}
```

## 题目2（训练）

定义一个方法，该方法能够找出三个整数中的最大值并返回。在主方法中调用方法测试执行。

### 训练提示

1. 根据题意，方法中需要使用三个整数，所以方法参数应该是三个整数类型。
2. 方法需要有返回值，返回值的类型也是整数类型。

### 解题方案

### 操作步骤

1. 定义方法getMax()，方法的参数是三个int类型变量a,b,c，方法的返回值是int类型。
2. 在方法中使用多分支if...else...判断出最大值并返回。
3. 在主方法中调用getMax()方法并接受返回值。
4. 在主方法中打印结果。

### 参考代码

```java
public class Demo2 {
    public static void main(String[] args) {
        //调用方法传入参数
        int max = getMax(33, 44, 11);
        //打印最大值
        System.out.println("最大值是" + max);


    }
    //定义获取最大值的方法
    public static int getMax(int a ,int b ,int c){
        //判断出最大值并返回
        if(a > b && a > c){
            return a;
        }else if(b > a && b > c){
            return b;
        }else{
            return c;
        }
    }
}
```

## 题目3（训练）

通过键盘录入两个整数n和m。n代表行数，m代表列数。定义一个方法，方法的功能是打印n行m列的@符号。执行效果如下：

```
请输入行数：
4
请输入列数：
5
@@@@@
@@@@@
@@@@@
@@@@@
```

### 训练提示

1. 方法内需要知道行数和列数，所以参数应该是两个整数类型。
2. 方法不需要返回任何值，所以返回值类型应该是void。

### 解题方案

### 操作步骤

1. 创建键盘录入对象。
2. 通过键盘录入n的值代表行数，通过键盘录入m的值代表列数。
3. 定义print()方法，方法的参数是两个整数n和m,返回值类型是void。
4. 在方法中使用循环嵌套按照指定格式输出内容。
5. 在主方法中调用print方法，传入n和m两个参数。

### 参考答案

```java
public class Demo3 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //输入行数
        System.out.println("请输入行数：");
        int n = sc.nextInt();
        //输入列数
        System.out.println("请输入列数：");
        int m = sc.nextInt();
        //调用方法
        print(n,m);
    }
    //定义打印的方法
    public static void print(int n, int m){
        //循环输入n行
        for (int i = 0; i < n; i++) {
            //循环输出m列
            for (int j = 0; j < m; j++) {
                System.out.print("@");
            }
            //每一行的最后输出换行符
            System.out.println();
        }
    }
}
```

## 题目4（训练）

我们知道数学中有九九乘法表。请定义一个方法，方法的功能是打印nn乘法表。在主方法中键盘录入取值范围为[1-9]的变量n，测试方法。执行效果如下：

```
请输入一个1-9之间的整数：
4
乘法表：
1×1=1	
1×2=2	2×2=4	
1×3=3	2×3=6	3×3=9	
1×4=4	2×4=8	3×4=12	4×4=16

```

### 训练提示

1. 方法需要一个整数变量n,那么方法的参数如何定义？
2. 方法的目的是做打印，那么方法的返回值类型是什么？

### 解题方案

### 操作步骤

1. 创建键盘录入对象。

2. 通过键盘输入一个整数变量n。

3. 定义乘法表的方法，方法参数是int类型参数n，返回值类型void。

   3.1. 方法内部定义嵌套循环，外层循环从1开始，到n结束，代表打印n行。

   3.2.内层循环从1开始，到i结束，代表每行打印i个式子。

   3.3.每行最后打印换行。

4. 在主方法中对方法进行调用。

### 参考答案

```java
public class Demo4 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //键盘录入一个整数
        System.out.println("请输入一个1-9之间的整数：");
        int n = sc.nextInt();
		//调用方法
        method(n);
    }
	//定义乘法表方法
    public static void method(int n) {
        System.out.println("乘法表：");
        //外层循环n次
        for (int i = 1; i <= n; i++) {
            //内存循环i次
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" +j*i + "\t");
            }
            //每行结尾执行换行
            System.out.println();
        }
    }
}
```

## 题目5（训练）

在主方法中通过键盘录入三个整数。定义一个方法，方法接收三个整数变量，在方法中从大到小依次打印三个变量。执行效果如下：

```
请输入第一个整数：10
请输入第二个整数：30
请输入第三个整数：20
从大到小的顺序是： 30 20 10 
```

### 训练提示

1. 方法需要接受三个整数，那么方法的形式参数如何定义？
2. 方法没有返回值的需求，返回值类型是什么？

### 解题方案

### 操作步骤

1. 使用键盘录入分别录入三个整数。

2. 定义method方法，方法的参数是三个int类型，方法的返回值类型是void。

   2.1. 定义整数变量max用于存储最大值，定义min变量用于存储最小值。

   2.2. 使用if..else..多分支判断语句计算三个整数中的最大值并赋值给max。

   2.3. 使用if..else..多分支判断语句计算三个整数中的最小值并赋值给min。

   2.4. 定义变量mid代表中间数,三个整数的和减去max,再减去min,就是中间数的值。

   2.5. 依次打印最大值，中间值和最小值。

3. 在主方法中调用method方法，传入参数。

### 参考答案

```java
public class Demo5 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //分别输入三个整数
        System.out.println("请输入第一个整数:");
        int a = sc.nextInt();
        System.out.println("请输入第二个整数:");
        int b = sc.nextInt();
        System.out.println("请输入第三个整数:");
        int c = sc.nextInt();
        //调用方法
        method(a,b,c);
    }

    //定义方法
    public static void method(int a, int b, int c) {
        //定义变量存储最大值
        int max = 0;
        //定义变量存储最小值
        int min = 0;
        //判断最大值
        if(a > b && a > c ){
            max = a;
        }else if(b > a && b > c){
            max = b;
        }else{
            max = c;
        }
        //判断最小值
        if(a < b && a < c ){
            min = a;
        }else if(b < a && b < c){
            min = b;
        }else{
            min = c;
        }
        //计算中间值
        int mid = a + b + c - max - min;
        //按照从大到小的顺序输出
        System.out.println("从大到小的顺序是：" + max + " "+ mid + " " + min);
    }
}
```

## 题目6（训练）

数字是有绝对值的，负数的绝对值是它本身取反，非负数的绝对值是它本身。请定义一个方法，方法能够得到小数类型数字的绝对值并返回。请定义方法并测试。

### 训练提示

1. 方法的功能是得到一个小数的绝对值，参数应该是一个小数类型。
2. 绝对值需要被返回，返回值类型应该也是小数类型。

### 解题方案

### 操作步骤

1. 定义一个小数变量num。

2. 定义获取绝对值的方法，方法的参数是一个double类型，返回值类型是double。

3. 在方法内部使用if..else..判断。

   3.1. 如果是负数则对负数取反并返回。

   3.2. 如果不是负数则直接返回数字本身。

4. 在主方法中调用绝对值方法，传入参数num,并接受返回值。
5. 打印返回的结果。

### 参考答案

```java
public class Demo6 {
    public static void main(String[] args) {
        double num = -3.14;
        //调用方法
        double abs = abs(num);
        //打印结果
        System.out.println(num +"的绝对值是" + abs);
    }
    //定义绝对值方法
    public static double abs(double num){
        if(num < 0){
            //如果数字是负数则取反
            return -num;
        }else{
            //如果是非负数则返回本身
            return num;
        }
    }
}
```

## 题目7（综合）

请定义一个方法，对正数的小数进行四舍五入的操作(不考虑负数情况)。四舍五入之后的结果是一个int整数类型并返回。最后对方法进行测试。

### 训练提示

1. 要求对小数进行操作，方法的参数类型是一个小数类型。
2. 操作之后的结果是int整数，那么返回值类型是int类型。
3. 四舍五入的操作关键是十分位(小数第一位)，如何获取十分位？

### 解题方案

### 操作步骤

1. 定义一个正数的小数数字num。
2. 定义四舍五入的方法，方法的参数是一个double类型num，返回值类型是int类型。
3. 将小数乘以10后强转为int,再对10取余，能过获取到十分位数字，赋值给int类型变量a。
4. 对a进行判断，如果a小于4则把num强转为int并返回(舍去小数)。
5. 如果a大于等于5则把num强转为int后再加一并返回(相当于进一位)。
6. 在主方法中调用四舍五入方法，传入参数num，并接收返回值。
7. 打印返回的结果。

### 参考答案

```java
public class Demo7 {
    public static void main(String[] args) {
        double num = 3.44;
        //调用方法
        int abs = round(num);
        //打印结果
        System.out.println(num +"四舍五入之后是" + abs);
    }
    //定义四舍五入方法
    public static int round(double num){
        //将小数乘以10后强转为int,再对10取余，能过获取到十分位(小数第一位)
        int a = (int)(num * 10) % 10;
        if(a < 5){
            //如果a小于5,则四舍
            return (int)num;
        }else{
            //如果a大于等于5,则五入
                return (int)num + 1;
        }
    }
}
```

## 题目8（综合扩展）

一个大V直播抽奖，奖品是现金红包，分别有{2,588,888,1000,10000}五个奖金。请使用代码模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。打印效果如下：（随机顺序，不一定是下面的顺序）

```
888元的奖金被抽出
588元的奖金被抽出
10000元的奖金被抽出
1000元的奖金被抽出
2元的奖金被抽出
```

### 训练提示

1. 奖项要随机出现，但奖金不是连续的数字，不能被随机产生。能随机产生的只有数组的索引了，可以使用随机索引来代表随机元素。因为索引和元素是一一对应的，
2. 哪些奖被抽过了，哪些奖没有被抽过，要定义一个数组来存放已经被抽过的奖项。
3. 每个奖项只能被抽出一次，要写一个方法来控制奖项不重复。

### 解题方案

​	使用数组存放多个奖金，再使用另一个数组存放已经被抽过的奖金，使用方法来判断某个奖金是否已经被抽取过。

### 操作步骤

1. 定义奖金的数组arr。
2. 定义数组brr准备存放已经被抽过的奖金，两个数组长度相同。
3. 定义一个变量index,用户代表数组brr的索引。
4. 定义方法，判断数组中是否存在某数字，存在返回true,不存在返回false。
5. 写一个while循环，如果index<arr.length则说明奖项没有被抽完继续抽取。
6. 在循环中使用随机数产生一个随机索引i。
7. 使用步骤4的方法判断brr数组中是否包含arr[i]奖金。
8. 如果不包含，则打印arr[i]奖金，并且把它放入brr数组中代表已经被抽取过，同时index加一。

### 参考答案

```java
public class Demo8 {
    public static void main(String[] args) {
        //1.定义存放奖金的数组
        int[] arr = {10000,1000,588,888,2};
        //2.定义数组存放已经被取过的奖金
        int[] brr = new int[5];
        //3.定义变量表示brr的索引
        int index = 0;
        //4.创建随机数对象
        Random r = new Random();
        //5.定义循环反复获取随机数,如果index小于arr的长度则继续循环
        while(index < arr.length){
            //5.1每次生成一个随机索引对应一个奖金
            int i = r.nextInt(arr.length);
            //5.2调用方法判断这个奖金是否被获取过
            boolean b = exist(brr, arr[i]);
            //5.3b是false代表这个奖金没有被抽取过
            if(!b) {
                //5.4把获取之后的奖金存放到brr中
                brr[index] = arr[i];
                //5.5index索引向后移动一次
                index++;
                //5.6打印本次被抽出的奖项
                System.out.println( arr[i] + "元的奖金被抽出");
            }
        }
    }
    //6.定义方法：判断brr数组中是否存在num这个数字
    public static boolean exist(int[] brr,int num){
        //6.1对数组进行遍历
        for (int i = 0; i < brr.length; i++) {
            //6.2判断如果找到数字，则返回true
            if(brr[i] == num){
                return true;
            }
        }
        //6.3如果最终没有找到则返回false
        return false;
    }
}
```

