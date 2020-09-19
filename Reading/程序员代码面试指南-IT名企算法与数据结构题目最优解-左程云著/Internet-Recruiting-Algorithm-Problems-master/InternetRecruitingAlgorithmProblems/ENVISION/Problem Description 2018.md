# 远景能源2018校园招聘算法笔试题

<!-- TOC -->
* [第一题](#第一题)
* [第二题](#第二题)
* [第三题](#第三题)
<!-- TOC -->


## 第一题

### 题目描述
>有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，例如，原数组为`[1,2,3,4,5,6]`，向左移位5个位置即变成了`[6,1,2,3,4,5]`,现在对于移位后的数组，需要查找某个元素的位置。请设计一个复杂度为log级别的算法完成这个任务。
给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。保证数组中元素互异。

**测试样例:**
```
[6,1,2,3,4,5],6,6 
返回：0
```

### 解题思路
- 原数组是有序数组经过向左移动得到，近似有序，而且从中间元素为中心把数组分为两部分，左边或右边必然有一个是有序的，因此可以考虑使用一些判别条件不断缩小查找范围。所以该题是一个变形的带限制的二分查找算法。

### 参考代码

```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] source = new int[n];
            for (int i = 0; i < n; i++) {
                source[i] = in.nextInt();
            }
            int result = finder(source, n, x);
            System.out.println(result);
        }
    }
    public static int finder(int[] arr, int n, int x) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x) {
                if (arr[left] > arr[mid] && x > arr[right])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (arr[mid] > arr[right] && x < arr[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
```

## 第二题

### 题目描述
>对于传统的汉诺塔游戏我们做一个拓展，我们有从大到小放置的n个圆盘，开始时所有圆盘都放在左边的柱子上，按照汉诺塔游戏的要求我们要把所有的圆盘都移到右边的柱子上，请实现一个函数打印最优移动轨迹。
给定一个int n，表示有n个圆盘。请返回一个string数组，其中的元素依次为每次移动的描述。描述格式为： move from [left/mid/right] to [left/mid/right]。

**测试样例:**
```
1
返回：move from left to right
```

### 解题思路
- 先把三个柱子编码0，1，2。
假设我们从柱子x向柱子y移动n个盘，由于大的不能放小的上面，所以移动最下面一个的时候前面n-1个一定按顺序排在第三个柱子（编码为3-x-y）上，将最后一个从x移到y，再把3-x-y上的全移动到y。

### 参考代码

```java
import java.util.*;
public class Hanoi {
    private String[] pos = {"left", "mid", "right"};
    public ArrayList<String> getSolution(int n) {
        return getSolution(n, 0, 2);
    }
    public ArrayList<String> getSolution(int n, int from, int to) {
        if(n==0) return new ArrayList<String>();
        ArrayList<String> list = getSolution(n-1, from, 3-from-to);
        list.add("move from "+pos[from]+" to "+pos[to]);
        list.addAll(getSolution(n-1, 3-from-to, to));
        return list;
    }
}
```

## 第三题

### 题目描述
>旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文字会是怎样？

**输入格式：**
>输入在2行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过105个字符的串。可用的字符包括字母[a-z, A-Z]、数字0-9、以及下划线“_”（代表空格）、“,”、“.”、“-”、“+”（代表上档键）。题目保证第2行输入的文字串非空。
注意：如果上档键坏掉了，那么大写的英文字母无法被打出。

**输出格式：**
>在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。

**测试样例:**
```
输入样例：
7+IE.
7_This_is_a_test.
输出样例：
_hs_s_a_tst
```

### 解题思路
- 用布尔型的数组来记录坏了的键盘，数组下标是字符的ASCII码。遍历要输出的字符串，对应的键盘没有坏就输出。

### 参考代码
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        boolean[] broken = new boolean[500]; // 用来记录键盘是否坏了
        for (int i = 0; i < 500; i++) {
            broken[i] = false;
        }

        for (int i = 0; i < a.length(); i++) { // 更新坏的键盘的布尔值
            broken[a.charAt(i)] = true;
            if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                broken[a.charAt(i) + 32] = true;
            }
        }
        // 遍历输出
        for (int i = 0; i < b.length(); i++) {
            if (broken['+'] || broken['\''] || broken['-'] || broken['.']) {
                if (!broken[b.charAt(i)]
                        && (b.charAt(i) < 'A' || b.charAt(i) > 'Z')) {
                    System.out.print(b.charAt(i));
                }
            } else {
                if (!broken[b.charAt(i)]) {
                    System.out.print(b.charAt(i));
                }
            }
        }
        System.out.println();
    }
}
```
