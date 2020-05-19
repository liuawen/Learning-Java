package homework;

import java.lang.annotation.ElementType;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 * 4、比较数组
 * 两个"相等"数组，必须保证两个两个数组满足以下条件:
 * - 数组长度相等
 * - 两个数组中相应位置的元素全部相等
 * 在 ArrayHelper 类中增加一组相互重载的 equal 方法，实现判断数组是否相等。
 * 完成以上 equal 方法后，在 main 方法中予以测试
 */
public class ArrayHelper {
    //判断两个数组是否相等
    public static boolean equal(int[] first, int[] second) {
        if (first.length == second.length) {
            for (int i = 0; i < first.length; i++) {
                if (first[i] == second[i]) {
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {1, 2, 3, 4, 5, 6};

        //判断数组是否相等
        if (ArrayHelper.equal(array1, array2)) {
            System.out.println("array1等于array2");
        } else {
            System.out.println("array1不等于array2");
        }
    }
}
