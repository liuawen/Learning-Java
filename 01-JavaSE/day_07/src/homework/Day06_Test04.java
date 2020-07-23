package homework;

/**
 * @author Liu Awen
 * @create 2020-05-16 8:34
 */
/*
杨辉三角
*/
class Day06_Test04{
    public static void main(String[] args){
        //(1)先确定行数
        int[][] yanghui = new int[10][];//yangHui

        //(2)再确定每一行的列数
        //第一行有 1 个元素, 第 n 行有 n 个元素
        for(int i=0; i<yanghui.length; i++){
            yanghui[i] = new int[i+1];
        }

        //(3)再确定元素
        for(int i=0; i<yanghui.length; i++){
            //每一行的第一个和最后一个元素都是1
            yanghui[i][0] = 1;
//            yanghui[i][yanghui[i].length-1]=1;//通用的
            yanghui[i][i] = 1;

            //中间的元素
            for(int j=1; j<yanghui[i].length-1; j++){
                yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
            }

        }

        //(4)打印显示
        for(int i=0; i<yanghui.length; i++){
            for(int j=0; j<yanghui[i].length; j++){
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }
    }
}