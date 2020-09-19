package company.meili;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-23.
 */
public class P1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        int month=sc.nextInt();
        int day=sc.nextInt();
        int res=0;
        switch (month){
            case 2:res=31;break;
            case 3:res=59;break;
            case 4:res=90;break;
            case 5:res=120;break;
            case 6:res=151;break;
            case 7:res=181;break;
            case 8:res=212;break;
            case 9:res=243;break;
            case 10:res=273;break;
            case 11:res=304;break;
            case 12:res=334;break;
        }
        res+=day;
        if(month>2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                res+=1;
            }
        }
        System.out.println(res);
    }
}
