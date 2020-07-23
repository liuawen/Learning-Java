package cn.liuawen.thread;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 */
/*
 * 1.定义一个子任务类，实现Runnable接口。
 */
public class SubRunnable implements Runnable {
    @Override
    public void run() {
        // 2.在子任务类中重写run方法，在run方法中打印子线程的名称。
        System.out.println("SubRunnable:" + Thread.currentThread().getName());
    }
}
