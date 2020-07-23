package homework;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 * 5、排序数组
 * 在 sort 方法内部，将目标数组 array 中的所有元素按照从大到小的顺序排列，
 * 并将排好顺序放入新数组后返回。
 */
public class Sorter {

    public void traversal(int[] array) {
        //遍历数组
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                System.out.print((i < array.length - 1) ? " , " : "");
            }
            System.out.println();
        }
    }

    //排序数组
    public int[] sort(int[] array) {
        // 实现排序并返回一个新数组
        int[] array2 = new int[array.length];

        //array的值都赋值给array2
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        //冒泡排序完成array2 大到小排序
        for (int i = 1; i < array2.length; i++) {
            for (int j = 0; j < array2.length - i; j++) {
                if (array2[j] < array2[j + 1]) {
                    int temp;
                    temp = array2[j];
                    array2[j] = array2[j + 1];
                    array2[j + 1] = temp;
                }
            }
        }
        return array2;
    }

    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        int[] a = {1, 100, -20, 99, 1000, 0, 30};
        System.out.print("原数组: ");
        sorter.traversal(a); // 原数组: 1 , 100 , -20 , 99 , 1000 , 0 , 30

        int[] x = sorter.sort(a);
        System.out.print("新数组: ");
        sorter.traversal(x); // 新数组: -20 , 0 , 1 , 30 , 99 , 100 , 1000

        System.out.print("原数组: ");
        sorter.traversal(a); // 原数组: 1 , 100 , -20 , 99 , 1000 , 0 , 30

        //Result:
        //原数组: 1 , 100 , -20 , 99 , 1000 , 0 , 30
        //新数组: 1000 , 100 , 99 , 30 , 1 , 0 , -20
        //原数组: 1 , 100 , -20 , 99 , 1000 , 0 , 30
    }
}
