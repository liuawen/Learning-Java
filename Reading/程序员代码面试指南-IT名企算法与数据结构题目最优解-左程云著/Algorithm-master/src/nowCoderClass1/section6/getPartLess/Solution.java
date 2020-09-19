package nowCoderClass1.section6.getPartLess;

/**
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，
 * 如果arr[0]<arr[1]，那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 * Created by Dell on 2017-05-11.
 */
public class Solution {
    /**
     * 使用二分法查找局部最小的数,是有根据的，如果两边的数不符合要求，就去看中间的数，找较小的一端去查看，一定会找到一个较小的数
     *
     * @param arr
     * @return
     */
//    public int getLessIndex(int[] arr) {
//
//    }
}
