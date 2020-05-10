/**
 * @author Liu Awen
 * @create 2018-05-10 20:22
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
class Test14_Reverse_2{
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
        //方式二：首尾交换
        //问题1：交换几次   次数 = 长度/2  例如：6个元素交换3次，5个元素交换2次
		/*
		这个i可以用作下标，同时循环的次数，可以表示交换的次数
		*/
        for(int i=0; i<letters.length/2; i++){
            //问题2：谁和谁交换
            //letters[0] ~ letters[25]
            //letters[1] ~ letters[24]
            //..
            //首尾交换
            //letters[i] ~ letters[长度-1 - i]

            //问题3：如何交换
            //借助第三个变量
            char temp = letters[i];
            letters[i] = letters[letters.length-1-i];
            letters[letters.length-1-i] = temp;
        }

        //显示结果
        for(int i=0; i<letters.length; i++){
            System.out.println(letters[i]);
        }
    }
}