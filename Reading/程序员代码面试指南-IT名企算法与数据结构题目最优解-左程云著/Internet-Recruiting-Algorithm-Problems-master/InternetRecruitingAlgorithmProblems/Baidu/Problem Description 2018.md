# 百度2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:字符串匹配](#第一题-字符串匹配)
* [第二题:完成括号匹配](#第二题-完成括号匹配)
* [第三题:字符覆盖](#第三题-字符覆盖)
* [第四题:最大子序列](#第四题-最大子序列)
<!-- TOC -->


## 第一题 字符串匹配

### 题目描述
>牛牛有两个字符串A和B,其中A串是一个01串,B串中除了可能有0和1,还可能有'?',B中的'?'可以确定为0或者1。 寻找一个字符串T是否在字符串S中出现的过程,称为字符串匹配。牛牛现在考虑所有可能的字符串B,有多少种可以在字符串A中完成匹配。
例如:A = "00010001", B = "??"
字符串B可能的字符串是"00","01","10","11",只有"11"没有出现在字符串A中,所以输出3

**输入描述:**
>输入包括两行,第一行一个字符串A,字符串A长度length(1 ≤ length ≤ 50),A中每个字符都是'0'或者'1'。
 第二行一个字符串B,字符串B长度length(1 ≤ length ≤ 50),B中的字符包括'0','1'和'?'。

**输出描述:**
>输出一个整数,表示能完成匹配的字符串种数。

**样例：**
```
输入
00010001
??
输入
3
```

### 解题思路
- 将A中长度等于B长度的子字符串存储到HashSet中，然后深度优先搜索所有可能的B的字符串存储到ArrayList,然后判断每个可能的字符串是否在HashSet中。

### 参考代码
```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        ArrayList<String> possibleStringList = new ArrayList<>();
        int lenA = A.length();
        int lenB = B.length();
        int count = 0;
        HashSet<String> childStringOfA = new HashSet<>();
        for(int i=lenB;i<=lenA;i++){
            String str = A.substring(i-lenB,i);
            childStringOfA.add(str);
        }
        findPossibleString(B,"",0,lenB,possibleStringList);
        for(int i=0;i<possibleStringList.size();i++){
            if(childStringOfA.contains(possibleStringList.get(i)))
                count++;
        }
        System.out.println(count);
    }

    private static void findPossibleString(String str,String temp,int index,int len,ArrayList<String> stringList){
        if(index==len){
            stringList.add(temp);
            return;
        }
        if(str.charAt(index)=='?'){
            findPossibleString(str,temp+"0",index+1,len,stringList);
            findPossibleString(str,temp+"1",index+1,len,stringList);
        }else if(str.charAt(index)=='0'){
            findPossibleString(str,temp+"0",index+1,len,stringList);
        }else{
            findPossibleString(str,temp+"1",index+1,len,stringList);
        }
    }
}
```

## 第二题 完成括号匹配

### 题目描述
>合法的括号匹配序列被定义为:
1. 空串""是合法的括号序列
2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
3. 如果"X"是一个合法的序列,那么"[X]"也是一个合法的括号序列
4. 每个合法的括号序列都可以由上面的规则生成
例如"", "[]", "[][][]", "[[][]]", "[[[[]]]]"都是合法的。
 牛牛现在给出一个括号序列s,牛牛允许你执行的操作是:在s的开始和结尾处添加一定数量的左括号('[')或者右括号(']')使其变为一个合法的括号匹配序列。牛牛希望你能求出添加最少的括号之后的合法的括号匹配序列是什么。

**输入描述:**
>输入包括一个字符串s,s的长度length(1 ≤ length ≤ 50),s中只包含`[`和`]`。

**输出描述:**
>输出一个字符串,表示括号完全匹配的序列。

**样例：**
```
输入
][

输出
[][]
```

### 解题思路
- 设置两个变量left(需要的左括号的数量)，right(需要的有括号的数量)，出现`[`则right++，出现`]`可right--或left++。

### 参考代码
```java
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line==null||line.length()==0) {
            System.out.println("");
            return;
        }
        char[] chars = line.toCharArray();
        int left=0;
        int right=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='['){
                right++;
            }else{
                if(right!=0)
                    right--;
                else
                    left++;
            }
        }
        String result = "";
        for(int i=0;i<left;i++){
            result+="[";
        }
        for(int i=0;i<chars.length;i++){
            result+=chars[i];
        }
        for(int i=0;i<right;i++){
            result+="]";
        }
        System.out.println(result);
    }
}
```

## 第三题 字符覆盖

### 题目描述
>小度有一个小写字母组成的字符串s.字符串s已经被写在墙上了.
 小度还有很多卡片,每个卡片上有一个小写字母,组成一个字符串t。小度可以选择字符串t中任意一个字符,然后覆盖在字符串s的一个字符之上。小度想知道在选取一些卡片覆盖s的一些字符之后,可以得到的字典序最大的字符串是什么。

**输入描述:**
>输入包括两行,第一行一个字符串s,字符串s长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母
 第二行一个字符串t,字符串t长度length(1 ≤ length ≤ 50),t中每个字符都是小写字母

**输出描述:**
>输出一个字符串,即可以得到的字典序最大字符串

**样例：**
```
输入
fedcba
ee

输出
feeeba
```

### 解题思路

- 选择t中最大的字符，从左到右依次与s中的字符比较，找到比自己小的替换。

### 参考代码

```java
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        StringBuilder res = new StringBuilder();
        int index=tArr.length-1;
        Arrays.sort(tArr);
        for(int i=0;i<sArr.length;i++){
            if(index>=0){
                if(tArr[index]-sArr[i]>0){
                    res.append(tArr[index]);
                    index--;
                }else{
                    res.append(sArr[i]);
                }
            }
            else{
                res.append(sArr[i]);
            }
        }
        System.out.println(res.toString());
    }
}
```

## 第四题 最大子序列

### 题目描述
>对于字符串x和y, 如果擦除x中的某些字母(有可能全擦掉或者都不擦)能够得到y,我们就称y是x的子序列。例如."ncd"是"nowcoder"的子序列,而"xt"不是。
 现在对于给定的一个字符串s,请计算出字典序最大的s的子序列。 

**输入描述:**
>输入包括一行,一个字符串s,字符串s长度length(1 ≤ length ≤ 50).
s中每个字符都是小写字母

**输出描述:**
>输出一个字符串,即字典序最大的s的子序列。

**样例：**
```
输入
test

输出
tt
```

### 解题思路

- 将字符串中的字符降序排序，从左到右依次取出字符满足字符顺序不变的子串。

### 参考代码

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[][] chars = new char[s.length()][2];
        for(int i=0;i<s.length();i++){
            chars[i][0]=s.charAt(i);
            chars[i][1]= (char) ('0'+i);
        }
        Arrays.sort(chars, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                if(o1[0]-o2[0]==0) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        int index=-1;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(chars[i][1]-'0'>index){
                index=chars[i][1]-'0';
                res.append(chars[i][0]);
            }
        }
        System.out.println(res.toString());
    }
}
```
