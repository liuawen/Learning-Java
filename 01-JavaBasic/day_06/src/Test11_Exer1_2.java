/**
 * @author Liu Awen
 * @create 2020-05-15 21:23
 */
/*
 1
 2 2
 3 3 3
 4 4 4 4
 5 5 5 5 5
*/

class Test11_Exer1_2{
    public static void main(String[] args){
        //1、声明一个二维数组，并且确定行数
        //因为每一行的列数不同，这里无法直接确定列数
        int[][]  arr = new int[5][];


        for(int i=0; i<arr.length; i++){
            //2、确定每一行的列数
            arr[i] = new int[i+1];

            //3、确定元素的值
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = i+1;

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }

    }
}