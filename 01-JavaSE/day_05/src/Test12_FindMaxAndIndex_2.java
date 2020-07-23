/**
 * @author Liu Awen
 * @create 2018-05-10 19:57
 */
/*
数组的相关的算法操作：
1、在数组中找最大值/最小值
2、在数组中找最大值/最小值及其下标
*/
class Test12_FindMaxAndIndex_2{
    public static void main(String[] args){
        int[] array = {4,2,-7,8,1,9};

        //最小值及其下标
        //(1)假设第一个元素最小
        int minIndex = 0;//array[minIndex]就是最小值

        //(2)用min与后面的元素一一比较
        for(int i=1; i<array.length; i++){
            if(array[i] < array[minIndex]){
                minIndex = i;
            }
        }
        System.out.println("最小值是：" + array[minIndex]);
        System.out.println("最小值的下标是：" + minIndex);
    }
}