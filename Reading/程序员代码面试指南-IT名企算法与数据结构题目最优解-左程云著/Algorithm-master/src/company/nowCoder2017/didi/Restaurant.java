package company.nowCoder2017.didi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 优先级队列，multiset
 *  //数据量较大,超时，70%
 *  //优化,查找桌子时用二分法或者使用别的数据结构
 * Created by Dell on 2017-09-09.
 */
public class Restaurant {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] tablesCap=new int[n];
        for(int i=0;i<n;i++){
            tablesCap[i]=sc.nextInt();
        }
        Arrays.sort(tablesCap);
        PriorityQueue<Costom> queue=new PriorityQueue<Costom>();
        int num=0,money=0;//顾客排序换成使用优先级队列，并过滤掉超过最大人数的组，效率提升不会很明显吧
        for(int i=0;i<m;i++){
            num=sc.nextInt();money=sc.nextInt();
            if(num<=tablesCap[n-1]){
                queue.add(new Costom(num,money));
            }
        }

        System.out.println(choose(tablesCap,queue));
    }
    static class Costom implements Comparable<Costom>{
        int num;
        int money;
        public Costom(int num, int money) {
            this.num = num;
            this.money = money;
        }
        @Override
        public int compareTo(Costom o) {
            return Integer.compare(o.money,this.money);
        }
    }
    public static long choose(int[] tablesCap,PriorityQueue<Costom> queue){
        long money=0;
        int usedNum=0;
        boolean[] used=new boolean[tablesCap.length];//没有用0，用1
        Costom cs=null;
        while(!queue.isEmpty()){//依次选择顾客
            cs=queue.poll();
//            int j=search(tablesCap,cs.num,0,tablesCap.length-1);
            int j=0;//改二分法失败了
            while(j<tablesCap.length&&!used[j]){j++;}
            if(j<tablesCap.length) {
                used[j] = true;
                money += cs.money;
                usedNum++;
            }
            if(usedNum==tablesCap.length){
                break;
            }
        }
        return money;
    }


    //找到target相等的第一个位置，如果没有相等的位置，返回比target大的
//    public static int search(int[] tableCap,int target,int begin,int end){
//        if(begin<end){
//            int mid=(begin+end)/2;
//            if(tableCap[mid]<target){
//                return search(tableCap,target,mid+1,end);
//            }else if(tableCap[mid]>target){
//                return search(tableCap,target,begin,mid-1);
//            }else{
//                int i=0;
//                for( i=mid;i>0;i--){
//                    if(tableCap[i]!=tableCap[mid]){
//                        mid=i+1;
//                        break;
//                    }
//                }
//                if(i==-1){
//                    mid=0;
//                }
//                return mid;
//            }
//        }else{
//            //可能从右半区逼近，左半区逼近,target=6,begin=5,begin=7,,,,
//            while(begin<tableCap.length&&tableCap[begin]<=target){
//                begin++;
//            }
//            return begin;
//        }
//    }
}
