/**
 * @author Liu Awen
 * @create 2018-05-10 20:21
 */
/*
程序：
（1）数据结构：如何存储数据
（2）算法：实现功能的代码的逻辑结构

数组的相关的算法操作：
1、在数组中找最大值/最小值
2、在数组中找最大值/最小值及其下标
3、数组的元素累加和及平均值
4、数组的反转
*/
class Test14_Reverse{
    public static void main(String[] args){
        //有一个数组，存储26个字母
        //'A'~'Z'
        char[] letters = new char[26];
        for(int i=0; i<letters.length; i++){
            letters[i] = (char)('A' + i);
        }

        //需求：要反转整个数组
        //原来letters[0]中存储的是'A'-->现在letters[0]中存储的是'Z'
        //...
        //原来letters[25]中存储的是'Z'-->现在letters[25]中存储的是'A'
        //方式一：定义一个与原来的数组长度相同的新数组，并且逆序复制元素
        char[] newLetters = new char[letters.length];
        //逆序复制元素
        for(int i=0; i<newLetters.length; i++){
            newLetters[i] = letters[letters.length-1-i];
        }

        //让letters这个数组名指向新的数组
        letters = newLetters;

        //显示结果
        for(int i=0; i<letters.length; i++){
            System.out.println(letters[i]);
        }
    }
}