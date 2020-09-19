package bitOperator;

/**
 * Created by Dell on 2017-06-20.
 */
public class FindTwoLonely {
    /**
     * 思路是得到异或结果，在结果中寻找为1的下标K，再和该位下标为1的异或，最后结果就是其中一个，
     * 利用n异或0为n，n异或n为0，具有结合律和交换律
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int n=0;
        for(int i=0;i<array.length;i++){
            n=n^array[i];
        }
        int k=1,temp=n;
        while((temp&1)==0){
            temp=temp>>1;
            k=k<<1;
        }
        int n1=0;
        for(int i=0;i<array.length;i++){
            if((array[i]&k)==k){
                n1^=array[i];
            }
        }
        num1[0]=n1;
        num2[0]=n^n1;
    }
}
