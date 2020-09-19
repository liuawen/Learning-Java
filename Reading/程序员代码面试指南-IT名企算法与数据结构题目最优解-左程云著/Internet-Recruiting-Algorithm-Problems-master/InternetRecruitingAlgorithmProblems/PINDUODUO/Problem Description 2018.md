# 拼多多2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:最大乘积](#第一题-最大乘积)
* [第二题:大整数相乘](#第二题-大整数相乘)
* [第三题:六一儿童节](#第三题-六一儿童节)
* [第四题:迷宫寻路](#第四题-迷宫寻路)
<!-- TOC -->


## 第一题 最大乘积

### 题目描述
>给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)

**输入描述:**
>无序整数数组A[n]

**输出描述:**
>满足条件的最大乘积

**样例：**

**输入**
>3 4 1 2

**输入**
>24

### 解题思路

- 由于题目要求时间复杂度为O(n)，空间复杂度为O(1)。所以考虑使用单调栈的数据结构，维护3个元素的单调递减栈，即取出数组中最大的三个元素。同时维护2个元素的单调递增栈，存储的是数组中最小的两个元素，目的是为了考虑负负得正的情况。

### 参考代码
```java
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L = in.readLine();
        String[] L1 = in.readLine().split(" ");
        int[] A = new int[L1.length];
        for(int i=0;i<A.length;i++){
            A[i]=Integer.parseInt(L1[i]);
        }
        if(A.length<3)
            System.out.println(0);
        else{
            Stack<Integer> maxStack = new Stack<>();
            int lenOfmax = 0;
            Stack<Integer> minStack = new Stack<>();
            int lenOfmin = 0;
            for(int i=0;i<A.length;i++){
                if(maxStack.empty()){
                    maxStack.push(A[i]);
                    lenOfmax++;
                }else{
                    Stack<Integer> temp = new Stack<>();
                    while(!maxStack.empty()&&maxStack.peek()<A[i]){
                        temp.push(maxStack.pop());
                        lenOfmax--;
                    }
                    if(lenOfmax<3){
                        maxStack.push(A[i]);
                        lenOfmax++;
                    }
                    while(lenOfmax<3&&!temp.empty()){
                        maxStack.push(temp.pop());
                        lenOfmax++;
                    }
                }
                if(minStack.empty()){
                    minStack.push(A[i]);
                    lenOfmin++;
                }else{
                    Stack<Integer> temp = new Stack<>();
                    while(!minStack.empty()&&minStack.peek()>A[i]){
                        temp.push(minStack.pop());
                        lenOfmin--;
                    }
                    if(lenOfmin<2){
                        minStack.push(A[i]);
                        lenOfmin++;
                    }
                    while(lenOfmin<2&&!temp.empty()){
                        minStack.push(temp.pop());
                        lenOfmin++;
                    }
                }
            }
            long maxPositive = 1;
            long maxNegitive = 1;
            while(lenOfmax>1){
                maxPositive*=maxStack.pop();
                lenOfmax--;
            }
            maxPositive*=maxStack.peek();
            maxNegitive*=maxStack.pop();
            while(!minStack.empty()){
                maxNegitive*=minStack.pop();
            }
            long res = maxPositive>maxNegitive?maxPositive:maxNegitive;
            System.out.println(res);
        }

    }
}
```


## 第二题 大整数相乘

### 题目描述
>有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。

**输入描述:**
>空格分隔的两个字符串，代表输入的两个大整数

**输出描述:**
>输入的乘积，用字符串表示

**样例：**

**输入**
>72106547548473106236 982161082972751393

**输入**
>70820244829634538040848656466105986748


### 参考代码
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


## 第三题 六一儿童节

### 题目描述
>六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。。

**输入描述:**
>第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素

**输出描述:**
>上台表演学生人数

**样例：**

**输入**
>
```
3
2 2 3
2
3 1
```

**输入**
>1

### 解题思路

- 排序过后用贪心法，对每块巧克力找到最合适的小朋友。


### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int[] h = new int[n];
            for(int i=0;i<n;i++){
                h[i]=in.nextInt();
            }
            int m=in.nextInt();
            int[] w = new int[m];
            for(int i=0;i<m;i++){
                w[i]=in.nextInt();
            }
            Arrays.sort(h);
            Arrays.sort(w);
            int res=0;
            int index=0;
            for(int i=0;i<m;i++){
                if(h[index]<=w[i]){
                    res++;
                    index++;
                }
                if(index>=n){
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
```


## 第四题 迷宫寻路

### 题目描述
>假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。请设计一个算法，帮助探险家找到脱困的最短路径。如前所述，迷宫是通过一个二维矩阵表示的，每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙。

**输入描述:**
>迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。

**输出描述:**
>路径的长度，是一个整数

**样例：**

**输入**
>
```
5 5
02111
01a0A
01003
01001
01111
```

**输入**
>7

### 解题思路

- 带约束的BFS。


### 参考代码
```java
import java.util.*;
 
public class Main {
    static class Node{
        int x;
        int y;
        int key;
        int step;
        public Node(int x,int y,int key,int step){
            this.x=x;
            this.y=y;
            this.key=key;
            this.step=step;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        in.nextLine();
        char[][] G=new char[N][M];
        for(int i=0;i<N;i++){
            G[i]=in.nextLine().toCharArray();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(G[i][j]=='2'){
                    System.out.println(bfs(i,j,N,M,G));
                    return;
                }
            }
        }
    }
    private static int bfs(int si, int sj,int N,int M,char[][] G) {
        Queue<Node> queue=new LinkedList<>();
        int[][][] mp=new int[101][101][1025];
        int[][] next={{-1,0},{0,-1},{1,0},{0,1}};
        queue.offer(new Node(si,sj,0,0));
        while(!queue.isEmpty()){
            Node node=queue.poll();
            for(int i=0;i<4;i++){
                int x=node.x+next[i][0];
                int y=node.y+next[i][1];
                int key=node.key;
                if(x<0||x>=N||y<0||y>=M||G[x][y]=='0') continue;
                else if(G[x][y]=='3') return node.step+1;
                else if(G[x][y]<='z'&&G[x][y]>='a') key=key|(1<<(G[x][y]-'a'));
                else if(G[x][y]<='Z'&&G[x][y]>='A'&&(key&(1<<(G[x][y]-'A')))==0) continue;
                if(mp[x][y][key]==0){
                    mp[x][y][key]=1;
                    queue.offer(new Node(x,y,key,node.step+1));
                }
            }
        }
        return -1;
    }
}
```
