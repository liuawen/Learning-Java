
# 基础题目

## 第一题：语法练习

* 语法点：运算符，while，if

* 按步骤编写代码，效果如图所示：

  ![](img\1.jpg)

* 编写步骤：

  1. 定义类 Test1
  2. 定义 main方法
  3. 定义变量i为0,i2为10
  4. 使用第一个while循环,当条件为`i小于5` 时,则进入循环
  5. 循环内,i自增,i2自增
  6. 循环内,使用if判断,当`i大于等于 2 ` 并且` i2小于15` 时,同时输出i和i2的值
  7. 使用第二个while循环,当条件为`i2小于20` 时,则进入循环
  8. 循环内,i自增,i2自增
  9. 循环内,使用if判断,当`i大于8 ` 或者`i2小于等于18` 时,同时输出i和i2的值


* 参考答案：

  ```java
  public class Test1 {
      public static void main(String[] args) {
          // 定义变量i为0,i2为10
          int i = 0;
          int i2 = 10;
  		// 使用第一个while循环,当条件为i小于5时,则进入循环
          while (i < 5) {
              // 循环内,i自增,i2自增
              i++;
              i2++;
              // 使用if判断,当i大于等于 2 并且i2小于15 时,同时输出i和i2的值
              if (i >= 2 && i2 < 15) {
                  System.out.println("i:" + i + ", i2:" + i2);
              }
          }

          System.out.println("-----------------------");
          // 使用第二个while循环,当条件为i2小于20 时,则进入循环
          while (i2 < 20) {
              // 循环内,i自增,i2自增
              i++;
              i2++;
              // 循环内,使用if判断,当i大于8 或者i2小于等于18 时,同时输出i和i2的值
              if (i > 8 || i2 <= 18) {
                  System.out.println("i:" + i + ", i2:" + i2);
              }
          }
      }
  }
  ```

## 第二题：语法练习

* 语法点：变量，运算符，if

* 按步骤编写代码，效果如图所示：

  ![](img\2.jpg)

* 编写步骤：

  1. 定义类 Test2
  2. 定义 main方法
  3. 定义变量 discount为1, totalPrice为550
  4. 判断当`totalPrice >=500` ,discount赋值为0.5
  5. 判断当`totalPrice >=400` 且`<500`时,discount赋值为0.6
  6. 判断当`totalPrice >=300` 且`<400`时,discount赋值为0.7
  7. 判断当`totalPrice >=200` 且`<300`时,discount赋值为0.8
  8. 输出totalPrice.
  9. 输出totalPrice 与 discount 的积


* 参考答案：

  ```java

  public class Test2 {
      public static void main(String[] args) {

          // 定义变量 discount为1, totalPrice为550
          double discount = 1 ;
          int totalPrice = 550;
          // 判断当totalPrice >=500 ,discount赋值为0.5
          if (totalPrice >= 500){
              discount = 0.5;
          }else  if (totalPrice >=400 && totalPrice < 500) {
              // 判断当totalPrice >=400 且<500时,discount赋值为0.6
              discount = 0.6;
          } else if (totalPrice >=300 && totalPrice < 400) {
              // 判断当totalPrice >=300 且<400时,discount赋值为0.7
              discount = 0.7;
          } else if (totalPrice >= 200 && totalPrice < 300) {
              // 判断当totalPrice >=200 且<300时,discount赋值为0.8
              discount = 0.8;
          }
          // 输出totalPrice.
          System.out.println("totalPrice:"+totalPrice);
          // 输出totalPrice 与 discount 的积
          System.out.println("totalPrice的discount:"+(totalPrice*discount));

      }
  }
  ```

## 第三题：语法练习

* 语法点：运算符，for，while

* 按步骤编写代码，效果如图所示：

  ![](img\3.jpg)

* 编写步骤

  1. 定义类 Test3
  2. 定义 main方法
  3. 使用for循环,初始化变量r为10,当`r>0`时,进入循环
  4. for循环内,定义变量c,赋值为r
  5. for循环内,使用while循环,当`c>=0`时,输出c,再将c减2赋值给c
  6. for循环内,while循环外,r除以c赋值给r


* 参考答案：

  ```java
  public class Test3 {
      public static void main(String[] args) {
          // 使用for循环,初始化变量r为10,当r>0时,进入循环
          for (int r = 10; r > 0; ) {
              // for循环内,定义变量c,赋值为r
              int c = r;
              // or循环内,使用while循环,当c>=0时,输出c,再将c减2赋值给c
              while (c >= 0) {
                  System.out.print(c + " ");
                  c -= 2;
              }
              // for循环内,while循环外,r除以c赋值给r
              r /= c;
          }
      }
  }
  ```

## 第四题：语法练习

* 语法点：方法，运算符，for，while 

* 按步骤编写代码，效果如图所示：

  ![](img\8.jpg)

* 编写步骤

1. 定义类 Test4，定义 main方法
2. main方法中,定义int类型变量 a为10,b为20,c为30
3. 定义 method1方法, 定义变量a为-5,变量b为--a,判断a为偶数,则a赋值为++b,否则b赋值为--a.打印a,b
4. 定义 method2方法, 定义变量a为0,使用while循环,判断a<=5,进入循环.
5. while循环内部,使用for循环,初始化int类型变量b为1,当b<=5时进入循环, 步进表达式b++
6. for循环内,不换行输出i并拼接" "
7. for循环外,输出换行.
8. j自增.
9. main方法调用method1方法,method2方法
10. 输出a,b,c

* 参考答案：

  ```java
  public class Test4 {
      public static void main(String[] args) {
          // 3.main方法中,定义int类型变量 a为10,b为20,c为30
          int a = 10, b = 20, c = 30;
           // 调用 method1
          method1();
          // 调用 method2
          method2();
    
          System.out.println();
          System.out.println(a);
          System.out.println(b);
          System.out.println(c);
    
      }
      // 定义 method2方法, 定义变量a为0,使用while循环,判断a<=5,进入循环.
      private static void method2() {
          int a = 0;
          // while循环内部,使用for循环,初始化int类型变量b为1,当b<=5时进入循环, 步进表达式b++
          while (a <= 5) {
              // for循环内,不换行输出i并拼接" "
              for (int b = 1; b <= 5; b++) {
                  System.out.print(b + " ");
              }
              // for循环外,输出换行.
              System.out.println();
              // a自增.
              a++;
          }
          System.out.println("----------");
      }
    
      // 定义 method1方法, 定义变量a为-5,变量b为--a,判断a为偶数,则a赋值为++b,否则b赋值为--a.打印a,b
      public static void method1() {
          int a = -5;
          int b = --a;
    
          if (a % 2 == 0) {
              a = ++b;
          } else {
              b = --a;
          }
          System.out.println(a);
          System.out.println(b);
          System.out.println("----------");
      }
  }
  ```

## 第五题：语法练习

* 语法点：运算符，for，if

* 按步骤编写代码，效果如图所示：

  ![](img\5.jpg)

* 编写步骤

  1. 定义类 Test5
  2. 定义 main方法
  3. 定义变量jj为20,a为0,b为0
  4. 使用for循环,初始化值ii为0,当`ii<jj` 时进入循环,步进表达式为ii+=2,jj自减
  5. 循环内,使用if判断ii被3整除,ii赋值给a,并输出ii拼接"Hello"
  6. 不被3整除,ii赋值给b,并输出ii拼接"World"
  7. 循环外,按照格式,打印a与b的乘积


* 参考答案：

  ```java
  public class Test5 {
      public static void main(String[] args) {
          // 定义变量jj为20,a为0,b为0
          int jj = 20;
          int a = 0;
          int b = 0;
          // 使用for循环,初始化值ii为0,当ii<jj时进入循环,步进表达式为ii+=2,jj自减
          for (int ii = 0; ii < jj ; ii+=2,jj--) {
              // 循环内,使用if判断ii被3整除,ii赋值为a,并输出ii与"Hello"
              if (ii %  3 ==0 ){
                  a = ii;
                  System.out.println(ii +" Hello");
              }else {
                  // 不被3整除,ii赋值为b,并输出ii与"World"
                  b = jj;
                  System.out.println(ii + "  World");
              }
          }
          // 循环外,按照格式,打印a与b的乘积
          System.out.println("a*b的值:" +a+"*"+b +"=" + a * b);
      }
  }

  ```

## 第六题：语法练习

* 语法点：字符串，for，switch

* 按步骤编写代码，效果如图所示：

  ![](img\6.jpg)

* 编写步骤：

  1. 定义类 Test6
  2. 定义 main方法
  3. 定义字符串遍历 str,赋值为J
  4. 使用for循环,初始化变量i = 0,如果i<5进入循环,步进表达式i++
  5. for循环内部,嵌套定义变量key ,赋值为i%3;
  6. 定义switch语句 ,表达式为key.
  7. case 为0时,str拼接字符'a',i++后,break
  8. case 为2时,str拼接字符'V'
  9. 循环结束后,输出str


* 参考答案：

  ```java
  public class Test6 {
      public static void main(String[] args) {

          // 定义字符串遍历 str,赋值为J
          String str  = "J";
          // 使用for循环,初始化变量i = 0,如果i<5进入循环,步进表达式i++
          for (  int i = 0 ; i < 5;i++) {
              // for循环内部,嵌套定义变量key ,赋值为i%3;
            int  key  = i % 3;
            // 定义switch语句 ,表达式为key.
              switch (key) {
                  // case 为0时,str拼接字符'a',i++后,break
                  case 0:
                      str +='a';
                      i++;
                      break;
                  //case 为2时,str拼接字符'V'
                  case 2:
                      str +='V';

              }
          }
          // 循环结束后,输出str
          System.out.println(str);
      }
  }
  ```

## 第七题：语法练习

* 语法点：do-while，if

* 按步骤编写代码，效果如图所示：

  ![](img\7.jpg)

* 编写步骤

  1. 定义类 Test7
  2. 定义 main方法
  3. 定义boolean类型变量,bVar为false,bVar1为true
  4. 定义int类型变量,count 为 8
  5. 使用do ... while 格式,do代码块中,输出"Hello Java!"拼接count的字符串
  6. do代码块中,使用if判断,如果count大于等于7,则bVar1赋值为false,count自减,否则count+=3.
  7. while中,当bVar与bVar1值相等并且count小于9的时候,进入循环


* 参考答案：

  ```java
  public class Test7 {
          public static void main(String[] args) {
              // 定义boolean类型变量,bVar为false,bVar1为true
              boolean bVar = false;
              boolean bVar1 = true;
              // 定义int类型变量,count 为 8
              int count =8;
              // 使用do ... while 格式,do代码块中,输出"Hello Java!"拼接count的
              do {
                  // do代码块中,使用if判断,如果count大于等于7,则bVar1赋值为false,count自减,否则count+=3.
                  System.out.println("Hello Java! " +count);
                  if (count >= 7) {
                      bVar1 = false;
                      count--;
                  }else {
                      count += 3;
                  }

                  // while中,当bVar与bVar1值相等并且count小于9的时候,进入循环
              } while (bVar == bVar1 && count < 9);

          }
    }
  ```

