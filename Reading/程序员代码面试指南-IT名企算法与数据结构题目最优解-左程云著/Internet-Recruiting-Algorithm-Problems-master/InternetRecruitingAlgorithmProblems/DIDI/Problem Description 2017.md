# 滴滴出行2017校园招聘算法笔试题

<!-- TOC -->
* [第一题:编码](#第一题-编码)
* [第二题:餐馆](#第二题-餐馆)
* [第三题:地下迷宫](#第三题-地下迷宫)
* [第四题:末尾0的个数](#第四题-末尾0的个数)
* [第五题:进制转换](#第五题-进制转换)
* [第六题:数字和为sum的方法数](#第六题-数字和为sum的方法数)
<!-- TOC -->


## 第一题 编码

### 题目描述
>一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3. 

**输入描述:**
>输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。

**输出描述:**
>所有连续子数组中和最大的值。

**样例：**

**输入**
>3 -1 2 1

**输入**
>3

### 解题思路

<div align="center">
<img src="http://latex.codecogs.com/gif.latex?f(x)=\left\{\begin{matrix}&space;Arr[i],i=0&space;\quad&space;or&space;\quad&space;f(i-1)\leq&space;0\\&space;f(i-1)&plus;Arr[i],i\neq&space;0&space;\quad&space;and&space;\quad&space;f(i-1)&space;>&space;0&space;\end{matrix}\right." title="f(x)=\left\{\begin{matrix} Arr[i],i=0 \quad or \quad f(i-1)\leq 0\\ f(i-1)+Arr[i],i\neq 0 \quad and \quad f(i-1) > 0 \end{matrix}\right." /></div>

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n= in.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int res=Integer.MIN_VALUE;
            int sum=arr[0];
            for(int i=0;i<n;i++){
                if(sum<=0){
                    sum=arr[i];
                }else{
                    sum+=arr[i];
                }
                if(sum>res)
                    res=sum;
            }
            System.out.println(res);
        }
    }
}
```

## 第二题 餐馆

### 题目描述
>某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大

**输入描述:**
>输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。

**输出描述:**
>输出一个整数,表示最大的总预计消费金额

**样例：**

**输入**
>3 5 2 4 2 1 3 3 5 3 7 5 9 1 10

**输入**
>20

### 解题思路

桌子序列升序排列  ，客人按照预定花钱多少降序排序，然后贪心法从钱多的客人开始招呼。但是这题时间复杂度卡得太紧，在遍历能容得下第i批客人的时候需要二分查找去找否则超时

### 参考代码
```java
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] L1 = in.readLine().trim().split(" ");
        int n = Integer.parseInt(L1[0]);
        int m = Integer.parseInt(L1[1]);
        String[] L2 = in.readLine().trim().split(" ");
        int[] table = new int[n];
        for(int i=0;i<n;i++){
            table[i] = Integer.parseInt(L2[i]);
        }
        Arrays.sort(table);
        int[][] customer = new int[m][2];
        for(int i=0;i<m;i++){
            String[] L = in.readLine().trim().split(" ");
            customer[i][0] = Integer.parseInt(L[0]);
            customer[i][1] = Integer.parseInt(L[1]);
        }
        Arrays.sort(customer,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return b[1]-a[1];
            }
        });
        boolean[] tableFlag = new boolean[n];
        long res=0L;
        for(int i=0;i<m;i++){
            if(customer[i][0]>table[n-1])
                continue;
            int index = bs(table,customer[i][0]);
            while(index<n&&tableFlag[index])
                index++;
            if(index<n){
                res+=customer[i][1];
                tableFlag[index]=true;
            }
            
        }
        System.out.println(res);
    }
    private static int bs(int[] num, int tar){
        int low=0;
        int high=num.length-1;
        int mid=0;
        while(low<=high){
            mid=(high+low)>>1;
            if(num[mid]>=tar)
                high=mid-1;
            else
                low=mid+1;
        }
         
        return low;
    }
}
```


## 第三题 地下迷宫

### 题目描述
>小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。

**输入描述:**
>输入包括n+1行:
 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 接下来的n行:
 每行m个0或者1,以空格分隔

**输出描述:**
>如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一

**样例：**

**输入**
>4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1

**输入**
>[0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]

### 解题思路

- 回溯法

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            int[][] map = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    map[i][j]=in.nextInt();
                }
            }
            ArrayList<ArrayList<int[]>> res = new ArrayList<>();
            ArrayList<int[]> path = new ArrayList<>();
            int[] start = {0,0};
            map[0][0]=0;
            path.add(start);
            findPath(res,path,map,p,n,m);
            if(res.size()<=0){
                System.out.println("Can not escape!");
            }else{
                ArrayList<int[]> min = res.get(0);
                for(int i=1;i<res.size();i++){
                    if(res.get(i).size()<min.size()){
                        min=res.get(i);
                    }
                }
                System.out.print("["+min.get(0)[0]+","+min.get(0)[1]+"]");
                for(int i=1;i<min.size();i++){
                    System.out.print(",["+min.get(i)[0]+","+min.get(i)[1]+"]");
                }
                System.out.println();
            }

        }
    }
    public static void findPath(ArrayList<ArrayList<int[]>> res,ArrayList<int[]> path,int[][] map,int p,int n,int m){
        int[] cur = new int[2];
        cur[0]=path.get(path.size()-1)[0];
        cur[1]=path.get(path.size()-1)[1];
        if(p<0){
            return;
        }
        if(p>=0&&cur[0]==0&&cur[1]==m-1){
            res.add(new ArrayList<>(path));
            return;
        }
        if(cur[0]-1>=0){
            int[] temp = new int[2];
            temp[0]=cur[0]-1;
            temp[1]=cur[1];
            if(map[temp[0]][temp[1]]==1){
                map[temp[0]][temp[1]]=0;
                path.add(temp);
                findPath(res,path,map,p-3,n,m);
                path.remove(path.size()-1);
                map[temp[0]][temp[1]]=1;
            }
        }
        if(cur[1]+1<m){
            int[] temp = new int[2];
            temp[0]=cur[0];
            temp[1]=cur[1]+1;
            if(map[temp[0]][temp[1]]==1){
                map[temp[0]][temp[1]]=0;
                path.add(temp);
                findPath(res,path,map,p-1,n,m);
                path.remove(path.size()-1);
                map[temp[0]][temp[1]]=1;
            }
        }
        if(cur[0]+1<n){
            int[] temp = new int[2];
            temp[0]=cur[0]+1;
            temp[1]=cur[1];
            if(map[temp[0]][temp[1]]==1){
                map[temp[0]][temp[1]]=0;
                path.add(temp);
                findPath(res,path,map,p,n,m);
                path.remove(path.size()-1);
                map[temp[0]][temp[1]]=1;
            }
        }
        if(cur[1]-1>=0){
            int[] temp = new int[2];
            temp[0]=cur[0];
            temp[1]=cur[1]-1;
            if(map[temp[0]][temp[1]]==1){
                map[temp[0]][temp[1]]=0;
                path.add(temp);
                findPath(res,path,map,p-1,n,m);
                path.remove(path.size()-1);
                map[temp[0]][temp[1]]=1;
            }
        }
    }
}
```

## 第四题 末尾0的个数

### 题目描述
>输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2。

**输入描述:**
>输入为一行，n(1 ≤ n ≤ 1000)

**输出描述:**
>输出一个整数,即题目所求

**样例：**

**输入**
>10

**输入**
>2

### 解题思路

- 2和5同时出现末尾便会有0，而2出现的次数远远大于5，则计算5出现的次数，25,50,75,...需要另外考虑；

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int count=0;
            while(n/5!=0){
                n=n/5;
                count+=n;
            }
            System.out.println(count);

        }
    }
}
```

## 第六题 数字和为sum的方法数

### 题目描述
>给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。

**输入描述:**
>输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。

**输出描述:**
>输出所求的方案数

**样例：**

**输入**
>5 15 5 5 10 2 3

**输入**
>4

### 解题思路

给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
```
解：此题使用递归的遍历方法也可以解决，但是会超时
dp解决：
以每个物品作为横轴，以背包容量作为纵轴
0 | 1 2 3 4 5 6
——— —— —— —— ——
0 | 1 0 0 0 0 0
5 | 1 0 0 0 0 1
其中1表示前n件物品放入容量为M的背包有1种方法，（5，0）表示重量为5的物品放入容量为0的背包的背包有1中方法，即不放入。0表示恰好放满背包的方法为0
```
当M>weight[i]时，dp[M]=dp[M]+dp[M-weight[i]];意义是：放入物品i和不放入物品i的方法总和

### 参考代码
```java
import java.util.Scanner;
public class Main {
    public static int n=0; 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
            int[]a=new int[n+1];
            int sum=sc.nextInt();
            for (int i = 1; i <=n; i++) {
                a[i]=sc.nextInt();
            }
            System.out.println(calculate(a,sum));
        sc.close();
    }
    public static long calculate(int[] a,int sum)
    {
        long dp[][]=new long[n+1][sum+1];
        dp[0][0]=1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=sum; j++) {
                if(j>=a[i])
                    dp[i][j]=dp[i-1][j-a[i]]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }

        }
        return dp[n][sum];
    }
}
```
