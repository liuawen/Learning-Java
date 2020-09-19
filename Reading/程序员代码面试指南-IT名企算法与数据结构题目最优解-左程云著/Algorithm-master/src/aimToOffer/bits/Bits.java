package bits;

/**
 * Created by Dell on 2017-06-09.
 */
public class Bits {
    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    // -1的二进制     11111111111111111111111111111111
    // -16的二进制    11111111111111111111111111110000
//    public int NumberOf1(int n) {
//        int count = 0;
//        while (n != 0) {
//            ++count;
//            n = (n - 1) & n;//n每次-1再与就会将每次最右边的1与为0，其他位置不变。如果是负数，结果为0时，计数会结束
//        }
//        return count;
//    }

    /**
     * 考虑的特殊情况有base为0，exponent为0，exponent为负数
     * base的0为小数，有精确度，直接和0比较不相等
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if(base==0){
            return base;
        }
        if(exponent==0){
            return 1;
        }
//        boolean isNegative=false;//默认不是负数
//        if(exponent<0){
//            isNegative=true;
//            exponent=Math.abs(exponent);
//        }
        return Math.pow(base,exponent);

    }


}
