package binaryTree;

/**
 * Created by Dell on 2017-06-10.
 */
public class ConvertDoubleLinked {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    public TreeNode i(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        inOrder(pRootOfTree,null);
        TreeNode c=pRootOfTree;
        while(c.left!=null){
            c=c.left;
        }
        return c;
    }

    /**
     *  思路是中序遍历，
     * @param root   保证root不为空
     * @param current   相当于是该树的前序
     */
    public TreeNode inOrder(TreeNode root,TreeNode current){
        //左节点不空
        if(root.left!=null)
            current=inOrder(root.left,current);
        else if(current==null){
            //这是最左节点
            current=root;
            //考虑左节点的右节点
            if(root.right!=null){
                current=inOrder(root.right,current);
            }
            return current;
        }
        if(current!=null){
            current.right=root;
            root.left=current;
            current=root;
        }

        if(root.right!=null){
            current=inOrder(root.right,current);
        }
//        System.out.println(root.val);
        return current;
    }

}
