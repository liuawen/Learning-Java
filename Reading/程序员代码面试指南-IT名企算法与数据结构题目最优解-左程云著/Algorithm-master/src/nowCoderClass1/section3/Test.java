package nowCoderClass1.section3;

import nowCoderClass1.section4.MaxTree;
import nowCoderClass1.sorted.ShellSort;

/**
 * Created by Dell on 2017-05-07.
 */
public class Test {
    public static void main(String[] args){
        int[] A={3,1,4,2};
        new MaxTree().buildMaxTree(A,4);
//        int[] B=new SlideWindow().slide(A,7,3);
        System.out.print(new ShellSort().print(A));
//        new TwoStacks().twoStacksSort(A);

//        new StackReverse().reverseStack(A,4);
//        String A="dfghj";
//        String B="fghdj";
//        System.out.println(new Transform().chkTransform(A,5,B,5));
//        Solution s=new Solution();
//        s.push(3);
//        System.out.println(s.min());

    }

}
