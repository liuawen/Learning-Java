package tree.expressionTree;

import tree.treeImple.BinaryTreeNode;
import tree.treeImple.LinkedBinaryTree;

/**
 * 表达式树，有运算对象和运算符,根及内部结点包含着操作，所有叶子包含着操作数
 * Created by Dell on 2017-04-05.
 */
public class ExpressionTree extends LinkedBinaryTree<ExpressionTreeOp> {


    public ExpressionTree() {
        super();
    }
    public ExpressionTree(ExpressionTreeOp element,ExpressionTree leftSubtree,ExpressionTree rightSubtree){
        root=new BinaryTreeNode<ExpressionTreeOp>(element,leftSubtree,rightSubtree);
    }

    public int evaluateTree() {
return evaluateNode(root);
    }

    /**
     * 求某个节点对应的表达式的值
     * @param root
     * @return
     */
    public int evaluateNode(BinaryTreeNode root){
        int result,operand1,operand2;
        ExpressionTreeOp temp;
        if(root==null)
            return 0;
        else {
            temp=(ExpressionTreeOp)root.getElement();
            if(temp.isOperator()){//如果是操作符，就去求左边的值，右边的值
                operand1=evaluateNode(root.getLeft());
                operand2=evaluateNode(root.getRight());
                result=ComputeTerm(temp.getOperator(),operand1,operand2);
            }else {//操作数
                result=temp.getValue();
            }
        }
        return result;
    }

    private int ComputeTerm(char operator, int operand1, int operand2) {
        int result=0;
        if(operator=='+')
            result=operand1+operand2;
        else if(operator=='-')
            result=operand1-operand2;
             else if(operator=='*')
                 result=operand1*operand2;
             else
                 result=operand1/operand2;
        return result;
    }

    public String printTree() {
        return "";
    }
}
