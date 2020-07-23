/**
 * @author Liu Awen
 * @create 2018-05-10 20:23
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
5、数组的复制
（1）复制一个和原来一样的数组，长度和元素
（2）复制一个比原来数组短的
	例如：从原数组中截取一部分
（3）复制一个比原来的长的
	例如：数组扩容，那么新数组会比原来的数组长
*/
class Test15_Copy_01{
    public static void main(String[] args){
        //（1）复制一个和原来一样的数组，长度和元素
        int[] arr = {1,2,3,4,5};

		/*
		(1)创建一个新数组，和原来的数组一样
		*/
        int[] newArr = new int[arr.length];
		/*
		(2)复制元素
		*/
        for(int i=0; i<newArr.length; i++){
            newArr[i] = arr[i];
        }

        //(3)遍历新数组
        for(int i=0; i<newArr.length; i++){
            System.out.println(newArr[i]);
        }
    }
}