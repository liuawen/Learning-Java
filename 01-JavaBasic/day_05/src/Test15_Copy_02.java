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
class Test15_Copy_02{
    public static void main(String[] args){
        //（1）复制一个比原来数组短的
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        //复制原来的数组的一部分，来构成新数组，例如：[2]~[8]
        int start = 2;
        int end = 8;
		/*
		（1）创建新数组，新数组的长度 = 8-2
		*/
        int[] newArr = new int[end-start+1];

        //(2)复制元素
        for(int i=0; i<newArr.length; i++){
			/*
			newArr[0] = arr[2] = arr[start+0];
			newArr[1] = arr[3] = arr[start+1];
			...
			*/
            //newArr[i] = 值;
            newArr[i] = arr[start+i];
        }

        //(3)遍历结果
        for(int i=0; i<newArr.length; i++){
            System.out.println(newArr[i]);
        }
    }
}