# 腾讯2017校园招聘算法笔试题

<!-- TOC -->
* [第一题](#第一题-编码)
* [第二题](#第二题-游戏任务标记)
* [第三题](#第三题-素数对)
* [第四题](#第四题-geohash编码)
<!-- TOC -->


## 第一题 编码

### 题目描述
>假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index. 

**输入描述:**
>输入一个待编码的字符串,字符串长度小于等于100.

**输出描述:**
>输出这个编码的index

**样例：**

**输入**
>baca

**输入**
>16331

### 解题思路

计算以a为首字母的字符串的个数，单个字符的字符串有1个，两个字符的字符串有`1*25`，三个字符的字符串有`1*25*25`，四个字符的字符串有`1*25*25*25`，怎总的字符串为`(1+1*25+1*25*25+1*25*25*25)*25`
由此可以推算出输入字符串前有多少个字符串编码
```
以“baca”为例：
index=('b'-'a')*(1+1*25+1*25*25+1*25*25*25)+1    ---- 'b'
      ('a'-'a')*(1+1*25+1*25*25)+1               ---- 'a'
      ('c'-'a')*(1+1*25)+1                       ---- 'c'
	  ('a'-'a')*(1)+1                            ---- 'a'
index=index-1;//因为起始索引从0开始
```

### 参考代码
```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            int res = 0;
            int[] step = {16276,651,26,1};
            for(int i=0;i<s.length();i++){
                res+=((s.charAt(i)-'a')*step[i]+1);
            }
            System.out.println(res-1);
        }
    }
}
```

## 第二题 游戏任务标记

### 题目描述
>游戏里面有很多各式各样的任务，其中有一种任务玩家只能做一次，这类任务一共有1024个，任务ID范围[1,1024]。请用32个unsigned int类型来记录着1024个任务是否已经完成。初始状态都是未完成。 输入两个参数，都是任务ID，需要设置第一个ID的任务为已经完成；并检查第二个ID的任务是否已经完成。 输出一个参数，如果第二个ID的任务已经完成输出1，如果未完成输出0。如果第一或第二个ID不在[1,1024]范围，则输出-1。 

**输入描述:**
>输入包括一行,两个整数表示人物ID.

**输出描述:**
>输出是否完成

**样例：**
```
输入
1024 1024

输出
1
```

### 解题思路

1024种任务有2^1024种可能，需要1024个bit，就是1024/8=128byte。一个int是4byte，刚好需要32个int。就是说，把32个int排成一行，就是1024个bit，每个bit来表示某个任务是否完成。


### 参考代码
```java
import java.io.*;
import java.util.*;
  
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String L=in.readLine();
        String[] s1=L.split(" ");
        int m=Integer.parseInt(s1[0]);
        int n=Integer.parseInt(s1[1]);
        int[] arr = new int[32];
        if((m<1||m>1024)||(n<1||n>1024)){
            System.out.println(-1);
        }else{
            int mod = 1 << m % 32;
            arr[(m - 1) / 32] |= mod;
            mod = 1 << n % 32;
            if((arr[(m - 1) / 32] & mod) == 0)
                System.out.println(0);
            else
                System.out.println(1);
        }
    }
}
```

## 第三题 素数对

### 题目描述
>给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)） 

**输入描述:**
>输入包括一个整数n,(3 ≤ n < 1000)

**输出描述:**
>输出对数

**样例：**
```
输入
10

输出
2
```

### 解题思路

- 首先找到小于target的所有质数;
- 然后此题将转化为数组中两个数的和是否等于target;


### 参考代码

```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=2;i<=n;i++){
                if(i==2||i==3){
                    list.add(i);
                }else{
                    boolean flag=true;
                    for(int j=2;j<=i/2;j++){
                        if(i%j==0) {
                            flag=false;
                            break;
                        }
                    }
                    if(flag){list.add(i);}
                }
            }
            int count=0;
            int head=0;
            int tail=list.size()-1;
            while(head<=tail){
                if(list.get(head)+list.get(tail)==n){
                    count++;
                    head++;
                    tail--;
                }else if(list.get(head)+list.get(tail)<n){
                    head++;
                }else{
                    tail--;
                }
            }
            System.out.println(count);
        }
    }
}
```


## 第四题 geohash编码

### 题目描述
>geohash编码：geohash常用于将二维的经纬度转换为字符串，分为两步：第一步是经纬度的二进制编码，第二步是base32转码。
此题考察纬度的二进制编码：算法对纬度[-90, 90]通过二分法进行无限逼近（取决于所需精度，本题精度为6）。注意，本题进行二分法逼近过程中只采用向下取整来进行二分，针对二分中间值属于右区间。算法举例如下： 针对纬度为80进行二进制编码过程：
```
1) 区间[-90, 90]进行二分为[-90, 0),[0, 90]，成为左右区间，可以确定80为右区间，标记为1；
2) 针对上一步的右区间[0, 90]进行二分为[0, 45),[45, 90]，可以确定80是右区间，标记为1；
3) 针对[45, 90]进行二分为[45, 67),[67,90],可以确定80为右区间，标记为1；
4) 针对[67,90]进行二分为[67, 78),[78,90]，可以确定80为右区间，标记为1；
5) 针对[78, 90]进行二分为[78, 84),[84, 90]，可以确定80为左区间，标记为0；
6) 针对[78, 84)进行二分为[78, 81), [81, 84)，可以确定80为左区间，标记为0； 
```

**输入描述:**
>输入包括一个整数n,(-90 ≤ n ≤ 90)

**输出描述:**
>输出二进制编码

**样例：**
```
输入
80

输出
111100
```

### 解题思路

- 二分查找，不断分割区间。

### 参考代码

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int target=sc.nextInt();
        String res = "";
        int lo = -90;
        int hi = 90;
        for(int i=0;i<6;i++){
            int mid=(lo+hi)/2;
            if(mid>target){
                hi=mid;
                res+="0";
            }else{
                lo=mid;
                res+="1";
            }
        }
        System.out.println(res);
        sc.close();
    }
}
```

