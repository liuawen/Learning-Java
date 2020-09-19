package company.toutiao.p1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Point[] arr=new Point[n];
        for(int i=0;i<n;i++) {
            arr[i]=new Point(in.nextInt(),in.nextInt());
        }
        Arrays.sort(arr,Point.getComparatorX());
        for(int i=0;i<n;i++){
            arr[i].order=i;
        }
        Arrays.sort(arr,Point.getComparatorY());
        int cur=-1;
        for(int i=0;i<n;i++){
            if(i>cur){
                System.out.println(arr[i].x+" "+arr[i].y);
                cur=arr[i].order;
            }
        }
//        boolean flag=true;
//        for(int i=0;i<n;i++){
//            flag=true;
//            for(int j=i+1;j<n;j++){
//                if(arr[j].x>arr[i].x&&arr[j].y>arr[i].y){
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag){
//                System.out.println(arr[i].x+" "+arr[i].y);
//            }

    }
    public static class Point{
        int order;
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Comparator<Point> getComparatorX(){
            return new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.x!=o2.x){
                        return o1.x-o2.x;
                    }
                    return o1.y-o2.y;
                }
            };
        }
        public static Comparator<Point> getComparatorY(){
            return new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.y!=o2.y){
                        return o2.y-o1.y;
                    }
                    return o1.x-o2.x;
                }
            };
        }
    }
}
