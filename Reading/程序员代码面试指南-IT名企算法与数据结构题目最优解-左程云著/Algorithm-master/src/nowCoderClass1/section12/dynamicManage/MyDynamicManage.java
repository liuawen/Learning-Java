package nowCoderClass1.section12.dynamicManage;

/**
 * Created by Dell on 2017-06-04.
 */
public class MyDynamicManage {
    /**
     * 动态规划的暴力搜索
     * @param arr 存放钱的种类
     * @param aim  要找零的总数
     */
    public int violence(int[] arr,int aim){
        if(arr==null||arr.length==0||aim==0){
            return 0;
        }
        return violenceSolution(arr,0,aim);
    }

    /**
     * 使用暴力搜索的办法去解决，递归，从下标0的钱币使用不同的数量构成的种类+其他钱币构成的种类
     * @param arr 钱币的面值
     * @param index 当前要统计的初始下标
     * @param aim   还要找零的钱数
     * @return  使用index之后的面值的钱币构成的钱数
     */
    private int violenceSolution(int[] arr,int index, int aim) {
        int res=0;
        //保证找零的钱币不会超出aim,通过for的条件限制找零的数量，但是如何计数，需要判断最后的aim是否等于0
        //限制下标不要越界，注意不要无限递归下去
        if(index==arr.length){
            res=aim==0?1:0;//每种方法的计数都会到这里，如果钱正好找完，方法数加1，如果还有剩余的钱，则此次结果为0
        }else{
            for(int i=0;i*arr[index]<=aim;i++){//条件是使用该货币的数量从0至最大
                res+=violenceSolution(arr,index+1,aim-i*arr[index]);
            }
        }
        return res;
    }

    /**
     * 使用记忆搜索法,记忆的key是 index，aim
     */
    public int memorySearch(int[] arr,int aim){
        if(arr==null||arr.length==0||aim==0){
            return 0;
        }
        int[][] map=new int[arr.length+1][aim+1];
        return memorySolution(arr,0,aim,map);
    }

    private int memorySolution(int[] arr, int index, int aim, int[][] map) {
        int res=0;
        //保证找零的钱币不会超出aim,通过for的条件限制找零的数量，但是如何计数，需要判断最后的aim是否等于0
        //限制下标不要越界，注意不要无限递归下去
        if(index==arr.length){
            res=aim==0?1:0;//每种方法的计数都会到这里，如果钱正好找完，方法数加1，如果还有剩余的钱，则此次结果为0
        }else{
            for(int i=0;i*arr[index]<=aim;i++){//条件是使用该货币的数量从0至最大
                int current=aim-i*arr[index];//存放未找零的钱数
                int value=map[index+1][current];
                if(value==0){//没计算过
                    res+=violenceSolution(arr,index+1,current);
                }else{
                    res+=value==-1?0:value;
                }
            }
        }
        //维护本次搜索的值到map
        map[index][aim]=res==0?-1:res;
        return res;
    }
    /**
     * 动态规划是利用矩阵，按顺序去计算出最终的结果
     * 矩阵的行是钱币的种类，列是钱的数量。从0至aim
     * i和j的值的含义是使用arr[0...i]货币，组成钱数j的方法数
     * 很容易能确定第一行的对应的钱数的种类，那i，j对应的位置上的
     */
    public int dynamicOne(int[] arr,int aim){
        if(arr==null||arr.length==0||aim==0){
            return 0;
        }
        int[][] dp=new int[arr.length][aim+1];
        //先将第一列的值初始化为1
        for(int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }
        //依次求得每一行的值
        for(int i=0;i<arr.length;i++){
            dynamicOne(arr,i,aim,dp);
            for(int j=0;j<=aim;j++){
                System.out.print("   "+dp[i][j]);
            }
            System.out.println();
        }
        return dp[arr.length-1][aim];
    }
    private void dynamicOne(int[] arr, int row, int aim, int[][] dp) {
        //从第0行开始
        if(row==0){//第0行
            for(int i=1;i*arr[row]<=aim;i++)
            {
                int currentMoney=i*arr[row];
                dp[row][currentMoney]=1;
            }
        }else{//第1 - r-1行
            //arr[i]货币的数量从0 - 最多的数量
            //根据i-1，钱数去找对应的种数
            for(int j=1;j<=aim;j++){//依次求解i，j对应的位置上的值
                //使用aim[j]不同的数量统计
                int type=0;//要不停的进行累加，所以此处可以化简dp[i][j]=dp[row][j-arr[row]]+dp[row-1][j]
                for(int num=0;num*arr[row]<=j;num++){//num代表使用arr[row]的钱币数量
                    type+=dp[row-1][j-num*arr[row]];
                }
                //统计结束，赋值
                dp[row][j]=type;
            }
        }
    }
    public int dynamicTwo(int[] arr,int aim){
        if(arr==null||arr.length==0||aim==0){
            return 0;
        }
        int[][] dp=new int[arr.length][aim+1];
        //先将第一列的值初始化为1
        for(int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }
        //依次求得每一行的值
        for(int i=0;i<arr.length;i++){
            dynamicTwo(arr,i,aim,dp);
            for(int j=0;j<=aim;j++){
                System.out.print("   "+dp[i][j]);
            }
            System.out.println();
        }
        return dp[arr.length-1][aim];
    }
    private void dynamicTwo(int[] arr, int row, int aim, int[][] dp) {
        //从第0行开始
        if(row==0){//第0行
            for(int i=1;i*arr[row]<=aim;i++)
            {
                int currentMoney=i*arr[row];
                dp[row][currentMoney]=1;
            }
        }else{//第1 - r-1行
            //arr[i]货币的数量从0 - 最多的数量
            //根据i-1，钱数去找对应的种数
            for(int j=1;j<=aim;j++){//依次求解i，j对应的位置上的值
                //此处可以化简dp[i][j]=dp[row][j-arr[row]]+dp[row-1][j]
                if(j<arr[row]){
                    dp[row][j]=dp[row-1][j];
                }else{
                    dp[row][j]=dp[row][j-arr[row]]+dp[row-1][j];
                }
            }
        }
    }

}
