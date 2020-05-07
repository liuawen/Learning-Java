/**
 * @author Liu Awen
 * @create 2020-05-06 21:25
 */
/*
练习2：打印个人信息
个人信息使用变量保存
*/
class TestExer2{
    public static void main(String[] args){
        String name = "菜鸡文";
        String password = String.valueOf(123456);
        int age = 18;
        char gender = '男';
        double height = 178.0;
        double weight = 70.5;
        boolean marry = false;

        System.out.println(name);
        System.out.println(password);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(height);
        System.out.println(weight);
        System.out.println(marry);
        System.out.println("---------------------");

		/*
		""中的内容，原因显示
		name是变量，在显示的时候，不是显示name单词，而是把name变量中存的值取出来显示，所以这里name不加""
		"姓名：" + name：把姓名:和name变量中的值拼接起来一起显示
		*/
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("性别：" + gender);
        System.out.println("身高：" + height);
        System.out.println("体重：" + weight);
        System.out.println("是否已婚：" + marry);
    }
}