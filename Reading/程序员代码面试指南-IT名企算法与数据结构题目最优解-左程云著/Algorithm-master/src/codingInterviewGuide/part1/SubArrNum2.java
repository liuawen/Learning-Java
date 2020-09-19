package codingInterviewGuide.part1;

import java.util.LinkedList;

/**
 * 思路，统计以i位置开头的，以j位置结尾，j-1是i最远能到达的位置，i和j一直往前走，不回退.
 * qmax（单调递减），qmin（单调递增）    每次以i位置统计时去除以i开头的情况，避免i对后面的判断产生错误
 * Created by Dell on 2017-08-03.
 */
public class SubArrNum2 {
    public static int getArrNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {//比当前元素大的在qmin中移除，相等的也移除
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {//比当前元素小的在qmax中移除，相等的也移除
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {//移除和i相等的，i++,就不会受i位置不满足的元素的影响产生错误的结果
                    break;
                }
                j++;
            }
            //大值-小>num,break    或j超出范围
            //弹出头部和i相等的,以i开头的
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }
}
