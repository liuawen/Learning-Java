package array;

public class Main {

    public static void main(String[] args) {

//        int[][] arr={{1,2,8},{2,4,12},{4,10,13},{8,11,15}};
//        boolean res=new Solution().Find(5,arr);
//        ArrayList<Integer> list=new RotateArray().printMatrix(arr);
//        Arrays.stream(list.toArray()).forEach(i->System.out.println(i));
        int[] a={1,1,3,3,3,3,3,5,5,5,5};
        int res=new GetNumberOfK().GetNumberOfK(a,3);
        System.out.println(res);
    }
}
