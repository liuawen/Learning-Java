/**
 * @author Liu Awen
 * @create 2020-05-06 21:25
 */
/*
练习3：
声明一些变量，来保存，一份图书信息：
书名：
作者：
价格：
销量：
库存量：
是否是促销产品：

*/
class TestExer3{
    public static void main(String[] args){
		/*
		String的S是大写的
		*/
        String bookName = "《Java从入门到放弃》";
        String author = "菜鸡文";
        double price = 100.0;
        int sale = 0;
        int amount = 100;
        boolean cu = true;

        System.out.println("书名：" + bookName);
        System.out.println("作者：" + author);
        System.out.println("价格：" + price);
        System.out.println("销量：" + sale);
        System.out.println("库存量：" + amount);
        System.out.println("是否促销：" + cu);
    }
}