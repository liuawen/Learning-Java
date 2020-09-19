package nowCoderClass1.section14.tree;

/**
 * Created by Dell on 2017-06-20.
 */
public class FoldPaper {
    public String[] foldPaper(int n) {
        //先根据n计算出折痕的数量
        if(n==0)
            return null;
        int count=(int)Math.pow(2,n)-1;
        String[] strs=new String[count];
        strs[count/2]="down";
        return strs;
    }
}
