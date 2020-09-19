package nowCoderClass1.sorted;

/**
 * Created by Dell on 2017-05-04.
 */
public class RadixSort {
    /**
     * 如果输入的数是两位数，如何保证程序正常运行
     * 基数排序，最大为2000，对整数排序，需要0-9，十个桶，从个位开始依次倒入桶中，直到千位。再依次从桶中取出，即为有序
     * @param A
     * @param n
     * @return
     */
    public int[] radixSort(int[] A, int n) {
        //准备桶等
        int[][] radix=new int[10][n];//创建十个桶,n表示每个桶能存放的个数
        int[] count=new int[10];//count计数，表示每个桶内存放的个数

        //从个位到千位，取出并放入相应的桶，再取出，存放入A数组中
        for(int i=3;i>=0;i--){//四位数，需要循环四次
            //遍历数组中的每一个数
            for(int j=0;j<A.length;j++){
                //取出对应位上的整数,放入桶中，并将计数的+1
                String temp=String.valueOf(A[j]);
                if(temp.length()!=4){
                    temp="0000"+temp;
                    temp=temp.substring(temp.length()-4);
                }
                int place=Character.digit(temp.charAt(i),10);
                radix[place][count[place]++]=A[j];
            }
            //将桶中的每一个数取出
            int index=0;//记录桶中取出的数将要存放的位置
            for(int j=0;j<radix.length;j++){//每一个桶
                for(int k=0;k<count[j];k++){//每个桶中的元素
                    A[index++]=radix[j][k];
                }
            }
            //将桶的计数清0
            for(int k=0;k<count.length;k++){//每个桶中的元素
                count[k]=0;
            }
        }
        return A;
    }
}
