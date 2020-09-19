package part12dp;

/**
 * 有数组penny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * Created by Dell on 2017-07-29.
 */
public class ExchangeVoilence {

    public int countWays(int[] penny, int n, int aim) {
        return voilence(penny,0,3);
    }
    //使用从index开始的货币组成
    public int voilence(int[] penny,int index,int aim){
        int count=0;
        if(aim==0){
            count++;
        }else{
            if(index<penny.length){
                for(int i=0;i<=aim/penny[index];i++){//使用index类型的货币，可以有0-aim/penny[index]种
                    count+=voilence(penny,index+1,aim-penny[index]*i);//使用i个index类型货币，剩下的货币要组成的钱数
                }
            }
        }
        return count;
    }


}
