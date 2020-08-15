package com.itheima_04;

/*
    练习
        1:定义一个类(PrintString)，里面定义一个方法
            public void printUpper(String s)：把字符串参数变成大写的数据，然后在控制台输出
        2:定义一个接口(Printer)，里面定义一个抽象方法
            void printUpperCase(String s)
        3:定义一个测试类(PrinterDemo)，在测试类中提供两个方法
            一个方法是：usePrinter(Printer p)
            一个方法是主方法，在主方法中调用usePrinter方法
 */
public class PrinterDemo {
    public static void main(String[] args) {
        //在主方法中调用usePrinter方法

//        usePrinter((String s) -> {
////            String result = s.toUpperCase();
////            System.out.println(result);
//            System.out.println(s.toUpperCase());
//        });

        usePrinter(s -> System.out.println(s.toUpperCase()));

        //引用对象的实例方法
        PrintString ps = new PrintString();
        usePrinter(ps::printUpper);

        //Lambda表达式被对象的实例方法替代的时候，它的形式参数全部传递给该方法作为参数
    }

    private static void usePrinter(Printer p) {
        p.printUpperCase("HelloWorld");
    }
}
