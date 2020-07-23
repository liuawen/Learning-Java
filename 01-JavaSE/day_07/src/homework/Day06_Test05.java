package homework;

/**
 * @author Liu Awen
 * @create 2020-05-16 8:34
 */
class Day06_Test05{
    public static void main(String[] args){
        //1、声明一个二维数组，并确定长度
        String[][] arr = new String[2][];

        //2、确定第一行的列数，第一行存储花色
        arr[0] = new String[4];

        //3、确定第二行的列数，第二行存储点数
        arr[1] = new String[13];

        //4、把花色和点数放进去
        //花色
        arr[0][0] = "黑桃";
        arr[0][1] = "红桃";
        arr[0][2] = "梅花";
        arr[0][3] = "方片";

        //点数
        arr[1][0] = "A";
        for(int i=1; i<=9; i++){//表示第二行部分下标
            arr[1][i] = i+1+"";
        }
        arr[1][10] = "J";
        arr[1][11] = "Q";
        arr[1][12] = "K";

        //5、显示
        for(int i=0; i<arr[0].length; i++){//外循环循环花色
            for(int j=0; j<arr[1].length; j++){//内循环循环点数
                //arr[0][?]是花色
                //arr[1][?]是点数
                System.out.print(arr[0][i] + arr[1][j] + " ");
            }
            System.out.println();
        }
    }
}