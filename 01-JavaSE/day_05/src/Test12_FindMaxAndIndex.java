/**
 * @author Liu Awen
 * @create 2018-05-10 19:56
 */
/*
数组的相关的算法操作：
1、在数组中找最大值/最小值
2、在数组中找最大值/最小值及其下标
*/
class Test12_FindMaxAndIndex{
    public static void main(String[] args){
        int[] array = {4,2,-7,8,1,9};

        //最小值及其下标
        //(1)假设第一个元素最小
        int min = array[0];
        int index = 0;

        //(2)用min与后面的元素一一比较
        for(int i=1; i<array.length; i++){
            if(array[i] < min){
                min = array[i];
                index = i;
            }
        }
        System.out.println("最小值是：" + min);
        System.out.println("最小值的下标是：" + index);
    }
}