/**
 * @author Liu Awen
 * @create 2018-05-08 16:05
 */
/*
8、打印1-100之间数，其中3、5、7的倍数不打印
*/
class Test13_Exer8{
    public static void main(String[] args){
		/*
		不使用continue
		*/
        for(int i=1; i<=100; i++){
            //其中3、5、7的倍数不打印
            //如果这个数不是3，5,7的倍数就打印
            //这还有争议吗  什么的打印
            if(i%3!=0 && i%5!=0 && i%7!=0){
                System.out.println(i);
            }
        }
        System.out.println("-----------------------");
		/*
		使用continue
		*/
        for(int i=1; i<=100; i++){
            //其中3、5、7的倍数不打印
            //如果是3,5,7的倍数就跳过打印语句
            if(i%3==0 || i%5==0 || i%7==0){
                //break;//如果用break，那么只打印1和2
                continue;
            }
            System.out.println(i);
        }
    }
}
