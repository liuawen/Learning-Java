package com.awen.test03;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */
/*
 * 所有类的根父类是Object。
 * 枚举的公共父类是Enum，根父类仍然是Object
 * 异常的公共父类是Throwable，根父类仍然是Object
 *
 * 1、异常的公共父类：java.lang.Throwable
 * (1)只有当对象是此类（或其子类之一）的实例时，才能通过 Java 虚拟机或者 Java throw 语句“抛”出。
 * (2)只有此类或其子类之一才可以是 catch 子句中的参数类型。
 *
 * 2、Throwable又分为两大派别：
 * （1）Error：错误
 * 		一般指严重错误，一般合理的应用程序不应该试图去捕获它。
 *		如果出现这个问题，要么需要升级程序，要么需要升级架构，要么需要升级硬件。
 *		例如：报了一个OutOfMemoryError
 *
 *		经典代表：VirtualMachineError（堆内存溢出OutOfMemoryError，栈内存溢出StackOverflowError）
 * （2）Exception：异常
 * 		一般异常，合理的应用程序应该试图去捕获它。
 *
 * 3、Exception还可以分为两大类：
 * （1）运行时异常(RuntimeException或它子类)：又称为非受检异常
 * 		编译时，编译器是不会提醒你做处理的，只有运行期间，才会发生。
 * 		运行时异常是不建议用try...catch，因为它发生频率太高，而且一般都是很不应该发生的问题。
 * 		例如：空指针异常，数组下标越界异常，类型转换异常等，这些异常完全可以避免掉。
 * 		但是如果实在没有考虑到，也可以通过try...catch处理。
 *
 * （2）编译时异常，除了RuntimeException系列以外的，都是编译时异常。又称为受检异常。
 * 		编译时，编译器会强制要求程序员编写处理的代码，如果你不编写，那么就编译不通过。
 * 		例如：FileNotFoundException，IOException等
 */
public class TestExceptionType {
    public static void main(String[] args) {

    }
}