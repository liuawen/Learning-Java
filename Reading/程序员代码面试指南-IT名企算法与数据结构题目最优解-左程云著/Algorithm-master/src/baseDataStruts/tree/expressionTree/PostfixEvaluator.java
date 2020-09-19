package tree.expressionTree;

import java.util.Scanner;
import java.util.Stack;

/**
 * 处理后缀表达式
 * Created by Dell on 2017-04-05.
 */
public class PostfixEvaluator {
    private String expression;
    private Stack<ExpressionTree> treeStack;//栈，用来构造表达式树

    public PostfixEvaluator(){
        treeStack=new Stack<ExpressionTree>();
    }

    /**
     * 通过构造一颗表达式树来计算表达式
     * 计算后缀表达式
     * @param expression
     * @return
     */
    public int evaluate(String expression){
        ExpressionTree operand1,operand2;
        char operator;
        String tempToken;

        Scanner parser=new Scanner(expression);
        while (parser.hasNext()){
            tempToken=parser.next();
            operator=tempToken.charAt(0);
            if(operator=='+'||operator=='-'||operator=='*'||operator=='/'){//如果是操作符
                operand2=getOperand(treeStack);
                operand1=getOperand(treeStack);
                treeStack.push(new ExpressionTree(new ExpressionTreeOp(1,operator,0),operand1,operand2));
            }else{//如果是操作数
                treeStack.push(new ExpressionTree(new ExpressionTreeOp(2,' ',Integer.parseInt(tempToken)),null,null));
            }
        }
        return (treeStack.peek()).evaluateTree();
    }



    //获取后缀表达式的树
    public String getTree(){
        return treeStack.peek().printTree();
    }

    private ExpressionTree getOperand(Stack<ExpressionTree> treeStack){
        ExpressionTree tree;
        tree=treeStack.pop();
        return tree;
    }






}
