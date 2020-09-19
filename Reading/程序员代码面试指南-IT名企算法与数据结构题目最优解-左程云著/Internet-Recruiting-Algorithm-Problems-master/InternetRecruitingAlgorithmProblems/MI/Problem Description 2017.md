# 小米2017校园招聘算法笔试题

<!-- TOC -->
* [第一题:电话号码分身](#第一题-电话号码分身)
* [第二题:句子反转](#第二题-句子反转)
* [第二题:树的高度](#第三题-树的高度)
<!-- TOC -->


## 第一题 电话号码分身

### 题目描述
>继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"）， 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。

**输入描述:**
>第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。

**输出描述:**
>输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。

**样例：**

**输入**
>4
EIGHT
ZEROTWOONE
OHWETENRTEO
OHEWTIEGTHENRTEO

**输入**
>0
234
345
0345

### 解题思路

分析0-9这10个数字所对应英文单词中字母的特性，不难发现：
```
[0,2,4,6,8]对应单词中都包含自身特有的字母，每个特有字母出现的次数即代表这个单词出现的次数：
ZERO(Z),TWO(W),FOUR(U),SIX(X),EIGHT(G)

[1,3,5,7]对应单词在排除上述单词后，便拥有了可以判断自身出现次数的字母：
ONE(O),THREE(H),FIVE(F),SEVEN(S)

[9]对应的单词在排除其它所有单词的情况下，便可以通过字母I的个数知道出现的次数：
NINE(I)
```

然后通过单词与电话号码数字之间的关系，知道每个数字出现的次数，从小到大排列即为最小的电话号码，通过桶排序依次输出每个数字便可以解决问题：
```
ZERO  ----  2
ONE   ----  3
TWO   ----  4
THREE ----  5
FOUR  ----  6
FIVE  ----  7
SIX   ----  8
SEVEN ----  9
EIGHT ----  0
NINE  ----  1
```

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String L1 = in.nextLine();
            int T = Integer.parseInt(L1);
            for(int i=0;i<T;i++){
                String s = in.nextLine();
                int[] asciiArr = new int[26];
                int[] digitArr = new int[10];
                for(int j=0;j<s.length();j++){
                    asciiArr[s.charAt(j)-'A']++;
                }
                // ZERO<--->2
                while(asciiArr['Z'-'A']>0){
                    digitArr[2]++;
                    asciiArr['Z'-'A']--;
                    asciiArr['E'-'A']--;
                    asciiArr['R'-'A']--;
                    asciiArr['O'-'A']--;
                }
                // TWO<--->4
                while(asciiArr['W'-'A']>0){
                    digitArr[4]++;
                    asciiArr['T'-'A']--;
                    asciiArr['W'-'A']--;
                    asciiArr['O'-'A']--;
                }
                // FOUR<--->6
                while(asciiArr['U'-'A']>0){
                    digitArr[6]++;
                    asciiArr['F'-'A']--;
                    asciiArr['O'-'A']--;
                    asciiArr['U'-'A']--;
                    asciiArr['R'-'A']--;
                }
                // SIX<--->8
                while(asciiArr['X'-'A']>0){
                    digitArr[8]++;
                    asciiArr['S'-'A']--;
                    asciiArr['I'-'A']--;
                    asciiArr['X'-'A']--;
                }
                // EIGHT<--->0
                while(asciiArr['G'-'A']>0){
                    digitArr[0]++;
                    asciiArr['E'-'A']--;
                    asciiArr['I'-'A']--;
                    asciiArr['G'-'A']--;
                    asciiArr['H'-'A']--;
                    asciiArr['T'-'A']--;
                }
                // THREE<--->5
                while(asciiArr['H'-'A']>0){
                    digitArr[5]++;
                    asciiArr['T'-'A']--;
                    asciiArr['H'-'A']--;
                    asciiArr['R'-'A']--;
                    asciiArr['E'-'A']--;
                    asciiArr['E'-'A']--;
                }
                // FIVE<--->7
                while(asciiArr['F'-'A']>0){
                    digitArr[7]++;
                    asciiArr['F'-'A']--;
                    asciiArr['I'-'A']--;
                    asciiArr['V'-'A']--;
                    asciiArr['E'-'A']--;
                }
                // SEVEN<--->9
                while(asciiArr['S'-'A']>0){
                    digitArr[9]++;
                    asciiArr['S'-'A']--;
                    asciiArr['E'-'A']--;
                    asciiArr['V'-'A']--;
                    asciiArr['E'-'A']--;
                    asciiArr['N'-'A']--;
                }
                // ONE<--->3
                while(asciiArr['O'-'A']>0){
                    digitArr[3]++;
                    asciiArr['O'-'A']--;
                    asciiArr['N'-'A']--;
                    asciiArr['E'-'A']--;
                }
                // NINE<--->1
                while(asciiArr['I'-'A']>0){
                    digitArr[1]++;
                    asciiArr['N'-'A']--;
                    asciiArr['I'-'A']--;
                    asciiArr['N'-'A']--;
                    asciiArr['E'-'A']--;
                }
                String res="";
                for(int j=0;j<10;j++){
                    for(int k=0;k<digitArr[j];k++){
                        res+=j;
                    }
                }
                System.out.println(res);
            }
        }
    }
}
```


## 第二题 句子反转

### 题目描述
>给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello”

**输入描述:**
>输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)

**输出描述:**
>对于每个测试示例，要求输出句子中单词反转后形成的句子

**样例：**

**输入**
>hello xiao mi

**输入**
>mi xiao hello

### 解题思路
- 通过空格将字符串进行分割，然后逆序输出。

### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String L1=in.nextLine();
            String[] sArr = L1.trim().split(" ");
            String res = "";
            for(int i=sArr.length-1;i>0;i--){
                res += sArr[i]+" ";
            }
            res+=sArr[0];
            System.out.println(res);
        }
    }
}
```

## 第三题 树的高度

### 题目描述
>现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度

**输入描述:**
>输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号

**输出描述:**
>输出树的高度，为一个整数

**样例：**

**输入**
>5
0 1
0 2
1 3
1 4

**输入**
>3


### 参考代码
- 在自己的运行环境中正确，但是在线测试却没过，可能给的用例不恰当或者自己理解的不到位。

```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int res=1;
            int[][] edge=new int[n-1][2];
            for(int i=0;i<n-1;i++){
                edge[i][0]=in.nextInt();
                edge[i][1]=in.nextInt();
            }
            ArrayList<Integer> que = new ArrayList<>();
            int bef=0;
            int beh=0;
            int cur=0;
            que.add(edge[0][0]);
            while(beh<n-1){
                while(beh<n-1&&que.get(bef)==edge[beh][0]){
                    que.add(edge[beh++][1]);
                }
                if(bef==cur){
                    cur=beh;
                    res++;
                }
                bef++;
            }
            if(beh>cur)
                res++;
            System.out.println(res);
        }
    }
}
```

- 别人AC的代码

```
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = "";
        // 树的深度Map、节点孩子数量Map
        HashMap<Integer, Integer> deep = new HashMap<>();
        HashMap<Integer, Integer> childNum = new HashMap<>();
        deep.put(0, 1);
        childNum.put(0, 0);
        // 默认树的深度为1
        int max = 1;
        int myDeep = 0;
        for (int i = 0; i < n - 1; i++) {
            int parent = scanner.nextInt();
            int num = scanner.nextInt();
            // 不包含父节点或者孩子数目超过两个，则跳过
            if (!deep.containsKey(parent) || childNum.get(parent) >= 2) {
                continue;
            }
            // 树的深度加一
            myDeep = deep.get(parent) + 1;
            // 子节点和树的深度
            deep.put(num, myDeep);
            // 存父节点，其子节点的数量加一
            childNum.put(parent, (childNum.get(parent) + 1));
            // 存子节点，其子节点数量为0
            childNum.put(num, 0);
            if (myDeep > max) {
                max = myDeep;
            }
        }
        System.out.println(max);
    }
}
```
