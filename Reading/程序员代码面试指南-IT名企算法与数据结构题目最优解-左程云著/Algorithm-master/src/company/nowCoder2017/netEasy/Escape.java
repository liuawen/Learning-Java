package company.nowCoder2017.netEasy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dell on 2017-09-03.
 */
public class Escape {
    static class Point{
        public int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr=new char[n][m];
        sc.nextLine();
        for(int i = 0; i < n; i++){
            String str=sc.nextLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        ArrayList<Point> list=new ArrayList<Point>();
        list.add(new Point(sc.nextInt(),sc.nextInt()));
        arr[list.get(0).x][list.get(0).y]='0';
        int k= sc.nextInt();
        Point[] step=new Point[k];
        for(int i=0;i<k;i++){
            step[i]=new Point(sc.nextInt(),sc.nextInt());
        }
        //调用完之后，所有可达的点都被标记，如果有。出现，输出-1，没有输出最大值
        int max=getMaxStep(arr,list,step);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j]=='.'){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);

    }
    //list中存放的是起点，可用递归的方式去找么？找一次step+1，直到list为空，返回
    private static int getMaxStep(char[][] arr, ArrayList<Point> list, Point[] step) {
        char count=(char)(arr[list.get(0).x][list.get(0).y]+1);
        ArrayList<Point> next=new ArrayList<Point>();
        for(Point p:list){
            for(Point s:step){
                if((p.x+s.x)>=0&&(p.x+s.x)<arr.length&&(p.y+s.y)>=0&&(p.y+s.y)<arr[0].length){
                    if(arr[p.x+s.x][p.y+s.y]=='.') {
                        arr[p.x + s.x][p.y + s.y] = count;
                        next.add(new Point(p.x + s.x,p.y + s.y));
                    }
                }
            }
        }
        if(next.size()==0){
            return count-'1';
        }
        return getMaxStep(arr,next,step);
    }

}
