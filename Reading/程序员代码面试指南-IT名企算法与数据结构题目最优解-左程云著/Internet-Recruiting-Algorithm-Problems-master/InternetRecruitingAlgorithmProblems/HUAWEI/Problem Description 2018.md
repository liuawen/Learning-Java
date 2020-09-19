# 华为2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:字符串重排](#第一题-字符串重排)
* [第二题:跳跃比赛](#第二题-跳跃比赛)
* [第三题:大数相乘](#第三题-大数相乘)
* [第四题:找出重复字符并排序](#第四题-找出重复字符并排序)
* [第五题:连续字串](#第五题-连续字串)
* [第六题:广告牌](#第六题-广告牌)
<!-- TOC -->


## 第一题 字符串重排

### 题目描述
>给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。
```java
举例！假设原始字符串为：
eeefgghhh
则每种字符出现的次数分别是：
(1).eee        3次
(2).f          1次
(3).gg         2次
(4).hhh        3次
重排输出后的字符串如下：
efghegheh
编写程序，实现上述功能。
【温馨提示】
(1).原始字符串中仅可能出现“数字”和“字母”；
(2).请注意区分字母大小写。
```

**输入描述:**
```java
eeefgghhh
```

**输出描述:**
```java
efghegheh
```

**样例：**

**输入**
```java
eeefgghhh
```
**输入**
```java
efghegheh
```

### 参考代码
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine().trim();
            int[] ascArr = new int[128];
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                ascArr[s.charAt(i)]++;
                if (ascArr[s.charAt(i)] > max) {
                    max = ascArr[s.charAt(i)];
                }
            }
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < 128; j++) {
                    if (ascArr[j] > 0) {
                        System.out.print((char) j);
                        ascArr[j]--;
                    }
                }
            }
            System.out.println();
        }
    }
}
```

## 第二题 跳跃比赛

### 题目描述
>给出一组正整数，你从第一个数向最后一个数方向跳跃，每次至少跳跃1格，每个数的值表示你从这个位置可以跳跃的最大长度。计算如何以最少的跳跃次数跳到最后一个数。

**输入描述:**
```
第一行表示有多少个数n
第二行开始依次是1到n个数，一个数一行
```

**输出描述:**
```
输出一行，表示最少跳跃的次数。
```

**样例：**
```
输入
7
2
3
2
1
2
1
5
输出
3
说明
7表示接下来要输入7个正整数，从2开始。数字本身代表可以跳跃的最大步长，此时有2种跳法，为2-2-2-5和2-3-2-5都为3步
```

### 参考代码
```java
import java.util.*;
public class  Main {
    public static  void main(String[]args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
           int n=in.nextInt();
           int[] arr=new int[n];
           for(int i=0;i<n;i++){
               arr[i]=in.nextInt();
           }
            int jump=0;
            int cur=0;
            int next=0;
            for(int i=0;i<arr.length;i++){
                if(cur<i){
                    jump++;
                    cur=next;
                }
                next=Math.max(next,i+arr[i]);
            }
           System.out.println(jump);
        }
    }
}
```

## 第三题 大数相乘

### 题目描述
>编写”长整数相乘”程序，实现两个任意长度的长整数(正数)相乘，输出结果.

**输入描述:**
```
第一行输入数字A的字符串，字符范围（0～9），第二行输入数字B的字符串，字符范围（0～9）。
```

**输出描述:**
```
输出A、B俩数相乘的结果，结果为字符串。。
```

**样例：**
```
输入
1234
4321
输出
5332114
说明
第一排数字*第二排数字
```

```java
import java.util.Scanner;

public class Main {

    /**
     * 大数相乘基本思想，输入字符串，转成char数组，转成int数组。采用分治思想，每一位的相乘;<br>
     * 公式：AB*CD = AC (BC+AD) BD , 然后从后到前满十进位(BD,(BC+AD),AC)。
     * 
     * @param num1
     * @param num2
     */
    public static String multiply(String num1, String num2) {
        // 把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();

        // 声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];

        // 把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for (int i = 0; i < chars1.length; i++)
            n1[i] = chars1[i] - '0';
        for (int i = 0; i < chars2.length; i++)
            n2[i] = chars2[i] - '0';

        // 逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                result[i + j] += n1[i] * n2[j];
            }
        }

        // 满10进位，从后往前满十进位
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        // 转成string并返回
        String resultStr = "";
        for (int i = 0; i < result.length - 1; i++) {
            resultStr += "" + result[i];
        }
        return resultStr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();
            String res = multiply(str1, str2);
            System.out.println(res);
        }
    }
}
```


## 第四题 找出重复字符并排序

### 题目描述
>找出输入字符串中的重复字符，再根据ASCII把重复的字符从小到大排序。

**输入描述:**
>一个长度不超过100的字符串

**输出描述:**
>排序后的字符串

**样例：**
```
输入
ABCABCdd

输出
ABCd
```

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        boolean[] c = new boolean[256];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)]=true;
        }
        String res = "";
        for(int i=0;i<c.length;i++){
            if(c[i]){
                res+=(char)i;
            }
        }
        System.out.println(res);
    }
}
```


## 第五题 连续字串

### 题目描述
>给定一串字符，里面有些字符有连续出现的特点，请寻找这些连续出现字符中最长的串，如果最长的字串有多个，请输出字符ASCII码最小的那一串。

**输入描述:**
>用cin输入一串字符

**输出描述:**
>用count输出其中最长的字串

**样例：**
```
输入
aaabbbbbccccccccczzzzzzzzz

输出
cccccccccc
```

```java
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int[] map = new int[256];
        int count=1;
        for(int i=1;i<line.length();i++){
            if(line.charAt(i)==line.charAt(i-1)){
                count++;
            }
            else{
                if(count>map[line.charAt(i-1)]){
                    map[line.charAt(i-1)]=count;
                    count=1;
                }
            }
        }
        map[line.charAt(line.length()-1)]=count;
        int max=0;
        int index=0;
        for(int i=0;i<256;i++){
            if(map[i]>max){
                max=map[i];
                index=i;
            }
        }
        String res = "";
        char x= (char)index;
        for(int i=0;i<max;i++){
            res+=x;
        }
        System.out.println(res);
    }
}
```

## 第六题 广告牌

### 题目描述
>已知某小镇的房子沿直线分布，给定一个有序整数数组arr，里面的每个值都代表小镇每栋房子的一维坐标点。
 现在需要建N个广告牌，广告牌只能建在这些坐标点上，使得每个坐标点离广告牌的总距离最短，请返回这个最短的总距离。

**输入描述:**
>1. 1<=N<=arr的长度
 2. 每个坐标点以最近的广告牌距离作为该坐标点离广告牌的距离；
 3. 输入中最后一个为N值，其余为arr值，需要考生自行处理；

**输出描述:**
>输出为所有坐标点离广告牌的最短总距离

**样例：**
```
输入
1 2 3 4 5 1000 2

输出
6
```

```java
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strings = line.split(" ");
        int[] arr = new int[strings.length-1];
        int N = Integer.valueOf(strings[strings.length-1]);
        for(int i=0;i<strings.length-1;i++){
            arr[i]=Integer.valueOf(strings[i]);
        }
        ArrayList<Integer> min = new ArrayList<>();
        ArrayList<Integer> location = new ArrayList<>();
        DFS(arr,location,arr.length,N,0,min);
        System.out.println(min.get(0));
    }

    private static void DFS(int[] arr,ArrayList<Integer> loc,int len,int N,int index,ArrayList<Integer> min){
        if(loc.size()==N){
            int distance = caculateDis(loc,arr);
            if(min.size()==0){
                min.add(distance);
            }else{
                if(distance<min.get(0)){
                    min.remove(0);
                    min.add(distance);
                }
            }
            return;
        }
        if(index==len) return;
        DFS(arr,loc,len,N,index+1,min);
        loc.add(arr[index]);
        DFS(arr,loc,len,N,index+1,min);
        loc.remove(loc.size()-1);
        return;
    }

    private static int caculateDis(ArrayList<Integer> loc,int[] arr){
        int len = arr.length;
        int size = loc.size();
        int sum = 0;
        for(int i=0;i<len;i++){
            int dist = Math.abs(loc.get(0)-arr[i]);
            for(int j=1;j<size;j++){
                int temp = Math.abs(loc.get(j)-arr[i]);
                if(temp<dist){
                    dist=temp;
                }
            }
            sum+=dist;
        }
        return sum;
    }
}
```
