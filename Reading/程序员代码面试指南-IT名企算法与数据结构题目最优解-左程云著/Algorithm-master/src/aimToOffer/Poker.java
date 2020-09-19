import java.util.Arrays;

/**
 * Created by Dell on 2017-06-20.
 */
public class Poker {
    /**
     * 判断是否是顺子
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers.length<1){
            return false;
        }
        Arrays.sort(numbers);
        int index=0,zero=0;
        while(index<numbers.length&&numbers[index]==0){
            index++;zero++;
        }
        if(zero>4)
            return false;//扑克牌只有四张大小王
        index++;
        int distance=0;
        while(index<numbers.length){//检验对子
            distance=numbers[index]-numbers[index-1]-1;
            if(distance==-1){
                return false;
            }
            if(distance<=zero){
                zero-=distance;
            }else{
                return false;
            }
            index++;
        }
        return true;
    }
}
