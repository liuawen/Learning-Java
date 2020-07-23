/**
 * @author Liu Awen
 * @create 2018-05-08 22:45
 */
//12、找出1-100之间所有的素数（质数）
class Test18_Exer12_3{
    public static void main(String[] args){
        //找出1-100之间所有的素数（质数）
        //1-100之间
        for(int i=1; i<=100; i++){
            //里面的代码会运行100遍
            //每一遍i的值是不同的，i=1,2,3,4,5...100
            //每一遍都要判断i是否是素数，如果是，就打印i
			/*
			如何判断i是否是素数
			（1）假设i是素数
			boolean flag = true;//true代表素数
			（2）找i不是素数的证据
			如果在[2,i-1]之间只要有一个数能够把i整除了，说明i就不是素数
			修改flag = false;
			（3）判断这个flag
			*/

            //（1）假设i是素数
            boolean flag = true;//true代表素数
            //（2）找i不是素数的证据
            for(int j=2; j<i; j++){
                if(i%j==0){
                    flag = false;//找到一个就可以了
                    break;
                }
            }
            //（3）判断这个flag
            if(flag){
                System.out.println(i);
            }
        }
    }
}
