package com.awen.test06;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-22
 * @describe :
 */
public class TestExer06 {
    public static void main(String[] args) {
        Sportman t = new Sportman("兔子",30,100,10000);
        Sportman w = new Sportman("乌龟",30,1000,1000);

        t.start();
        w.start();

        //总是乌龟跑到后面的
    }
}
class Sportman extends Thread{
    private int distance;//距离
    private long millsPerMeter;//每米的时间，毫秒
    private long restPerTenMeter;//每10米休息的时间，毫秒

    public Sportman(String name, int distance ,long millsPerMeter, long restPerTenMeter) {
        super(name);
        this.distance = distance;
        this.millsPerMeter = millsPerMeter;
        this.restPerTenMeter = restPerTenMeter;
    }

    public void run(){
        for (int i = 1; i <= distance; i++) {
            try {
                Thread.sleep(millsPerMeter);//模拟跑1米的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //用线程名称代替运动员的名称
            System.out.println(getName() + "跑了" + i + "米");

            if(i== 10 || i == 20){
                System.out.println(getName() + "在休息....");
                try {
                    Thread.sleep(restPerTenMeter);//休息n秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}