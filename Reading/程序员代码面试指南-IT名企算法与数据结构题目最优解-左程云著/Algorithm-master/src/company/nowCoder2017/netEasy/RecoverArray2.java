package company.nowCoder2017.netEasy;

/**
 * Created by Dell on 2017-09-07.
 */
import java.util.*;

/**
 * Created by xliu on 16/8/26.
 */
public class RecoverArray2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        if (k > n * (n + 1) / 2) {
            System.out.println(0);
            return;
        }

        Set<Integer> set = new HashSet<>();//set存放不为0的元素
        LinkedList<Integer> zeroPos = new LinkedList<>();//为0的下标
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = in.nextInt();
            if (nums[i] == 0) {
                zeroPos.add(i);
            } else {
                set.add(nums[i]);
            }
        }
        int[] unknown = new int[zeroPos.size()];//unknown依次赋值
        int cnt = 0;
        // not known numbers
        for (int i=1; i<=n; i++) {
            if (!set.contains(i)) {
                unknown[cnt++] = i;
            }
        }

        // 统计已经给出的顺序对
        cnt = 0;
        for (int i=0; i<n; i++) {//统计顺序对
            for (int j=i+1; j<n; j++) {
                if (nums[i] != 0 && nums[j] != 0 && nums[i] < nums[j])
                    cnt ++;
            }
        }

        int left = k - cnt;//还剩这么多顺序对

        System.out.println(get(nums, zeroPos, unknown, 0, left, 0));

    }

    /**
     *
     * @param nums  给出的数组
     * @param fill  为0的下标,可变的
     * @param unknown   还不知道的，存放了所有可以试的数
     * @param pos       下标  范围为0-为0的个数
     * @param left      还差多少个顺序对
     * @param curr      当前的顺序对数
     * @return
     */
    public static int get(int[] nums, List<Integer> fill, int[] unknown, int pos, int left, int curr) {
        if (curr == left && pos == unknown.length) return 1;
        if (curr > left || pos == unknown.length ) return 0;

        int fillPos, tmp;
        int result = 0;

        fillPos = fill.get(pos);//获取当前坐标未知的下标
        for (int idx=pos; idx<unknown.length; idx++) { //选择未知的下标

            tmp = unknown[idx];//交换pos和idx的数，这样就可获得所有没有选的元素的全排列
            unknown[idx] = unknown[pos];
            unknown[pos] = tmp;

            nums[fillPos] = unknown[pos];//填入该数

            tmp = curr;//复制当前的顺序对数
            for (int i = 0; i < fillPos; i++) {//统计填入之后的顺序对数
                if (nums[i] < nums[fillPos]) tmp++;
            }

            for (int i=fillPos+1; i<nums.length; i++) {//统计填入该数，是否有新的顺序对
                if (nums[fillPos] < nums[i]) tmp++;
            }
            // 填入下一个未知位置，
            result += get(nums, fill, unknown, pos+1, left, tmp);

            //递归完之后恢复成原来的样子，方便下一次的递归
            nums[fillPos] = 0;
            //交换回原来的样子
            tmp = unknown[pos];
            unknown[pos] = unknown[idx];
            unknown[idx] = tmp;
        }
        return result;
    }

}

