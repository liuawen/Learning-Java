# 58同城公司2018校园招聘算法笔试题

<!-- TOC -->
* [第一题](#第一题)
* [第二题](#第二题)
<!-- TOC -->


## 第一题

### 题目描述
>给定一个数组metrix，数组中只包含1和0，且数组中的1都不相邻，输入一个数n，问能否在将数组中n个0替代换成1后不破坏1都不相邻的条件。

**输入描述:**
>第一行为N，表示数组元素个数
第二行为M，表示需要替换的个数
第三行为数组的N个元素


**输出描述:**
>替换后能否不破坏不相邻条件

**样例：**
```
输入
5
1
1 0 0 0 1

输出
true

输入
5
2
1 0 0 0 1

输出
false
```

### 参考代码
```java
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=in.nextInt();
        }
        //贪心法
        int max = 0;
        for(int i=0;i<N;i++){
            if(arr[i]==0){
                boolean left = i-1>=0 ? arr[i-1]==0:true;
                boolean right = i+1<N ? arr[i+1]==0:true;
                if(left && right){
                    max++;
                    arr[i]=1;
                }
            }
        }
        System.out.println(max>=M);
    }
}
```
