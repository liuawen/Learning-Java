package cn.liuawen.thread;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 */
/*
 * 3.定义一个测试类
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 4.在main方法中打印主线程的名称；
        System.out.println("main:" + Thread.currentThread().getName());
        // 5.在main方法中创建子线程对象；
        SubThread st = new SubThread();
        // 6.调用子线程对象的start方法，开启子线程。
        st.start();
    }
}

