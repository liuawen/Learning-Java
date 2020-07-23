package com.awen.test07;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-22
 * @describe :
 */

/*
2、案例：编写龟兔赛跑多线程程序，设赛跑长度为30米
兔子的速度是10米每秒，兔子每跑完10米休眠的时间10秒
乌龟的速度是1米每秒，乌龟每跑完10米的休眠时间是1秒
要求，
（1）每跑1米，显示一下结果：xxx跑了几米，
	  休息时，显示一下：xxx在休息...
（2）要求必须等乌龟和兔子都跑完了，然后显示结果谁赢了，用时xx时间
 */
public class TestExer07 {
    public static void main(String[] args) {
        Sportman t = new Sportman("兔子",30,100,10000);
        Sportman w = new Sportman("乌龟",30,1000,1000);

        t.start();
        w.start();

        try {
            //等t和w线程结束后，才能运行下面的代码
            //阻塞了main   t w 不影响
            t.join();//t阻塞了main
            w.join();//w阻塞了main
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //在这里想要获取运动员跑全程的时间
        long tTime = t.getTotalTime();
        long wTime = w.getTotalTime();
        if(tTime == wTime){
            System.out.println(t.getName() + "," + w.getName() + "平局");
        }else if(tTime < wTime){
            System.out.println(t.getName() + "赢了");
        }else{
            System.out.println(w.getName() + "赢了");
        }

        System.out.println(t.getName() + "用时：" + tTime);
        System.out.println(w.getName() + "用时：" + wTime);
        tTime /= 1000;
        System.out.println(t.getName() + "用时：" + tTime + "s");
    }
}
class Sportman extends Thread{
    private int distance;//距离
    private long runMillsPerMeter;//每米的时间，毫秒
    private long restMillsPerTenMeter;//每10米休息的时间，毫秒
    //来个变量存储时间  提供个get方法 外面可以拿到
    private long totalTime;

    public Sportman(String name, int distance ,long millsPerMeter, long restPerTenMeter) {
        super(name);
        this.distance = distance;
        this.runMillsPerMeter = millsPerMeter;
        this.restMillsPerTenMeter = restPerTenMeter;
    }

    public void run(){
        long start = System.currentTimeMillis();
        for (int i = 1; i <= distance; i++) {
            try {
                Thread.sleep(runMillsPerMeter);//模拟跑1米的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //用线程名称代替运动员的名称
            System.out.println(getName() + "跑了" + i + "米");

            if(i<distance && i%10==0){
                System.out.println(getName() + "在休息....");
                try {
                    Thread.sleep(restMillsPerTenMeter);//休息n秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        totalTime =  end - start;
    }

    public long getTotalTime() {
        return totalTime;
    }

}