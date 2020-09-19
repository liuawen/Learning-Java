package company.nowCoder2017.didi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Dell on 2017-09-09.
 */
public class Maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[][] maze=new int[n][m];
        int[][] dp=new int[n][m];
        for(int i = 0; i < n; i++){
            for (int j=0;j<m;j++) {
                maze[i][j] = sc.nextInt();
                dp[i][j]=Integer.MAX_VALUE;
            }
        }


        get(maze,dp);
        System.out.println();
    }
    //dp存放消耗的最小体力,如何防止往回走
    private static void get(int[][] maze, int[][] dp) {
        LinkedList<Point> queue=new LinkedList<Point>();
        queue.add(new Point(0,0));
        Point cur=null;

        while (!queue.isEmpty()){
            cur=queue.poll();//当前位置
            //上
            if(maze[cur.x-1][cur.y]==1&&isVaild(maze,cur.x-1,cur.y)){

            }
            //下

            //左

            //右

        }

    }
    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static boolean isVaild(int[][] maze, int i, int j){
        if(i>=0&&i<maze.length&&j>=0&&j<maze[0].length){
            return true;
        }
        return false;
    }



}
