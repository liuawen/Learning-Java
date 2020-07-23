package cn.liuawen.exception;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-29
 */
public class MyThread extends Thread {

    /**
     * 重写run方法，完成该线程执行的逻辑
     */
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println("子线程打印输出偶数：" + i);
            }
        }
    }


}
