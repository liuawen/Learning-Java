package part1sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 基数排序
 * Created by Dell on 2017-07-22.
 */
public class RadixSort {
    //TODO
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int negNum = 0; // 统计的是为负数的情况
        for (int i = 0; i < arr.length; i++) {//
            negNum += arr[i] < 0 ? 1 : 0;
        }
        int[] negArr = new int[negNum];//负数
        int[] posArr = new int[arr.length - negNum];//正数
        int negi = 0;
        int posi = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negArr[negi++] = -arr[i];//将负数变成正数
            } else {
                posArr[posi++] = arr[i];
            }
        }
        radixSortForPositive(negArr);//排序
        radixSortForPositive(posArr);
        int index = 0;
        for (int i = negArr.length - 1; i >= 0; i--) {//先将负数放入
            arr[index++] = -negArr[i];
        }
        for (int i = 0; i < posArr.length; i++) {//再将正数放入
            arr[index++] = posArr[i];
        }
    }

    // 基数排序
    public static void radixSortForPositive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        ArrayList<LinkedList> qArr1 = new ArrayList();
        ArrayList<LinkedList> qArr2 = new ArrayList();
        for (int i = 0; i < 10; i++) {//初始化两个ArrayList，里面均存放了十个链表，从0-9
            qArr1.add(new LinkedList());
            qArr2.add(new LinkedList());
        }
        for (int i = 0; i < arr.length; i++) {//先按最后一位添加到对应链表中
            qArr1.get(arr[i] % 10).offer(arr[i]);
        }
        long base = 10;
        while (base <= Integer.MAX_VALUE) {//要一直不停的比下去，对所有的整数排序
            for (int i = 0; i < 10; i++) {//将链表中的依次取出
                LinkedList queue = qArr1.get(i);
                while (!queue.isEmpty()) {
                    int value = (Integer)queue.poll();
                    qArr2.get((int) (value / base) % 10).offer(value);//取10位的数加入另一个链表
                }
            }
            ArrayList tmp = qArr1;//互换两个list的指针，
            qArr1 = qArr2;
            qArr2 = tmp;
            base *= 10;
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {//全部倒出，排序完毕
            LinkedList queue = qArr1.get(i);
            while (!queue.isEmpty()) {
                arr[index++] = (Integer)queue.poll();
            }
        }
    }

}
