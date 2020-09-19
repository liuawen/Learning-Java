/**
 * Created by Dell on 2017-06-12.
 */
public class GetUglyNum {
    public int GetUglyNumber_Solution(int index) {
        if(index<7) return index;
        int[] res=new int[index];
        res[0]=1;
        int t2=0,t3=0,t5=0,i;
        for(i=1;i<index;++i){
            res[i]=Math.min(res[t2]*2,Math.min(res[t3]*3,res[t5]*5));
            if(res[i]==res[t2]*2)   t2++;
            if(res[i]==res[t3]*3)   t3++;
            if(res[i]==res[t5]*5)   t5++;
        }
        return res[index-1];
    }
}
