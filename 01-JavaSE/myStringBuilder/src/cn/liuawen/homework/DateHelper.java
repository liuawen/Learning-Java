package cn.liuawen.homework;

import java.lang.annotation.ElementType;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-06-01
 */
public final class DateHelper {
    private DateHelper() {
    }

    public static DateHelper getInstance() {
        return new DateHelper();
    }

    public Date toDate(int year, int month, int date, int hourOfDay, int minute) {
        // 可以将 秒 和 毫秒 部分直接设置为 零
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date, hourOfDay, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date time = calendar.getTime(); // 从一个 Calendar 对象中获取 Date 对象
        return time;
    }

    public Date toDate(int year, int month, int date, int hourOfDay, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date, hourOfDay, minute, second);
        calendar.set(Calendar.MILLISECOND, 0);
        Date time = calendar.getTime(); // 从一个 Calendar 对象中获取 Date 对象
        return time;
    }

    public Date toDate(int year, int month, int date,
                       int hourOfDay, int minute, int second, int millis) {
        // 自行设计实现过程
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date, hourOfDay, minute, second);
        calendar.set(Calendar.MILLISECOND, millis);
        Date time = calendar.getTime(); // 从一个 Calendar 对象中获取 Date 对象
        return time;
    }

    public String toString(final Calendar date) {

        // 从 Calendar实例 中 获取 各个日历字段 的值 并 连接到 字符序列 中
        StringBuilder builder = new StringBuilder();

        int year = date.get(Calendar.YEAR);
        builder.append(year + "年");

        int month = date.get(Calendar.MONTH) + 1;
        if (month > 9) {
            builder.append(month + "月");
        } else {
            builder.append("0" + month + "月");
        }

        int day = date.get(Calendar.DATE);
        if (day > 9) {
            builder.append(day + "日 ");
        } else {
            builder.append("0" + day + "日 ");
        }

        int hours = date.get(Calendar.HOUR_OF_DAY);
        if (hours > 9) {
            builder.append(hours + ":");
        } else {
            builder.append("0" + hours + ":");
        }

        int minutes = date.get(Calendar.MINUTE);
        if (minutes > 9) {
            builder.append(minutes + ":");
        } else {
            builder.append("0" + minutes + ":");
        }

        int seconds = date.get(Calendar.SECOND);
        if (seconds > 9) {
            builder.append(seconds + ".");
        } else {
            builder.append("0" + seconds + ".");
        }

        int millis = date.get(Calendar.MILLISECOND);
        if (millis < 10) {
            builder.append("00" + millis);
        } else if (millis < 100) {
            builder.append("0" + millis);
        } else {
            builder.append(millis);
        }
        // 返回 Calendar实例 对应的字符序列

        // 2000年09月12日 17:25:35.369
        String time = builder.toString();

        return time;
    }

    public String toString(final Date date) {

        // 实现思路:

        // 1、获取一个 Calendar 实例
        final Calendar calendar = Calendar.getInstance(); // 默认地区、默认时区
        // 2、清空 Calendar 实例的 日历字段值 和 时间值
        calendar.clear();
        // 3、将 参数 date 所表示的瞬间设置到 新创建的 Calendar 实例中
        calendar.setTime(date);
        // 4、调用 toString( Calendar ) 方法获取 Calendar实例 的字符串形式
        String s = toString(calendar);
        // 5、将 Calendar实例 的字符串形式 直接返回即可
        return s;
    }

    public int durationOfDays(Date first, Date second) {
        // 自行设计实现过程
        if (first.equals(second)) {
            return 0;
        }
        if (first.before(second)) {
            long ms = second.getTime() - first.getTime();
            return -(int) Math.ceil(ms / (1000L * 60 * 60 * 24.0));
        } else {
            long ms = first.getTime() - second.getTime();
            return (int) Math.ceil(ms / (1000L * 60 * 60 * 24.0));
        }
    }
}
