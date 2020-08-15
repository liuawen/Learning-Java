package com.itheima_03;

public class Outer {

    private int num = 10;

    public void method() {
        int num2 = 20;
        class Inner {
            public void show() {
                System.out.println(num);
                System.out.println(num2);
            }
        }

        Inner i = new Inner();
        i.show();

    }

}
