package binaryTree;

/**
 * Created by Dell on 2017-06-09.
 */
public class PostOrder {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null)
            return false;
        return isBSTPostOrder(sequence,0,sequence.length-1);
    }
    public boolean isBSTPostOrder(int [] sequence,int begin,int end) {
        if(end-begin<=1){
            return true;
        }
        //后序遍历时左，右，根
        int root=end;
        //找到一个点，左边的比其小，右边的比其大，则是，一旦发现不是，则返回false，再用分治法
        int left=begin;
        int right=root-1;
        //通过这样的方式找划分的地方,考虑，如果第一个元素不符合的话，会出错
        while(left<=right&&sequence[left]<sequence[root]){left++;}
        while (right>=begin&&sequence[right]>sequence[root]){right--;}
        if(left-right==1){
            boolean l=true,r=true;
            if(left!=begin){
                l=isBSTPostOrder(sequence,begin,left-1);
            }
            if((right+1)<(end)){
                r=isBSTPostOrder(sequence,right+1,end-1);
            }
            return l&&r;
        }else{
            return false;
        }
    }
}
