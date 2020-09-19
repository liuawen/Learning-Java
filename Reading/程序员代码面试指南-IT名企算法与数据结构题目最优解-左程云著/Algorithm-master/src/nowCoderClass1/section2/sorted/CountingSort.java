package nowCoderClass1.sorted;

/**
 * Created by Dell on 2017-05-04.
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        //排除特殊情况
        if(A!=null&&A.length!=1){
            int min=A[0];
            int max=A[0];
            //找出最小值和最大值，创建桶
                for(int i=1;i<A.length;i++){
                    min=A[i]<min?A[i]:min;
                    max=A[i]>max?A[i]:max;
                }
                int[] bucket=new int[max-min+1];
            //一次遍历数组A，将对应的元素放入桶中
            for(int i=0;i<A.length;i++){
                bucket[A[i]-min]++;//元素的值和min的差值是桶的下标
            }
            //将桶中的元素倒出
            int index=0;//记录倒出的元素应该存放的位置
            for(int i=0;i<bucket.length;i++){
                while(bucket[i]-->0){
                    A[index++]=i+min;
                }
            }
        }
        return A;
    }
//    public int[] countingSort(int[] A, int n) {
//        // write code here
//        if(A==null&&A.length<2){
//            return A;
//        }
//        int min = A[0];
//        int max = A[0];
//        for (int i = 1; i < n; i++) {
//            min = Math.min(A[i], min);
//            max = Math.max(A[i], max);
//        }
//        int[] countArr=new int[max-min+1];
//        for(int i = 0; i < n; i++){
//            countArr[A[i]-min]++;
//        }
//        int index=0;
//        for(int i=0;i<countArr.length;i++){
//            while(countArr[i]-->0){
//                A[index++]=i+min;
//            }
//        }
//        return A;
//    }
}
