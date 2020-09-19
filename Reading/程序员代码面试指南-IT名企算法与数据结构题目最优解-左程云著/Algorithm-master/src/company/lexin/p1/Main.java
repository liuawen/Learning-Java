package company.lexin.p1;

import java.util.*;

/**
 * Created by Dell on 2017-09-23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split("-");
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(String s:strs){
            int value=Integer.valueOf(s);
            map.put(value,map.get(value)==null?1:map.get(value)+1);
        }
        Pair[] pairs=new Pair[map.size()];int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pairs[count++]=new Pair(entry.getValue(),entry.getKey());
        }
        Arrays.sort(pairs,Pair.getComparator());
        for(int i=map.size()-1;i>0;i--){
            System.out.print(pairs[i].getNum()+"-"+pairs[i].getTime()+" ");
        }
        System.out.println(pairs[0].getNum()+"-"+pairs[0].getTime());
    }
    public static class Pair{
        int time;
        int num;

        public Pair(int time, int num) {
            this.time = time;
            this.num = num;
        }
        public static Comparator<Pair> getComparator(){
            return new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.getTime()!=o2.getTime()){
                        return Integer.compare(o1.getTime(),o2.getTime());
                    }else{
                        return Integer.compare(o1.getNum(),o2.getNum());
                    }
                }
            };
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
