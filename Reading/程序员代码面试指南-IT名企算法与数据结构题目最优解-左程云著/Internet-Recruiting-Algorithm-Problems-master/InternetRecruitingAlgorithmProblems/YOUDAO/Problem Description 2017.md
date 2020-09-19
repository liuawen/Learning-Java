# 网易有道2017校园招聘算法笔试题

<!-- TOC -->
* [第一题:洗牌](#第一题-洗牌)
* [第二题:构造队列](#第二题-构造队列)
<!-- TOC -->


## 第一题 洗牌

### 题目描述
>洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。

**输入描述:**
>第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。。

**输出描述:**
>对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。

**样例：**
```
输入
3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
输出
1 4 2 5 3 6 1 5 4 3 2 6 1 1 1 1
```

### 解题思路
- 在读取数据时就根据洗牌次数来推算出每个数据最终的位置。

### 参考代码
```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        while (groups-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] res = new int[2*n];
            for(int i=0;i<2*n;i++){
                int tmp = i ;
                for(int j = 0; j < k;j++){
                    if (tmp < n) tmp = 2*tmp;
                    else tmp = 2 * (tmp - n)+1;
                }
                res[tmp]=sc.nextInt();
            }
            if(res.length> 0) System.out.print(res[0]);
            for(int i = 1;i< 2*n;i++){
                System.out.print(" "+res[i]);
            }
            System.out.println();
        }
    }
}
```




## 第二题 构造队列

### 题目描述
>小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
```
while(!Q.empty())              //队列不空，执行循环
{
    int x=Q.front();            //取出当前队头的值x
    Q.pop();                 //弹出当前队头
    Q.push(x);               //把x放入队尾
    x = Q.front();              //取出这时候队头的值
    printf("%d\n",x);          //输出x
    Q.pop();                 //弹出这时候的队头
}
```
做取出队头的值操作的时候，并不弹出当前队头。
小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？

**输入描述:**
>第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。

**输出描述:**
>对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.

**样例：**
```
输入
4
1
2
3
10
输出
1
2 1
2 1 3
8 1 6 2 10 3 7 4 9 5
```

### 解题思路
- 方法一：找规律，从几个样例找出数字和数字所在位置的关系

<div align="center"><img src="https://latex.codecogs.com/gif.latex?$$loc=2*i-1&space;\qquad&space;loc&space;<&space;n$$" title="$$loc=2*i-1 \qquad loc < n$$" /></div>

<div align="center"><img src="http://latex.codecogs.com/gif.latex?$$loc=2*(loc-n)&space;\qquad&space;loc&space;\ge&space;n$$" title="$$loc=2*(loc-n) \qquad loc \ge n$$" /></div>

- 方法二：原始队列操作的逆操作

### 参考代码
```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int T = in.nextInt();
            for(int i=0;i<T;i++){
                int n=in.nextInt();
                int[] res = new int[n];
                for(int j=1;j<=n;j++){
                    int tmp = 2*j-1;
                    while(tmp>=n){
                        tmp=2*(tmp-n);
                    }
                    res[tmp]=j;
                }
                System.out.print(res[0]);
                for(int k=1;k<n;k++){
                    System.out.print(" "+res[k]);
                }
                System.out.println();
            }
        }
    }
}
```

```java
import java.util.LinkedList;
import java.util.Scanner;
public class Main{
    public static LinkedList<Integer> func(int n){
        LinkedList<Integer> help=new LinkedList<Integer>();
        for(int i=n;i>=1;i--){
            help.addFirst(i);
            help.addFirst(help.removeLast());
        }
        return help;
    }
    public static void main(String[] args){
        int t;
        Scanner scan = new Scanner(System.in);
        t=scan.nextInt();
        int n;
        LinkedList<Integer> res;
        while(t-->0){
            n=scan.nextInt();
            res=func(n);
            for(int i=0;i<n-1;i++){
                System.out.print(res.removeFirst()+" ");
            }
            System.out.println(res.removeFirst());
        }
    }
}
```
