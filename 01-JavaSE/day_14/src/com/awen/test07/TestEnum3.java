package com.awen.test07;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

/*
 * 补充：枚举类型实现接口
 * 枚举类型实现接口
 */
public class TestEnum3 {
    public static void main(String[] args) {
        MyEnum a = MyEnum.A;
        a.test();//aaa

        MyEnum b = MyEnum.B;
        b.test();//bbb
    }
}
interface MyInter{
    void test();
}
enum MyEnum implements MyInter{
    //想A,B对象实现的不一样
    A{
        @Override
        public void test() {
            System.out.println("aaa");
        }
    },B{
        @Override
        public void test() {
            System.out.println("bbb");
        }
    }
}
/*enum MyEnum implements MyInter{
	A,B;

	@Override
	public void test() {
		System.out.println("test");
	}
}*/