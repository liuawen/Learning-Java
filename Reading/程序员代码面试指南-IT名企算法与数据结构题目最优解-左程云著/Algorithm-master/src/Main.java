import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        flowTest();
    }
    public static void flowTest(){
        int k,v,l;
        int count = 0;
        Scanner sc=new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        if(100<=m&&n<=999){
            for(int i=m;i<=n;i++){
                k=i/100;
                v=(i%100)/10;
                l=(i%100)%10;
                if(i==((int) ((Math.pow(k, 3)+Math.pow(v, 3)+Math.pow(l, 3))))){
                    list.add(i);
                    count++;
                }
            }
            if(count == 0){
                System.out.println("no");
            }else{
                for(int i=0;i<list.size()-1;i++){
                    System.out.print(list.get(i)+" ");
                }
                System.out.println(list.get(list.size()-1));
            }
        }else{
            System.out.print("输入数据越界");
        }
    }
}