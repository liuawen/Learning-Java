# 京东2017校园招聘算法笔试题

<!-- TOC -->
* [第一题:保卫方案](#第一题-保卫方案)
* [第二题:集合](#第二题-集合)
* [第三题:进制均值](#第三题-进制均值)
* [第四题:幸运数](#第四题-幸运数)
<!-- TOC -->


## 第一题 保卫方案

### 题目描述
>战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。首都位于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。

**输入描述:**
>输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),为首都周围的小山数量，第二行为n个整数，依次表示为小山的高度h（1<=h<=10^9）.

**输出描述:**
>对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。

**样例：**

**输入**
>5
1 2 4 5 3

**输入**
>7

### 解题思路

- [单调栈](https://blog.csdn.net/qq_35314344/article/details/76083170)

### 参考代码
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n*2];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            a[i+n]= a[i];
        }
        int maxIndex=0,secondIndex=0;
        for(int i=1;i<n;i++){
            if(a[maxIndex]<a[i])maxIndex = i;
        }
        if(maxIndex==0)secondIndex = 1;
        for(int i=1;i<n;i++){
            if(i==maxIndex)continue;
            if(a[secondIndex]<a[i])secondIndex = i;
        }
        int start = maxIndex>secondIndex?secondIndex:maxIndex;
        int mid = maxIndex>secondIndex?maxIndex:secondIndex;
        int end = start+n;
        System.out.println(getCount(a,start,mid)+getCount(a,mid,end)+1);
    }
    static long getCount(int a[],int start,int end){
        if(end-start==1)return 0;
        List<Integer> list = getMaxIndexExceptStartAndEnd(a,start,end);
        long c = (int)list.size();
        int f = list.get(0);
        int l = list.get(list.size()-1);
        long r1 = getCount(a,start,f)+c;
        long r2 = getCount(a,l,end)+c;
        long sum1= c*(c-1)/2;
        for(int i=1;i<list.size();i++){
            sum1 += getCount(a,list.get(i-1),list.get(i));
        }
        return r1+r2+sum1;
    }
      
    static List<Integer> getMaxIndexExceptStartAndEnd(int []a,int start,int end){
        List<Integer> list = new ArrayList<Integer>();
        int max = start+1;
        list.add(max);
        for(int i=start+2;i<end;i++){
            if(a[max]<a[i]){
                list.clear();
                list.add(i);
                max = i;
            }else if(a[max]==a[i]){
                list.add(i);
            }
        }
        return list;
    }
}
```


## 第二题 集合

### 题目描述
>给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。

**输入描述:**
>每组输入数据分为三行,第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数。后两行分别表示集合A和集合B。每个元素为不超过int范围的整数,每个元素之间有个空格隔开。

**输出描述:**
>针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开,行末无空格。

**样例：**

**输入**
>3 3
1 3 5
2 4 6

**输入**
>1 2 3 4 5 6

### 解题思路

- 将两个集合中的元素合并、排序、去重；利用TreeSet即可满足所有条件。

### 参考代码
```java
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
 
public class Main {
 
    //集合
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<Integer>();
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            for(int i=1; i<=m+n; i++){
                set.add(in.nextInt());
            }
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                System.out.print(it.next());
                if(it.hasNext())
                    System.out.print(" ");
            }
        }
    }
}
```


## 第三题 进制均值

### 题目描述
>尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题，现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示一个数，如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示为三位数1、7、3，按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11,。 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？ 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。

**输入描述:**
>输入中有多组测试数据，每组测试数据为一个整数A(1 ≤ A ≤ 5000).

**输出描述:**
>对每组测试数据，在单独的行中以X/Y的形式输出结果。

**样例：**

**输入**
>5
3

**输入**
>7/3
2/1

### 解题思路

- 将输入的数值用各个进制表示，并对各个位数求和，最后进行约分。

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n= in.nextInt();
            int Y=n-2;
            int X=0;
            for(int i=2;i<n;i++){
                int temp=n;
                while(temp>0){
                    X+=temp%i;
                    temp/=i;
                }
            }
            int ind=2;
            while(ind<=Y){
                if(X%ind==0&&Y%ind==0){
                    X/=ind;
                    Y/=ind;
                }else{
                    ind++;
                }
            }
            System.out.println(X+"/"+Y);
        }
    }
}
```

## 第四题 幸运数

### 题目描述
>小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，二进制数也很常用。现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。 f(x)表示把x这个数用十进制写出后各个数位上的数字之和。如f(123)=1+2+3=6。 g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，那么，g(123)=1+1+1+1+0+1+1=6。 小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数称为幸运数，现在他想知道，小于等于n的幸运数有多少个？

**输入描述:**
>每组数据输入一个数n(n<=100000)

**输出描述:**
>每组数据输出一行，小于等于n的幸运数个数。

**样例：**

**输入**
>21

**输入**
>3

### 解题思路

- 用十进制和二进制分别表示两个数，并将两数的和进行比较。

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int res=0;
        for(int i=1;i<=n;i++){
            int sum1=f(i);
            int sum2=g(i);
            if(sum1==sum2)
                res++;
        }
        System.out.println(res);
    }
    public static int f(int x){
        int sum=0;
        while(x>0){
            sum+=x%10;
            x/=10;
        }
        return sum;
    }
    public static int g(int x){
        int sum=0;
        while(x>0){
            sum+=x%2;
            x/=2;
        }
        return sum;
    }
}
```
