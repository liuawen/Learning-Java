package nowCoderClass1.sorted;

/**

 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。

 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。

 * Created by Dell on 2017-05-06.
 */
public class Merge {
    /**
     * 应该从后往前进行覆盖，就可保证不会有元素丢失，而且不开辟额外的空间
     * @param A
     * @param B
     * @param n
     * @param m
     * @return
     */
    public int[] mergeAB(int[] A, int[] B, int n, int m) {









        return A;
    }
//    public int[] mergeAB(int[] A, int[] B, int n, int m) {
//        //首先将A中n个数存放在一个数组中，
//        int[] a=new int[n];
//        for(int i=0;i<n;i++){
//            a[i]=A[i];
//        }
//        //用两个整数来记录正在比较的位置,用一个整数记录A中已经合并的位置
//        int an=0,bm=0,Alength=0;
//        //依次复制，直到有一个数组合并完
//        while(an<n&&bm<m){
//            if(a[an]<B[bm]){
//                A[Alength]=a[an];
//                an++;
//                Alength++;
//            }else{
//                A[Alength]=B[bm];
//                bm++;
//                Alength++;
//            }
//        }
//        //将另一个数组剩余的合并到B中
//        if(an<n){
//            for(;an<n;an++){
//                A[Alength]=a[an];
//                Alength++;
//            }
//        }
//        if(bm<m){
//            for(;bm<m;bm++){
//                A[Alength]=B[bm];
//                Alength++;
//            }
//        }
//        return A;
//    }
}
