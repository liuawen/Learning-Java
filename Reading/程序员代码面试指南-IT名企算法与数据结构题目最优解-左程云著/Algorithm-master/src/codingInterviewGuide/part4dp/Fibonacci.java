package codingInterviewGuide.part4dp;

/**
 * 斐波那契数列，前两项为1，后面每一项是前两项的和
 * 引申问题：跳台阶、母牛问题
 * Created by Dell on 2017-08-06.
 */
public class Fibonacci {

    //斐波那契有O(2^N)/O(N)/O(log(N))

    /**
     * F(n)=F(n-1)+F(n-2)   是二阶递推数列，可以用矩阵乘法表示，状态矩阵为2*2
     * （F(n),F(n-1)）=(F(n-1),F(n-2))*状态矩阵
     * 状态矩阵可以带两组数据，求出，a,b,c为1，d为0
     * 可以推出，当n>2时，F(n),F(n-1)=(1,1,)*状态矩阵
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n<=2){
            return 1;
        }
        int[][] rec={{1,1},{1,0}};
        int[][] res=recPower(rec,n-2);
        return res[0][0]+res[1][0];
    }

    private int[][] recPower(int[][] res,int i) {//奇数还是偶数
        if(i==1){
            return res;
        }
        if(i==2){//控制i不能到达0
            return multiply(res,res);
        }
        int[][] temp=recPower(res,i>>1);//折半
        temp=multiply(temp,temp);
        if((i&1)==1){//说明i是奇数
            return multiply(res,temp);
        }else{//说明i是偶数
            return temp;
        }
    }

    /**
     *  第一个矩阵的行*第二个矩阵的列，结果相加
     */
    public int[][] multiply(int[][] a,int[][] b){
        int[][] res=new int[a.length][a.length];
        int temp=0;
        //i,j控制res矩阵结果要存放的位置，i，j结果来自a的i行，b的j列
        for (int i = 0; i < a.length; i++) {//控制b矩阵的列
            for (int j = 0; j < a.length; j++) {//控制b矩阵的行
                //计算两矩阵相乘
                for(int z=0;z<a.length;z++){
                    temp+=a[i][z]*b[z][j];
                }
                res[i][j]=temp;
                temp=0;
            }
        }
        return res;
    }

    //N表示当前的年
    /**pre代表去年，cur当年,
     * mature[cur]=mature[pre]+babies[cur-3]
     * babies[cur]=mature[cur]
     * cows[cur]+=mature[cur]
     */
    public int getCowNum(int N){
        if(N<=3){
            return N;
        }
        int[][] rec={{1,1,0},{0,0,1},{1,0,0}};
        int[][] res=recPower(rec,N-3);
        return res[0][0]+res[1][0]+res[2][0];
    }

    public static void main(String[] args){
        int res=new Fibonacci().Fibonacci(9);
        System.out.println(res);
    }
}
