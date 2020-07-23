/**
 * @author Liu Awen
 * @create 2018-05-10 19:54
 */
/*
数组的相关的算法操作：
1、在数组中找最大值/最小值
猴子找玉米  熊 ？？？
*/
class Test11_FindMax{
    public static void main(String[] args){
        int[] array = {4,2,6,8,1};

        //在数组中找最大值
        //类似于：猴子掰玉米
        //先假设第一个最大，然后与后面的元素一一比较，如果有比手上还大，就修改手上的玉米

        //(1)//先假设第一个元素最大
        int max = array[0];
        //(2)用max中的值，与后面的元素一一比较，如果有比max的值还大，就修改max的值
        //这里i=1的原因，max与[1,长度-1]的元素比较就可以了，不用再与[0]元素进行比较
        for(int i=1; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        System.out.println("最大值是：" + max);
    }
}