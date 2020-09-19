# 腾讯2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:小Q的歌单](#第一题-小Q的歌单)
* [第二题:安排机器](#第二题-安排机器)
* [第三题:画家小Q](#第三题-画家小Q)
* [第四题:贪吃的小Q](#第四题-贪吃的小Q)
* [第五题:纸牌游戏](#第五题-纸牌游戏)
<!-- TOC -->


## 第一题 小Q的歌单

### 题目描述
>小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。 

**输入描述:**
>每个输入包含一个测试用例。
每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A 不等于B。

**输出描述:**
>输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。

**样例：**
```
输入
5
2 3 3 3
输出
9
```

### 解题思路

- 只有两种长度(A,B)的歌，找出A，B歌曲的组合，比如(i,j),表示需要i首A歌曲，j首B歌曲，则计算组合数C(X,i)*C(Y,j)即为(i,j)情况下的组合数。遍历不同情况下的组合数。


### 参考代码
```java
import java.util.Scanner;

public class Main {

    public static int[][] c = new int[101][101];
    public static final int mod = 1000000007;

    public static void init(){
        c[0][0]=1;
        for(int i=1;i<=100;i++) {
            c[i][0] = 1;
            for (int j = 1; j <= 100; j++) {
                c[i][j]=(c[i-1][j-1]+c[i-1][j])%mod;
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        init();
        while(in.hasNext()){
            int K = in.nextInt();
            int A = in.nextInt();
            int X = in.nextInt();
            int B = in.nextInt();
            int Y = in.nextInt();
            int[] couple = new int[X+1];
            for(int i=0;i<=X;i++){
                couple[i]=-1;
            }
            for(int i=0;i<=X;i++){
                int sumOfB=K-i*A;
                if(sumOfB<0){
                    break;
                }else{
                    if(sumOfB%B==0&&sumOfB/B<=Y){
                        couple[i]=sumOfB/B;
                    }
                }
            }
            int result = 0;
            for(int i=0;i<=X;i++){
                if(couple[i]!=-1){
                    result=(result+(c[X][i]*c[Y][couple[i]])%mod)%mod;
                }
            }
            System.out.println(result);
        }
    }
}
```

## 第二题 安排机器

### 题目描述
>小Q的公司最近接到的公司最近接到m个任务，第i个任务需要xi的时间去完成，难度等级为yi。
小Q拥有n台机器，每台机器最长工作时间zi，机器等级wi。
对于一个任务,它只能交由一台机器来完成，如果安排给它的机器最长工作时间小于任务需要的时间，则不能完成 ,如果完成这个任务将获得`200*xi+3*yi`收益。
对于一台机器 ,它一天只能完成个任务 , 如果它的机器等级小于安排给它的任务难度等级，则不能完成。
小Q想在今天尽可能的去完成任务，即完成的任务数量最大。如果有多种安排方案 即完成的任务数量最大。如果有多种安排方案 ,小Q还想找到收益最大的那个方案。小Q需要你来帮助他计算一下。

**输入描述:**
>输入包括N+M+1行，
输入的第一行为两个正整数n和m(1<=n,m<=100000)，表示机器的数量和任务的数量。
接下来n行，每行两个整数zi和wi(0<zi<1000,0<=wi<=100)，表示每台机器的最大工作时间和机器等级。
接下来m行，每行两个整数xi和yi(0<xi<1000,0<=yi<=100)，表示每个任务需要的完成时间和任务的难度等级。

**输出描述:**
>输出两个整数，分别表示最大能完成的任务数量和获取收益。 

**样例：**
```
输入
1 2
100 3
100 2
100 1

输出
1 20006
```

### 解题思路

- 贪婪算法，将任务和机器按时间降序排序，收益最多的任务开始遍历，看能否找到满足条件的机器，如果有，则可以完成任务，没有就无法完成任务。

### 参考代码
```java
import java.util.Array;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] machine = new int[n][2];//[zi wi]
        int[][] mission = new int[m][2];//[xi yi]
        for(int i=0;i<n;i++){
            machine[i][0]=in.nextInt();
            machine[i][1]=in.nextInt();
        }
        for(int j=0;j<m;j++){
            mission[j][0]=in.nextInt();
            mission[j][1]=in.nextInt();
        }
        Arrays.sort(machine, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                return o2[0]-o1[0];
            }
        });
        Arrays.sort(mission, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                return o2[0]-o1[0];
            }
        });
        int count=0;
        int money=0;
        int j=0;
        for(int i=0;i<m;i++){
            if(mission[i][0]<=machine[j][0]&&mission[i][1]<=machine[j][1]){
                j++;
                count++;
                money+=200*mission[i][0]+3*mission[i][1];
            }
            if(j>=n) break;
        }
        System.out.println(count+" "+money);
    }
}
```

## 第三题 画家小Q

### 题目描述
>画家小Q又开始他的艺术创作。小Q拿出了一块有N*M像素格的画板，画板初始状态是空白的，用`X`表示。
小Q有他独特的绘画技巧，每次小Q会选择一条斜线，如果斜线的方向形如`/`，即斜率为1，小Q会选择这条斜线中的一段格子，都涂画为蓝色，用`B`表示；如果对角线的方向形如`\`，即斜率为-1，小Q回旋着这条斜线中的一段格子，都涂为黄色，用`Y`表示。
如果一个格子既被蓝色涂画过又被黄色图画过,那么这个格子就会变成绿色 ,用'G'表示。
小Q已经有想画出的作品样子，请你帮他计算一下最少需要多次操作完成这幅画。 

**输入描述:**
>每个输入包含一个测试用例。
每个测试用例的第一行包含两个正整数N和M(1<=N,M<=50)，表示画板的长宽。
接下来的N行包含N个长度为M的字符串，其中包含字符`B`,`Y`,`G`,`X`，分别表示蓝色，黄色，绿色，空白。整个表示小Q要完成的作品。

**输出描述:**
>输出一个正整数，表示小Q最少需要多少次操作完成绘画。

**样例：**

```
输入
4 4
YXXB
XYGX
XBYY
BXXY

输出
3
```

### 解题思路

- 深度优先搜索，涂色的逆过程

### 参考代码

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line1=in.nextLine();
        String[] strArr = line1.split(" ");
        int N = Integer.valueOf(strArr[0]);
        int M = Integer.valueOf(strArr[1]);
        char[][] map = new char[N][M];
        for(int i=0;i<N;i++){
            String line = in.nextLine();
            char[] c = line.toCharArray();
            for(int j=0;j<M;j++){
                map[i][j]=c[j];
            }
        }
        int result = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='B'){
                    dfsB(map,i,j,N,M);
                    result++;
                }else if(map[i][j]=='Y'){
                    dfsY(map,i,j,N,M);
                    result++;
                }else if(map[i][j]=='G'){
                    dfsY(map,i,j,N,M);
                    result++;
                    dfsB(map,i,j,N,M);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void dfsB(char[][] map,int x,int y,int N,int M){
        if(x>=0&&x<N&&y>=0&&y<M&&(map[x][y]=='B'||map[x][y]=='G')){
            if(map[x][y]=='G'){
                map[x][y]='Y';
            }else if(map[x][y]=='B'){
                map[x][y]='X';
            }
            dfsB(map,x-1,y+1,N,M);
            dfsB(map,x+1,y-1,N,M);
        }
        return;
    }
    private static void dfsY(char[][] map,int x,int y,int N,int M){
        if(x>=0&&x<N&&y>=0&&y<M&&(map[x][y]=='Y'||map[x][y]=='G')){
            if(map[x][y]=='G'){
                map[x][y]='B';
            }else if(map[x][y]=='Y'){
                map[x][y]='X';
            }
            dfsY(map,x+1,y+1,N,M);
            dfsY(map,x-1,y-1,N,M);
        }
        return;
    }
}
```

## 第四题 贪吃的小Q

### 题目描述
>小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力，请问他第一天最多能吃多少块巧克力

**输入描述:**
>每个输入包含一个测试用例
每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000).

**输出描述:**
>输出一个数表示小Q第一天最多能吃多少块巧克力。

**样例：**
```
输入
3 7

输出
4
```

### 参考代码

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        boolean ok;
        int l=1;
        int r=M;
        int mid;
        int temp;
        int now;
        while(l!=r){
            ok=true;
            mid=(l+r+1)/2;
            temp=M;
            now = mid;
            for(int j=0;j<N;j++){
                if(temp<now){
                    ok=false;
                    break;
                }
                temp-=now;
                now=(now+1)/2;
            }
            if(ok)
                l=mid;
            else
                r=mid-1;
        }
        System.out.println(l);
    }
}
```

## 第五题 纸牌游戏

### 题目描述
>牛牛和羊羊正在玩一个纸牌游戏。这游戏一共有n张纸牌，第i张纸牌上写着数字ai。牛牛和羊羊轮流抽牌，牛牛先抽，每次抽牌他们可以从纸堆中任意选择一张抽出，直到纸牌被抽完。他们的得分等于他们抽到的纸牌数字总和。
现在假设牛牛和羊羊都采用最优策略，请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
**输入描述:**
>输入包括两行。
第一行包括一个正整数n(1<=n<=105),表示纸牌的数量。
第二行包括n个正整数ai(1<=ai<=109)，表示每个纸牌上的数字。

**输出描述:**
>输出一个整数，表示游戏结束后牛牛得分减去羊羊得分等于多少。

**样例：**
```
输入
3
2 7 4

输出
5
```

### 解题思路

- 牛牛和羊羊都取剩下牌中最大的。

### 参考代码

```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i]=in.nextInt();
        }
        Arrays.sort(a);
        int result = 0;
        boolean niuniu = true;
        for(int i=N-1;i>=0;i--){
            if(niuniu){
                niuniu=false;
                result+=a[i];
            }else{
                niuniu=true;
                result-=a[i];
            }
        }
        System.out.println(result);
    }
}
```

