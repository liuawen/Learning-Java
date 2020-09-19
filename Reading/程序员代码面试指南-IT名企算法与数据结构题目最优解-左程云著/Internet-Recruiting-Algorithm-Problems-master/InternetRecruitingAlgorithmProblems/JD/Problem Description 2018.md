# 京东2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:求幂](#第一题-求幂)
* [第二题:神奇数](#第二题-神奇数)
* [第三题:整除](#第三题-整除)
* [第四题:牛牛的括号匹配](#第四题-牛牛的括号匹配)
* [第五题:分解整数](#第五题-分解整数)
<!-- TOC -->


## 第一题 求幂

### 题目描述
>东东对幂运算很感兴趣，在学习的过程中东东发现了一些有趣的性质：`9^3=27^2`,`2^10=32^2`
东东对这个性质充满了好奇，东东现在给出了一个整数n，希望你能帮助他求出满足`a^b=c^d`(1<=a,b,c,d<=n)的式子有多少个。

**输入描述:**
>输入包括一个整数n(1<=n<=10^6)

**输出描述:**
>输出一个整数,表示满足要求的式子个数。因为答案可能很大，输出对1000000007求模的结果

**样例：**
```
输入
2
输入
6
```

### 参考代码
```java

```

## 第二题 神奇数

### 题目描述
>东东在一本古籍上看到有一种神奇数，如果能够将一个数的数字分成两组，其中一组数字的和等于另外一组数字的和，我们就将这个数称为神奇数。例如242就是神奇数，我们能够将这个数字分成两组，分别是{2,2}以及{4}，而且这两组数的和都是4。东东现在需要统计给定区间中有多少个神奇数，即给定区间[l,r]，统计这个区间有多少个神奇数，请你来帮助他。

**输入描述:**
>输入包括一行，一行中两个整数l和r(1<=l,r<=10^9,0<=r-1<=10^6)，以空格分割

**输出描述:**
>输出一个整数，即区间内的神奇数的个数

**样例：**
```
输入
1 50

输出
4
```

### 解题思路

首先判断数组能否被平分，即数组分割问题，dp[i][j]表示数组前 i个数字能否求和得到 j则dp[i][j]=dp[i−1][j]||dp[i−1][j−array[i]]其中||是逻辑或运算。
优化：
1. 若sum（array）为奇数，直接返回false
2. 使用逆序循环将dp数组简化为一维数组

### 参考代码
```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int mod = 1000000007;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int result=0;
        for(int i=l;i<=r;i++){
            int num = i;
            int[] nums = new int[10];
            int sum=0;
            Arrays.fill(nums,-1);
            int index = 0;
            while(num>0){
                int temp=num%10;
                nums[index++]=temp;
                sum+=temp;
                num=num/10;
            }
            if(isMagic(nums,sum))
                result++;
        }
        System.out.println(result);
    }

    public static boolean isMagic(int[] nums,int sum){
        int len = nums.length;
        if(sum%2!=0) return false;
        int mid = sum/2;
        int[] dp = new int[mid+1];
        dp[0]=1;
        for(int i=0;i<len;i++){
            for(int j=mid;j>0;j--){
                if(j>=nums[i]&&nums[i]!=-1)
                    dp[j]=Math.max(dp[j],dp[j-nums[i]]);
            }
        }
        if(dp[mid]>0)
            return true;
        else
            return false;
    }
}
```

## 第三题 整除

### 题目描述
>牛牛对整除非常感兴趣。牛牛的老师给他布置了一道题：牛牛的老师给出一个n，然后牛牛需要回答出能被1到n之间（包括1和n）所有整数整除的最小的数。牛牛犯了难，希望你能编程帮助他解决这个问题。

**输入描述:**
>输入包括一个整数n(1<=n<=100000)

**输出描述:**
>输出一个整数，即满足要求的最小整数。答案可能很大，请输出这个整数对于987654321取模的结果

**样例：**
```
输入
3

输出
6
```

### 解题思路

- 求1~n的最小公倍数

### 参考代码

```java
import java.util.Scanner;
public class Main {

    private static final int mod = 987654321;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        int result=1;
        for(int i=1;i<=n;i++){
            result = MinCommonNum(i,result);
        }
        System.out.println(result);
    }

    public static int MinCommonNum(int m,int n){
        int remainder=0;
        int m1=m;
        int n1=n;
        while(n!=0){
            remainder=m%n;
            m=n;
            n=remainder;
        }
        return (m1*n1/m)%mod;
    }
}
```

## 第四题 牛牛的括号匹配

### 题目描述
>如果一个括号序列中的每个左括号都有一个右括号与之完成配对，这个序列就是一个合法的括号匹配序列。
例如`((())),()()()`是合法的括号匹配序列，而`(((())()((()`不是。牛牛得到了一系列的括号序列，牛牛要从整个序列中任意选取两个位置进行一次交换操作，牛牛必须进行一次且仅一次操作。
牛牛想知道能否通过这次操作，把这个序列变为合法的括号匹配序列。
例如序列s=`())(`，对第三个位置和第四个位置进行交换变为s=`()()`，这是一个合法的括号匹配序列。

**输入描述:**
>输入的第一行包括测试样例t(1<=t<=1000),
接下来的t行，每行一个括号序列s(1<=length(s)<=100000),表示每个括号序列。

**输出描述:**
>如果可以通过一次变换变为合法的括号匹配序列，则输出`Yes`,否则输出`No`

**样例：**
```
输入
2
())(
)))(((

输出
4
```

### 解题思路

- 依次将括号压入栈中，如果形成匹配的括号对则将栈中括号弹出，最后如果栈中为空或`)(`则输出“Yes”,否则输出“No”。

### 参考代码

```java
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int t = Integer.valueOf(line);
        for(int i=0;i<t;i++){
            String str = in.nextLine();
            char[] charArr = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int j=0;j<charArr.length;j++){
                if(stack.empty()){
                    stack.push(charArr[j]);
                }else if(charArr[j]=='('){
                    stack.push('(');
                }else{
                    if(stack.peek()=='('){
                        stack.pop();
                    }else{
                        stack.push(')');
                    }
                }
            }
            boolean res = false;
            if(stack.empty()){
                res = true;
            }else{
                if(stack.pop()=='('){
                    if(!stack.empty()&&stack.pop()==')'){
                        if(stack.empty()){
                            res = true;
                        }
                    }
                }
            }
            if(res){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
```

## 第五题 分解整数

### 题目描述
>小Q的数学老师给了小Q一个整数N，问小Q能否将N分解为两个整数X和Y相乘，并且满足X为奇数，Y为偶数，即能否找到奇数X和偶数Y满足X*Y=N。
小Q被这个问题难住了，希望你能来帮助他计算。

**输入描述:**
>输入的第一行包含一个正整数t(1<=t<=1000)，表示测试样例数。
接下来的t行，每行一个正整数N(2<=N<2^63)，表示给出的N。保证N不是2的幂次。

**输出描述:**
>如果能找到这样的X,Y，则一次输出X,Y，如果有多解输出Y最小的那组解，以空格分割，否则输出“No”。

**样例：**
```
输入
2
10
5

输出
5 2
No
```

### 解题思路

- 若有满足条件的解，则Y必定是2的倍数，因为又要最小则必定是2的幂次，而X是奇数的乘积。

### 参考代码

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int Y=1;
            while(n%2==0){
                Y*=2;
                n/=2;
            }
            int X=n;
            if(Y==1){
                System.out.println("No");
            }else{
                System.out.println(X+" "+Y);
            }
        }
    }
}
```

