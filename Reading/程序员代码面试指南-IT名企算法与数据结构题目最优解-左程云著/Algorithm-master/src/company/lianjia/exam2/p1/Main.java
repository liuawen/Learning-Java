package company.lianjia.exam2.p1;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()) {
            int[] before=new int[3];
            int[] after=new int[3];

            for(int i=0;i<3;i++){
                before[i]=in.nextInt();
            }
            for(int i=0;i<3;i++){
                after[i]=in.nextInt();
            }
            for(int i=0;i<2;i++){
                if(before[i]>after[i]){
                    before[i+1]+=(before[i]-after[i])*9;
                    before[i]-=(before[i]-after[i]);
                }
            }
            for(int i=1;i>=0;i--){
                if(before[i]<after[i]){
                    before[i+1]-=(after[i]-before[i])*11;
                    before[i]+=(after[i]-before[i]);
                }
            }
            boolean res=true;
            for(int i=0;i<3;i++){
                if(after[i]!=before[i]){
                    res=false;
                    break;
                }
            }

        }
    }
}
