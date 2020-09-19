# 科大讯飞2018校园招聘算法笔试题

<!-- TOC -->
* [第一题:争吵](#第一题-争吵)
* [第二题:球赛](#第二题-球赛)
* [第三题:课程冲突](#第二题-课程冲突)
<!-- TOC -->


## 第一题 争吵

### 题目描述
>有n个人排成了一行队列，每个人都有一个站立的方向：面向左或面向右。由于这n个人中每个人都很讨厌其他的人，所以当两个人面对面站立时，他们会发生争吵，然后其中一个人就会被踢出队列，谁被踢出队列都是有可能的。
 我们用字符L来表示一个面向左站立的人，用字符R来表示一个面向右站立的人，那么这个队列可以用一个字符串描述。比如RLLR就表示一个四个人的队列，其中第一个人和第二个人是面对面站立的。他们发生争吵后队列可能会变成LLR，也可能变成RLR；若变成RLR，则第一个人与第二个人还会发生争吵，队列会进一步变成LR 或者RR。
 若在某个时刻同时可能有很多的争吵会发生时，接下来只会发生其中的一个，且任意一个都是有可能发生的。
 你想知道经过一系列的争吵后，这个队列最少会剩下多少人？
 
**输入描述:**
>第一行包含一个有字符L和R构成的字符串。(1<=字符串长度<=10^5)

**输出描述:**
>输出队列中最少会剩下多少人。

**样例：**
```
输入
LRRLRL
输入
2
说明：
LRRLRL -> LRLRL -> LRRL -> LRL -> LR
```

### 解题思路

- 如同括号匹配问题，成对的就消去其中一个，可以发现，在一成对括号中间的所有括号都可以被消去。即找出最左的R，而最右的L即可。

### 参考代码
```java
import java.util.Scanner;
public class Main {
    public static void main(String[]  args ) {
         Scanner in = new Scanner(System.in);
         String s = in.nextLine();
         int right = s.length()-1;
         int left = 0;
         while(left<s.length()){
             if(s.charAt(left)=='R') break;
             left++;
         }
         while(right>=0){
             if(s.charAt(right)=='L') break;
             right--;
         }

         if(left>right){
             System.out.println(s.length());
         }
         else{
             System.out.println(s.length()-right+left);
         }
    }
}
```

## 第二题 球赛

### 题目描述
>大学生足协决定举办全国性的大学生足球赛，由每个学校派遣一支队伍代表该校参赛。比赛分区分为几个赛区进行，最终的总决赛中，将有不超过n支队伍参加。经过激烈的角逐，有机会参与总决赛的队伍已经决出。
 协会对比赛的规则进行了调整，以便使得比赛更具有观赏性。
1. 总决赛的参赛队伍为n支，n为偶数；
2. 进入前1/2的队伍才有资格进入淘汰赛；
3. 队伍按积分排名，具体规则为：胜一场积3分；平一场积1分；负一场积0分。队伍首先按积分降序排列，积分相同按净胜球数降序排列，仍然相同的按进球数降序排列。
4. 基于上述规则，尚未出现有排名歧义的情况发生。
随着赛程的进行，目前各个队伍对战的结果已经确定了，小B负责确定进入淘汰赛的名单，她向你求助，你能帮她吗？

**输入描述:**
>测试数据有多组，每组测试数据的第一行为一个整数n（1=< n <=50），为参与总决赛的球队数，随后的n行为球队的名字，由不超过30个的大小写拉丁字母构成。随后的n*(n-1)/2行为赛事的开展情况，每行的格式为name1-name2 num1:num2，表示两支队伍的比分情况（1=<num1, num2<=100）。确保不会有两支队伍同名，也不会出现队伍自己通自己比赛的情况，且每场比赛仅出现一次。

**输出描述:**
>对每组测试数据，输出n/2行，为按字母序排列的进入淘汰赛的n/2支队伍的名单，每个名字在单独的行中输出。

**样例：**
```
输入
4
A
B
C
D
A-B 1:1
A-C 2:2
A-D 1:0
B-C 1:0
B-D 0:3
C-D 0:3
2
a
A
a-A 2:1
输出
A
D
a
```

### 参考代码
```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    class Team {
        String name;
        int grade;
        int realwin;
        int in;

        public Team(String name, int grade, int realwin, int in) {
            this.name = name;
            this.grade = grade;
            this.realwin = realwin;
            this.in = in;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public void setRealwin(int realwin) {
            this.realwin = realwin;
        }

        public void setIn(int in) {
            this.in = in;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        while (sc.hasNext()) {
            String ns = sc.nextLine();
            int n = Integer.valueOf(ns);
            Team[] win = new Team[n];// n支球队的名字
            TreeMap<String, Team> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String cname = sc.nextLine();
                Team team = main.new Team(cname, 0, 0, 0);
                map.put(cname, team);
            }
            int len = (n * (n - 1)) / 2;// 对所有的比赛结果进行处理
            for (int i = 0; i < len; i++) {
                // 以空格分为对战球队str[0]和比分str[1]分别进行处理
                // A-B 1:2
                String[] str = sc.nextLine().split(" ");
                String[] name = str[0].split("-");
                String cname1 = name[0];// A
                String cname2 = name[1];// B
                String[] grad = str[1].split(":");
                int c1 = Integer.valueOf(grad[0]);// 1
                int c2 = Integer.valueOf(grad[1]);// 2
                int c = c1 - c2;// 比分差距，用于计算净胜球
                int grade1 = 0;// 得分 3 1 0
                int realwin1 = 0;// 净胜球数
                int in1 = c1;// 进球数
                int grade2 = 0;
                int realwin2 = 0;
                int in2 = c2;
                if (c == 0) {// 平局
                    grade1 = 1;
                    grade2 = 1;
                }
                if (c > 0) {
                    grade1 = 3;
                    realwin1 = c;
                }
                if (c < 0) {
                    grade2 = 3;
                    realwin2 = c2 - c1;
                }
                //设置得分、净胜球数、进球数
                Team team = map.get(cname1);
                team.setGrade(team.grade + grade1);
                team.setIn(team.in + in1);
                team.setRealwin(team.realwin + realwin1);
                map.put(cname1, team);

                Team team2 = map.get(cname2);
                team2.setGrade(team2.grade + grade2);
                team2.setIn(team2.in + in2);
                team2.setRealwin(team2.realwin + realwin2);
                map.put(cname2, team2);
            }
            int i = 0;
            for (String key : map.keySet()) {
                win[i++] = map.get(key);
            }
            //自定义排序比较器。排序规则：
            //首先按照积分，其次净胜球，最后进球数
            Arrays.sort(win, new Comparator<Team>() {
                public int compare(Team o1, Team o2) {
                    int grade = o2.grade - o1.grade;
                    int realwin = o2.realwin - o1.realwin;
                    int in = o2.in - o1.in;
                    if (grade != 0)
                        return grade;
                    else if (realwin != 0)
                        return realwin;
                    else
                        return in;
                }
            });
            String[] name = new String[n / 2];
            for (i = 0; i < n / 2; i++)
                name[i] = win[i].name;
            Arrays.sort(name);//对球队名字按字典序输出
            for (i = 0; i < n / 2; i++)
                System.out.println(name[i]);
        }
    }
}
```

## 第三题 课程冲突

### 题目描述
>小明是一名学生，又到了学校的选课时间，他想选一些课程学习，已知课程开课时间都在每周一到周五之内，早上4讲课，下午4讲课，晚上2讲课。
 小明担心选课时间上有所冲突。所以他希望可以对课程时间进行检查。

**输入描述:**
>首先输入一个整数n（0<n<=100），表示小明选课总数。
 之后输入n行选课信息，每行选课信息有2个数字。
 第一个数字表示开课时间，开课时间用2位数表示，前一位用0到4表示周一至周五，后一位用0到9表示从早到晚顺序第几讲课，如12表示礼拜二第三讲课。01表示礼拜一第二讲课。
 每行第二个数字表示课程代码，如：204521。课程代码为6位数字。输入课程代码均不重复。

**输出描述:**
>如果没有冲突课程，输出YES。
 如果有冲突课程，也就是同一个时间多于一节课，输出所有冲突的课程。输出有多行，如果多个不同的上课时间都有课程冲突，按照周一到周五，早上到晚上时间先后，按行输出冲突信息。在同一行内，先输出冲突时间，之后输出这一时间的所有课程，输出课程的顺序为输入中这些课程出现的顺序，课程之间以空格分隔，不要在行末输出多余的空格。


**样例：**
```
输入
5
01 204528
23 204523
22 204526
01 204521
22 204527
输出
01 204521 204528
22 204526 204527

输入
3
11 204521
23 204522
43 204531
输出
YES
```

### 参考代码
```java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, PriorityQueue<String>> map = new TreeMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String time = sc.next(), code = sc.next();
            if (!map.containsKey(time))
                map.put(time, new PriorityQueue<>());
            map.get(time).add(code);
        }
        for (String time : map.keySet()) {
            if (map.get(time).size() > 1) {
                System.out.printf(time);
                for (String code : map.get(time))
                    System.out.printf(" " + code);
                System.out.printf("\n");
            }
        }
    }
}
```
