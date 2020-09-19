package tree.expressionTree;

import java.util.Scanner;

/**
 * 读后缀表达式
 * Created by Dell on 2017-04-05.
 */
public class PostfixTester {
    public static void main(String[] args){
        String expression,again="n";
        int result;
        Scanner in=new Scanner(System.in);
        //后缀表达式
        PostfixEvaluator evaluator=new PostfixEvaluator();
        System.out.println("输入一个有效的后缀表达式，用空格隔开");
        expression=in.nextLine();
        result=evaluator.evaluate(expression);
        System.out.println("这个表达式的值是    "+result);
        System.out.println("这个表达式的树是    "+evaluator.getTree());
    }
}
