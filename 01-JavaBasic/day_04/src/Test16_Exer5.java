/**
 * @author Liu Awen
 * @create 2018-05-08 21:44
 */
/*
循环嵌套：

5、输出所有的水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
    例如： 153 = 1*1*1 + 5*5*5 + 3*3*3
*/
class Test16_Exer5{
    public static void main(String[] args){
        //所谓水仙花数是指一个3位数==>[100,999]
        //百位：1-9
        //十位：0-9
        //个位：0-9

		/*
		当bai=1, shi会从0变到9整个来一轮
		当shi=0,ge会从0变到9整个来一轮
		*/
        for(int bai = 1; bai<=9; bai++){
            for(int shi = 0; shi<=9; shi++){
                for(int ge = 0; ge<=9; ge++){
                    if(bai*bai*bai + shi*shi*shi + ge*ge*ge == bai*100+shi*10+ge){
                        System.out.println(bai*100+shi*10+ge);
                    }
                }
            }
        }
    }
}