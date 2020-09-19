
# 程序员代码面试指南

Coding Interview Guide这个仓库是我在看左程云的著作《程序员代码面试指南》时，对其中的代码做的整理和总结！

## 目录
- [栈和队列](#栈和队列)
- [链表问题](#链表问题)
- [二叉树问题](#二叉树问题)
- [递归和动态规划](#递归和动态规划)
- [字符串问题](#字符串问题)
- [位运算](#位运算)
- [数组和矩阵问题](#数组和矩阵问题)
- [其他问题](#其他问题)

# 栈和队列

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 设计一个有getMin功能的栈 (☆)                     |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1001.md)  | 栈                                |
| 1002 | 由两个栈组成的队列 (☆☆)                          |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1002.md)  | 栈、队列                          |
| 1003 | 用递归函数和栈操作逆序一个栈 (☆☆)                |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1003.md)  | 栈、递归                          |
| 1004 | 用一个栈实现另一个栈的排序 (☆)                   |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1004.md)  | 栈                                |
| 1005 | 用栈来求解汉诺塔问题 (☆☆☆)                       |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1005.md)  | 栈、递归                          |
| 1006 | 生成窗口最大值数组 (☆☆)                          |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1006.md)  | 栈、队列                          |
| 1007 | 构造数组的MaxTree (☆☆☆)                          |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1007.md)  | 栈                                |
| 1008 | 求最大子矩阵的大小 (☆☆☆)                         |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1008.md)  | 栈                                |
| 1009 | 最大值减去最小值小于或等于num的子数组数量 (☆☆☆)  |[查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter01_Stack%26Queue/Q1009.md)  | 队列                              |

<br>[⬆ 回到顶部](#程序员代码面试指南)

# 链表问题

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 打印两个有序链表的公共部分 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1001.md)   | 打印链表                              |
| 1002 | 在单链表和双链表中删除倒数第k个节点 (☆)                    | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1002.md)   | 删除链表                              |
| 1003 | 删除链表的中间节点和a/b处的节点 (☆)                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1003.md)   | 删除链表                              |
| 1004 | 反转单向和双向链表 (☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1004.md)   | 链表逆序                              |
| 1005 | 反转部分单向链表 (☆)                                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1005.md)   | 链表逆序                              |
| 1006 | 环形链表的约瑟夫问题 (☆)                                   | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1006.md)   | 删除链表                              |
| 1007 | 判断一个链表是否为回文结构 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1007.md)   | 链表判断                              |
| 1008 | 将单向链表按某值划分成左边小、中间相等、右边大的形式 (☆☆)  | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1008.md)   | 链表调整                              |
| 1009 | 复制含有随机指针节点的链表 (☆☆)                            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1009.md)   | 复制链表                              |
| 1010 | 两个单链表生成相加链表 (☆)                                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1010.md)   | 合并链表                              |
| 1011 | 两个单链表相交的一系列问题 (☆☆☆☆)                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1011.md)   | 链表相交                              |
| 1012 | 将单链表的每k个节点之间逆序 (☆☆)                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1012.md)   | 链表逆序                              |
| 1013 | 删除无序单链表中值重复出现的节点 (☆)                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1013.md)   | 删除链表                              |
| 1014 | 在单链表中删除指定值的节点 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1014.md)   | 删除链表                              |
| 1015 | 将搜索二叉树转换成双向链表 (☆☆)                            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1015.md)   | 链表转换                              |
| 1016 | 单链表的选择排序 (☆)                                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1016.md)   | 链表排序                              |
| 1017 | 一种怪异的节点删除方式 (☆)                                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1017.md)   | 删除链表                              |
| 1018 | 向有序的环形单链表中插入新节点 (☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1018.md)   | 链表插入                              |
| 1019 | 合并两个有序的单链表 (☆)                                   | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1019.md)   | 合并链表                              |
| 1020 | 按照左右半区的方式重新组合单链表 (☆)                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter02_List/Q1020.md)   | 调整链表                              |

<br>[⬆ 回到顶部](#程序员代码面试指南)

# 二叉树问题

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 分别用递归和非递归方式实现二叉树先序、中序和后序遍历 (☆☆☆)             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1001.md)   | 二叉树遍历                              |
| 1002 | 打印二叉树的边界节点 (☆☆)                                              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1002.md)   | 打印二叉树                              |
| 1003 | 如何较为直观地打印二叉树 (☆☆)                                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1003.md)   | 打印二叉树                              |
| 1004 | 二叉树的序列化和反序列化 (☆)                                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1004.md)   | 二叉树的序列化                          |
| 1005 | 遍历二叉树的神级方法 (☆☆☆☆)                                            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1005.md)   | 遍历二叉树                              |
| 1006 | 在二叉树中找到累加和为指定值的最长路径长度 (☆☆)                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1006.md)   | 二叉树的路径                            |
| 1007 | 找到二叉树中的最大搜索二叉子树 (☆☆)                                    | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1007.md)   | 搜索二叉树                              |
| 1008 | 找到二叉树中符合搜索二叉树条件的最大拓扑结构 (☆☆☆)                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1008.md)   | 搜索二叉树                              |
| 1009 | 二叉树的按层打印与ZigZag打印 (☆☆)                                      | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1009.md)   | 打印二叉树                              |
| 1010 | 调整搜索二叉树中两个错误的节点 (☆☆)                                    | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1010.md)   | 搜索二叉树                              |
| 1011 | 判断t1树是否包含t2树全部的拓扑结构 (☆)                                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1011.md)   | 二叉树的拓扑结构                        |
| 1012 | 判断t1树中是否有与t2树拓扑结构完全相同的子树 (☆☆☆)                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1012.md)   | 二叉树的拓扑结构                        |
| 1013 | 判断二叉树是否为平衡二叉树 (☆)                                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1013.md)   | 平衡二叉树                              |
| 1014 | 根据后序数组重建搜索二叉树 (☆)                                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1014.md)   | 重建二叉树                              |
| 1015 | 判断一棵二叉树是否为搜索二叉树和完全二叉树 (☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1015.md)   | 完全二叉树                              |
| 1016 | 通过有序数组生成平衡搜索二叉树 (☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1016.md)   | 平衡二叉树                              |
| 1017 | 在二叉树中找到一个节点的后继节点 (☆☆)                                  | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1017.md)   | 寻找节点                                |
| 1018 | 在二叉树中找到两个节点的最近公共祖先 (☆)                               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1018.md)   | 最近公共祖先                            |
| 1019 | Tarjan算法与井查集解决二叉树节点间最近公共祖先的批量查询问题 (☆☆☆)     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1019.md)   | 最近公共祖先                            |
| 1020 | 二叉树节点问的最大距离问题 (☆☆)                                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1020.md)   | 最大距离问题                            |
| 1021 | 先序、中序和后序数组两两结合重构二叉树 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1021.md)   | 重构二叉树                              |
| 1022 | 通过先序和中序数组生成后序数组 (☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1022.md)   | 重构二叉树                              |
| 1023 | 统计和生成所有不同的二叉树 (☆☆)                                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1023.md)   | 统计二叉树                              |
| 1024 | 统计完全二叉树的节点数 (☆☆)                                            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter03_BT/Q1024.md)   | 统计二叉树                              |

<br>[⬆ 回到顶部](#程序员代码面试指南)

# 递归和动态规划

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 斐波那契系列问题的递归和动态规划 (☆☆☆☆)        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1001.md)   | 递归、动态规划                              |
| 1002 | 矩阵的最小路径和 (☆☆)                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1002.md)   | 递归、动态规划                              |
| 1003 | 换钱的最少货币数 (☆☆)                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1003.md)   | 递归、动态规划                              |
| 1004 | 换钱的方法数 (☆☆)                              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1004.md)   | 递归、动态规划                              |
| 1005 | 最长递增子序列 (☆☆☆)                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1005.md)   | 递归、动态规划                              |
| 1006 | 汉诺塔问题 (☆☆☆)                               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1006.md)   | 递归、动态规划                              |
| 1007 | 最长公共子序列问题 (☆☆)                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1007.md)   | 递归、动态规划                              |
| 1008 | 最长公共子串问题 (☆☆☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1008.md)   | 递归、动态规划                              |
| 1009 | 最小编辑代价 (☆☆☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1009.md)   | 递归、动态规划                              |
| 1010 | 字符串的交错组成 (☆☆☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1010.md)   | 递归、动态规划                              |
| 1011 | 龙与地下城游戏问题 (☆☆)                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1011.md)   | 递归、动态规划                              |
| 1012 | 数字字符串转换为字母组合的种数 (☆☆)            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1012.md)   | 递归、动态规划                              |
| 1013 | 表达式得到期望结果的组成种数 (☆)               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1013.md)   | 递归、动态规划                              |
| 1014 | 排成一条线的纸牌博弈问题 (☆☆)                  | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1014.md)   | 递归、动态规划                              |
| 1015 | 跳跃游戏 (☆)                                   | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1015.md)   | 递归、动态规划                              |
| 1016 | 数组中的最长连续序列 (☆☆)                      | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1016.md)   | 递归、动态规划                              |
| 1017 | N皇后问题 (☆☆☆)                                | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter04_RecursionAndDP/Q1017.md)   | 递归、动态规划                              |

<br>[⬆ 回到顶部](#程序员代码面试指南)

# 字符串问题

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 判断两个字符串是否互为变形词 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1001.md)   | 判断字符串                              |
| 1002 | 字符串中数字子串的求和 (☆)                                   | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1002.md)   | 字符串求和                              |
| 1003 | 去掉字符串中连续出现k个0的子串 (☆)                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1003.md)   | 删除字符串                              |
| 1004 | 判断两个字符串是否互为旋转词 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1004.md)   | 判断字符串                              |
| 1005 | 将整数字符串转成整数值 (☆☆)                                  | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1005.md)   | 字符串转换                              |
| 1006 | 替换字符串中连续出现的指定字符串 (☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1006.md)   | 替换字符串                              |
| 1007 | 字符串的统计字符串 (☆)                                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1007.md)   | 统计字符串                              |
| 1008 | 判断字符数组中是否所有的字符都只出现过一次 (☆)               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1008.md)   | 判断字符串                              |
| 1009 | 在有序但含有空的数组中查找字符串 (☆☆)                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1009.md)   | 搜索字符串                              |
| 1010 | 字符串的调整与替换 (☆)                                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1010.md)   | 替换字符串                              |
| 1011 | 翻转字符串 (☆)                                               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1011.md)   | 翻转字符串                              |
| 1012 | 数组中两个字符串的最小距离 (☆☆)                              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1012.md)   | 字符串间的最小距离                      |
| 1013 | 添加最少字符使字符串整体都是回文字符串 (☆☆☆)                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1013.md)   | 回文字符串                              |
| 1014 | 括号字符串的有效性和最长有效长度 (☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1014.md)   | 字符串的有效长度                        |
| 1015 | 公式字符串求值 (☆☆☆)                                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1015.md)   | 字符串求值                              |
| 1016 | 0左边必有1的二进制字符串数量 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1016.md)   | 字符串数量                              |
| 1017 | 拼接所有字符串产生字典顺序最小的大写字符串 (☆☆☆)             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1017.md)   | 拼接字符串                              |
| 1018 | 找到宇符串的最长无重复字符子串 (☆☆)                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1018.md)   | 搜索字符串                              |
| 1019 | 找到被指的新类型字符 (☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1019.md)   | 搜索字符串                              |
| 1020 | 最小包含子串的长度 (☆☆☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1020.md)   | 字符串长度                              |
| 1021 | 回文最少分割数 (☆☆☆)                                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1021.md)   | 回文字符串                              |
| 1022 | 宇符串匹配问题 (☆☆☆)                                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1022.md)   | 字符串匹配                              |
| 1023 | 字典树（前缀树〉的实现 (☆☆)                                  | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter05_String/Q1023.md)   | 字典树                                  |

<br>[⬆ 回到顶部](#程序员代码面试指南)

# 位运算

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 不用额外变量交换两个整数的值 (☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter06_Bit/Q1001.md)   | 位运算                              |
| 1002 | 不用任何比较判断找出两个数中较大的数 (☆☆☆)                   | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter06_Bit/Q1002.md)   | 位运算                              |
| 1003 | 只用位运算不用算术运算实现整数的加减乘除运算 (☆☆)            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter06_Bit/Q1003.md)   | 位运算                              |
| 1004 | 整数的二进制表达中有多少个1 (☆☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter06_Bit/Q1004.md)   | 位运算                              |
| 1005 | 在其他数都出现偶数次的数组中找到出现奇数次的数 (☆☆)          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter06_Bit/Q1005.md)   | 位运算                              |
| 1006 | 在其他数都出现k次的数组中找到只出现一次的数(☆☆)              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter06_Bit/Q1006.md)   | 位运算                              |

<br>[⬆ 回到顶部](#程序员代码面试指南)

# 数组和矩阵问题

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 转圈打印矩阵 (☆)                                                   | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1001.md)   | 打印矩阵                              |
| 1002 | 将正方形矩阵顺时针转动90° (☆)                                      | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1002.md)   | 旋转矩阵                              |
| 1003 | “之” 字形打印矩阵 (☆)                                              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1003.md)   | 打印矩阵                              |
| 1004 | 找到无序数组中最小的k个数 (☆☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1004.md)   | 最小元素                              |
| 1005 | 需要排序的最短子数组长度 (☆)                                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1005.md)   | 数组长度                              |
| 1006 | 在数组中找到出现次数大于N/K的数 (☆☆☆)                              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1006.md)   | 寻找元素                              |
| 1007 | 在行列都排好序的矩阵中找数 (☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1007.md)   | 寻找元素                              |
| 1008 | 最长的可整合子数组的长度 (☆☆)                                      | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1008.md)   | 数组长度                              |
| 1009 | 不重复打印排序数组中相加和为给定值的所有二元组和三元组 (☆☆)        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1009.md)   | 打印矩阵                              |
| 1010 | 未排序正数数组中累加和为给定值的最长子数组长度 (☆☆)                | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1010.md)   | 数组长度                              |
| 1011 | 未排序数组中累加和为给定值的最长子数组系列问题 (☆☆)                | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1011.md)   | 子数组                                |
| 1012 | 未排序数组中累加和小于或等于给定值的最长子数组长度 (☆☆☆)           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1012.md)   | 子数组                                |
| 1013 | 计算数组的小和 (☆☆☆)                                               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1013.md)   | 数组的和                              |
| 1014 | 自然数数组的排序 (☆)                                               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1014.md)   | 数组排序                              |
| 1015 | 奇数下标都是奇数或者偶数下标都是偶数 (☆)                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1015.md)   | 搜索数组                              |
| 1016 | 子数组的最大累加和问题 (☆)                                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1016.md)   | 累加和                                |
| 1017 | 子矩阵的最大累加和问题 (☆☆)                                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1017.md)   | 累加和                                |
| 1018 | 在数组中找到一个局部最小的位置 (☆☆)                                | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1018.md)   | 搜索数组                              |
| 1019 | 数组中子数组的最大累乘积 (☆☆)                                      | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1019.md)   | 累乘积                                |
| 1020 | 打印N个数组整体最大的TopK (☆☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1020.md)   | TopK                                  |
| 1021 | 边界都是1的最大正方形大小 (☆☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1021.md)   | 矩阵边界                              |
| 1022 | 不包含本位置值的累乘数组 (☆)                                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1022.md)   | 累乘积                                |
| 1023 | 数组的partition调整 (☆)                                            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1023.md)   | 数组调整                              |
| 1024 | 求最短通路值 (☆☆)                                                  | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1024.md)   | 最短路径                              |
| 1025 | 数组中未出现的最小正整数 (☆☆)                                      | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1025.md)   | 搜索数组                              |
| 1026 | 数组排序之后相邻数的最大差值 (☆☆)                                  | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter07_ArrayAndMatrix/Q1026.md)   | 数组差值                              |

<br>[⬆ 回到顶部](#程序员代码面试指南)

# 其他问题

|  ID  | Title                               |                        JAVA                       | 备注                               |
| :--: | :---------------------------------- | :-----------------------------------------------: | :--------------------------------- |
| 1001 | 从5随机到7随机及其扩展 (☆☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1001.md)   |                               |
| 1002 | 一行代码求两个数的最大公约数 (☆☆)                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1002.md)   |                               |
| 1003 | 有关阶乘的两个问题 (☆☆)                                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1003.md)   |                               |
| 1004 | 判断一个点是否在矩形内部 (☆☆)                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1004.md)   |                               |
| 1005 | 判断一个点是否在三角形内部 (☆☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1005.md)   |                               |
| 1006 | 折纸问题 (☆☆)                                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1006.md)   |                               |
| 1007 | 蓄水池算法 (☆☆)                                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1007.md)   |                               |
| 1008 | 设计有setAll功能的哈希表 (☆)                            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1008.md)   |                               |
| 1009 | 最大的leftMax与rightMax之差的绝对值 (☆☆☆)               | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1009.md)   |                               |
| 1010 | 设计可以变更的缓存结构 (☆☆)                             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1010.md)   |                               |
| 1011 | 设计RandomPool结构 (☆☆)                                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1011.md)   |                               |
| 1012 | 调整[0,x)区间上的数出现的概率 (☆)                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1012.md)   |                               |
| 1013 | 路径数组变为统计数组 (☆☆☆)                              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1013.md)   |                               |
| 1014 | 正数数组的最小不可组成和 (☆☆)                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1014.md)   |                               |
| 1015 | 二种字符串和数字的对应关系 (☆☆☆)                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1015.md)   |                               |
| 1016 | 1到n中1出现的次数 (☆☆☆)                                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1016.md)   |                               |
| 1017 | 从N个数中等概率打印M个数 (☆)                            | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1017.md)   |                               |
| 1018 | 判读一个数是否是回文数 (☆)                              | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1018.md)   |                               |
| 1019 | 在有序旋转数组中找到最小值 (☆☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1019.md)   |                               |
| 1020 | 在有序旋转数组中找到一个数 (☆☆)                         | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1020.md)   |                               |
| 1021 | 数字的英文表达和中文表达 (☆☆☆)                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1021.md)   |                               |
| 1022 | 分糖果问题 (☆☆☆)                                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1022.md)   |                               |
| 1023 | 一种消息接收并打印的结构设计 (☆☆)                       | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1023.md)   |                               |
| 1024 | 设计一个没有扩容负担的堆结构 (☆☆☆☆)                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1024.md)   |                               |
| 1025 | 随时找到数据流的中位数 (☆☆☆☆)                           | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1025.md)   |                               |
| 1026 | 在两个长度相等的排序数组中找到上中位数 (☆☆)             | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1026.md)   |                               |
| 1027 | 在两个排序数组中找到第K小的数 (☆☆☆☆)                    | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1027.md)   |                               |
| 1028 | 两个有序数组间相加和的TOPK问题 (☆☆)                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1028.md)   |                               |
| 1029 | 出现次数的TOPK问题 (☆☆)                                 | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1029.md)   |                               |
| 1030 | Manacher算法 (☆☆☆☆)                                     | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1030.md)   |                               |
| 1031 | KMP算法 (☆☆☆☆)                                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1031.md)   |                               |
| 1032 | 丢棋子问题 (☆☆☆)                                        | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1032.md)   |                               |
| 1033 | 画匠问题 (☆☆☆)                                          | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1033.md)   |                               |
| 1034 | 邮局选址问题 (☆☆☆)                                      | [查看题解](https://github.com/LyricYang/Internet-Recruiting-Algorithm-Problems/blob/master/CodeInterviewGuide/Chapter08_Others/Q1034.md)   |                               |

<br>[⬆ 回到顶部](#程序员代码面试指南)
