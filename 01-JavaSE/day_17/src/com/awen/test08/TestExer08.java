package com.awen.test08;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-22
 * @describe :
 */

/*
 * 2、案例：编写龟兔赛跑多线程程序，设赛跑长度为30米
兔子的速度是10米每秒，兔子每跑完10米休眠的时间10秒
乌龟的速度是1米每秒，乌龟每跑完10米的休眠时间是1秒
要求，
（1）每跑1米，显示一下结果：xxx跑了几米，
	  休息时，显示一下：xxx在休息...

（2）只要有跑完的，比赛就结束，最先跑完的就赢了，其他运动员就停下来别跑了
相当于，只比冠军
 */
public class TestExer08 {
    public static void main(String[] args) {
        //1、启动线程
        Sportman t = new Sportman("兔子",30,100,10000);
        Sportman w = new Sportman("乌龟",30,1000,1000);

        t.start();
        w.start();

        //2、判断是否有运动员跑完了
        while(true){
            //如果有人跑完了，停下所有线程
            if(t.isFinish() || w.isFinish()){
                t.interrupt();
                w.interrupt();

/*				t.stop();
				w.stop();*/

                t.setStop(true);
                w.setStop(true);

                break;
            }
        }

        //3、宣布结果
        //看谁先跑完，谁就赢了
        if(t.isFinish() && w.isFinish()){
            System.out.println(t.getName() + "," + w.getName() + "平局");
        }else if(t.isFinish()){
            System.out.println(t.getName() + "赢了");
        }else{
            System.out.println(w.getName() + "赢了");
        }
    }
}
class Sportman extends Thread{
    private int distance;//距离
    private long runMillsPerMeter;//每米的时间，毫秒
    private long restMillsPerTenMeter;//每10米休息的时间，毫秒
    private long totalTime;
    private volatile boolean finish;//默认值是false，如果跑完了，修改为true
    private boolean stop;//默认值是false

    public Sportman(String name, int distance ,long millsPerMeter, long restPerTenMeter) {
        super(name);
        this.distance = distance;
        this.runMillsPerMeter = millsPerMeter;
        this.restMillsPerTenMeter = restPerTenMeter;
    }

    public void run(){
        long start = System.currentTimeMillis();
        int i;
        for (i = 1; i <= distance && !stop; i++) {
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
        if(i >= distance){//不是中途结束，而是全程跑完的
            finish = true;
        }
    }

    public long getTotalTime() {
        return totalTime;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

}