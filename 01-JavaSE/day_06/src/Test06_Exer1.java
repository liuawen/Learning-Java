/**
 * @author Liu Awen
 * @create 2020-05-15 20:58
 */
/*
 1
 2 2
 3 3 3
 4 4 4 4
 5 5 5 5 5
*/
//遍历二维数组  arr.length 换行的
class Test06_Exer1{
    public static void main(String[] args){
        int[][] arr = {{1},{2,2},{3,3,3},{4,4,4,4},{5,5,5,5,5}};

        //遍历二维数组的arr.length行的数据
        for(int i=0; i<arr.length; i++){
            //每一行
            //(1)先打印arr[i]行的几个元素
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            //(2)换行
            System.out.println();
        }
    }
}