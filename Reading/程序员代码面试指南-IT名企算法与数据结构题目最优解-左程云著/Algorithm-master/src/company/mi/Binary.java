package mi;

/**
 * Created by Dell on 2017-06-24.
 */
public class Binary {
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public int countBitDiff(int m, int n) {
        //用异或
        String diff = Integer.toBinaryString(m^n);

        int count = 0;
        for(int i = 0; i <diff.length() ; i++){
            if(diff.charAt(i) == '1'){
                count++;
            }
        }
        return count;





    }
}
