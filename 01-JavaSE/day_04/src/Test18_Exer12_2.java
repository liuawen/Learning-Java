/**
 * @author Liu Awen
 * @create 2018-05-08 22:44
 */
//12、找出1-100之间所有的素数（质数）
class Test18_Exer12_2{
    public static void main(String[] args){
        //找出1-100之间所有的素数（质数）
        //1-100之间
        for(int i=1; i<=100; i++){
            //里面的代码会运行100遍
            //每一遍i的值是不同的，i=1,2,3,4,5...100
            //每一遍都要判断i是否是素数，如果是，就打印i
			/*
			如何判断i是否是素数
			（1）找出i在[2,i-1]之间的约数的个数
			（2）如果这个个数是0，那么i就是素数
			*/
            int iCount = 0;
            for(int j=2; j<i; j++){
                if(i%j==0){//j是i在[2,i-1]之间的约数
                    iCount++;
                }
            }

            //（2）如果这个个数是0，那么i就是素数
            if(iCount == 0){
                System.out.println(i);
            }
        }
    }
}