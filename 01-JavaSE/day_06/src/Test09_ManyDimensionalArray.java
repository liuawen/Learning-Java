/**
 * @author Liu Awen
 * @create 2020-05-15 21:15
 */
/*
二维数组的初始化：
1、静态初始化

2、动态初始化
（1）确定总行数
（2）确定每一行的列数
（3）确定元素的值

 1 1 1 1 1
 2 2 2 2 2
 3 3 3 3 3
 4 4 4 4 4

*/
class Test09_ManyDimensionalArray{
    public static void main(String[] args){
        //1、声明一个二维数组
        //int[][] arr;

        //2、动态初始化
        //(1)确定总行数
        //arr = new int[4][];
        //要确定总行数的 arr


        //如果声明和确定总行数合起来
        int[][] arr = new int[4][];

        System.out.println("总行数：" + arr.length);
        //System.out.println("arr[0]行：" + arr[0]);//null，因为此时该行的更详细的信息没有

        //(2)确定每一行的列数
        //因为arr[0]是代表一行，代表一个一维数组
        //arr[0] = new int[5];
        //System.out.println(arr[0][2]);

        //(3)确定元素的值
        //arr[0][0] = 1;
        //arr[0][1] = 1;
        //arr[0][2] = 1;
        //arr[0][3] = 1;
        //arr[0][4] = 1;

        //(2)确定每一行的列数
        for(int i=0; i<arr.length; i++){
            arr[i] = new int[5];//每一行都是5个元素
        }

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
        System.out.println();
    }
}