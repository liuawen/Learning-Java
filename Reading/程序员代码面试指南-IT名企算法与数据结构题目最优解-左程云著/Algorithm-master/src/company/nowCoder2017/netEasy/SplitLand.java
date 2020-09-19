package company.nowCoder2017.netEasy;

import java.util.Scanner;

/**
 * 网易 分田地
 * Created by Dell on 2017-09-03.
 */
public class SplitLand {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr=new int[n][m];
        sc.nextLine();
        for(int i = 0; i < n; i++){
            String str=sc.nextLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        System.out.println(splitLand(arr));
    }

    public static int splitLand(int[][] arr){
        return 0;
    }
    //将土地矩阵求和，减少计算量
    public static int splitLand1(int[][] arr){
        //处理下矩阵,第一行，第一列
//        for(int i=1;i<arr.length;i++){
//            arr[0][i]+=arr[0][i-1];
//        }
//        for(int j=1;j<arr[0].length;j++){
//            arr[j][0]+=arr[j-1][0];
//        }
//        for(int i=1;i<arr.length;i++){
//            for(int j=1;j<arr[0].length;j++){
//                arr[i][j]+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
//            }
//        }
        int res=Integer.MIN_VALUE;
        int[] row={1,1,1,};//前三个数字是切割的刀数，第四个数字是为了统计16块土地的面积设计的
        //每次分割的开始位置
        for(int i=2;i>=0&&row[i]<=arr.length-(3-i)-1;){//行
            int[] col={1,2,3,arr[0].length};
            for( int j=2;j>=0&&col[j]<=arr[0].length-1-(3-j);){//列
                //输出
                for(int x=0;x<row.length-1;x++){
                    System.out.print(col[x]+"    ");
                }
                System.out.print("           ");
                for(int y=0;y<col.length-1;y++){
                    System.out.print(col[y]+"    ");
                }
                System.out.println();


                //分割好了，找出最小的一块地的坐标，将最小的坐标在res中，res的更新策略是res与最小的中，较大的一个
//               int min=arr[row[0]-1][col[0]-1];//遍历每块土地的方法
//                //第一行，列为col不变
//                for(int y=1;y<col.length;y++){
//                    min=Math.min(arr[row[0]-1][col[y]-1]-arr[row[0]-1][col[y-1]-1],min);
//                }
//                //第一列
//                for(int x=1;x<col.length;x++){
//                    min=Math.min(arr[row[x]-1][col[0]-1]-arr[row[x-1]-1][col[0]-1],min);
//                }
//
//               for(int x=1;x<row.length;x++){
//                   for(int y=1;y<col.length;y++){
//                       min=Math.min(arr[row[x]-1][col[y]-1]-arr[row[x]-1][col[y-1]-1]-arr[row[x-1]-1][col[y]-1]+arr[row[x-1]-1][col[y-1]-1],min);
//                   }
//               }
//                res=Math.max(res,min);
                //这是一种切分方式，
                if(col[j]==arr[0].length-(3-j)-1){
                    j--;
                }
                if(j>=0){col[j]++;}
            }
            if(row[i]==arr.length-(3-i)-1){
                i--;
            }
            if(i>=0){row[i]++;}
        }
        return res;
    }
}
