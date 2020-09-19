package nowCoderClass1.section12;

/**
 * 动态规划
 * Created by Dell on 2017-06-02.
 */
public class DominalManage {
    /**
     * 使用暴力破解硬币问题
     */
    public int coins1(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0){
            return 0;
        }
        return process1(arr,0,aim);
    }
    private int process1(int[] arr, int index, int aim) {
        int res=0;
        if(index==arr.length)
            res=aim==0?1:0;
        else{
            //求得下标为index的不同数量的种数
            for(int i=0;arr[index]*i<=aim;i++){
                res+=process1(arr,index+1,aim-arr[index]*i);
            }
        }
        return res;
    }
    /**
     * 使用记忆搜索方法，原理是将index，aim作为key，res作为value，将值记录下来，减少重复的计算
     */
    public int coins2(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0){
            return 0;
        }
        int[][] map=new int[arr.length+1][aim+1];//以
        return process2(arr,0,aim,map);
    }
    private int process2(int[] arr, int index, int aim,int[][] map) {
        int res=0;
        if(index==arr.length)
            res=aim==0?1:0;
        else{
            int mapValue=0;
            //求得下标为index的不同数量的种数
            for(int i=0;arr[index]*i<=aim;i++){
                mapValue=map[index+1][aim-arr[index]*i];
                if(mapValue!=0){//0代表未计算过，-1代表计算过，但是结果为0，可以减少结果为0的重复计算
                    res+=mapValue==-1?0:mapValue;
                }else{
                    res+=process2(arr,index+1,aim-arr[index]*i,map);
                }
            }
        }
        map[index][aim]=res==0?-1:res;//维护本次计算的值
        return res;
    }

}


