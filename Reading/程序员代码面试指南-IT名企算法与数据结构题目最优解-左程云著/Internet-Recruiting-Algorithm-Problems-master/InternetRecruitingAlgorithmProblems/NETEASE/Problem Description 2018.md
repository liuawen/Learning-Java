# 网易2018校园招聘算法笔试题

<!-- TOC -->
* [第一题](#第一题)
* [第二题](#第二题)
* [第三题](#第三题)
* [第四题](#第四题)
* [第五题](#第五题)
* [第六题](#第六题)
* [第七题](#第七题)
* [第八题](#第八题)
* [第九题](#第九题)
* [第十题](#第十题)
* [第十一题](#第十一题)
<!-- TOC -->


## 第一题

### 题目描述
>平面内有n个矩形，左下角坐标(x1[i],y1[i])，右上角坐标(x2[i],y2[i])，判断重叠矩形最大数目是多少。如果有两个或多个矩形有公共区域，则认为它们是重叠的，不考虑边界和角落。请计算出平面内重叠矩形最多的地方的矩形数目。

**输入描述:**
>输入包括五行，第一行表示矩形数目n，第二行x1-->左下角横坐标，第三行y1-->左下角纵坐标，第四行x2-->右上角横坐标，第五行y2-->左上角纵坐标。

**输出描述:**
>输出最大重叠的矩形数目，如果都不重叠输出1.

### 解题思路
- 该题就是一个采用搜索的方式，假设以第一个为基准，对后面的矩形进行搜索，判断，如果相离，则剪枝往后搜索；如果重叠，则需要考虑它是否是最大重叠区域内的，求两者递归结果的最大值即可。同时，需要以每个点为基准都进行搜索一次，并用贪心思想保留最大值。

### 参考代码

```java
import java.util.Scanner;
public class Main {
    public static int solve(int[] x1, int[] x2, int[] y1, int[] y2, int k,
            int xa, int ya, int xb, int yb) {
        if (k == x1.length)
            return 0;
        else {
            if (x1[k] >= xb || y1[k] >= yb || xa >= x2[k] || ya >= y2[k])// 排除相离的情况。
                return solve(x1, x2, y1, y2, k + 1, xa, ya, xb, yb);
            else {
                int xa1 = Math.max(xa, x1[k]);
                int ya1 = Math.max(ya, y1[k]);
                int xb1 = Math.min(xb, x2[k]);
                int yb1 = Math.min(yb, y2[k]);// 如果当前矩形计算在内，保留公共区域。
                return Math.max(solve(x1, x2, y1, y2, k + 1, xa, ya, xb, yb),
                        solve(x1, x2, y1, y2, k + 1, xa1, ya1, xb1, yb1) + 1);// 当前矩形算不算
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] x1 = new int[n];
            int[] y1 = new int[n];
            int[] x2 = new int[n];
            int[] y2 = new int[n];
            for (int i = 0; i < n; i++) {
                x1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                x2[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y2[i] = sc.nextInt();
            }
            int ans = 1;
            for (int i = 0; i < x1.length; i++)// 依次以不同矩形为基础进行计算，同时以相应的坐标点为基准值。求最大值。
            {
                int num = solve(x1, x2, y1, y2, 0, x1[i], y1[i], x2[i], y2[i]);
                ans = Math.max(num, ans);
            }
            System.out.println(ans);
        }
    }
}
```

## 第二题
### 题目描述
>牛牛以前在老师那里得到了一个正整数数对（x,y），牛牛忘记他们具体是多少了。但是牛牛记得老师告诉他x和y均不大于n,并且x除以y的余数大于等于k。牛牛希望你能帮他计算一共有多少个可能的数对。

**输入描述:**
>输入包括两个正整数n,k(1<=n<=10^5,0<=k<=n-1)

**输出描述：**
>对于每个测试用例，输出一个正整数表示可能的数对数量。

**例子：**

输入：
```
5 2
```
输出
```
7
```
说明
```
满足条件的数对有：（2,3）（2,4）（2,5）（3,4）（3,5）（4,5）（5,3）
```

### 解题思路

- 余数循环出现
- 叠加每组循环余数中余数大于k的元素的个数,以及剩下的一次循环余数不足情况下余数大于等于k的元素的个数
- 举例
```
n=10 k=2
i= 1  %  3 =  1
i= 2  %  3 =  2
i= 3  %  3 =  0
i= 4  %  3 =  1
i= 5  %  3 =  2
i= 6  %  3 =  0
i= 7  %  3 =  1
i= 8  %  3 =  2
i= 9  %  3 =  0
i=10  %  3 =  1
```

### 参考代码

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (k == 0)
                System.out.println(1L * n * n);
            else {
                long ans = 0L;
                for (int i = k + 1; i <= n; i++) {
                    ans += (n / i) * (i - k);
                    if (n % i >= k)
                        ans += n % i - k + 1;
                }
                System.out.println(ans);
            }
        }
    }
}
```

## 第三题

### 题目描述
>为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。

**输入描述:**
>每个输入包含一个测试用例。
每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
保证不存在两项工作的报酬相同。

**输出描述:**
>对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

**输入例子1:**
```
3 3
1 100
10 1000
1000000000 1001
9 10 1000000000
```

**输出例子1:**
```
100
1000
1001
```

### 解题思路
- 维护一个（N+M）的dp[N+M]的数组，记录不同能力和不同难度下的最大薪酬
- 复杂度 MAX（O(NlogN),O(MlogM),O(N+M))

<div align="center"> <img src="https://raw.githubusercontent.com/LyricYang/Internet-Recruiting-Algorithm-Problems/master/InternetRecruitingAlgorithmProblems/NETEASE/pic/Q3Y2018.png"/> </div><br>

### 参考代码

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] mission = new int[N + 1][2];
            int[][] person = new int[M + 1][2];
            for (int i = 1; i <= N; i++) {
                mission[i][0] = in.nextInt();
                mission[i][1] = in.nextInt();
            }
            for (int i = 1; i <= M; i++) {
                person[i][0] = in.nextInt();
                person[i][1] = i;
            }

            Arrays.sort(mission, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    int[] one = (int[]) o1;
                    int[] two = (int[]) o2;
                    if (one[0] > two[0])
                        return 1;
                    else if (one[0] < two[0])
                        return -1;
                    else
                        return 0;
                }
            });
            Arrays.sort(person, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    int[] one = (int[]) o1;
                    int[] two = (int[]) o2;
                    if (one[0] > two[0])
                        return 1;
                    else if (one[0] < two[0])
                        return -1;
                    else
                        return 0;
                }
            });

            int[] DP = new int[N + M + 1];
            int[] location = new int[M + 1];
            int index = 1;
            int left = 1;
            int right = 1;
            while (left <= N && right <= M) {
                if (mission[left][0] < person[right][0]) {
                    DP[index++] = mission[left++][1];
                } else if (mission[left][0] == person[right][0]) {
                    DP[index] = mission[left++][1];
                    location[person[right][1]] = index;
                    right++;
                    index++;
                } else {
                    location[person[right][1]] = index;
                    index++;
                    right++;
                }
            }
            while (right <= M) {
                location[person[right][1]] = index;
                index++;
                right++;
            }
            for (int i = 1; i <= N + M; i++) {
                DP[i] = Math.max(DP[i - 1], DP[i]);
            }
            for (int i = 1; i <= M; i++) {
                System.out.println(DP[location[i]]);
            }
        }
    }
}
```

## 第四题

### 题目描述
>小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
并且小Q对于能否被3整除这个性质很感兴趣。
小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。

**输入描述:**
>输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。

**输出描述:**
>输出一个整数, 表示区间内能被3整除的数字个数。

**输入例子1:**
```
2 5
```

**输出例子1:**
```
3
```

**例子说明1:**
```
12, 123, 1234, 12345...
其中12, 123, 12345能被3整除
```

### 解题思路
- 每个数字加起来能被3整除
- 周期循环，余数为2或0都能整除

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int left = in.nextInt();
            int right = in.nextInt();
            int result = 0;
            for(int i=left;i<=right;i++){
                if(i%3==0||i%3==2){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
```

## 第五题

### 题目描述
>小Q正在给一条长度为n的道路设计路灯安置方案。
为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。

**输入描述:**
>输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
第二行一个字符串s表示道路的构造,只包含'.'和'X'。

**输出描述:**
>对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。

**输入例子1:**
```
2
3
.X.
11
...XX....XX
```

**输出例子1:**
```
1
3
```

### 解题思路
- 因为路灯只能照亮三个位置，所以将道路方格分成三个一组进行讨论，共有8种情况
- 如果是上面四种情况，第一个位置是'.'，则路灯数加1，下面四种情况第一个位置是'X'，则将下标向右移一位重新进行分组考虑

```
...  ..X  .X.  .XX
XXX  XX.  X.X  X..
```

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int t = Integer.parseInt(in.nextLine());
            for(int i=0;i<t;i++){
                int n = Integer.parseInt(in.nextLine());
                String s = in.nextLine();
                int res = 0;
                int index=0;
                while(index<s.length()){
                    if(index+2>=s.length()){
                        break;
                    }
                    if(s.charAt(index)=='X')
                        index++;
                    else{
                        index+=3;
                        res++;
                    }
                }
                if(index+1<=s.length())
                    if(s.charAt(index)=='.')
                        res++;
                    else if(index+2==s.length()){
                        if(s.charAt(index+1)=='.')
                            res++;
                    }
                System.out.println(res);
            }
        }
    }
}
```

## 第六题

### 题目描述
>牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。

**输入描述:**
>每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。

**输出描述:**
>输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。

**输入例子1:**
```
3
LRR
```

**输出例子1:**
```
E
```

### 解题思路

- 分析面向不同方向做左转右转动作后的不同朝向，即模拟行走过程。

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int N = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            String res = "N";
            for(int i=0;i<s.length();i++){
                if(res.equals("N")){
                    if(s.charAt(i)=='L')
                        res="W";
                    else
                        res="E";
                }
                else if(res.equals("S")){
                    if(s.charAt(i)=='L')
                        res="E";
                    else
                        res="W";
                }
                else if(res.equals("E")){
                    if(s.charAt(i)=='L')
                        res="N";
                    else
                        res="S";
                }
                else if(res.equals("W")){
                    if(s.charAt(i)=='L')
                        res="S";
                    else
                        res="N";
                }
            }
            System.out.println(res);
        }
    }
}
```

## 第七题

### 题目描述
>牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床。

**输入描述:**
>每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=Hi<24)时Mi(0<=Mi<60)分。
接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
数据保证至少有一个闹钟可以让牛牛及时到达教室。

**输出描述:**
>输出两个整数表示牛牛最晚起床时间。

**输入例子1:**
```
3 
5 0 
6 0 
7 0 
59 
6 59
```

**输出例子1:**
```
6 0
```

### 解题思路

- 将时分格式的时间转化为分钟表示的时间，找到最大的小于起床时间（上课时间-路程时间）的闹铃时间

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int[] alarm=new int[N];
            for(int i=0;i<N;i++){
                alarm[i]=in.nextInt()*60+in.nextInt();
            }
            int X = in.nextInt();
            int school = in.nextInt()*60+in.nextInt();
            int wakeup = school-X;
            Arrays.sort(alarm);
            int index=Arrays.binarySearch(alarm,wakeup);
            int res=0;
            if(index<0){
                res=-index-2;
            }
            else{
                res = index;
            }
            System.out.println(alarm[res]/60+" "+alarm[res]%60);
        }
    }
}
```

## 第八题

### 题目描述
>牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。


**输入描述:**
>输入包括两行
第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。

**输出描述:**
>输出一个正整数, 表示牛牛一共有多少种零食放法。

**输入例子1:**
```
3 10
1 2 4
```

**输出例子1:**
```
8
```

**例子说明1:**
>三种零食总体积小于10,于是每种零食有放入和不放入两种情况，一共有2*2*2 = 8种情况。

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int w = in.nextInt();
            int[] v = new int[n];
            for(int i=0;i<n;i++){
                v[i]=in.nextInt();
            }
            Arrays.sort(v);
            int[][] dp = new int[v.length][w+1];
            for(int j=0;j<=w;j++){
                if(j>=v[0])
                    dp[0][j]=2;
                else
                    dp[0][j]=1;
            }
            for(int i=1;i<v.length;i++){
                for(int j=0;j<=w;j++){
                    if(j-v[i]>=0)
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-v[i]];
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
            System.out.println(dp[v.length-1][w]);
        }
    }
}
```
- Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int w = in.nextInt();
            int[] v = new int[n];
            for(int i=0;i<n;i++){
                v[i]=in.nextInt();
            }
            long res = putSolution(v,w,n-1);
            System.out.println(res);
        }
    }
    public static long putSolution(int[] v,int w,int n){
        if(w<0)
            return 0;
        if(n==0&&w>=v[0])
            return 2;
        if(n==0&&w<v[0])
            return 1;
        return putSolution(v,w,n-1)+putSolution(v,w-v[n],n-1);
    }
}
```
- 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
case通过率为80.00%




## 第九题

### 题目描述
>小易觉得高数课太无聊了，决定睡觉，不过他对课上的一些内容挺感兴趣的，所以希望你在老师讲到有趣的部分的时候叫醒他一下。
你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使他在接下来的k分钟内保持清醒。
你需要选择一种方案最大化小易这堂课听的知识点分值。


**输入描述:**
>第一行n,k(1<=n,k<=10^5)，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 第二行n个数，a1,a2,...,an(1<=ai<=10^4)表示小易对每分钟知识点的感兴趣评分。
 第三行n个数，t1,t2,...,tn表示每分钟小易是否清醒，1表示清醒。

**输出描述:**
>小易这堂课听到的知识点的最大兴趣值。

**输入例子1:**
```
6 3
1 3 5 2 5 4
1 1 0 1 0 0
```

**输出例子1:**
```
16
```

### 参考代码

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] score = new int[n];
        int[] wakeup = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            score[i]=in.nextInt();
            sum+=score[i];
        }
        for(int i=0;i<n;i++){
            wakeup[i]=in.nextInt();
        }
        if(n<=k) System.out.println(sum);
        else{
            sum=0;
            int max=0;
            for(int i=0;i<n;i++){
                if(wakeup[i]==1){
                    sum+=score[i];
                }else{
                    int bound = (i+k-1)>=n?n-1:(i+k-1);
                    int window = 0;
                    for(int j=i;j<=bound;j++){
                        if(wakeup[j]==0){
                            window+=score[j];
                        }
                    }
                    if(window>max){
                        max=window;
                    }
                }
            }
            System.out.println(max+sum);
        }
    }
}
```

## 第十题

### 题目描述
>又到了丰收的季节，恰好小易去牛牛的果园里游玩。
牛牛常说他多整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
在果园里有N堆苹果，每堆苹果的数量为ai,小易希望知道从左往右数第x个苹果是属于哪一堆的。
牛牛觉得问题太简单了，所以希望你来替他回答。


**输入描述:**
>第一行一个数n(1<=n<=10^5)
 第二行n个数ai(1<=ai<=1000),表示从左往右数第i堆有多少苹果
 第三行一个数m(1<=m<=10^5),表示有m次询问
 第四行m个数qi,表示小易希望知道第qi个苹果属于哪一堆。

**输出描述:**
>m行，第i行输出第qi个苹果属于哪一堆。

**输入例子1:**
```
5
2 7 3 4 9
3
1 25 11
```

**输出例子1:**
```
1
5
3
```

### 参考代码

```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++)
            arr[i] = in.nextInt();
        int m = in.nextInt();
        int[] q = new int[m];
        for (int i = 0; i < m; i++)
            q[i] = in.nextInt();
        int[] res = new int[count];
        res[0] = arr[0];
        // 累加
        for (int i = 1;i < count;i++)
            res[i] = arr[i] + res[i - 1];
        // 二分查找
        for (int i = 0; i < m; i++) {
            int j = 0, k = count - 1;
            while (j < k){
                int mid = (j + k) /2;
                if (q[i] > res[mid])
                    j = mid + 1;
                else if (q[i] < res[mid])
                    k = mid;
                else
                    k = mid;
            }
            System.out.println(k + 1);
        }
    }
}
```


## 第十一题

### 题目描述
>给你n个a,m个z组成所有可能的字符串，并将字符串按字典序从小到大排列，输出第k个字符串。


**输入描述:**
>第一行为三个数，分别为a的个数n,z的个数m,第k个字符串。

**输出描述:**
>第k个字符串

**输入例子1:**
```
2 2 6
```

**输出例子1:**
```
zzaa
```

### 解题思路

- 刚开始深度优先存储所有字符串，然后取出第k个字符串，通过30%；
- 通过计算不同等级的组合数，看k在哪一种情况下，比较考验数学分析。

### 参考代码

```java
import java.util.ArrayList;
        import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        ArrayList<String> map = new ArrayList<>();
        DFS(n,m,map,"");
        if(k>map.size()) System.out.println(-1);
        else System.out.println(map.get(k-1));
    }

    private static void DFS(int n,int m,ArrayList<String> map,String s){
        if(n==0&&m==0){
            map.add(s);
            return;
        }
        if(n>0){
            DFS(n-1,m,map,s+"a");
        }
        if(m>0){
            DFS(n,m-1,map,s+"z");
        }
    }
}
```

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        String res = solve(n,m,k);
        System.out.println(res);
    }
    private static String solve(int a,int z,int k){
        String out = "";
        int n = a+z;
        int s = check(a+z,a,(long)k);
        if(s != -1) return out;
        for(int i = 0; i < n; i++) {
            if (a == 0 || z == 0) break;
            s=check(a-1+z,a-1,k);
            if(s==-1){
                out += "a";
                a--;
            }else{
                k -= s;
                out += "z";
                z--;
            }
        }
        for(int i=0;i<a;i++) out+="a";
        for(int i=0;i<z;i++) out+="z";
        return out;
    }
    private static int check(int a,int b,long lim) {
        long res = 1;
        if(b*2>a) b = a-b;
        for(int i=0;i<b;i++){
            res*=(a-i);
            res/=(i+1);
            if(res>=lim) return -1;
        }
        if(res>=lim) return -1;
        return (int)res;
    }
}
```

