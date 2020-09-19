package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Dell on 2017-06-12.
 */
public class MinDirectionOrder {
    public String findSmallestOrder(String[] str,int n){
        if(n==0)
            return "";
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String res="";
        for(int i=0;i<n;i++){
            res+=str[i];
        }
        return res;
    }

}
