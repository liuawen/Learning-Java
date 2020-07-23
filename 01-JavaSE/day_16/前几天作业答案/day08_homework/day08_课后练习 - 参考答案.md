# day08_课后练习

# 基础练习

## 第1题

知识点：方法的声明与调用、方法的重载

案例：

​	声明一个图形工具类GraphicTools，包含如下方法：

1、void printRectangle()：该方法打印5行5列*矩形

2、void printRectangle(int line, int column, String sign)：该方法打印line行colomn列由sign组成的矩形

3、double getTriangleArea(double base, double height)：根据底边和底边对应的高求三角形面积

4、double getTriangleArea(double a, double b, double c)：根据三角形的三条边求三角形面积，如果a,b,c不能组成三角形，返回0.0

```java
public class GraphicTools {
	void printRectangle() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	void printRectangle(int line, int column, String sign) {
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j <= column; j++) {
				System.out.print(sign);
			}
			System.out.println();
		}
	}

	double getTriangleArea(double base, double height) {
		return base * height / 2;
	}

	double getTriangleArea(double a, double b, double c) {
		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
}

```

```java
public class Test01 {
	public static void main(String[] args) {
		GraphicTools tools = new GraphicTools();

		tools.printRectangle();
		System.out.println("--------------------------");

		tools.printRectangle(5, 10, "#");
		System.out.println("--------------------------");

		System.out.println("底边为3，高为4的三角形面积：" + tools.getTriangleArea(3, 4));
		System.out.println("边为3，4，5的三角形面积：" + tools.getTriangleArea(3, 4, 5));
	}
}
```



## 第2题

知识点：方法的重载

案例：

​	声明一个数组工具类MyArrays，包含如下方法：

1、int  binarySearch(int[]  arr,  int  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

2、int  binarySearch(char[]  arr,  char  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

3、int  binarySearch(double[]  arr,  double  value)：使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确

4、int[]  copy(int[] arr , int length)：从指定的arr数组的arr[0]开始复制得到一个新数组，新数组的长度为length。

5、double[]  copy(double[] arr , int length)：从指定的arr数组的arr[0]开始复制得到一个新数组，新数组的长度为length。

6、char[]  copy(char[] arr , int length)：从指定的arr数组的arr[0]开始复制得到一个新数组，新数组的长度为length。

7、void sort(int[] arr)：可以给arr数组从小到大排序，用冒泡排序实现

8、void sort(char[] arr)：可以给arr数组从小到大排序，用冒泡排序实现

9、void sort(double[] arr)：可以给arr数组从小到大排序，用冒泡排序实现

10、void print(int[] arr)：打印数组元素，效果如：[3,4,2,1,5]

11、void print(double[] arr)：：打印数组元素，效果如：[3.0,4.9,2.0,1.0,5.0]

12、void print(char[] arr)：：打印数组元素，效果如：['h','e','l','l','o']

```java
public class MyArrays {
	public int binarySearch(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		int mid = (left + right) / 2;

		while (left <= right) {
			if (arr[mid] == value) {
				return mid;
			} else if (value > arr[mid]) {
				left = mid + 1;
			} else if (value < arr[mid]) {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return -1;
	}
	
	public int binarySearch(char[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		int mid = (left + right) / 2;

		while (left <= right) {
			if (arr[mid] == value) {
				return mid;
			} else if (value > arr[mid]) {
				left = mid + 1;
			} else if (value < arr[mid]) {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return -1;
	}
	
	public int binarySearch(double[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		int mid = (left + right) / 2;

		while (left <= right) {
			if (arr[mid] == value) {
				return mid;
			} else if (value > arr[mid]) {
				left = mid + 1;
			} else if (value < arr[mid]) {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return -1;
	}

	public int[] copy(int[] arr, int length) {
		// (1)创建新数组
		int[] newArr = new int[length];

		// (2)复制元素
		for (int i = 0; i < arr.length && i < newArr.length; i++) {
			newArr[i] = arr[i];
		}

		return newArr;
	}
	public double[] copy(double[] arr, int length) {
		// (1)创建新数组
		double[] newArr = new double[length];

		// (2)复制元素
		for (int i = 0; i < arr.length && i < newArr.length; i++) {
			newArr[i] = arr[i];
		}

		return newArr;
	}
	public char[] copy(char[] arr, int length) {
		// (1)创建新数组
		char[] newArr = new char[length];

		// (2)复制元素
		for (int i = 0; i < arr.length && i < newArr.length; i++) {
			newArr[i] = arr[i];
		}

		return newArr;
	}
	

	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	public void sort(double[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	public void sort(char[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					char temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
    	public void print(int[] arr){
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if(i==0){
				System.out.print(arr[i]);
			}else{
				System.out.print("," + arr[i]);
			}
		}
		System.out.println("]");
	}
	public void print(double[] arr){
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if(i==0){
				System.out.print(arr[i]);
			}else{
				System.out.print("," + arr[i]);
			}
		}
		System.out.println("]");
	}
	public void print(char[] arr){
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if(i==0){
				System.out.print(arr[i]);
			}else{
				System.out.print("," + arr[i]);
			}
		}
		System.out.println("]");
	}
}

```

```
public class Test02 {

	public static void main(String[] args) {
		int[] arr = {3,4,2,7,1};
		
		MyArrays my = new MyArrays();
		my.print(arr);
		System.out.println("1在数组中的下标：" + my.binarySearch(arr, 1));//结果错误，因为数组无序
		
		my.sort(arr);
		my.print(arr);
		System.out.println("1在数组中的下标：" + my.binarySearch(arr, 1));
		
		my.print(my.copy(arr, 10));
	}

}

```



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

```java
public class Test03 {
	public static void main(String[] args){
		int num = 1;
		//doubleNumber(x);
		num = doubleNumber(num);
		System.out.println("x = " + num);
		
		char c = 'a';
		//toUpperCase(c);
		c = toUpperCase(c);
		System.out.println(c);
		
		Circle c1 = new Circle();
		c1.radius = 1.0;
		
		expandCircle(c1, 5);
		System.out.println("半径：" + c1.radius);
		
		int[] arr = {3,4,2,7,1};
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		String str = "hello";
		//concatAtguigu(str);
		str = concatAtguigu(str);
		System.out.println(str);
	}
    /*
    不能
    public static  void  doubleNumber(int num){
		num *= 2;
	}*/
	/*偷梁换柱
	public static  void  doubleNumber(int x){
		x *= 2;
		System.out.println("x = " + x);
		System.exit(0);
	}*/
	public static int doubleNumber(int num){
		return num*2;
	}
	
	/*不能
	public static void toUpperCase(char letter){
		letter = (char)(letter - 32);
	}*/
	public static char toUpperCase(char letter){
		return (char)(letter - 32);
	}
	
	public static void expandCircle(Circle  c,double times){
		c.radius *= times;
	}
	
	public static void sort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	//尝试在str后面拼接“atguigu"字符串，看是否可以将给str赋值的实参字符串变量也修改了，
	//为什么，如果不能，那怎么解决？
	//不能，因为String类型比较特殊，它的对象是不可变对象，一旦修改（包括拼接）就会产生新对象
	//public static void concatAtguigu(String str){
	//	str += "atguigu";//str修改后会指向新对象，就不是原来的实参的那个字符串对象了
	//}
	public static String concatAtguigu(String str){
		return str += "atguigu";
	}
}
```



## 第4题

知识点：可变参数

案例：

​	在Test04类中，声明如下方法：

1、public static long  sum(int...  nums)：求0~n个整数的累加和，如果没有传参，就返回0

2、public static int max(int a, int... others)：求1~n个整数中的最大值

3、public static String concat(String...  str)：求0~n个字符串的拼接结果

4、public static boolean isEven(int... even)：判断0~n个整数是否都是偶数，如果都是偶数，返回true，否则返回false

5、public static void main(String[] args)：以上方法在main中调用测试

```java
public class Test04 {
	public static void main(String[] args) {
		System.out.println("1,2,3,4,5的总和：" + sum(1,2,3,4,5));
		System.out.println("3,4,2,1的最大值是：" + max(3,4,2,1));
		System.out.println("尚，硅，谷，好拼接的结果：" + concat("尚","硅","谷","好"));
		System.out.println("2,4,6,8是否都是偶数：" + isEven(2,4,6,8));
	}
	
	public static long sum(int...  nums){
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
	
	public static int max(int a, int... others){
		int max = a;
		for (int i = 0; i < others.length; i++) {
			if(others[i] > max){
				max = others[i];
			}
		}
		return max;
	}
	
	public static String concat(String...  strings){
		String result = "";
		for (int i = 0; i < strings.length; i++) {
			result += strings[i];
		}
		return result;
	}
	
	public static boolean isEven(int... nums){
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]%2 !=0){
				return false;
			}
		}
		return true;
	}
}

```



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

```java
public class Employee {
	int id;
	String name;
	double salary;
	int age;
	
	void printInfo(){
		System.out.println("编号：" + id + "，姓名：" + name + "，薪资：" + salary + "，年龄：" +age);
	}
	void setInfo(int  i, String n, double s, int a){
		id = i;
		name = n;
		salary = s;
		age = a;
	}
}

```

```java
public class Test05 {
	public static void main(String[] args){
		Employee[] all = new Employee[5];
		all[0] = new Employee();
		all[0].setInfo(1,"张三",10000,23);
		
		all[1] = new Employee();
		all[1].setInfo(2,"李四",12000,23);
		
		all[2] = new Employee();
		all[2].setInfo(3,"王五",8000,18);
		
		all[3] = new Employee();
		all[3].setInfo(4,"赵六",6000,20);
		
		all[4] = new Employee();
		all[4].setInfo(5,"钱七",15000,21);
		
		print(all);
		sort(all);
		System.out.println("------------------------------------------");
		print(all);
		
		addSalary(all, 200);
		System.out.println("------------------------------------------");
		print(all);
	}
	
	public static void print(Employee[] all){
		for(int i=0; i<all.length; i++){
			all[i].printInfo();
		}
	}
	
	public static void sort(Employee[] all){
		for(int i=1; i<all.length; i++){
			for(int j=0; j<all.length-i; j++){
				//从高到低
				if(all[j].age < all[j+1].age){
					Employee temp = all[j];
					all[j] = all[j+1];
					all[j+1] = temp;
				}
			}
		}
	}
	
	public static void addSalary(Employee[] all, double increament){
		for(int i=0; i<all.length; i++){
			all[i].salary += increament;
		}
	}
}

```



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

```java
public class Rectangle {
	private double length;
	private double width;
	
	public Rectangle(){
		
	}
	public Rectangle(double chang, double kuan){
		length = chang;
		width = kuan;
	}
	
	public void setLength(double chang){
		length = chang;
	}
	public double getLength(){
		return length;
	}
	public void setWidth(double kuan){
		width = kuan;
	}
	public double getWidth(){
		return width;
	}
	
	public double getArea(){
		return length * width;
	}
	public double getPerimeter(){
		return 2 * (length + width);
	}
	public String getInfo(){
		return "长：" + length + "，宽：" + width + "，面积：" + getArea() + "，周长：" + getPerimeter(); 
	}
}

```

```java
public class Test06 {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.setLength(2);
		r1.setWidth(3);
		System.out.println(r1.getInfo());
		
		Rectangle r2 = new Rectangle(4,7);
		System.out.println(r2.getInfo());
	}

}

```



## 第7题

案例：

​	编写Test07类，在main方法中，

​	（1）创建一个Rectangle[]数组，长度为5

​	（2）并创建5个Rectangle的矩形对象，放到数组中，矩形的长和宽随机生成[0,10.0)范围内的值

​	（3）遍历显示

​	（4）按照面积从小到大排序

​	（5）再次遍历显示

```java
public class Test07 {
	public static void main(String[] args){
		Rectangle[] arr  = new Rectangle[5];
		for(int i=0; i<arr.length; i++){
			arr[i] = new Rectangle();
			double d1 = Math.random()*10;
			double d2 = Math.random()*10;
			arr[i].setLength(d1>d2?d1:d2);		
			arr[i].setWidth(d1<=d2?d1:d2);		
		}
		
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i].getInfo());
		}
		System.out.println("------------------------");
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<arr.length-i; j++){
				if(arr[j].getArea() > arr[j+1].getArea()){
					Rectangle temp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = temp;
				}
			}
		}
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i].getInfo());
		}
	}
}

```







