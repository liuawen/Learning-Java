/**
 * @author Liu Awen
 * @create 2018-05-10 22:10
 */
public class Test01_Review{
    public static void main(String[] args){
        //推荐
        int[] arr1;//在Java中int[]是一种引用数据类型，是数组类型
        //也对，但是不推荐
        int arr2[];
        //最早的时候，C语言不提对象的概念，所以没有把int[]看成一种数据类型，
        //只是强调一组数，而最重要的是这组数据的类型是int类型

        //int[] arr = new int[5]{1,2,3,4,5};//错误的

        int[] arr = new int[5];
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(System.identityHashCode(arr));

        int[] arr3 = new int[5];
//        arr3 = new int[5]{1, 2, 3, 4, 5};//错误的
        arr3 = new int[]{1, 2, 3, 4, 5};
        System.out.println(System.identityHashCode(arr3));

        int[] arr4 = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr4.length ; i++) {
            System.out.println(arr4[i]);
        }
    }
}