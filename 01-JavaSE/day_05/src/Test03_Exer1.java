/**
 * @author Liu Awen
 * @create 2018-05-09 22:42
 */
/*
1、数组的练习1：
	用一个数组，随意保存5个奇数，并且遍历显示
*/
class Test03_Exer1{
    public static void main(String[] args){
        //用一个数组，随意保存5个奇数，
        int[] array = {1,3,5,7,9};
        //遍历显示
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = 2*i - 1;
        }

        //遍历显示
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
        //Result
        //1
        //3
        //5
        //7
        //9
        //-1
        //1
        //3
        //5
        //7

    }
}