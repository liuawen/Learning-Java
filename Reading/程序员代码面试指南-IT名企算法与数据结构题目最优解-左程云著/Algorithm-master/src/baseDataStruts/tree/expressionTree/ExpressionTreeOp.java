package tree.expressionTree;

/**
 * 每一个节点的存储元素
 * 可以跟踪记录该元素是一个数还是操作符以及其值
 * Created by Dell on 2017-04-05.
 */
public class ExpressionTreeOp {
    private int termType;//类型  1操作符
    private char operator;//操作符
    private int value;//操作数


    public ExpressionTreeOp(int type,char op,int val){
        termType=type;
        operator=op;
        value=val;
    }
    public boolean isOperator(){
        return (termType==1);
    }

    @Override
    public String toString() {
        if(termType==1)
            return operator+"";
        else
            return value+"";
    }

    public char getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }
}
