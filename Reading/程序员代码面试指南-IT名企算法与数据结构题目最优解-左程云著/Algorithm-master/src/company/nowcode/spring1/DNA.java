package company.nowcode.spring1;

import java.util.Scanner;

/**
 * DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。碱基互补配对原则：A和T是配对的，C和G是配对的。如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，
 * 允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
 * Created by Dell on 2017-09-23.
 */
public class DNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs=sc.nextLine().split(" ");
        char[] one=strs[0].toCharArray();
        char[] two=strs[1].toCharArray();
        int count=0;
        for(int i=0;i<one.length;i++){
            if(one[i]=='A'){
                if(two[i]!='T')
                    count++;
                    continue;
            }
            if(one[i]=='T'){
                if(two[i]!='A')
                    count++;
                    continue;
            }
            if(one[i]=='C'){
                if(two[i]!='G')
                    count++;
                    continue;
            }
            if(one[i]=='G'){
                if(two[i]=='C')
                    count++;
                    continue;
            }
        }
        System.out.println(count);
    }
}
