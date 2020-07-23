# day08_课后练习

# 基础练习

## 第1题

知识点：方法的声明与调用、方法的重载

案例：

​	声明一个图形工具类，包含如下方法：

1、void printRectangle()：该方法打印5行5列*矩形

2、void printRectangle(int line, int column, String sign)：该方法打印line行colomn列由sign组成的矩形

3、double getTriangleArea(double base, double height)：根据底边和底边对应的高求三角形面积

4、double getTriangleArea(double a, double b, double c)：根据三角形的三条边求三角形面积，如果a,b,c不能组成三角形，返回0.0



## 第2题

知识点：方法的重载

案例：

​	声明一个数组工具类，包含如下方法：

1、int  binarySearch(int[]  arr,  int  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

2、int  binarySearch(char[]  arr,  char  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

3、int  binarySearch(double[]  arr,  double  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

4、int  copy(int[] arr , int length)：从指定的arr数组的arr[0]开始复制得到一个新数组，新数组的长度为length。

5、int  copy(double[] arr , int length)：从指定的arr数组的arr[0]开始复制得到一个新数组，新数组的长度为length。

6、int  copy(char[] arr , int length)：从指定的arr数组的arr[0]开始复制得到一个新数组，新数组的长度为length。

7、void sort(int[] arr)：可以给arr数组从小到大排序，用冒泡排序实现

，。

8、void sort(char[] arr)：可以给arr数组从小到大排序，用冒泡排序实现

9、void sort(double[] arr)：可以给arr数组从小到大排序，用冒泡排序实现



## 第3题

知识点：方法的参数传递机制

案例：

​	在Test03类中，声明如下方法，并体会方法的参数传递机制：

1、public static  void  doubleNumber(int num)：尝试将num变为原来的2倍大，看是否可以将给num赋值的实参变量值也扩大2倍，为什么，如果不能，那怎么解决呢？

2、public static void toUpperCase(char letter)：尝试将letter的小写字母转为大写字母，看是否可以将给letter赋值的实参变量值也转为大写，为什么，如果不能，那怎么解决呢？

3、public static void expandCircle(Circle  c，double times)：尝试将Circle的c对象的半径扩大为原来的times倍，看是否可以将给c赋值的实参对象的半径也扩大times倍，为什么，如果不能，那怎么解决呢？

4、public static void sort(int[] arr)：尝试对arr数组实现从小到大排序，看是否可以将给arr赋值的实参数组也排序，为什么，如果不能，那怎么解决呢？

5、public static void concatAtguigu(String str)：尝试在str后面拼接“atguigu"字符串，看是否可以将给str赋值的实参字符串变量也修改了，为什么，如果不能，那怎么解决？

6、public static void main(String[] args)：以上方法在main中调用测试

要求：

1、实现代码

2、思考原因

3、画图分析



## 第4题

知识点：可变参数

案例：

​	在Test04类中，声明如下方法：

1、public static long  sum(int...  nums)：求0~n个整数的累加和，如果没有传参，就返回0

2、public static int max(int a, int... others)：求1~n个整数中的最大值

3、public static String concat(String...  str)：求0~n个字符串的拼接结果

4、public static boolean isEven(int... even)：判断0~n个整数是否都是偶数，如果都是偶数，返回true，否则返回false

5、public static void main(String[] args)：以上方法在main中调用测试



## 第5题

知识点：对象数组

案例：

​	1、声明一个Employee员工类，

​		包含属性：编号(id)、姓名(name)、薪资(salary)、年龄(age)

​		包含方法：

​		（1）void printInfo()：可以打印员工的详细信息

​		（2）void setInfo(int  i, String n, double s, int a)：可以同时给id,name,salary,age赋值

​	2、声明一个TestEmployee测试类，

​	（1）public static void main(String[] args)：在main方法中，创建Employee[]数组，并创建5个员工对象放到数组中，并为员工对象的属性赋值

​	（2）public static void print(Emplyee[] all)：遍历打印员工数组中的每个员工的详细信息，并在main中调用

​	（3）public static void sort(Employee[] all)：将all员工数组按照年龄从高到低排序，并在main中调用测试

​	（4）public static void addSalary(Employee[] all, double increament)：将all员工数组的每一个员工的工资，增加increament，并在main中调试测试



## 第6题

案例：

​	1、声明矩形类Rectangle

​	（1）包含属性：长和宽，要求属性私有化

​	（2）包含两个构造器：无参和有参

​	（3）给每一个属性提供get/set方法

​	（4）public double getArea()

​	（5）public double getPerimeter()

​	（6）提供getInfo()返回矩形对象的信息

​			例如：长：2，宽：3，面积：6，周长：10

​	2、测试类TestRectangle



## 第7题

案例：

​	编写Test07类，在main方法中，

​	（1）创建一个Rectangle[]数组，长度为5

​	（2）并创建5个Rectangle的矩形对象，放到数组中，矩形的长和宽随机生成[0,10.0]范围内的值

​	（3）遍历显示

​	（4）按照面积从小到大排序

​	（5）再次遍历显示

​	

