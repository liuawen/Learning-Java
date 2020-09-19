package mi;

/**
 * Created by Dell on 2017-06-24.
 */
public class Stock {

    /**
     * 实际上，在每一个循环里面，即只考虑前 i 天的话，
     firstBuy表示必须做出且只能做出【买一次】行为的最大收益，而和后面买卖几次无关；
     firstSell表示必须做出且只能做出 【买一次，卖一次】行为的最大收益，
     secondBuy表示必须做出且只能做出【买一次，卖一次，再买一次】行为的最大收益，
     secondSell表示必须做出且只能做出【买一次，卖一次，再买一次，再卖一次】行为的最大收益。
     所以firstBuy, firstSell,secondBuy, secondSell 都只受到它的前面一个变量和当前price的影响，即firstBuy只受当前price影响，firstSell只受到firstBuy和当前price影响。
     * @param prices
     * @return
     */
    public int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {

            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
    }
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax1(int[] prices) {
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        //求以i结尾的情况下收益最大值
        int min=prices[0];int max=0;
        for(int i=0;i<prices.length;i++){
            max=Math.max(prices[i]-min,max);
            left[i]=max;
            min=Math.min(prices[i],min);
        }
        //求以i开始的，收益最大值,倒着求，从简单至复杂
        max=prices[prices.length-1];min=0;
        for(int i=prices.length-1;i>=0;i--){
            min=Math.min(prices[i]-max,min);
            right[i]=-min;
            max=Math.max(max,prices[i]);
        }
        //综合两次收益，求得最大值
        int res=0;
        for(int i=0;i<prices.length-1;i++){
            res=Math.max(left[i]+right[i+1],res);
        }
        res=Math.max(left[prices.length-1],res);
        return res;
    }

}
