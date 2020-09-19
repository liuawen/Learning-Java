# 美团点评2017校园招聘算法笔试题

<!-- TOC -->
* [第一题:丢失的三个数](#第一题-丢失的三个数)
* [第二题:网格走法数目](#第二题-网格走法数目)
* [第三题:拼凑面额](#第三题-拼凑面额)
* [第四题:整数加法](#第四题-整数加法)
<!-- TOC -->


## 第一题 丢失的三个数

### 题目描述
>现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。

**输入描述:**
>输入数据为一行，包含9997个数字，空格隔开。

**输出描述:**
>输出为一行，包含一个数字。

**样例：**

**输入**
>同题设例子输入

**输入**
>2

### 解题思路

- 因为输入的数字都在1-10000以内且不重复，所以用一个10000长度的数组记录每个位置上的数组是否出现，等待全部输入后，遍历数组，找出未出现的三个数字。

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10001];
        for(int i=0;i<9997;i++){
            arr[in.nextInt()]++;
        }
        String res ="";
        int count=0;
        for(int i=1;i<=10000;i++){
            if(arr[i]==0){
                res +=i;
                count++;
            }
            if(count==3)
                break;
        }
        long ans = Long.parseLong(res);
        System.out.println(ans%7);
    }
}
```

## 第二题 网格走法数目

### 题目描述
>有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。

**输入描述:**
>输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。

**输出描述:**
>输出包括一行，为走法的数目。

**样例：**

**输入**
>3 2

**输入**
>10

### 解题思路

- 典型的组合数学问题，若是一个`X*Y`的网格，则总共要走`X+Y`步才能从左上角到右下角，共有多少种走法，即从`X+Y`步中选择`X`步向下走，共有多少种选法。
<div align="center">
<img src="https://raw.githubusercontent.com/LyricYang/Internet-Recruiting-Algorithm-Problems/master/InternetRecruitingAlgorithmProblems/MEITUAN/pic/Q2Y2017.png" /></div>

### 参考代码
```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();
        long res = 1;
        long mod = 1;
        int th = Math.min(X,Y);
        for(int i=1;i<=th;i++){
            res*=(X+Y-i+1);
            mod*=i;
        }
        System.out.println(res/mod);
    }
}
```

## 第三题 拼凑面额

### 题目描述
>给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。

**输入描述:**
>输入为一个数字N，即需要拼凑的面额

**输出描述:**
>输出也是一个数字，为组成N的组合个数。

**样例：**

**输入**
>5

**输入**
>2

### 解题思路

- [动态规划](https://blog.csdn.net/weixin_40255793/article/details/79634651)

### 参考代码
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[] m = {1, 5, 10, 20, 50, 100}; // 保存基本面额的数组
        long[] data = new long[num+1]; // 保存计算数据的数组
        for(int i = 0; i <= num; i++) // 边界条件A(n,1) = 1 (n>=0)
            data[i] = 1;
        for(int i = 1; i < 6; i++) // 基本面额从5开始，因为1元情况在数组初始化时已经写入了
            for(int n = 1; n <= num; n++) // n从1开始，保证了边界条件A(0,m)=1 (m=1,5,10,20,50,100)
                if(n >= m[i])
                    data[n] += data[n - m[i]]; // 状态转移方程
        System.out.println(data[num]);
        in.close();
    }
}
```

## 第四题 整数加法

### 题目描述
>请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回error

**输入描述:**
>输入为一行，包含两个字符串，字符串的长度在[1,100]。

**输出描述:**
>输出为一行。合法情况输出相加结果，非法情况输出error

**样例：**

**输入**
>123 123
abd 123

**输入**
>246
Error

### 解题思路

- 大整数加法，每个位置上相加，同时加上进位数。

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] L = in.nextLine().split(" ");
        String res = add(L[0],L[1]);
        System.out.println(res);
    }
    
    public static String add(String s1,String s2){
        int index1=s1.length()-1;
        int index2=s2.length()-1;
        StringBuilder res = new StringBuilder();
        int c=0;
        int sum=0;
        while(index1>=0&&index2>=0){
            if(s1.charAt(index1)<'0'||s1.charAt(index1)>'9'||
               s2.charAt(index2)<'0'||s2.charAt(index2)>'9'){
                return "error";
            }else{
                sum=s1.charAt(index1)-'0'+s2.charAt(index2)-'0'+c;
                c=sum/10;
                res.append(sum%10);
                index1--;
                index2--;
            }
        }
        while(index1>=0){
            if(s1.charAt(index1)<'0'||s1.charAt(index1)>'9'){
                return "error";
            }else{
                sum=s1.charAt(index1)-'0'+c;
                c=sum/10;
                res.append(sum%10);
                index1--;
            }
        }
        while(index2>=0){
            if(s2.charAt(index2)<'0'||s2.charAt(index2)>'9'){
                return "error";
            }else{
                sum=s2.charAt(index1)-'0'+c;
                c=sum/10;
                res.append(sum%10);
                index2--;
            }
        }
        if(c>0){
            res.append(c);
        }
        res.reverse();
        return res.toString();
    }
}
```
