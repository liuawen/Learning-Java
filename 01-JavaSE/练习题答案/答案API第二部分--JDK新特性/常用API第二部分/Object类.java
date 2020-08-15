练习一：Object类equals方法
一、简述String类中的equals方法与Object类中的equals方法的不同点。
答：String类中的equals方法是用来判断两个对象的内容是否相同，而Object 类中的equals方法是用来判断两个对象是否是同一个对象，所谓同一个对象指的是内存中的同一块存储空间。

练习二：Object类的toString方法
二、不运行代码，直接说出打印结果，并解释原因。
public class ToStringTest{
    static int i = 1;
    public static void main(String args[]){
        System.out.println("love " + new ToStringTest());//love java
        ToStringTest a = new ToStringTest();
        a.i++;
        System.out.println("me " + a.i);//me 2
    }
    public String toString(){
        System.out.print("I ");//I
        return "java ";
    }
}
运行结果：I love java    me 2
原因：当执行代码的时候，首先加载静态变量，然后执行main方法，由于main方法内部第一行代码为输出语句，里面new了此类对象，当执行此行代码时会先创建了本类的对象，由于此类重写了toString方法，会先执行toString方法的打印输出，然后返回“java ”，再执行main方法第一行打印输出。在Java中“System.out.println(类对象名);”实际输出的是该对象的toString()方法返回的字符串，即括号中的内容等价于类对象名.toString(),toString方法的好处是在碰到println方法的时候会被自动调用，不用显示的写出来。


练习三：Object类equals方法
三、看下列程序，不运行说结果，写出答案后，并在IntelliJ IDEA中运行看看自己给的答案与运行结果是否正确，并分析原因。
	(1)
		String s1 = new String("abc");
		String s2 = "abc";
		System.out.println(s1 == s2);     	//false
		System.out.println(s1.equals(s2));     	//true
	(2)
		String s1 = "abc";
      		String s2 = "abc";
		System.out.println(s1 == s2);     	//true
		System.out.println(s1.equals(s2)); 	//true
	(3)
		String s1 = "a" + "b" + "c";
      		String s2 = "abc";
		System.out.println(s1 == s2);    		 //true
		System.out.println(s1.equals(s2));	 //true
	(4)
		String s1 = "ab";
     		String s2 = "abc";
     		String s3 = s1 + "c";
		System.out.println(s3 == s2);     	//false
      		System.out.println(s3.equals(s2));   	//true
