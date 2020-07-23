/**
 * @author Liu Awen
 * @create 2018-05-07 16:40
 */
//什么是求和  什么是拼接
class Test08_Exer7{
    public static void main(String[] args){
		/*
		String str1 = 4;
		左边是String字符串类型，右边是4int类型，它们之间无法自动类型转换
		*/
        //String str1 = 4;
        String str2 = 3.5f + "";
        System.out.println(str2);   //3.5
        System.out .println(3+4+"Hello!");  //7Hello!
        System.out.println("Hello!"+3+4); // Hello!34
        System.out.println('a'+1+"Hello!");   // 98Hello!
        System.out.println("Hello"+'a'+1);  //Helloa1
    }
}