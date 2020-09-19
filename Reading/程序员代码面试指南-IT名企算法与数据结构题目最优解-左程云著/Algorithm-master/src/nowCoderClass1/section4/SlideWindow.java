package nowCoderClass1.section4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。
 * 因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。
 * 所以最终返回[5,5,5,4,6,7]。
 * Created by Dell on 2017-05-07.
 */
public class SlideWindow {
    /**
     * 使用qmax双端队列,较优解O(n)，qmax是维护窗口最大值的
     *如果q[max]为空，直接放入
     * 不为空，取出队尾下标j，arr[j]>arr[i],将i放入队尾
     * 如果arr[j]<=arr[i],一直从队尾弹出，直至下标在qmax的值大于i，将i放入队尾
     *qmax弹出规则为，如果qmax队头的下标等于i-w,弹出qmax当前对头下标
     * @param arr
     * @param n
     * @param w
     * @return
     */
    public int[] slide(int[] arr, int n, int w) {
        // write code here
        if(w>n||n==1){
            return arr;
        }
       Deque<Integer> qmax=new ArrayDeque<Integer>();
        int[] res=new int[n-w+1];
        //处理0---w-1
        for(int i=0;i<w;i++){
            if(qmax.isEmpty()){
                qmax.add(i);
            }else{
                if(arr[i]<arr[qmax.peekLast()]){
                    qmax.addLast(i);
                }else{
                    //从队尾依次比较，舍弃较小的
                    while((!qmax.isEmpty())&&arr[i]>=arr[qmax.peekLast()]){
                        qmax.pollLast();
                    }
                    qmax.addLast(i);
                }
            }
        }
        //将第一个窗口的最大值记录下来
        res[0]=arr[qmax.peekFirst()];

        for(int i=w;i<n;i++){
            if(arr[i]<arr[qmax.peekLast()]){
                qmax.addLast(i);
            }else{
                //从队尾依次比较，舍弃较小的
                while((!qmax.isEmpty())&&arr[i]>=arr[qmax.peekLast()]){
                    qmax.pollLast();
                }
                qmax.addLast(i);
            }
            //去检查队首是否过期
            if(i-w==qmax.peekFirst()){//过期
                qmax.pollFirst();
            }
            res[i-w+1]=arr[qmax.peekFirst()];
        }
        return res;

    }
}
