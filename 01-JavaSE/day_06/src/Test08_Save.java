/**
 * @author Liu Awen
 * @create 2020-05-15 21:03
 */
/*
看内存图
*/
class Test08_Save{
    public static void main(String[] args){
        int[][] arr = {
                {1,1,1,1,1},
                {2,2,2,2,2},
                {3,3,3,3,3},
                {4,4,4,4,4}
        };
        //这是什么呢 对象数据类型@hash码
        System.out.println(arr[0]);//下标为0的行
        //[I@15db9742
        //对象数据类型@hash码
        //[I ：代表元素是int类型的一维数组

        int[] array = {1,1,1,1,1};
        System.out.println(array);
        //[I@6d06d69c
    }
}