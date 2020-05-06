/**
 * @author Liu Awen
 * @create 2018-05-06 21:13
 */
/*
问题2：大小写问题
(1)源文件名.java的大小写问题
源文件名不区分大小写，但是我们强烈建议大家还是注意大小写
单词首个字母大大写
(2)字节码文件名（类名）
严格区分大小写的
java Problem2   ok
java problem2  error  找不到或无法加载主类
(3)代码中大小写问题
严格区分大小写
大是大 小是小  大不是小  小不是大
大大小小  小小大大
*/
class Problem2{
    public static void main(String[] args){
        System.out.println("大小写问题");
    }
}
