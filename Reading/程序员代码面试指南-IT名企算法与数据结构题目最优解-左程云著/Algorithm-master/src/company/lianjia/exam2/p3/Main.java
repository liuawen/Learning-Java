package company.lianjia.exam2.p3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()) {
            int a = in.nextInt();
            Point[] arr=new Point[a];
            for(int i=0;i<a;i++){
                arr[i]=new Point(in.nextInt(),in.nextInt());
            }
            Arrays.sort(arr,Point.getComparator());
            int count=0;
            for(int i=1;i<a;i++){
                if(arr[i-1].wei>arr[i].wei){
                    count++;
                }
            }
            System.out.println(count+1);
        }
    }
    public static class Point{
        int len;
        int wei;

        public Point(int len, int wei) {
            this.len = len;
            this.wei = wei;
        }
        public static Comparator<Point> getComparator(){
            return new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.len!=o2.len){
                        return o1.len-o2.len;
                    }
                    return o1.wei-o2.wei;
                }
            };
        }
    }
}
