package nowCoderClass1.sorted;

/**
 * Created by Dell on 2017-05-06.
 */
public class ThreeColor {
    /**
     * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
     给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
     * @param A
     * @param n
     * @return
     */
    public int[] sortThreeColor(int[] A, int n) {
        //左边为0区，右边为2区
        int zero=0;
        int two=n-1;
        //从左往右扫描，遇到左区0就交换
        int index=0;
        while(index<=two){
            switch(A[index]){
                case 0: swap(A,index,zero);
                    index++;
                    zero++;break;
                case 2:swap(A,index,two); //遇到右区2就交换，交换之后继续判断此位置，因为此位置的值未知，可能是0或2等
                    two--;
                    break;
                case 1:index++;break;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp=A[j];
        A[j]=A[i];
        A[i]=temp;
    }



}
