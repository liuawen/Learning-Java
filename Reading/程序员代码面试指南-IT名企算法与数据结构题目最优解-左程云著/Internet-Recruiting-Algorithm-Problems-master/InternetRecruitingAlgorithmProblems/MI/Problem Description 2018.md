# 小米2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:24点](#第一题-24点)
* [第二题:完美矩形](#第二题-完美矩形)
* [第三题:合并集合](#第三题-合并集合)
* [第四题:添加符号](#第四题-添加符号)
<!-- TOC -->


## 第一题 24点

### 题目描述
>有n个1~23的整数，写一个算法，求出有多少个相互不同的子集合的和为24点。

**输入描述:**
>输入数据包含一组，每组占一行，包括n个整数(1<=整数<=23)

**输出描述:**
>对于每个测试实例，要求输出能组成24点的所有子集合的数量（子集合相互不同）。如果不存在，则输出0。每个测试实例的输出占一行。

**样例：**
```
输入
1 2 22 23
输入
2
```

### 参考代码
```java
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] array = line.split(" ");
        int[] numArr = new int[array.length];
        for(int i=0;i<numArr.length;i++){
            numArr[i]=Integer.valueOf(array[i]);
        }
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        DFS(0,0,array.length,numArr,res,list);
        System.out.println(res.size());
    }
    private static void DFS(int sum,int index,int len,int[] arr,HashSet<ArrayList<Integer>> res,ArrayList<Integer> list){
        if(sum==24){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(index==len) return;
        DFS(sum,index+1,len,arr,res,list);
        list.add(arr[index]);
        DFS(sum+arr[index],index+1,len,arr,res,list);
        list.remove(list.size()-1);
    }
}
```

## 第二题 完美矩形

### 题目描述
>给定n个轴对齐的矩形其中n>0，判断他们组合在一起能否覆盖一个完美的矩形区域（无重叠，无空隙）
每个矩形使用左下和右上的点表示。例如，一个矩形的定义为[1,1,2,2]，（左下坐标点（1,1）和右上坐标点（2,2）的一个单元的正方形）。

**输入描述:**
>输入包含一组数据，有n行，每行代表一个矩形（左下坐标点和右上坐标点），数字用空格隔开。

**输出描述:**
>对于每个测试实例，输出能否组合覆盖一个矩形（false/true)。

**样例：**
```
输入
1 1 3 3
3 1 4 2
3 2 4 4
1 3 2 4
2 3 3 4

输出
true
```

### 解题思路
- 遍历每个矩形判断是否与之前的矩形有没有重叠，

### 参考代码
```java
import java.util.*;
public class Main {
    private static class Rect{
        private int x0;
        private int y0;
        private int x1;
        private int y1;
        public Rect(int x0,int y0,int x1,int y1){
            this.x0 = x0;
            this.x1 = x1;
            this.y0 = y0;
            this.y1 = y1;
        }
        public int getX0() {
            return x0;
        }
        public void setX0(int x0) {
            this.x0 = x0;
        }
        public int getY0() {
            return y0;
        }
        public void setY0(int y0) {
            this.y0 = y0;
        }
        public int getX1() {
            return x1;
        }
        public void setX1(int x1) {
            this.x1 = x1;
        }
        public int getY1() {
            return y1;
        }
        public void setY1(int y1) {
            this.y1 = y1;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Rect> rectList = new ArrayList<>();
        int square = 0;
        Rect parentRect = null;
        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] strings = line.split(" ");
            Rect rect = new Rect(Integer.valueOf(strings[0]),
                    Integer.valueOf(strings[1]),
                    Integer.valueOf(strings[2]),
                    Integer.valueOf(strings[3]));
            square+=caculateSquare(rect);
            if(rectList.isEmpty()){
                parentRect = new Rect(rect.x0,rect.y0,rect.x1,rect.y1);
                rectList.add(rect);
            }else{
                for(int i=0;i<rectList.size();i++){
                    if(isOverLap(rect,rectList.get(i))){
                        System.out.println("false");
                        return;
                    }
                }
                caculateParentRect(rect,parentRect);
            }
        }
        if(square==caculateSquare(parentRect)){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    private static int caculateSquare(Rect rect){
        return (rect.y1-rect.y0)*(rect.x1-rect.x0);
    }

    private static boolean isOverLap(Rect rec1,Rect rec2){
        if((rec1.x0 >= rec2.x0) && (rec1.x0 < rec2.x1))
        {
            if((rec1.y0 >= rec2.y0) && (rec1.y0 < rec2.y1))
                return true;
            if((rec1.y1 > rec2.y0) && (rec1.y1  <= rec2.y1))
                return true;
            if((rec2.y0 >= rec1.y0) && (rec2.y0 < rec1.y1))
                return true;
            if((rec2.y1 > rec1.y0) && (rec2.y1 <= rec1.y1))
                return true;
        }
        if((rec1.x1 > rec2.x0) && (rec1.x1 <= rec2.x1))
        {
            if((rec1.y0 >= rec2.y0) && (rec1.y0 < rec2.y1))
                return true;
            if((rec1.y1 > rec2.y0) && (rec1.y1  <= rec2.y1))
                return true;
            if((rec2.y0 >= rec1.y0) && (rec2.y0 < rec1.y1))
                return true;
            if((rec2.y1 > rec1.y0) && (rec2.y1 <= rec1.y1))
                return true;
        }
        if((rec2.x0 >= rec1.x0) && (rec2.x0 < rec1.x1))
        {
            if((rec1.y0 >= rec2.y0) && (rec1.y0 < rec2.y1))
                return true;
            if((rec1.y1 > rec2.y0) && (rec1.y1  <= rec2.y1))
                return true;
            if((rec2.y0 >= rec1.y0) && (rec2.y0 < rec1.y1))
                return true;
            if((rec2.y1 > rec1.y0) && (rec2.y1 <= rec1.y1))
                return true;
        }
        if((rec2.x1 > rec1.x0) && (rec2.x1 <= rec1.x1))
        {
            if((rec1.y0 >= rec2.y0) && (rec1.y0 < rec2.y1))
                return true;
            if((rec1.y1 > rec2.y0) && (rec1.y1  <= rec2.y1))
                return true;
            if((rec2.y0 >= rec1.y0) && (rec2.y0 < rec1.y1))
                return true;
            if((rec2.y1 > rec1.y0) && (rec2.y1 <= rec1.y1))
                return true;
        }
        return false;
    }

    private static void caculateParentRect(Rect rect,Rect parentRect){
        if(rect.x0<parentRect.x0){
            parentRect.setX0(rect.x0);
        }
        if(rect.y0<parentRect.y0){
            parentRect.setY0(rect.y0);
        }
        if(rect.x1>parentRect.x1){
            parentRect.setX1(rect.x1);
        }
        if(rect.y1>parentRect.y1){
            parentRect.setY1(rect.y1);
        }
    }
}
```


## 第三题 集合合并

### 题目描述
>给定若干个32位int数字集合，每个集合中的数字无重复，譬如：
  {1,2,3}  {2,5,6}  {8}
将其中交集不为空的集合合并，保证合并完成后所有集合之间无交集，输出合并后的集合个数以及最大集合中元素的个数。

**输入描述:**
>1. 第一行为一个数字N，表示集合数。
2. 接下来N行，每行一个非空集合，包含若干个数字，数字之间用空格分开。

**输出描述:**
>1. 第一行为合并后的集合个数。
2. 第二个为最大集合中元素的个数。

**样例：**
```
输入
3
1 2 3
2 5 6
8

输出
2
5
```


### 参考代码
```java
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N  = in.nextInt();
        in.nextLine();
        ArrayList<Set<Integer>> set = new ArrayList<>();
        for(int i=0;i<N;i++){
            String line = in.nextLine();
            String[] arr = line.split(" ");
            HashSet<Integer> nums = new HashSet<>();
            for(int j=0;j<arr.length;j++){
                nums.add(Integer.valueOf(arr[j]));
            }
            set.add(nums);
        }
        ArrayList<HashSet<Integer>> result = new ArrayList<>();
        boolean flag = true;
        for(int i=0;i<set.size();i++){
            for(int j=i+1;j<set.size();){
                Set<Integer> tmp = union(set.get(i),set.get(j));
                if(tmp.size()<set.get(i).size()+set.get(j).size()&&tmp.size()>set.get(i).size()&&tmp.size()>set.get(j).size()){
                    set.set(i,tmp);
                    set.remove(j);
                }else{
                    j++;
                }
            }
        }
        System.out.println(set.size());
        int max = 0;
        for(int i=0;i<set.size();i++){
            if(set.get(i).size()>max){
                max = set.get(i).size();
            }
        }
        System.out.println(max);
    }

    public static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> set = new HashSet<T>(a);
        set.addAll(b);
        return set;
    }
}
```

## 第四题 添加符号

### 题目描述
>给出一个数字N，对于数字序列 1,2,3 ... N。现在在其中插入“+”, "-", " "，使得表达式的和为M。" "的含义是把相邻的两个数字组成一个数。例如：1 + 2 3 - 4，含义是：1 + 23 - 4 = 20。
给出N和M，求出所有合法的序列的个数。

**输入描述:**
>两个整数N,M ( N <= 7, M <= 100)

**输出描述:**
>合法序列的个数

**样例：**
```
输入
7 0

输出
6

样例中的六种合法序列
1+2-3+4-5-6+7 
1+2-3-4+5+6-7 
1-2 3+4+5+6+7 
1-2 3-4 5+6 7 
1-2+3+4-5+6-7 
1-2-3-4-5+6+7
```

### 参考代码
```java
import java.util.*;
public class Main {

    private static List<List<Integer>> list = new ArrayList<>();
    private static List<List<Integer>> op_list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int result = in.nextInt();
        System.out.println(getResult(N,result));
    }

    public static int getResult(int N,int result) {
        fun(N);
        int count = 0;
        for(int k=0; k<list.size(); k++){
            Integer [] ee = new Integer[list.get(k).size()];
            op_list.clear();
            fun_op(list.get(k).toArray(ee), list.get(k).size()-1);
            //一组组合添加+或者-以后可能有的数组，计算其和
            for(int i=0; i<op_list.size(); i++){
                List<Integer> l = op_list.get(i);
                int sum = 0;
                for(int j=0; j<l.size(); j++){
                    sum+=l.get(j);
                }
                if(sum==result && l.get(0)>0){
                    count++;
                }
            }
        }
        return count;
    }
    //所有数字有可能的组合
    public static int fun(int c) {
        if(c==1){
            List gen = new ArrayList();
            gen.add(1);
            list.add(gen);
            return 1;
        }
        int r = 0;
        r = r + 2*fun(c-1);

        int k = list.size();
        for(int i=0; i<k; i++){
            List old = list.get(i);
            List gen = new ArrayList(old);
            gen.set(gen.size()-1, (int)(gen.get(gen.size()-1))*10 + c);
            list.add(gen);
            old.add(c);
        }
        return r;
    }
    //一组组合添加+或者-以后可能有的数组
    public static int fun_op(Integer [] arr, int c){
        if(c==0){
            List gen1 = new ArrayList();
            gen1.add(arr[c]);
            List gen2 = new ArrayList();
            gen2.add(-arr[c]);
            op_list.add(gen1);
            op_list.add(gen2);
            return 2;
        }
        int r = 0;
        r = r + fun_op(arr,c-1);

        int k = op_list.size();
        for(int i=0; i<k; i++){
            List old = op_list.get(i);
            List gen = new ArrayList(old);
            gen.add(-1*arr[c]);
            op_list.add(gen);
            old.add(arr[c]);
        }
        return r;
    }
}
```
