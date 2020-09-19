package bitOperator;

/**
 * Created by Dell on 2017-06-20.
 */
public class Sum {
    //使用位运算，计算两数的和
    public int Add(int num1,int num2) {
        int a=0,b=0;
        do{
            //1.求各位相加，不计进位
            a=num1^num2;
            //2.求进位
            b=(num1&num2)<<1;//左移一位是进位
            num1=a;num2=b;
        }while((a&b)!=0);//直到两数不产生进位
        return num1;
    }
}
