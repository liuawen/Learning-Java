/**
 * @author Liu Awen
 * @create 2018-05-11 13:25
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
*/
class Test02_Find{
    public static void main(String[] args){
        int[] arr = {1,4,5,7,9};

        //在arr的数组中，查找2的下标，或者判断2在数组中是否存在
        int value = 2;
        int index = -1;//因为正常的下标，没有-1,正常不是-1.
        for(int i=0; i<arr.length; i++){
            if(arr[i] == value){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println(value+"不存在");
        }else{
            System.out.println(value+"在数组中的下标是：" + index);
        }

    }
}