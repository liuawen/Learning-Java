# 网易2017校园招聘算法笔试题

<!-- TOC -->
* [第一题：合唱团](#第一题-合唱团)
* [第二题：地牢逃脱](#第二题-地牢逃脱)
* [第三题：下厨房](#第三题-下厨房)
* [第四题：分田地](#第四题-分田地)
* [第五题：分苹果](#第五题-分苹果)
* [第六题：星际穿越](#第六题-星际穿越)
* [第七题：藏宝图](#第七题-藏宝图)
* [第八题：数列还原](#第八题-数列还原)
* [第九题：混合颜料](#第九题-混合颜料)
* [第十题：幸运的袋子](#第十题-幸运的袋子)
* [第十一题：不要二](#第十一题-不要二)
* [第十二题：解救小易](#第十二题-解救小易)
* [第十三题：统计回文](#第十三题-统计回文)
* [第十四题：饥饿的小易](#第十四题-饥饿的小易)
* [第十五题：两种排序方法](#第十五题-两种排序方法)
* [第十六题：小易喜欢的单词](#第十六题-小易喜欢的单词)
* [第十七题：Fibonacci数列](#第十七题-Fibonacci数列)
* [第十八题：数字游戏](#第十八题-数字游戏)
<!-- TOC -->

## 第一题 合唱团

### 题目描述
>有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？

**输入描述:**
>每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。

**输出描述:**
>输出一行表示最大的乘积。

**样例：**
```
输入
3
7 4 7
2 50

输出
49
```

### 解题思路
- 采用动态规划。设Maxval[i][j]表示以第i个人为最后一个人，一共选取了j+1个人时的最大乘积。
同理，Minval[i][j]表示同样状态下的最小乘积（由于数据中存在负数，负数乘上某个极大的负数反而会变成正的极大值，因而需要同时记录最小值）。
Maxval[i][j]很显然与Maxval[i][j-1]相关，可以理解为Maxval[i][j]由两部分组成，一部分是自身作为待选值，另一部分是Maxval[i][j-1]乘上一个人后得到的值，然后取它们的极大值，由此可以得到状态转移方程如下：

<div align="center"> <img src="https://raw.githubusercontent.com/LyricYang/Internet-Recruiting-Algorithm-Problems/master/InternetRecruitingAlgorithmProblems/NETEASE/pic/Q1Y2017.jpg"/> </div><br>

### 参考代码

```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int[] power = new int[n];
            for(int i=0;i<n;i++){
                power[i]=in.nextInt();
            }
            int k=in.nextInt();
            int d=in.nextInt();
            System.out.println(MaxPower(power,k,d));
        }
    }
    static long max(long a, long b) {
        return a > b ? a : b;
    };

    static long min(long a, long b) {
        return a < b ? a : b;
    };

    private static long MaxPower(int[] array, int k, int d) {
        long dpMax[][] = new long[array.length][k + 1];
        long dpMin[][] = new long[array.length][k + 1];
        // dpMax[i][j] 表示以数组元素A【i】作结尾时， 序列长度为j的最大乘积结果
        for (int i = 0; i < array.length; i++) {
            dpMax[i][1] = array[i];
            dpMax[i][0] = array[0];
        }

        // 状态转移方程是 dpMax[i][j] = max(dpMax[i-1][j-1]* A[i], dpMin[i-d][j-1] * A[i])

        long maxSoFar = Long.MIN_VALUE;
        for (int j = 2; j <= k; j++) {
            for (int i = j - 1; i < array.length; i++) {
                dpMax[i][j] = Long.MIN_VALUE;
                dpMin[i][j] = Long.MAX_VALUE;
                for (int x = 1; x <= d && (i - x) >= j - 2; x++) {
                    // 倒数第二个元素自己加上之前的元素数量至少还要有j-1个， 所以下标i-x需要大于j-2
                    long resMax = max(dpMax[i - x][j - 1] * array[i], dpMin[i - x][j - 1] * array[i]);
                    long resMin = min(dpMax[i - x][j - 1] * array[i], dpMin[i - x][j - 1] * array[i]);

                    if (resMax > dpMax[i][j])
                        dpMax[i][j] = resMax;
                    if (resMin < dpMin[i][j])
                        dpMin[i][j] = resMin;

                }
            }
        }

        for (int i = k-1; i < array.length; i++) {
            if (dpMax[i][k] > maxSoFar) {
                maxSoFar = dpMax[i][k];
            }
        }

        return maxSoFar;

    }

}
```

## 第二题 地牢逃脱

### 题目描述
>给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。

**输入描述:**
>每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），出发位置一定是 '.'）。之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）

**输出描述:**
>输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。

**样例：**
```
输入
3 3
...
...
...
0 1
4
1 0
0 1
-1 0
0 -1

输出
3
```

### 解题思路
- 题意可以理解为：有没有可以通行的点，但牛牛到不了（输出-1）。如果没有这样的点，牛牛可能花费最多步数是多少。
BFS算法：计算地图里，每个点的最短到达步数。找到到不了的点，或者步数最多的点。
 1. 分别用stepMap，stepLen矩阵表示地牢，步长限制。其中在stepMap中-2表示'X'，-1表示'.'。
 2. 在stepMap中设置当前位置为0，在步长限制内能到的位置，即元素为-1的位置，更新值为当前步数+1
 3. 将位置坐标加入队列中以便下次搜索。
 4. 循环2，3步，直到没有新一轮的搜索点。

### 参考代码

```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String line1 = in.nextLine();
            String[] line1Arr = line1.split(" ");
            int n = Integer.parseInt(line1Arr[0]);
            int m = Integer.parseInt(line1Arr[1]);
            int[][] stepMap = new int[n][m];
            for(int i=0;i<n;i++){
                String mapLine = in.nextLine();
                for(int j=0;j<mapLine.length();j++){
                    if(mapLine.charAt(j)=='.'){
                        stepMap[i][j]=-1;
                    }else{
                        stepMap[i][j]=-2;
                    }
                }
            }
            String start = in.nextLine();
            String[] startArr = start.split(" ");
            int x0 = Integer.parseInt(startArr[0]);
            int y0 = Integer.parseInt(startArr[1]);
            int k = Integer.parseInt(in.nextLine());
            int[][] stepLen = new int[k][2];
            for(int i=0;i<k;i++){
                String stepLine = in.nextLine();
                String[] stepLIneArr = stepLine.split(" ");
                stepLen[i][0]=Integer.parseInt(stepLIneArr[0]);
                stepLen[i][1]=Integer.parseInt(stepLIneArr[1]);
            }
            LinkedList<Integer> xQueue = new LinkedList<>();
            LinkedList<Integer> yQueue = new LinkedList<>();
            stepMap[x0][y0]=0;
            xQueue.add(x0);
            yQueue.add(y0);
            //BFS搜索
            while(xQueue.size()>0&&yQueue.size()>0){
                int curX = xQueue.poll();
                int curY = yQueue.poll();
                for(int i=0;i<k;i++){
                    int x = curX+stepLen[i][0];
                    int y = curY+stepLen[i][1];
                    if(x>=0 && x<n && y>=0 && y<m && stepMap[x][y] == -1){
                        stepMap[x][y] = stepMap[curX][curY]+1;
                        xQueue.add(x);
                        yQueue.add(y);
                    }
                }
            }
            int res=-1;
            boolean flag=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(stepMap[i][j]==-1){
                        flag=true;
                        res=-1;
                        break;
                    }
                    else{
                        if(stepMap[i][j]>res){
                            res=stepMap[i][j];
                        }
                    }
                }
                if(flag){
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
```


## 第三题 下厨房

### 题目描述
>牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。

**输入描述:**
>每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。

**输出描述:**
>输出一行一个数字表示完成所有料理需要多少种不同的材料。

**样例：**
```
输入
BUTTER FLOUR
HONEY FLOUR EGG

输出
4
```

### 解题思路
- 首先输入行数不定，则需要用while来判断输入是否结束，并用set来记录输入的材料种类，达到去重目的，即完成所有料理需要的食材种类。

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Set<String> Material = new HashSet<>();//记录食材种类，用于去重
        while(in.hasNext()){
            Material.add(in.next());
        }
        System.out.println(Material.size());
        Material.clear();
    }
}
```

## 第四题 分田地

### 题目描述
>牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？

**输入描述:**
>每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，每行包含 m 个 0-9 之间的数字，表示每块位置的价值。

**输出描述:**
>输出一行表示牛牛所能取得的最大的价值。

**样例：**
```
输入
4 4
3332
3233
3332
2323

输出
2
```

### 解题思路

- 假定二分值为mid。暴力枚举竖切的位置（三重循环），然后看横切能切多少刀。枚举横切时，当这部分的4个矩形（新的一横与上面一横之间被竖着的边界以及竖切三刀形成的四个矩形）的价值都大于等于mid，说明这一刀切得合理，从这个位置开始继续往下枚举横切。如果最终横切的刀数大于等于4，那么说明这个值mid是合理的，否则不合理。通过这样的不断压缩区间，最终必然能够得到答案。

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String line1 = in.nextLine();
            String[] line1Arr = line1.split(" ");
            int n = Integer.parseInt(line1Arr[0]);
            int m = Integer.parseInt(line1Arr[1]);
            int[][] map = new int[n+1][m+1];
            int[][] sum = new int[n+1][m+1];
            for(int i=1;i<=n;i++){
                String line = in.nextLine();
                for(int j=0;j<m;j++){
                    map[i][j+1] = line.charAt(j)-'0';
                }
            }
            
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+map[i][j];
                }
            }
            int l=0;
            int r=sum[n][m];
            int ans=0;
            while(l<=r){
                int mid = (l+r)>>1;
                if(judge(sum,mid,n,m)){
                    l=mid+1;
                    ans=mid;
                }
                else{
                    r=mid-1;
                }
            }
            System.out.println(ans);
        }
    }

    public static int calc(int[][] sum,int x,int y,int i,int j){
        return sum[x][y]-sum[x][j]-sum[i][y]+sum[i][j];
    }

    public static boolean judge(int[][] sum,int x,int n,int m){
        for(int i=1;i<=m-3;i++){
            for(int j=i+1;j<=m-2;j++){
                for(int k=j+1;k<=m-1;k++){
                    int last=0;
                    int cnt=0;
                    for(int r=1;r<=n;r++){
                        int s1=calc(sum,r,i,last,0);
                        int s2=calc(sum,r,j,last,i);
                        int s3=calc(sum,r,k,last,j);
                        int s4=calc(sum,r,m,last,k);
                        if(s1>=x&&s2>=x&&s3>=x&&s4>=x){
                            last=r;
                            cnt++;
                        }
                    }
                    if(cnt>=4){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
```

## 第五题 分苹果

### 题目描述
>n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。

**输入描述:**
>每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。

**输出描述:**
>输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。

**样例：**
```
输入
4
7 15 9 5

输出
3
```

### 解题思路
- 首先判断苹果能不能被牛均分，若不能则输入-1；
- 若能均分，求出均值，并计算每头牛拥有的苹果数与均值是否差2的倍数，若不是则输出-1；
- 从大于均值的牛处拿出苹果的次数与给小于均值的牛苹果的次数相同，则大于均值的苹果数目除以2即为操作的步数。

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] appleMap = new int[n];
            int appleSum = 0;
            for(int i=0;i<n;i++){
                appleMap[i]=in.nextInt();
                appleSum+=appleMap[i];
            }
            int result=0;
            if(appleSum%n==0){
                int avg = appleSum/n;
                for(int i=0;i<n;i++){
                    int diff = appleMap[i]-avg;
                    if(diff%2==0){
                        if(diff>0)
                            result+=diff/2;
                    }else{
                        System.out.println(-1);
                        return;
                    }
                }
            }else{
                System.out.println(-1);
                return;
            }
            System.out.println(result);
        }
    }
}
```

## 第六题 星际穿越

### 题目描述
>航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，科学家根据实验数据估计，如果在发射过程中，产生了 x 程度的损耗，那么在降落的过程中就会产生 x2 程度的损耗，如果飞船的总损耗超过了它的耐久度，飞行器就会爆炸坠毁。问一艘耐久度为 h 的飞行器，假设在飞行过程中不产生损耗，那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程中可以承受多少程度的损耗？

**输入描述:**
>每个输入包含一个测试用例。每个测试用例包含一行一个整数 h （1 <= h <= 10^18）。

**输出描述:**
>输出一行一个整数表示结果。

**样例：**
```
输入
10

输出
2
```

### 解题思路
- 是一题简单的求解一元二次方程(X^2+x=h)的算法题，只要计算求根公式就可以得出答案；
- 因为输入值已经超过了整数的范围，需要用long来表示；
- 居然发现通过输入流的方式读取值比Scanner方式读取值快了好多倍。


### 参考代码

```java
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long h = Long.parseLong(br.readLine());
        long result = (long)(-1 + Math.sqrt(1 + 4 * h)) / 2;
        System.out.println(result);
    }
}
```

## 第七题 藏宝图

### 题目描述
>牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。

**输入描述:**
>每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。

**输出描述:**
>输出一行 “Yes” 或者 “No” 表示结果。

**样例：**
```
输入
x.nowcoder.com
ooo

输出
YES
```

### 解题思路
- 动态规划：用一个s字符串长度的dp数组，记录t字符串中每个字符前有多少个s中的字符。
<div align="center"> <img src="https://raw.githubusercontent.com/LyricYang/Internet-Recruiting-Algorithm-Problems/master/InternetRecruitingAlgorithmProblems/NETEASE/pic/Q7Y2017.jpg"/> </div><br>

### 参考代码

```java
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        while((s = in.readLine()) != null){
            String t = in.readLine();
            int[] map = new int[s.length()];
            int loc=0;
            for(int i=0;i<map.length;i++){
                if(s.charAt(i)==t.charAt(loc))
                    loc++;
                map[i]=loc;
                if(loc==t.length()){
                    break;
                }
            }
            if(loc==t.length()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
```

## 第八题 数列还原

### 题目描述
>牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。

**输入描述:**
>每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。

**输出描述:**
>输出一行表示合法的排列数目。

**样例：**
```
输入
5 5
4 0 0 2 0

输出
2
```

### 解题思路

首先，顺序对的个数互不影响。也就是说，对于数组A来说，增加（插入）一个数字，其A的顺序对个数不变，所以新数组A+1的顺序对个数=数组A的顺序对+新插入的数字产生的顺序对.
进而推广到，增加c个数字，新数组A+c的顺序对=数组A的顺序对+数组c的顺序对+每个新插入的数字产生顺序对（共c个数字）。
所以，
1. 首先计算已经给出的数字共有arrbase个顺序对；
2. 然后计算缺失的数字共有canbase个顺序对；
3. 最后计算每个缺失的数字产生的顺序对；

对于2,3步骤，可以将缺失的数字（数组）进行全排列。

### 参考代码

```java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line1=null;
        while((line1=in.readLine())!=null){
            String[] s1 = line1.trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);
            String line2 = in.readLine();
            String[] s2=line2.trim().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(s2[i]);
            }
            int x1 = 0;
            int x2 = 0;
            int x3 = 0;
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                    continue;
                }else{
                    for(int j=i+1;j<n;j++){
                        if(arr[j]==0)
                            continue;
                        else{
                            if(arr[i]<arr[j]){
                                x1++;
                            }
                        }
                    }
                }
            }
            k-=x1;
            List<Integer> indexs = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i < n;i++){
                if(arr[i] > 0){
                    temp.add(arr[i]);
                }else{
                    indexs.add(i);
                }
            }
            
            for(int i = 1;i <= n;i++){
                if(!temp.contains(i)){
                    values.add(i);
                }
            }
            int res = count(arr,indexs,values,k);
            System.out.println(res);
        }
    }
    
    public static int count(int[] array,List<Integer> indexs,List<Integer> values,int k){
        int count = 0;
        if(indexs.size()==0){
            if(k==0)
                return 1;
            else
                return 0;
        }
        int index = indexs.remove(0);
        for(int i=0;i<values.size();i++){
            int value = values.get(i);
            array[index]=value;
            int pairs = getPairs(array,index);
            if(pairs<=k){
                values.remove(i);
                count+=count(array,indexs,values,k-pairs);
                values.add(i,value);
            }
        }
        array[index]=0;
        indexs.add(0,index);
        return count;
    }
    public static int getPairs(int[] array,int index){
        int count=0;
        for(int i=0;i<array.length;i++){
             if((i < index && array[i] < array[index]) || (i > index && array[i] > array[index])){
                count++;
            }
        }
        return count;
    }
}
```

## 第九题 混合颜料

### 题目描述
>你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？

**输入描述:**
>第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50)
第二行为n个数xi(1 ≤ xi ≤ 1,000,000,000)，表示需要的各种颜料.

**输出描述:**
>输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色。

**样例：**
```
输入
3
1 7 3

输出
3
```

### 解题思路
本题的数学意思是根据给出的几个数，要找到最少的数字根据规则（异或：相同为0，不同为1）可以得到给出的几个数。

1. 根据异或的原则，很容易联想到位运算。例如001,010,100便可生成1~7之间的所有数。所以，本题答案的上限应该是最大数字的位数。

2. 在给出的N个数中，可能有一些数是可以由其他数字异或生成，我们需要找到最“基础”的几个数，也就是由这几个数通过异或运算可以生成给出的所有数。那么什么是“基础”的数呢？ 
回想起矩阵当中的秩：通过矩阵初等变换求出的对角线上的元素个数。反应了矩阵元素样本所张成的线性子空间的维数。 
换言之，只要求出了矩阵的秩，那么通过初等变换是可以还原原始矩阵的。

3. 根据上面的分析，我们只需要对给出的数，求出其二进制位矩阵，然后做高斯消元，最后得到秩的个数即为需要求的最少的数字个数

### 参考代码

```java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line1=null;
        while((line1=in.readLine())!=null){
            int n = Integer.parseInt(line1);
            String line2 = in.readLine();
            String[] s2 = line2.trim().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(s2[i]); 
            }
            int count = 0;
            Arrays.sort(arr);
            for(int i=n-1; i>=0; i--){
                for(int j=i-1; j>=0; j--){
                    if(highbit(arr[i]) == highbit(arr[j])){
                        arr[j] = arr[j] ^ arr[i];
                    }
                }
                Arrays.sort(arr);
            }
            for(int i=0 ;i<n;i++)
                if(arr[i] !=0){
                    count++;
            }
            System.out.println(count);
        }
    }
    public static int highbit(int x){
        for(int i=31;i>=0;i--)
        {
           int m = (x>>i)&1;
           if(m != 0)
               return i+1;
        }
        return 0;
    }
}
```

## 第十题 幸运的袋子

### 题目描述
>一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。

**输入描述:**
>第一行输入一个正整数n(n ≤ 1000)
第二行为n个数正整数xi(xi ≤ 1000)

**输出描述:**
>输出可以产生的幸运的袋子数

**样例：**
```
输入
3
1 1 1

输出
2
```

### 解题思路
- 题目可以转化成求符合条件的集合真子集个数。每次从全集中选择若干元素（小球）组成子集（袋子）。集合子集个数为2^n个，使用dfs必然超时。且此题有重复元素，那么就搜索**剪枝**。对于任意两个正整数a,b如果满足`a+b>a*b`，则必有一个数为1.可用数论证明：
设`a=1+x,b=1+y，则1+x+1+y>(1+x)*(1+y)，--->  1>x*y`，则x，y必有一个为0，即a,b有一个为1.推广到任意k个正整数，假设a1,a2,...ak，如果不满足给定条件，即和sum小于等于积pi，如果此时再选择一个数b,能使其满足`sum+b > pi*b`，则，b必然为1，且为必要非充分条件。反之，如果选择的b>1，则`sum+b <=pi*b`，即a1,a2,...,ak,b不满足给定条件。
<div align="center"> <img src="https://raw.githubusercontent.com/LyricYang/Internet-Recruiting-Algorithm-Problems/master/InternetRecruitingAlgorithmProblems/NETEASE/pic/Q10Y2017.jpg"/> </div><br>

### 参考代码

```java
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line1=null;
        while((line1=in.readLine())!=null){
            int n = Integer.parseInt(line1);
            String line2 = in.readLine();
            String[] Arr2 = line2.trim().split(" ");
            int[] boll = new int[n];
            for(int i=0;i<n;i++){
                boll[i]=Integer.parseInt(Arr2[i]);
            }
            Arrays.sort(boll);
            int result = calc(boll,0,0,1);
            System.out.println(result);
        }
    }
    public static int calc(int[] boll,int index,int sum,int mult){
        int count=0;
        for(int i=index;i<boll.length;i++){
            sum+=boll[i];
            mult*=boll[i];
            if(sum>mult){
                count+=1+calc(boll,i+1,sum,mult);
            }else if(boll[i]==1){
                count+=calc(boll,i+1,sum,mult);
            }else
                break;
            sum-=boll[i];
            mult/=boll[i];
            while(i<boll.length-1&&boll[i]==boll[i+1]){
                i++;
            }
        }
        return count;
    }
}
```

## 第十一题 不要二

### 题目描述
>二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根。
小易想知道最多可以放多少块蛋糕在网格盒子里。

**输入描述:**
>每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)

**输出描述:**
>输出一个最多可以放的蛋糕数

**样例：**
```
输入
3 2

输出
4
```

### 解题思路
- **算法一**：类似八皇后问题，用一个长宽W,H的网格`G`记录是否允许防止蛋糕，从Loc[0,0]开始遍历，将G[0,0]赋值为1，欧几里得距离为2的位置赋值为-1，即Loc[0,2]=-1、Loc[2,0]=-1。遍历过程中若值为0则可以放置蛋糕，否则不能，用变量count记录放置蛋糕的次数；
- 算法复杂度**O(WH)**,空间复杂度**O(WH)**

- **算法二**：分整除4，整除2，奇数等几种情况讨论即可。蛋糕位置就是间隔每个2*2的正方形的区域。
<div align="center"> <img src="https://raw.githubusercontent.com/LyricYang/Internet-Recruiting-Algorithm-Problems/master/InternetRecruitingAlgorithmProblems/NETEASE/pic/Q11Y2017.jpg"/> </div><br>

### 参考代码

```java
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line=in.readLine())!=null){
            String[] strArr = line.trim().split(" ");
            int W = Integer.parseInt(strArr[0]);
            int H = Integer.parseInt(strArr[1]);
            int[][] map = new int[W][H];
            int count=0;
            for(int i=0;i<W;i++){
                for(int j=0;j<H;j++){
                    if(map[i][j]==0){
                        count++;
                        delPlace(i,j,map);
                    }
                }
            }
            System.out.println(count);
        }
    }
    
    public static void delPlace(int i,int j,int[][] map){
        map[i][j]=1;
        if(i-2>=0){
            map[i-2][j]=-1;
        }
        if(i+2<map.length){
            map[i+2][j]=-1;
        }
        if(j-2>=0){
            map[i][j-2]=-1;
        }
        if(j+2<map[0].length){
            map[i][j+2]=-1;
        }
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String[] string;
        int w, h, count = 0;
        while((str = reader.readLine()) != null) {
            string = str.split(" ");
            w = Integer.parseInt(string[0]);
            h = Integer.parseInt(string[1]);
            if(w % 4 == 0 || h % 4 ==0) {
            count = w * h / 2;
            }
            else if(w % 2 == 0 && h % 2 == 0) {
                count = (w * h / 4 + 1) / 2;
            }
            else {
                count = (w * h) / 2 + 1;
            }
            System.out.println(count);
        }
    }
}
```


## 第十二题 解救小易

### 题目描述
>有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走出边界)。大反派超超想去捕捉可爱的小易，他手里有n个陷阱。第i个陷阱被安置在横坐标为xi ，纵坐标为yi 的位置上，小易一旦走入一个陷阱，将会被超超捕捉。你为了去解救小易，需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。

**输入描述:**
>第一行为一个整数n(n ≤ 1000)，表示超超一共拥有n个陷阱。
第二行有n个整数xi，表示第i个陷阱的横坐标
第三行有n个整数yi，表示第i个陷阱的纵坐标
保证坐标都在草地范围内。

**输出描述:**
>输出一个整数,表示小易最少可能多少秒就落入超超的陷阱

**样例：**
```
输入
3
4 6 8
1 2 1

输出
3
```

### 解题思路
- 计算每个陷阱距离(1,1)的最短时间即为最后结果。

### 参考代码

```java
import java.io.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L1 = null;
        while((L1=in.readLine())!=null){
            int n=Integer.parseInt(L1);
            String L2 = in.readLine();
            String[] L2Arr = L2.trim().split(" ");
            int[] X=new int[n];
            for(int i=0;i<n;i++){
                X[i]=Integer.parseInt(L2Arr[i]);
            }
            String L3 = in.readLine();
            String[] L3Arr = L3.trim().split(" ");
            int[] Y=new int[n];
            for(int i=0;i<n;i++){
                Y[i]=Integer.parseInt(L3Arr[i]);
            }
            int result=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                int diff=X[i]-1+Y[i]-1;
                if(diff<result)
                    result=diff;
            }
            System.out.println(result);
        }
    }
}
```

## 第十三题 统计回文

### 题目描述
>“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。花花非常喜欢这种拥有对称美的回文串，生日的时候她得到两个礼物分别是字符串A和字符串B。现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。你接受花花的请求，帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
例如：
A = “aba”，B = “b”。这里有4种把B插入A的办法：
* 在A的第一个字母之前: "baba" 不是回文 
* 在第一个字母‘a’之后: "abba" 是回文 
* 在字母‘b’之后: "abba" 是回文 
* 在第二个字母'a'之后 "abab" 不是回文 
所以满足条件的答案为2

**输入描述:**
>每组输入数据共两行。
第一行为字符串A
第二行为字符串B
字符串长度均小于100且只包含小写字母

**输出描述:**
>输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数

**样例：**
```
输入
aba
b

输出
2
```

### 解题思路
- 将B插入到A中并判断是否是回文字符串。

### 参考代码

```java
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A = null;
        while((A=in.readLine())!=null){
            String B=in.readLine();
            int count=0;
            for(int i=0;i<=A.length();i++){
                String comb = A.substring(0,i)+B+A.substring(i,A.length());
                if(isPalindrome(comb))
                    count++;
            }
            System.out.println(count);
        }
    }
    
    public static boolean isPalindrome(String s){
        int head=0;
        int tail=s.length()-1;
        while(head<tail){
            if(s.charAt(head)==s.charAt(tail)){
                head++;
                tail--;
            }else{
                return false;
            }
        }
        return true;
    }
}
```

## 第十四题 饥饿的小易

### 题目描述
>小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。

**输入描述:**
>输入一个初始位置x_0,范围在1到1,000,000,006

**输出描述:**
>输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1

**样例：**
```
输入
125000000

输出
1
```

### 解题思路
- [思路](https://blog.csdn.net/fcxxzux/article/details/52138964#t0)

### 参考代码

```java
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L1=null;
        while((L1=in.readLine())!=null){
            long x0=Long.parseLong(L1);
            x0%=1000000007;
            int times=4;
            int result=-1;
            for(int i=1;i<300000;i++){
                long n=(x0*times+times-1)%1000000007;
                if(n==0){ 
                    result=(i+1)/3+((i+1)%3>0?1:0); 
                    break; 
                }
                times=times*2%1000000007;
            }
            System.out.println(result>100001?-1:result);
        }
    }
}
```


## 第十五题 两种排序方法

### 题目描述
>考拉有n个字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如：
"car" < "carriage" < "cats" < "doggies < "koala"
2.根据字符串的长度排序。例如：
"car" < "cats" < "koala" < "doggies" < "carriage"
考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。

**输入描述:**
>输入第一行为字符串个数n(n ≤ 100)
接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成

**输出描述:**
>如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",
如果根据长度排列而不是字典序排列输出"lengths",
如果两种方式都符合输出"both"，否则输出"none"

**样例：**
```
输入
3
a
aa
bbb

输出
both
```

### 解题思路
- 简单比较前后字符串的字典序和长度。

### 参考代码

```java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L1=null;
        while((L1=in.readLine())!=null){
            int n = Integer.parseInt(L1);
            String[] strArr = new String[n];
            int[] lenArr = new int[n];
            for(int i=0;i<n;i++){
                strArr[i]=in.readLine();
                lenArr[i]=strArr[i].length();
            }
            boolean cond0 = true;
            boolean cond1 = true;
            for(int i=1;i<n;i++){
                if(strArr[i].compareTo(strArr[i-1])<=0){
                    cond0=false;
                    break;
                }
            }
            for(int i=1;i<n;i++){
                if(lenArr[i]<=lenArr[i-1]){
                    cond1=false;
                    break;
                }
            }
            if(cond0&&cond1){
                System.out.println("both");
            }
            else if(cond0){
                System.out.println("lexicographically");
            }else if(cond1){
                System.out.println("lengths");
            }else{
                System.out.println("none");
            }
        }
    }
}
```

## 第十六题 小易喜欢的单词

### 题目描述
>小易喜欢的单词具有以下特性：
1.单词每个字母都是大写字母
2.单词没有连续相等的字母
3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
例如：
小易不喜欢"ABBA"，因为这里有两个连续的'B'
小易不喜欢"THETXH"，因为这里包含子序列"THTH"
小易不喜欢"ABACADA"，因为这里包含子序列"AAAA"
小易喜欢"A","ABA"和"ABCBA"这些单词
给你一个单词，你要回答小易是否会喜欢这个单词。

**输入描述:**
>输入为一个字符串，都由大写字母组成，长度小于100

**输出描述:**
>如果小易喜欢输出"Likes",不喜欢输出"Dislikes"

**样例：**
```
输入
AAA

输出
Dislikes
```

### 解题思路
- 算法一：三个约束条件，相当于正则表达式的构造方式；
- 算法二：前两个条件容易判断，主要是第三个条件，记录重复字符在字符串中的位置，若不同重复字符之间的位置相互交叉，则返回false；

### 参考代码

```java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L1=null;
        while((L1=in.readLine())!=null){
            if(isAllUpCase(L1) && isConEql(L1) && isThrEql(L1))
                System.out.println("Likes");
            else
                System.out.println("Dislikes");
        }
    }
    public static boolean isAllUpCase(String word){
        return word.matches("[A-Z]+");
    }
    public static boolean isConEql(String word){
        return !word.matches(".*(.)(\\1).*");
    }
    public static boolean isThrEql(String word){
        return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }
}
```

```java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L1=null;
        while((L1=in.readLine())!=null){
            if(isAllUpCase(L1) && isConEql(L1) && isThrEql(L1))
                System.out.println("Likes");
            else
                System.out.println("Dislikes");
        }
    }
    public static boolean isAllUpCase(String word){
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>'Z'&&word.charAt(i)<'A')
                return false;
        }
        return true;
    }
    public static boolean isConEql(String word){
        for(int i=1;i<word.length();i++){
            if(word.charAt(i-1)==word.charAt(i))
                return false;
        }
        return true;
    }
    public static boolean isThrEql(String word){
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i=1;i<word.length();i++){
            for(int j=i-1;j>=0;j--){
                if(word.charAt(i)==word.charAt(j)){
                    numList.add(j);
                    numList.add(i);
                    break;
                }
            }
        }
        if(numList.size()<4){
            return true;
        }
        for(int i=0;i<numList.size()-3;i+=2){
            if(numList.get(i+2)>numList.get(i)&&numList.get(i+2)<numList.get(i+1))
                return false;
        }
        return true;
    }
}
```

## 第十七题 Fibonacci数列

### 题目描述
>Fibonacci数列是这样定义的：
F[0] = 0
F[1] = 1
for each i ≥ 2: F[i] = F[i-1] + F[i-2]
因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。

**输入描述:**
>输入为一个正整数N(1 ≤ N ≤ 1,000,000)

**输出描述:**
>输出一个最小的步数变为Fibonacci数"

**样例：**
```
输入
15

输出
2
```

### 解题思路
- 找到输入的数N前后的Fibonacci数，计算N与前后Fibonacci数的差值，选最小的差值即为最小步数。

### 参考代码

```java
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L1=null;
        while((L1=in.readLine())!=null){
            int N = Integer.parseInt(L1);
            int fir=0;
            int sec=1;
            int sum=1;
            while(sum<N){
                fir=sec;
                sec=sum;
                sum=fir+sec;
            }
            int result=Math.min(N-sec,sum-N);
            System.out.println(result);
        }
    }
}
```

## 第十八题 数字游戏

### 题目描述
>小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数。

**输入描述:**
>输入第一行为数字个数n (n ≤ 20)
第二行为n个数xi (1 ≤ xi ≤ 100000)

**输出描述:**
>输出最小不能由n个数选取求和组成的数

**样例：**
```
输入
3
5 1 2

输出
4
```

### 解题思路

例子：
```
假如给的集合是nums = {1, 2, 2, 7}
用N表示目前能表达1-N里所有的数。
一开始什么都没有，能凑出的钱是0，N=0
N = 0。拿到第0个数字nums[0]=1，判断一下新的数字1和原来的范围N+1的大小关系，1<=N+1(1)，因此可以“安全地”扩大范围到N = N+1， N=1。也就是说用第1个数字可以表示0-1。
N = 1。再拿到第1个数字nums[1]=2，判断一下新的数字2和原来的范围N+1的大小关系，2<=N+1(2)，因此可以“安全地”扩大范围到N = N+2， N=3。也就是说用前两个数字可以表示0-3。
N = 3。再拿到第2个数字nums[1]=2，判断一下新的数字2和原来的范围N+1的大小关系，2<=N+1(4)，因此可以“安全地”扩大范围到N = N+2， N=5。也就是说用前两个数字可以表示0-5。
N = 5。再拿到第3个数字nums[3]=7，判断一下新的数字7和原来的范围N+1的大小关系，7>N+1(6)，因此不可以“安全地”扩大范围了，也就是说用前三个数字还是只可以表示0-5。
由此，这堆数字只能表示0-5了，不能表示6。
```
数学解释：
```
当1<=x<=N+1的时候： 
原来，我们已经可以用前面的一堆数字表示1-N了，现在来了一个新的数字x，在1~N+1的范围内，那么我们现在可以表示1~N+x的范围了。
原来是可以表示1~N了，然后考虑N+1。怎么表示N+1？咱们可以用x+(N+1-x)啊！(N+1-x)这个数肯定是在1~N的范围里（注），因此这个数咱们早就可以用前面的数表示出来了。

证明：N>=N+1-x>=1
1<=x<=N 
->
-1>=-x>=-N
->
N+1-1>=N+1-x>=N+1-N
->
N>=N+1-x>=1
证毕。
```

### 参考代码

```java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L1 = null;
        while((L1=in.readLine())!=null){
            int n=Integer.parseInt(L1);
            String L2 = in.readLine();
            String[] L2Arr=L2.trim().split(" ");
            int[] num = new int[n];
            for(int i=0;i<n;i++){
                num[i]=Integer.parseInt(L2Arr[i]);
            }
            Arrays.sort(num);
            int miss=0;
            for(int i=0;i<n;i++){
                if(num[i]>miss+1) break;
                miss+=num[i];
            }
            System.out.println(miss+1);
        }
    }
}
```
