package codingInterviewGuide.part1;

/**
 * Created by Dell on 2017-07-15.
 */
public class Test {

    public static void main(String[] args){
        int[] arr={7,3,1,5,6,2,3,2,3,7,3,1,5,6,2,3};
        int res=new MySubArrNum().getArrNum(arr,3);
        System.out.println(res);
        int r=new SubArrNum2().getArrNum(arr,3);
        System.out.println(r);

//        int[][] arr={{1,0,1,0,1,1,0},{1,1,1,0,0,1,1},{1,1,1,1,0,1,0}};
//        int res=new MaxSubRectangle().getMaxArea(arr,3,7);
//        System.out.println(res);

//        int[] arr={3,12,8,7};
//        new MaxTree().getMaxTree(arr);
//        Stack<Integer> stack=new Stack<Integer>();
//        stack.add(1);
//        stack.add(2);
//        stack.add(3);
//        new ReverseStack().reverse(stack);
        //预期结果1,2,3
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
    }
}
