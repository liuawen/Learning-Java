# 今日头条2018校园招聘算法笔试题

<!-- TOC -->
* [第一题](#第一题)
* [第二题](#第二题)
* [第三题](#第三题)
* [第四题](#第四题)
* [第五题](#第五题)
* [第六题:抖音红人](#第六题-抖音红人)
* [第七题:UTF-8校验](#第七题-UTF-8校验)
* [第八题:IP还原](#第八题-IP还原)
* [第九题:组织优化](#第九题-组织优化)
* [第十题:最大不重复子串](#第十题-最大不重复子串)
<!-- TOC -->

## 第一题

### 题目描述：
>在n个元素的数组中，找到差值为k的数字对去重后的个数。

**输入描述:**
>第一行，n和k，n表示数字个数，k表示差值 
第二行，n个正整数

**输出描述：**
>差值为k的数字对去重后的个数

**样例:**
```
in:
5 2
1 5 3 4 2
out:
3
```

### 解题思路
- 剑指Offer66题之每日6题 - 第七天中第六题：和为S的两个数字中的头尾指针法，这里变形为差为K的两个数字。其实是一样的，这样一来，时间复杂度就为O(2n)，但是排序的时间复杂度还是O(nlogn)

### 参考代码
```java
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            Set<Integer> s = new TreeSet<Integer>();
            for (int i = 0; i < n; i++) {
                s.add(in.nextInt());
            }
            Integer[] arr = new Integer[s.size()];
            Integer[] arrtemp = s.toArray(arr);
            int ans = 0;
            for (int head = 0, tail = 1; tail < arr.length; head++) {
                while (tail < arr.length && arr[tail] - arr[head] < Math.abs(k))
                    tail++;
                if (tail >= arr.length)
                    break;
                if (arr[tail] - arr[head] == Math.abs(k))
                    ans += 1;
            }
            System.out.println(ans);
        }
    }
}
```


## 第二题

### 题目描述：
>定义两个字符串变量：s和m，再定义两种操作， 
第一种操作：
```
m = s;
s = s + s;
```
第二种操作：
```
s = s + m;
```
假设s, m初始化如下：
```
s = "a";
m = s;
```
求最小的操作步骤数，可以将s拼接到长度等于n

**输入描述:**
>一个整数n，表明我们需要得到s字符长度，0<n<10000

**输出描述：**
>一个整数，表明总共操作次数

**样例:**
```
in:
6
out:
3
```

### 解题思路
- 质数x操作步数都是x-1;
- 合数x的操作步数都是由因数的操作步数+因数组合成合数的步数；

### 参考代码
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                dp[i] = i - 1;//质数的操作步数
                //寻找最大因素
                for (int j = i / 2; j >= 1; j--) {
                    if (i % j == 0) {
                        //通过因数的组合过程也是一个质数的合成过程
                        dp[i] = Math.min(dp[i], dp[j] + i / j - 1);
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}
```

## 第三题

### 题目描述：
>今日头条6周年周年庆就要开始啦。活动主办方请你帮忙制作一个小彩蛋。你的程序需要读取一个表达式，并输出用字符6拼出的计算结果。相邻数字使用两个英文句号"."间隔，如下是0123456789。
```
66666......6..66666..66666..6...6..66666..66666..66666..66666..66666
6...6......6......6......6..6...6..6......6..........6..6...6..6...6
6...6......6..66666..66666..66666..66666..66666......6..66666..66666
6...6......6..6..........6......6......6..6...6......6..6...6......6
66666......6..66666..66666......6..66666..66666......6..66666..66666
```

**输入描述：**
>第一行为一个整数n 
接下来n行，每一行为一个表达式 
对于30%的数据，表达式仅包含`6`, `+`, `-`三种字符 
对于100%的数据，表达式仅包含`6`, `+`, `-`, `*`四种字符。1≤n≤1001≤n≤100，表达式长度不超过100，其中`+`, `-`, `*`均为二元运算符，计算中间结果在$[-2^{63},2^{63}-1]$之内，最终结果在$[0,2^{63}?1]$之内

**输出描述：**
>对于每组数据输出用字符`6`拼出的计算结果。

**样例:**
```
in:
2
6+6
6*6
out:
....6..66666
....6......6
....6..66666
....6..6....
....6..66666
66666..66666
....6..6....
66666..66666
....6..6...6
66666..66666
```

### 参考代码

```java
import java.util.Scanner;

public class Main {
    private static String G[][] = {
            { "66666", "....6", "66666", "66666", "6...6", "66666", "66666",
                    "66666", "66666", "66666" },
            { "6...6", "....6", "....6", "....6", "6...6", "6....", "6....",
                    "....6", "6...6", "6...6" },
            { "6...6", "....6", "66666", "66666", "66666", "66666", "66666",
                    "....6", "66666", "66666" },
            { "6...6", "....6", "6....", "....6", "....6", "....6", "6...6",
                    "....6", "6...6", "....6" },
            { "66666", "....6", "66666", "66666", "....6", "66666", "66666",
                    "....6", "66666", "66666" } };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                long ans = cal(s);
                String ansString = "" + ans;
                int[] digit = new int[ansString.length()];
                for (int k = 0; k < ansString.length(); k++) {
                    digit[k] = ansString.charAt(k) - '0';
                }
                for (int j = 0; j < 5; j++) {
                    String temp = G[j][digit[0]];
                    for (int k = 1; k < digit.length; k++) {
                        temp = temp + ".." + G[j][digit[k]];
                    }
                    System.out.println(temp);
                }

            }
        }
    }

    private static long cal(String s) {
        int n = s.length();
        long sum = 0, cur = 0, prd = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
                cur = cur * 10 + s.charAt(i) - '0';
            else if (s.charAt(i) == '-') {
                sum += prd * cur;
                cur = 0;
                prd = -1;
            } else if (s.charAt(i) == '+') {
                sum += prd * cur;
                cur = 0;
                prd = 1;
            } else {
                prd *= cur;
                cur = 0;
            }
        }
        return sum + prd * cur;
    }
}
```

## 第四题

### 题目描述：
>给一个包含`n`个整数元素的集合`a`，一个包含`m`个整数元素的集合`b`。定义magic操作为，从一个集合中取出一个元素，放到另一个集合里，切操作过后每个集合的平均值都大于操作前。
注意一下两点：
- 不可以把一个集合的元素取空，这样就没有平均值了
- 值为x的元素从集合b取出放入集合a，但集合a中已经有值为x的元素，则a的平均值不变(因为集合元素不会重复)，b的平均值可能会改变(因为x被取出了)
问最多可以进行多少次magic操作？


**输入描述：**
>第一行为两个整数n，m 
第二行n个整数，表示集合a中的元素 
第三行m个整数，表示集合b中的元素 
对于100%的数据，`1<n,m<100000` `0<a[i],b[i]<100000000`，集合a中元素互不相同，集合b中的元素互不相同。

**输出描述：**
>输出一个整数，表示最多可以进行的操作次数。

**样例:**
```
in:
3 5
1 2 5
2 3 4 5 6
out:
2
```

### 参考代码

```java
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n,m;
        int cnt;
        n=scan.nextInt();
        m=scan.nextInt();
        double []a=new double[n];
        double []b=new double[m];
        for(int i=0;i<n;++i) {
            a[i]=scan.nextDouble();
        }
        for(int i=0;i<m;++i) {
            b[i]=scan.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        double va=avd(a);
        double vb=avd(b);
        if(vb>va) {
            cnt=Maicg(a,b,va,vb);
        }
        else {
            cnt=Maicg(b,a,vb,va);
        }
        System.out.println(cnt);
    }
    static double avd(double []a) {
        double sum=0;
        for(int i=0;i<a.length;++i) {
            sum+=a[i];
        }
        return sum/a.length;
    }
    static int Maicg(double[]a,double[]b,double va,double vb) {
        int cnt=0;
        Set se=new TreeSet();
        for(int i=0;i<a.length;++i) {
            se.add(a[i]);
        }
        int n,m;
        n=a.length;
        m=b.length;
        for(int i=0;i<b.length-1&&b[i]<vb;i++) {
            if(b[i]>va) {
                int j=se.size();
                se.add(b[i]);
                if(j!=se.size()) {
                    va=(va*n+b[i])/(n+1);
                    vb=(vb*m-b[i])/(m-1);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
```

## 第五题

### 题目描述
>小T最近迷上了一款跳板小游戏。已知在空中有N个高度互不相同的跳板，小T刚开始在高度为0的地方，每次跳跃可以选择与自己当前高度绝对值差小于等于H的跳板，跳跃过后到达以跳板为轴的镜像位置，问小T在最多跳K次的情况下最高能跳多高？（任意时刻，高度不能为负）

**输入描述：**
>第一行三个整数N, K, H
以下N行，每行一个整数Ti，表示第i个跳板的离地高度

**输出描述：**
>一个整数，表示最高能跳到的高度

**样例：**
```
输入：
3 3 2
1
3
6
输出：
8
```

### 参考代码
```java
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static int max = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int K = in.nextInt();
            int H = in.nextInt();
            int[] block = new int[N];
            for (int i = 0; i < N; i++) {
                block[i] = in.nextInt();
            }

            HighestLevel(block, 0, K, H, new Stack<Integer>());
            System.out.println(max);
        }
    }

    private static void HighestLevel(int[] block, int cur, int k, int h,
            Stack<Integer> s) {
        // TODO Auto-generated method stub
        if (cur > max)
            max = cur;
        for (int i = 0; i < block.length; i++) {
            if (block[i] - cur > 0 && block[i] - cur <= h) {
                s.push(block[i]);
                cur = cur + (block[i] - cur) * 2;
                HighestLevel(block, cur, k - 1, h, s);
                cur = cur - (cur - block[i]) * 2;
                s.pop();
            }
        }
        return;
    }
}
```


## 第六题 抖音红人

### 题目描述
>抖音工程师想要找到抖音里的红人！假设用户数为N，有M个关注关系对（A,B）。（A,B）表示用户A关注了用户B。关注关系具有传递性，例如：用户A关注了用户B，用户B关注了用户C，那么认为用户A间接关注了C。如果一个用户被所有N个用户直接或者间接关注，那么我们认为这个用户就是抖音红人。求抖音红人的总数。

**输入描述：**
>第一行一个整数，代表N
第二行一个整数，代表M

**输出描述：**
>一行一个整数，表示答案

**样例：**
```
输入：
3
3
1 2 2 1 2 3
输出：
1
```

### 参考代码
```java
YANG:
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] graph = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            graph[i][i]=1;
        }
        for(int i=0;i<M;i++){
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph[v1][v2]=1;
        }
        for(int i=1;i<=N;i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            for(int j=1;j<=N;j++){
                if(!set.contains(j)){
                    if(graph[i][j]==1){
                        set.add(j);
                        int index=j;
                        for(int k=1;k<=N;k++){
                            if(graph[j][k]==1){
                                graph[i][k]=1;
                                if(index>k){
                                    index=k;
                                }
                            }
                        }
                        if(index<j){
                            j=index-1;
                        }
                    }
                }
            }
        }
        int result = 0;
        for(int i=1;i<=N;i++){
            int sum = 0;
            for(int j=1;j<=N;j++){
                sum+=graph[j][i];
            }
            if(sum==N){
                result++;
            }
        }
        System.out.println(result);
    }
}
```

## 第七题 UTF-8校验

### 题目描述
>一个UTF8字符的长度可能是1到4个字节。其编码规则如下：对于一个字节长的UTF-8字符，第一个bit是0，后面的bit都是它的Unicode码;
对于n字节长的UTF8字符，前n个bits都是1，第n+1bit是0，接下来n-1个字节的前两个bits都是10。

```java
Char.number range  |   UTF-8 octet sequence
   (hexadecimal)   |        (binary)
-------------------------------------------
0000 0000~0000 007F|  0xxxxxxx
0000 0080~0000 07FF|  110xxxxx 10xxxxxx
0000 0800~0000 FFFF|  1110xxxx 10xxxxxx 10xxxxxx
0001 0000~0010 FFFF|  11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
```

>给定一个整数数组表示的数据，判断其是否是合法的UTF-8编码。
注意：每个整数只有最低8位用于存储数据。即：输入的每个整数代表一个byte


**输入描述：**
>第一行一个整数，代表数组长度N
第二行空格分隔的N个整数

**输出描述：**
>1表示合法，0代表不合法

**样例：**
```
输入：
3
197 130 1
输出：
1
```

### 参考代码
```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int M = in.nextInt();
            int[] data = new int[M];
            for (int i = 0; i < M; i++) {
                data[i] = in.nextInt();
            }
            System.out.println(validUtf8(data));
        }
    }

    public static int validUtf8(int[] data) {
        if (data == null || data.length == 0) return 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 255) return 0;
            int moreChecks = 0; 
            if ((data[i] & 0b10000000) == 0) moreChecks = 0;
            else if ((data[i] & 0b11100000) == 0b11000000) moreChecks = 1;
            else if ((data[i] & 0b11110000) == 0b11100000) moreChecks = 2;
            else if ((data[i] & 0b11111000) == 0b11110000) moreChecks = 3;
            else return 0;
            for (int j = 1; j <= moreChecks; j++) {
                if (i + j >= data.length) return 0;
                if ((data[i + j] & 0b11000000) != 0b10000000) return 0;
            }
            i = i + moreChecks;
        }
        return 1;
    }
}
```


## 第八题 IP还原

### 题目描述
>工程师校长的代码Bug了。在上报用户IP的时候，漏掉了"."符号，例如10.0.0.1变成了10001。请你帮小张对这些异常数据进行处理，还原所有可能的原始IP，输出可能的原始IP的数量。

**输入描述：**
>第一行一个字符串，代表抹掉.符号的ip

**输出描述：**
>一行一个整数，表示答案

**样例：**
```
输入：
8888
输出：
1
```

### 参考代码
```java
import java.util.*;
public class Main {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            int res=restoreIpAddresses(str);
            System.out.println(res);
        }
    }
    public static int restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return 0;
        }
        StringBuilder tmp = new StringBuilder();
        depthFS(0, 0, s, tmp, res);
        return res.size();
    }

    public static void depthFS(int count, int index, String s, StringBuilder tmp,
                               ArrayList<String> res) {
        if (count == 4 && index == s.length()) {
            res.add(tmp.toString().substring(0, tmp.length() - 1));
            return;
        } else {
            for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
                String tmpStr = s.substring(index, index + i);
                if (isValid(tmpStr)) {
                    int bt = tmp.length();
                    int ed = tmp.length() + tmpStr.length();
                    tmp.append(tmpStr).append(".");
                    depthFS(count + 1, index + i, s, tmp, res);
                    tmp.delete(bt, ed + 1);
                }
            }
        }
    }

    public static boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }

        int num = Integer.parseInt(s);

        return num > 0 && num <= 255;
    }
}
```


## 第九题 组织优化

### 题目描述
>随着公司的快速发展，基层团队越来越多。近期公司希望对部门重新做个划分，尽可能把紧密合作的团队放在同一个部门。
给定一个M*M的2维数组，每个值1的元素代表一个团队。如果2个团队在上下或左右的方向上相邻，说明2个团队有紧密合作关系。需要把合作紧密的团队放在一起，形成一个部门；没有合作关系的团队，放在不同的部门。
判断给定输入中，有多少个部门。

```java
例如，给定一个二维数组：
1 0 0 1 1
1 0 0 1 1
0 0 1 0 0
0 0 1 0 0
0 0 1 0 0
其中九个团队，一共需要组成3个部门，分别是：
1
1 
以及
1 1
1 1
以及
1
1
1
```


**输入描述：**
>第一行一个整数，代表M
后面M行，每行M个整数（取值0或1）

**输出描述：**
>一个整数，表示部门数量

**样例：**
```
输入：
4
1 0 0 0
0 0 0 0
0 0 0 1
0 0 0 0
输出：
2
```

### 参考代码
```java
import java.util.*;
class Node{
    int row;
    int col;
    public Node(int i,int j){
        row=i;
        col=j;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}
public class Main {
    public static  void main(String[]args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int M=Integer.parseInt(in.nextLine());
            int[][]dp=new int[M][M];
            for(int i=0;i<M;i++){
                String[] strs=in.nextLine().split(" ");
                for(int j=0;j<M;j++){
                    dp[i][j]=Integer.parseInt(strs[j]);
                }
            }
            int res=0;
            boolean[][]flag=new boolean[M][M];
            for(int i=0;i<M;i++){
                for(int j=0;j<M;j++){
                    if(dp[i][j]==1&&!flag[i][j]){
                        flag[i][j]=true;
                        res++;
                        dfs(dp,i,j,flag);
                    }
                }
            }
            System.out.println(res);
        }
    }

    private static void dfs(int[][] dp, int i, int j, boolean[][] flag) {
        if(i<0||j<0||i>=dp.length||j>=dp[0].length) return;
        Queue<Node>queue=new LinkedList<>();
        queue.add(new Node(i,j));
        while(!queue.isEmpty()){
            Node temp=queue.poll();
            int row=temp.getRow();
            int col=temp.getCol();
            if(col<dp[0].length-1&&dp[row][col+1]==1){
                queue.add(new Node(row,col+1));
                flag[row][col+1]=true;
            }
            if(row<dp.length-1&&dp[row+1][col]==1){
                queue.add(new Node(row+1,col));
                flag[row+1][col]=true;
            }
        }
        
    }
}
```

## 第十题 最大不重复子串

### 题目描述
>给定一个字符串，请找出其中无重复字符的最长字符串的长度。
例如，
```java
"abcabcbb",其无重复字符的最长字符串是"abc",其中长度为3。
"bbbbb",其无重复字符的最长字符串为"b",长度为1。
```


**输入描述：**
>一个字符串

**输出描述：**
>一个整数

**样例：**
```
输入：
abc
输出：
3
```

### 参考代码
```java
import java.util.*;
public class Main{
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str=in.nextLine();
            char[]chs=str.toCharArray();
            int []dp=new int[chs.length];
            Arrays.fill(dp,1);
            for(int i=1;i<chs.length;i++){
                int temp=1;
                for(int j=1;j<=dp[i-1];j++){
                    if(chs[i]==chs[i-j]){
                        break;
                    }else {
                        temp++;
                    }
                }
                dp[i]=temp;
            }
            int res=0;
            for(int i=0;i<dp.length;i++){
                if(dp[i]>res){
                    res=dp[i];
                }
            }
            System.out.println(res);
        }
    }
}
```

