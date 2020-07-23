/**
 * @author Liu Awen
 * @create 2018-05-08 22:51
 */
//兼容  C  goto  ？？？ 不推荐使用
class Test19_BreakContinue_2{
    public static void main(String[] args){
        //out就是标签名称，和变量名一样命名规则，规范
        //标签名后面加:
        out:for(int i=1; i<=5; i++){

            for(int j=1; j<=5; j++){
                System.out.print("*  ");
                if(i==j){//如果需要，当i==j时，结束整个的双重循环，内外循环一起结束
                    break out;
                }
            }
            System.out.println();
        }
    }
}