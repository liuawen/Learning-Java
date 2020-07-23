# day07_课后练习

# 属性基础练习

## 第1题

案例：

​	声明员工类Employee，包含属性：编号、姓名、年龄、薪资，创建2个员工对象，并为属性赋值，并打印两个员工的信息。

![1558849379468](imgs/1558849379468.png)

## 第2题

案例：

​	声明一个日期类MyDate，包含属性：年、月、日，创建3个日期对象，一个是你的出生日期，一个是来尚硅谷的日期，一个是毕业的日期，并打印显示



## 第3题

案例：

​	声明公民类Citizen，包含属性：姓名，生日，身份证号，其中姓名是String类型，生日是MyDate类型，身份证号也是String类型。创建你们家庭成员的几个对象，并打印信息。

# 方法基础练习

## 第4题：

案例：

​	声明一个日期类MyDate，包含属性：年、月、日，并在MyDate类中声明几个方法：

1、boolean isLeapYear()：判断当前日期的是闰年吗？

2、void set(int y, int m, int d)：修改年，月，日为新日期



## 第5题：

案例：

​	声明一个三角形类Triangle，包含属性：a,b,c，表示三条边，并在Triangle类中声明几个方法：

1、boolean  isRightTriangle()：判断是否是一个直角三角形

2、boolean isIsoscelesTriangle()：判断是否是一个等腰三角形

3、boolean isEquilateralTriangle()：判断是否是一个等边三角形

4、double getArea()：根据三条边，用海伦公式求面积

5、double getLength()：求周长



## 第6题：

案例：

​	声明一个数学计算工具类MathTools，包含如下方法：

1、int add(int a, int b)：求a+b

2、int subtract(int a,int b)：求a-b

3、int mutiply(int a, int b)：求a*b

4、int divide(int a, int b)：求a/b

5、int remainder(int a, int b)：求a%b

6、int max(int a, int b)：求a和b中的最大值

7、int min(int a, int b)：求a和b中的最小值

8、boolean equals(int a, int b)：判断a和b是否相等

9、boolean isEven(int a)：判断a是否是偶数

10、boolean isPrimeNumer(int a)：判断a是否是素数

11、int round(double d)：返回d的四舍五入后的整数值



## 第7题：

案例：

​	声明一个数组管理工具类MyArrays，包含如下方法：

1、void sort(int[] arr)：可以为任意一维整型数组arr实现从小到大排序

2、int indexOf(int[] arr, int value)：可以在任意一维整型数组arr中查找value值的下标，如果不存在返回-1

3、int[] copy(int[] arr, int len)：可以实现从任意一维数组arr中复制一个新数组返回，新数组的长度为len，从arr[0]开始复制



## 第8题：

案例：

​	声明一个常识工具类CommonsTools，包含如下方法：

1、String getWeekName(int week)：根据星期值，返回对应的英语单词

2、String getMonthName(int month)：根据月份值，返回对应的英语单词

3、int getTotalDaysOfMonth(int year, int month)：返回某年某月的总天数

4、int getTotalDaysOfYear(int year)：获取某年的总天数

5、boolean isLeapYear(int year)：判断某年是否是闰年

