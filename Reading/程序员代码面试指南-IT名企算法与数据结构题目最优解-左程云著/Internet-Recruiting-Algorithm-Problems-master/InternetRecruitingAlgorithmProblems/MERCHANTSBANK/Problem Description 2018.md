# 招行信用卡中心2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:最小差值](#第一题-最小差值)
* [第二题:不想出差的HR](#第二题-不想出差的HR)
* [第三题:年会抢玩偶游戏](#第三题-年会抢玩偶游戏)
<!-- TOC -->


## 第一题 最小差值

### 题目描述
>给定一个升序的整形数组A以及两个整数`x`和`k`，要求输出数组A中与x之差的绝对值最小的k个元素。若存在与x差值的绝对值相等的两个元素，则取其中较小的元素。

**输入描述：**
>输入的第一行为空格分隔的整型数组，第二行为空格分隔的两个整数x和k。
数组长度不超过1000，数组元素绝对值和不超过1000，k大于0且不超过数组长度。

**输出描述：**
>每组输入数据对应一行输出，输出数字元素间以空格分隔。

**样例：**
```
输入
1 2 3 4 5 
3 4
输出
1 2 3 4
```

### 解题思路
- 首先是升序的数组，如果出现值不满足则后面的所有值便不满足条件
- 维护一个k个元素的队列

![](index_files/f8afa61c-d484-48d2-9878-1c21d55d0086.png)

```java
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] sArr = s.split(" ");
            int[] arr = new int[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                arr[i] = Integer.valueOf(sArr[i]);
            }
            String s2 = in.nextLine();
            String[] s2Arr = s2.split(" ");
            int x = Integer.valueOf(s2Arr[0]);
            int k = Integer.valueOf(s2Arr[1]);
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < arr.length; i++) {
                if (list.size() < k) {
                    list.add(arr[i]);
                } else {
                    int maxD = Math.abs(list.getFirst() - x);
                    if (Math.abs(arr[i] - x) < maxD) {
                        list.pollFirst();
                        list.add(arr[i]);
                    } else
                        break;
                }
            }
            System.out.print(list.get(0));
            for (int i = 1; i < k; i++) {
                System.out.print(" " + list.get(i));
            }
        }
    }
}
```


## 第二题 不想出差的HR

### 题目描述
>按照卡中心校园招聘的要求，HR小招和小商需要从三个科室中（分别为A、B、C）抽派面试官去往不同城市。
两名HR按照以下规定轮流从任一科室选择面试官：每次至少选择一位，至多选择该科室剩余面试官数。最先选不到面试官的HR需要自己出差。
假设HR小招和小商都不想出差且每次选择都采取最优策略，如果是小招先选，写一个函数来判断她是否需要出差。如果不需要出差，请给出第一步的最优策略。

**输入描述：**
>输入为三个正整数，分别代表三个科室的面试官人数，用英文逗号分隔

**输出描述：**
>若小招需要出差，则输出：1；
若小招不需要出差，则输出：第一步选择的科室名称和选择人数，用英文逗号分隔

**样例：**
```
输入
1,8,9
输出
1

输入
2,0,4
输出
C,2
```

### 解题思路
Nim游戏改版，异或和为0的则先手必败，所以A^B^C=0时就输出1，然后赢得情况，因为只有三个数就很简单了，枚举两两的异或和，只有第三个的值大于这个异或值，就输出第三个值减去另外两个数的异或值就是答案了

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String[] s = in.nextLine().split(",");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int C = Integer.parseInt(s[2]);
            int temp1 = A^B;
            int temp2 = A^C;
            int temp3 = B^C;
            int res=0;
            if((temp1^C)==0){
                System.out.println(1);
            }else{
                if(C>temp1){
                    res = C-temp1;
                    System.out.println("C,"+res);
                }
                if(B>temp2){
                    res = B-temp2;
                    System.out.println("B,"+res);
                }
                if(A>temp3){
                    res = A-temp3;
                    System.out.println("A,"+res);
                }
            }
        }
    }
}
```


## 第三题 年会抢玩偶游戏

### 题目描述
>某公司年会上，组织人员安排了一个小游戏来调节气氛。游戏规则如下：
N个人参与游戏，站成一排来抢工作人抛来的M个小玩偶。为了增加游戏的趣味和难度，规则规定，参与游戏的人抢到的礼物不能比左右两边的人多两个或以上，否则会受到一定的惩罚。游戏结束时拥有玩偶最多的人将获得一份大奖。
假设大家都想赢得这份大奖，请问站在第K个位置的小招在赢得游戏时，最多能拥有几个玩偶？

**输入描述：**
>输入为用空格分隔的3个正整数，依次为：参与游戏人数N、玩偶数M、小招所在位置K

**输出描述：**
>输出为1个正整数，代表小招最多能够拥有的玩偶数。若没有，则输出0。

**样例：**
```
输入
1 1 0
输出
0

输入
1 3 1
输出
3
```

### 解题思路
Nim游戏改版，异或和为0的则先手必败，所以A^B^C=0时就输出1，然后赢得情况，因为只有三个数就很简单了，枚举两两的异或和，只有第三个的值大于这个异或值，就输出第三个值减去另外两个数的异或值就是答案了

### 参考代码

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int k = in.nextInt();
            int[] loc = new int[N+1];
			//判断小招位置是否超过人数或者小于1，若是则判断为非法输入
            if(k==0||k>N){
                System.out.println(0);
            }else{
                while(M>0){
                    if(M>0){
                        loc[k]++;
                        M--;
                    }
                    for(int i=k;i>1;i--){
                        if(loc[i]-loc[i-1]>1){
                            loc[i-1]++;
                            M--;
                        }
                    }
                    for(int j=k+1;j<=N;j++){
                        if(loc[j-1]-loc[j]>1){
                            loc[j]++;
                            M--;
                        }
                    }
                }
                if(M<0){
                    System.out.println(--loc[k]);
                }else{
                    System.out.println(loc[k]);
                }
            }
        }
    }
}
```
