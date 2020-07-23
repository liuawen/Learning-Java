/**
 * @author Liu Awen
 * @create 2018-05-10 20:24
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
class Test15_Copy_04{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};

		/*
		复制一个新数组，新数组的长度由键盘输入，可能和原来一样，可能比原来的短，可能比原来的长
		*/
		/*
		（1）从键盘输入新数组的长度
		*/
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入新数组的长度：");
        int len = input.nextInt();

        //（2）创建新数组
        int[] newArr = new int[len];

        //（3）复制元素，这里都是从原数组的[0]开始复制
        //i<arr.length && i<newArr.length保证newArr[i] = arr[i];左右两边都不越界
        for(int i=0; i<arr.length && i<newArr.length; i++){
            newArr[i] = arr[i];
        }

        //(4)遍历结果
        for(int i=0; i<newArr.length; i++){
            System.out.println(newArr[i]);
        }
    }
}