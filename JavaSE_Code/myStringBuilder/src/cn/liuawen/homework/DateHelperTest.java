package cn.liuawen.homework;

import java.util.Date;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-06-01
 */
public class DateHelperTest {
    public static void main(String[] args) {

        DateHelper dh = DateHelper.getInstance(); // 获取 DateHelper 实例

        Date first = dh.toDate(2000, 4, 30, 5, 50); // 获取 Date 实例
        System.out.println(dh.toString(first)); // 输出 2000年05月30日 05:50:00.000

        Date second = dh.toDate(2020, 5, 1, 18, 20, 35); // 获取 Date 实例
        System.out.println(dh.toString(second)); // 输出 2020年06月01日 18:20:35.000

        int days1 = dh.durationOfDays(first, second); // 统计 first 和 second 之间间隔的天数
        System.out.println(days1);

        int days2 = dh.durationOfDays(second, first); // 统计 second 和 first 之间间隔的天数
        System.out.println(days2);

        //2000年05月30日 05:50:00.000
        //2020年06月01日 18:20:35.000
        //-7308
        //7308

    }
}
