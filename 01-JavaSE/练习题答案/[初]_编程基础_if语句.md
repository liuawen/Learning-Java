# 知识点

if判断语句

## 题目1（训练）

李雷想买一个价值7988元的新手机，她的旧手机在二手市场能卖1500元，而手机专卖店推出以旧换新的优惠，把她的旧手机交给店家，新手机就能够打8折优惠。为了更省钱，李雷要不要以旧换新？请在控制台输出。

### 训练提示

1. 用什么知识点能够对不同购买方式的价格做判断？

### 解题方案

1. 使用if...else语句判断

### 操作步骤

1. 计算不使用以旧换新时的花费。
2. 计算使用以旧换新时的花费。
3. 使用if..else语句判断哪种方式更省钱，并输出结果

### 参考答案

```java
public class Demo1 {
    public static void main(String[] args) {
        //1.计算不使用以旧换新的花费
        int money1 = 7988 - 1500;
        //2.计算以旧换新的花费
        double money2 = 7988 * 0.8;
        //3.判断两种方式
        if(money1 > money2){
            System.out.println("使用以旧换新更省钱");
        }else{
            System.out.println("不使用以旧换新更省钱");
        }
    }
}
```

## 题目2（训练）

让用户依次录入三个整数，求出三个数中的最小值，并打印到控制台。

### 训练提示

1. 如何完成用户录入？
2. 求最小值需要用到什么知识点？

### 解题方案

1. 使用Scanner完成键盘录入，使用if..else的嵌套完全判断

2. 使用Scanner完成键盘录入，使用多条件的if...else完成判断

   以下解题以方案2为准

### 操作步骤

1. 使用三次键盘录入的方法让用户输入三个整数
2. 使用多条件的if...else判断三个数大小关系的各种情况求出最小值
3. 打印输出最小值

### 参考答案

```java
//1.导包
import java.util.Scanner;
public class Demo2 {
    public static void main(String[] args) {
        //2.创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //3.分别录入三个数字
        System.out.println("请输入第一个整数：");
        int i = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int j = sc.nextInt();
        System.out.println("请输入第三个整数：");
        int k = sc.nextInt();
        //4.定义变量代表最小值
        int min;
        //5.对三个整数进行判断
        if( i < j && i < k){
            min = i;
        }else if( j < i && j < k){
            min = j;
        }else{
            min = k;
        }
        //6.打印最小值
        System.out.println("最小值是" + min);
    }
}
```

## 题目3（综合）

某银行推出了整存整取定期储蓄业务，其存期分为一年、两年、三年、五年，到期凭存单支取本息。存款年利率表如下：

​	存期		年利率（%）

​	一年		2.25

​	两年		2.7

​	三年		3.25

​	五年		3.6

请存入一定金额（1000起存），存一定年限（四选一），计算到期后得到的本息总额。

提示：

​	存入金额和存入年限均由键盘录入

​	本息计算方式：本金+本金×年利率×年限

### 训练提示

1. 使用什么方式让用户输入内容？
2. 使用哪种if语句的格式对信息作出判断？

### 解题方案

1. 使用Scanner和if..else...的嵌套操作。

### 操作步骤

1. 键盘录入金额和年份。
2. 使用多条件if...else判断年份，计算本息金额。
3. 输出结果。

### 参考答案

```java
//1.导包
import java.util.Scanner;
public class Demo3 {
    public static void main(String[] args) {
        // 2.创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // 3.调用方法获取键盘录入的本金和存取年限
        System.out.println("请输入存款金额：");
        int money = sc.nextInt();
        System.out.println("请输入存款年限：");
        int year = sc.nextInt();
        // 4.定义本息和的变量
        double outMoney = 0;
        // 5.根据利率和年限计算本息和
        if (year == 1) {
            outMoney = money + money * 2.25 / 100 * 1;
        } else if (year == 2) {
            outMoney = money + money * 2.7 / 100 * 2;
        } else if (year == 3) {
            outMoney = money + money * 3.25 / 100 * 3;
        } else if (year == 5) {
            outMoney = money + money * 3.6 / 100 * 5;
        } else {
            System.out.println("输入的年限有误");
        }
        // 6.打印输出
        System.out.println("存款" + year + "年后的本息是：" + outMoney);
    }
}
```

## 题目4（综合）

某商场购物可以打折，具体规则如下：

​	普通顾客购不满100元不打折，满100元打9折；

​	会员购物不满200元打8折，满200元打7.5折；

​	不同打折规则不累加计算。

请根据此优惠计划进行购物结算，键盘录入顾客的类别（0表示普通顾客，1表示会员）和购物的折前金额（整数即可），输出应付金额（小数类型）。

### 训练提示

1. 使用什么方式让用户输入内容？
2. 使用哪种if语句的格式对信息作出判断？

### 解题方案

1. 使用Scanner键盘录入和if..else判断语句的嵌套使用来完成。

### 操作步骤

1. 键盘录入会员类别和购物金额。
2. 先使用if-else判断顾客类别。
3. 在不同的顾客类别中再使用if-else语句判断购物金额。
4. 输出结果。

### 参考答案

```java
//1.导包
import java.util.Scanner;
public class Demo4 {
    public static void main(String[] args) {
        // 2.创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // 3.调用方法获取键盘录入的顾客类别和购物金额
        System.out.println("请输入顾客类别（0表示普通顾客，1表示会员顾客）：");
        int type = sc.nextInt();
        System.out.println("请输入购物金额：");
        int money = sc.nextInt();
        // 4.先判断顾客类别
        if (type == 0) {
            // 4.1.普通顾客，再判断购物金额
            if (money > 0 && money < 100) {
                System.out.println("您的应付金额为：" + money);
            } else if (money >= 100) {
                System.out.println("您的应付金额为：" + money * 0.9);
            } else {
                System.out.println("您输入的金额有误");
            }
        } else if (type == 1) {
            // 4.2.会员顾客，再判断购物金额
            if (money > 0 && money < 200) {
                System.out.println("您的应付金额为：" + money * 0.8);
            } else if (money >= 200) {
                System.out.println("您的应付金额为：" + money * 0.75);
            } else {
                System.out.println("您输入的金额有误");
            }
        } else {
            System.out.println("您输入的顾客类别有误");
        }
    }
}
```

## 题目5（综合扩展）

2019年1月1日起，国家推出新的个人所得税政策，起征点上调值5000元。也就是说税前工资扣除三险一金（三险一金数额假设是税前工资的10%）后如果不足5000元，则不交税。如果大于5000元，那么大于5000元的部分按梯度交税，具体梯度比例如下：

​	0 ~ 3000元的部分，交税3%			

​	3000 ~ 12000元的部分，交税10%

​	12000 ~ 25000的部分 ， 交税20%		

​	25000 ~ 35000的部分，交税25%

​	35000 ~ 55000的部分，交税30%		

​	55000 ~ 80000的部分，交税35%

​	超过80000的部分，交税45%

比如：黑马某学员入职一家企业后，税前工资是15000，则他每月该交个税的部分是15000-1500-5000=8500元，个税缴纳数额是3000×3%+5500×10%=640元。税后工资12860元。

请完成一个个税计算程序，在用户输入税前工资后，计算出他对应的纳税数额，以及税后工资为多少？

### 训练提示

1. 工资的哪些部分是属于要纳税部分，如何计算？
2. 纳税比例有很多区间，用什么知识点能够对应多个区间？
3. 每个区间的纳税数额是多少，计算的规律是什么？

### 解题方案

1. 使用多条件的if...else对应各个纳税梯度，分别计算每一个梯度的纳税数额。

### 操作步骤

1. 提示用户输入税前工资，使用键盘录入让用户输入一个整数。
2. 计算工资中应交税部分。也就是去除三险一金和起征点数额。
3. 使用多条件if..else..对每个区间分别判断，用每个梯度的计算公式求出对应的纳税数额。
4. 根据求出的纳税数额求出税后工资。

### 参考答案

```java
//1.导包
import java.util.Scanner;
public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的税前工资：");
        //2.键盘录入税前工资
        int money = sc.nextInt();
        //3.计算应纳税部分的工资
        double before = money - (money*0.1) - 5000;
        //4.定义个税变量
        double shui = 0;
        //5.按照梯度范围计算个税数值
        if(before > 0 && before <=3000){
            shui = before * 0.03;
        }else if(before > 3000 && before <=12000){
            shui = 3000*0.03 + (before-3000) * 0.1;
        }else if(before > 12000 && before <=25000){
            shui = 3000*0.03 + 9000*0.1 +  (before-12000)*0.2;
        }else if(before > 25000 && before <=35000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + (before-25000)*0.25;
        }else if(before > 35000 && before <=55000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + 10000*0.25 + (before-35000)*0.3;
        }else if(before > 55000 && before <=80000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + 10000*0.25 + 20000*0.3 + (before-55000)*0.35;
        }else if(before > 80000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + 10000*0.25 + 20000*0.3 + 25000*0.35 + (before-80000)*0.45;
        }
        //6.计算税后工资
        double after = money - (money*0.1) - shui;
        //7.打印个税和税后工资
        System.out.println("个人所得税" + shui + "元");
        System.out.println("税后工资" + after + "元");
    }
}
```
