/**
 * @author Liu Awen
 * @create 2020-05-15 21:21
 */
/*
 1 1 1 1 1
 2 2 2 2 2
 3 3 3 3 3
 4 4 4 4 4
 */

class Test10_ManyDimensionalArray{
    public static void main(String[] args){
        //当二维数组每一行的列数是相同的

        //声明，确定行数，确定每一行的列数一起完成
        int[][] arr = new int[4][5];//共4行，每一行都是5列

        //(3)确定元素的值
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = i+1;
            }
        }

        //(4)遍历
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}