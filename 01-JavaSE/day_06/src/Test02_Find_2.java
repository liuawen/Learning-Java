/**
 * @author Liu Awen
 * @create 2020-05-15 16:52
 */
/*
数组的算法：
1、找最值
2、找最值及其下标
3、统计：累加和、平均值等
4、反转
5、复制
6、查找：在数组中，查找某个值是否存在，或者查找某个值的下标
（1）数组中的元素是无序的
	顺序查找
（2）数组中的元素是有序的
	①顺序查找
	②二分查找
*/
class Test02_Find_2{
    public static void main(String[] args){
        int[] arr = {1,2,5,7,9,10};//有序的，从小到大，或者大到小
        //顺序查找 二分查找

        int value = 10;

        int index = -1;
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right)/2;
		/*
		假设数组的长度是5，left=0,right=4,mid = 2
		假设数组的长度是6，left=0,right=5,mid = 2
		*/

        while(left<=right){
            if(arr[mid] == value){//找到了
                index = mid;
                break;
            }else if(value > arr[mid]){//去右边找
                left = mid + 1;//因为mid比较过了，就不用看了，从mid的下一个作为左边界
            }else{//说明value < arr[mid] 去左边找
                right = mid - 1;
            }
            mid = (left + right)/2;//重新计算mid，因为left或right修改了
        }

        if(index == -1){
            System.out.println(value+"不存在");
        }else{
            System.out.println(value+"在数组中的下标是：" + index);
        }
    }
}