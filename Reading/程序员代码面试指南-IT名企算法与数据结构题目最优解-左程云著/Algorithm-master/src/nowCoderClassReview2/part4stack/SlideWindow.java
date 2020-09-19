package part4stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Dell on 2017-07-23.
 */
public class SlideWindow {
    /**
     * 滑动窗口，要找到每几个元素中的最大值，保存下来，直接比较会重复比较，使用之前的结果，
     * 定义和窗口同样大小的窗口，添加时最大的在前面，最小的插在后面，如果插入的值较大，则比其小的值就是无效的，可直接丢掉
     * 队首就是该窗口的最大值，更新时需判断该值是否过期，如过期，移除
     *
     * @param arr
     * @param n
     * @param w
     * @return
     */
    public int[] slide1(int[] arr, int n, int w) {
        if (arr == null || w < 1 || n < w) {
            return null;
        }
        Deque<Integer> deque=new LinkedList<Integer>();
        int[] res=new int[n-w+1];
        for(int i=0;i<n;i++){
            while(!deque.isEmpty()&&arr[deque.peekLast()]<arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //如果窗口出现，则记录最大值
                //去除无效的窗口值
            while(deque.peekFirst()<i-w+1){
                deque.pollFirst();
            }
            res[i-w+1]=arr[deque.peekFirst()];
        }
        return res;
    }
    public int[] slide(int[] arr, int n, int w) {
        if (arr == null || w < 1 || n < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList();
        int[] res = new int[n - w + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
