# 360公司2018校园招聘算法笔试题

<!-- TOC -->
* [第一题](#第一题)
* [第二题](#第二题)
* [第三题](#第三题)
* [第四题:游乐园](#第四题-游乐园)
* [第五题:跳高游戏](#第五题-跳高游戏)
* [第六题:树上的旅行](#第六题-树上的旅行)
<!-- TOC -->


## 第一题

### 题目描述
>有一个城市需要修建，给你N个民居的坐标X,Y，问把这么多民居全都包进城市的话，城市所需最小面积是多少（注意，城市为平行于坐标轴的正方形）

**输入描述:**
>第一行为N，表示民居数目（2≤N≤1000）
下面为N行，每行两个数字Xi，Yi，表示该居民的坐标（-1e9≤xi,yi≤1e9）


**输出描述:**
>城市所需最小面积

**样例：**
```
输入
2
0 0
2 2

输出
4

输入样例2
2
0 0
0 3
输出样例2
9
```

### 参考代码
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] loc = new int[N][2];
        for(int i=0;i<N;i++){
            loc[i][0]=in.nextInt();
            loc[i][1]=in.nextInt();
        }
        long min = 0;
        long min_x = loc[0][0];
        long max_x = loc[0][0];
        long min_y = loc[0][1];
        long max_y = loc[0][1];
        for(int i = 1; i < N; ++i) {
            if(min_x > loc[i][0])
                min_x = loc[i][0];
            if(max_x < loc[i][0])
                max_x = loc[i][0];
            if(min_y > loc[i][1])
                min_y = loc[i][1];
            if(max_y < loc[i][1])
                max_y = loc[i][1];
        }
        min = (max_y-min_y)>(max_x-min_x)?(max_y-min_y)*(max_y-min_y):(max_x-min_x)*(max_x-min_x);
        System.out.println(min);
    }
}
```

## 第二题

### 题目描述
>小明有一个花园，花园里面一共有m朵花，对于每一朵花，都是不一样的，小明用1～m中的一个整数表示每一朵花。
他很喜欢去看这些花，有一天他看了n次，并将n次他看花的种类是什么按照时间顺序记录下来。
记录用a[i]表示，表示第i次他看了a[i]这朵花。
小红很好奇，她有Q个问题,问[l,r]的时间内，小明一共看了多少朵不同的花儿，小明因为在忙着欣赏他的花儿，所以想请你帮他回答这些问题。

**输入描述:**
>输入两个数n,m;(1<=n<=2000,1<=m<=100);分别表示n次看花，m表示一共有m朵花儿。
接下来输入n个数a[1]~a[n]，a[i]表示第i次，小明看的花的种类;
输入一个数Q(1<=Q<=1000000);表示小红的问题数量。
输入Q行 每行两个数 l,r(1<=l<=r<=n); 表示小红想知道在第l次到第r次，小明一共看了多少不同的花儿。


**输出描述:**
>一共Q行
每一行输出一个数 表示小明在[l,r]的时间内看了多少种花。

**样例：**
```
输入
5 3
1 2 3 2 2
3
1 4
2 4
1 5
输出
3
2
3
```

### 参考代码
```java
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] look = new int[n];
        for(int i=0;i<n;i++){
            look[i]=in.nextInt();
        }
        int k = in.nextInt();
        int[][] interval = new int[k][2];
        for(int i=0;i<k;i++){
            interval[i][0]=in.nextInt();
            interval[i][1]=in.nextInt();
        }
        for(int i=0;i<k;i++){
            HashSet<Integer> count = new HashSet<>();
            for(int j=interval[i][0]-1;j<=interval[i][1]-1;j++){
                count.add(look[j]);
            }
            System.out.println(count.size());
        }
    }
}

```

## 第三题

### 题目描述
>小红有两个长度为n的排列A和B。每个排列由[1,n]数组成，且里面的数字都是不同的。
现在要找到一个新的序列C，要求这个新序列中任意两个位置(i,j)满足:
如果在A数组中C[i]这个数在C[j]的后面，那么在B数组中需要C[i]这个数在C[j]的前面。
请问C序列的长度最长为多少呢？


**输入描述:**
>第一行一个整数，表示N。
第二行N个整数，表示A序列。
第三行N个整数，表示B序列。
满足:N<=50000


**输出描述:**
>输出最大的长度

**样例：**
```
输入
5
1 2 4 3 5
5 2 3 4 1
输入
2
```


### 参考代码

```java

```

## 第四题 游乐园

### 题目描述
>小明去游乐园玩耍，他的票一共可以玩t分钟。
游乐场一共有n个项目，编号1到n，第i个项目需要a[i]的时间。游乐场规定，在票没有到期前，拥有者都可以入场，无论完成项目出场时该票是否已经过期。
小明可以任意决定玩项目的顺序，但是每个项目他只想玩一次。问小明最长可以玩多久？


**输入描述:**
>第一行两个整数n，t，含义如题面，1≤n≤100，1≤t≤10000000；
接下来一行n个整数，第i个整数a[i]表示第i个项目所需的时间，1≤a[i]≤100。


**输出描述:**
>输出一个整数，表示小明最长可以玩多久。

**样例：**
```
输入
4 12
5 5 5 5
输出
15

输入
4 20
10 10 10 10
输出
20
```


### 参考代码

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        ArrayList<Integer> result = new ArrayList<>();
        DFS(0,0,arr,result,n,t);
        System.out.println(result.get(0));
    }

    public static void DFS(int index,int sum,int[] arr,ArrayList<Integer> result,int n,int t){
        if(sum>=t){
            if(result.size()==0){
                result.add(sum);
            }else{
                if(sum>result.get(0)){
                    result.add(0,sum);
                }
            }
            return;
        }
        for(int i=index;i<n;i++){
            DFS(i+1,sum+arr[i],arr,result,n,t);
            DFS(i+1,sum,arr,result,n,t);
        }

    }
}
```

## 第五题 跳高游戏

### 题目描述
>小新是一名小学生，最近妈妈给他送了一款小霸王游戏机，他非常的开心，里面有一款游戏他非常的喜爱。游戏中，一个模型会在一条隧道中向前运动，途中会遇到很多高高低低，上上下下的障碍物，小新需要用到不同的操作力度和按键方案来使模型跳到要求的高度从而越过障碍，连续跳高是比较难的操作，小新反反复复玩了很多遍，都没能前进很多。
于是他希望从失败中寻找一些规律，以便下次再玩时会轻松的越过这些障碍。我们假设一共有n个障碍物，从左到右分别用1到n来标识。我们用一个整数ai来表示小新需要在第i个障碍物处恰好跳到ai的高度才可以越过该障碍，如果连续3个障碍物的高度是不递减的，即ai≤ai+1≤ai+2，那么小新会将这里记为障碍难点。
注意每个障碍物可以被多次记录，例如连续5个障碍物的高度分别为1 2 3 4 5，这里有3个障碍难点，分别为1 2 3，2 3 4，3 4 5。现在小新知道了n个障碍物的高度，他想知道区间[l , r]里一共有多少个障碍难点，你能帮助他计算一下么？


**输入描述:**
>第一行一个整数n，1≤n≤200000；
第二行n个整数，第i个整数ai表示从左到右越过第i个障碍物需要的高度，1≤ai≤100000000；
第三行一个整数m，表示有m次询问，1≤m≤200000；
接下来m行每行2个整数l，r，1≤l≤r≤200000；


**输出描述:**
>一共m行，每一行输出对应区间内的障碍难点个数，注意是左右闭区间。

**样例：**
```
输入
5
1 2 3 4 4
5
1 2
1 3
2 4
2 5
4 4
输出
0
1
1
2
0
```


### 参考代码

```java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int m = in.nextInt();
        int[][] range = new int[m][2];
        for(int i=0;i<m;i++){
            range[i][0] = in.nextInt();
            range[i][1] = in.nextInt();
        }
        for(int i=0;i<m;i++){
            if(range[i][1]-range[i][0]<2){
                System.out.println(0);
                continue;
            }
            int left = range[i][0]-1;
            int right = range[i][1]-1;
            boolean[] inc = new boolean[right-left];
            for(int j=left+1;j<=right;j++){
                if(arr[j]>=arr[j-1]){
                    inc[j-left-1]=true;
                }
            }
            int result = 0;
            for(int j=1;j<inc.length;j++){
                if(inc[j]&&inc[j-1]){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
```

## 第六题 树上的旅行

### 题目描述
>快乐之城是一个非常愉快的城市，这个城市由n个片区组成，片区与片区之间由n-1条道路相连。任意两个片区之间，都存在一条简单路径可以到达。
现在有两个人，小红与小明，正在快乐之城中旅游。但是小红与小明的关系不是很好，所以他们都不想在旅行的过程中碰见对方。
而你作为他们旅行的规划师，需要制定出完美的计划，满足这两个人的旅行路径不相交的目标。
当然，这两个人的旅行路径都是从一个地方旅行到另外一个地方，且他们的路线一定是最短的路线。
请问，能够构造出多少种不同的计划呢？

**输入描述:**
>第一行一个整数n，表示快乐之城由n条片区组成。
接下来n-1行，每行两个整数x,y，表示片区x与片区y相连。
满足
1<=n<=30000
1<=x,y<=n


**输出描述:**
>输出一共有多少种计划。

**样例：**
```
输入
4
1 2
2 3
3 4
输出
8

Hint
表示小明的旅行计划是从A走到B，小红的旅行计划是从C走到D。

<1,2,3,4>,<2,1,3,4>,<1,2,4,3>,<2,1,4,3>

<3,4,1,2>,<3,4,2,1>,<4,3,1,2>,<4,3,2,1>
```


### 参考代码

```java

```

