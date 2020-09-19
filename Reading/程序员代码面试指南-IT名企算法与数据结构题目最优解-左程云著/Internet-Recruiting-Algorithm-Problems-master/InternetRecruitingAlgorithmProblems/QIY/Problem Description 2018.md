# 爱奇艺公司2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:拼凑正方形](#第一题-拼凑正方形)
* [第二题:区间表达](#第二题-区间表达)
* [第三题:缺失的括号](#第三题-缺失的括号)
* [第四题:回文素数](#第四题-回文素数)
* [第五题:排序](#第五题-排序)
* [第六题:青草游戏](#第六题-青草游戏)
* [第七题:红和绿](#第七题-红和绿)
* [第八题:拼凑三角形](#第八题-拼凑三角形)
* [第九题:括号匹配深度](#第九题-括号匹配深度)
* [第十题:最后一位](#第十题-最后一位)
<!-- TOC -->


## 第一题 拼凑正方形

### 题目描述
>牛牛有4根木棍,长度分别为a,b,c,d。羊羊家提供改变木棍长度的服务,如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。
牛牛需要用这四根木棍拼凑一个正方形出来,牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。

**输入描述:**
>输入包括一行,四个整数a,b,c,d(1 ≤ a,b,c,d ≤ 10^6), 以空格分割


**输出描述:**
>输出一个整数,表示牛牛最少需要支付的硬币

**样例：**
```
输入
4 1 5 4

输出
4
```

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i=0;i<4;i++){
            arr[i]=in.nextInt();
        }
        Arrays.sort(arr);
        int edge = arr[1];
        int result = 0;
        for(int i=0;i<arr.length;i++){
            result+=Math.abs(edge-arr[i]);
        }
        System.out.println(result);
    }
}
```

## 第二题 区间表达

### 题目描述
>牛牛的老师给出了一个区间的定义:对于x ≤ y,[x, y]表示x到y之间(包括x和y)的所有连续整数集合。例如[3,3] = {3}, [4,7] = {4,5,6,7}.牛牛现在有一个长度为n的递增序列,牛牛想知道需要多少个区间并起来等于这个序列。
例如:
{1,2,3,4,5,6,7,8,9,10}最少只需要[1,10]这一个区间
{1,3,5,6,7}最少只需要[1,1],[3,3],[5,7]这三个区间 

**输入描述:**
>输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),
第二行n个整数a[i](1 ≤ a[i] ≤ 50),表示牛牛的序列,保证序列是递增的。


**输出描述:**
>输出一个整数,表示最少区间个数。

**样例：**
```
输入
5
1 3 5 6 7

输出
3
```

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int result = 1;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]>1){
                result++;
            }
        }
        System.out.println(result);
    }
}
```

## 第三题 缺失的括号

### 题目描述
>一个完整的括号字符串定义规则如下:
1、空字符串是完整的。
2、如果s是完整的字符串，那么(s)也是完整的。
3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。 

**输入描述:**
>输入包括一行,一个括号序列s,序列长度length(1 ≤ length ≤ 50).
s中每个字符都是左括号或者右括号,即'('或者')'.


**输出描述:**
>输出一个整数,表示最少需要添加的括号数

**样例：**
```
输入
(()(()

输出
2
```

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i)==')'){
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                    else{
                        stack.push(')');
                    }
                }else{
                    stack.push('(');
                }
            }
        }
        System.out.println(stack.size());
    }
}
```

## 第四题 回文素数

### 题目描述
>如果一个整数只能被1和自己整除,就称这个数是素数。
如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
如果一个数字既是素数也是回文数,就称这个数是回文素数
牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。  

**输入描述:**
>输入包括一行,一行中有两个整数(1 ≤ L ≤ R ≤ 1000)


**输出描述:**
>输出一个整数,表示区间内回文素数个数。

**样例：**
```
输入
100 150

输出
2
```


### 参考代码
```java
import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int low = in.nextInt();
        int high = in.nextInt();
        int result = 0;
        for(int i=low;i<=high;i++){
            if(isPrime(i)&&isPlalindrome(i)){
                result++;
            }
        }
        System.out.println(low==1?result-1:result);
    }
     
    public static boolean isPrime(int num){
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
     
    public static boolean isPlalindrome(int num){
        String s = ""+num;
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
```


## 第五题 排序

### 题目描述
>牛牛有一个长度为n的整数序列,牛牛想对这个序列进行重排为一个非严格升序序列。牛牛比较懒惰,他想移动尽量少的数就完成重排,请你帮他计算一下他最少需要移动多少个序列中的元素。(当一个元素不在它原来所在的位置,这个元素就是被移动了的) 

**输入描述:**
>输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),即序列的长度
第二行n个整数x[i](1 ≤ x[i] ≤ 100),即序列中的每个数

**输出描述:**
>输出一个整数,即最少需要移动的元素个数

**样例：**
```
输入
3
3 2 1

输出
2
```

### 参考代码
```java
import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr_origine = new int[n];
        int[] arr_sorted = new int[n];
        for(int i=0;i<n;i++){
            arr_origine[i]=in.nextInt();
            arr_sorted[i]=arr_origine[i];
        }
        Arrays.sort(arr_sorted);
        int result = 0;
        for(int i=0;i<n;i++){
            if(arr_origine[i]!=arr_sorted[i]){
                result++;
	    }
	}
        System.out.println(result);
    }
}
```


## 第六题 青草游戏

### 题目描述
>牛牛和羊羊都很喜欢青草。今天他们决定玩青草游戏。
最初有一个装有n份青草的箱子,牛牛和羊羊依次进行,牛牛先开始。在每个回合中,每个玩家必须吃一些箱子中的青草,所吃的青草份数必须是4的x次幂,比如1,4,16,64等等。不能在箱子中吃到有效份数青草的玩家落败。假定牛牛和羊羊都是按照最佳方法进行游戏,请输出胜利者的名字。 

**输入描述:**
>输入包括t+1行。
第一行包括一个整数t(1 ≤ t ≤ 100),表示情况数.
接下来t行每行一个n(1 ≤ n ≤ 10^9),表示青草份数

**输出描述:**
>对于每一个n,如果牛牛胜利输出"niu",如果羊羊胜利输出"yang"。


**样例：**
```
输入
3
1
2
3

输出
niu
yang
niu
```

### 参考代码
```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int num = in.nextInt();
            if(num%5==0||num%5==2){
                System.out.println("yang");
            }else{
                System.out.println("niu");
            }
        }
    }
}
```



## 第七题 红和绿

### 题目描述
>牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
如样例所示: s = RGRGR
我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。 

**输入描述:**
>输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50),其中只包括'R'或者'G',分别表示红色和绿色。


**输出描述:**
>输出一个整数,表示牛牛最少需要涂染的正方形数量

**样例：**
```
输入
RGRGR

输出
2
```

### 解题思路
- 分别记录截止到每个位置处有多少个R和有多少个G，遍历字符串将‘G’作为分隔点，记录每个G位置处需要修改的次数，选出最小的次数。

```
  R  G  R  G  R
R:1  1  2  2  3
G:0  1  1  2  2

修改的次数：numOfPrint=numOfG[i]-1+numOfR[n-1]-numOfR[i];
例如：第一个G位置处需要修改这个位置前的所有G，这个位置后的所有R，即：1-1+3-1=2
```


### 参考代码
```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        int n = string.length();
        int[] numOfR = new int[n];
        int[] numOfG = new int[n];
        numOfR[0]=string.charAt(0)=='R'?1:0;
        numOfG[0]=string.charAt(0)=='G'?1:0;
        int result = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(string.charAt(i)=='R'){
                numOfR[i]=numOfR[i-1]+1;
                numOfG[i]=numOfG[i-1];
            }else{
                numOfR[i]=numOfR[i-1];
                numOfG[i]=numOfG[i-1]+1;
            }
        }
        for(int i=0;i<n;i++){
            if(string.charAt(i)=='G'){
                int numOfPrint=numOfG[i]-1+numOfR[n-1]-numOfR[i];
                if(numOfPrint<result){
                    result = numOfPrint;
                }
            }
        }
        System.out.println(result);
    }
}
```


## 第八题 拼凑三角形

### 题目描述
>牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。 

**输入描述:**
>输入包括一行,一行中有正整数a, b, c(1 ≤ a, b, c ≤ 100), 以空格分割


**输出描述:**
>输出一个整数,表示能拼凑出的周长最大的三角形。

**样例：**
```
输入
1 2 3

输出
5
```

### 解题思路
- 最长边大于其余两边之和。假设最长边为c并且c>=a+b,则c削短后最大为a+b-1。


### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if(a+b<=c){
            System.out.println(2*(a+b)-1);
        }else if(a+c<=b){
            System.out.println(2*(a+c)-1);
        }else if(b+c<=a){
            System.out.println(2*(b+c)-1);
        }else{
            System.out.println(a+b+c);
        }
    }
}
```





## 第九题 括号匹配深度

### 题目描述
>一个合法的括号匹配序列有以下定义:
1、空串""是一个合法的括号匹配序列
2、如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
3、如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
4、每个合法的括号序列都可以由以上规则生成。
例如: "","()","()()","((()))"都是合法的括号序列
对于一个合法的括号序列我们又有以下定义它的深度:
1、空串""的深度是0
2、如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y) 
3、如果"X"的深度是x,那么字符串"(X)"的深度是x+1
例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。 

**输入描述:**
>输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。


**输出描述:**
>输出一个正整数,即这个序列的深度。

**样例：**
```
输入
(())

输出
2
```

### 解题思路
- 用栈来解决括号匹配问题，栈中'('的最大个数就决定了括号的深度。


### 参考代码
```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        int result = 0;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<string.length();i++){
            if(stack.empty()){
                stack.push(string.charAt(i));
                if(stack.size()>result){
                    result = stack.size();
                }
            }else{
                if(string.charAt(i)=='('){
                    stack.push(string.charAt(i));
                    if(stack.size()>result){
                        result = stack.size();
                    }
                }else{
                    stack.pop();
                }
            }
        }
        System.out.println(result);
    }
}
```


## 第十题 最后一位

### 题目描述
>牛牛选择了一个正整数X,然后把它写在黑板上。然后每一天他会擦掉当前数字的最后一位,直到他擦掉所有数位。 在整个过程中,牛牛会把所有在黑板上出现过的数字记录下来,然后求出他们的总和sum.
例如X = 509, 在黑板上出现过的数字依次是509, 50, 5, 他们的和就是564.
牛牛现在给出一个sum,牛牛想让你求出一个正整数X经过上述过程的结果是sum. 

**输入描述:**
>输入包括正整数sum(1 ≤ sum ≤ 10^18)


**输出描述:**
>输出一个正整数,即满足条件的X,如果没有这样的X,输出-1。

**样例：**
```
输入
564

输出
509
```


### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long sum = in.nextLong();
        long low=0,cur=1,high,temp,n;
        high=sum;
        while(low<=high){
            temp=0;
            cur=(low+high)/2;
            n=cur;
            while(n>0){
                temp+=n;
                n/=10;
            }
            if(temp==sum){
                System.out.println(cur);
                return;
            }
            else{
                if(temp<sum) low=cur+1;
                else high=cur-1;
            }
        }
        System.out.println(-1);
    }
}
```
