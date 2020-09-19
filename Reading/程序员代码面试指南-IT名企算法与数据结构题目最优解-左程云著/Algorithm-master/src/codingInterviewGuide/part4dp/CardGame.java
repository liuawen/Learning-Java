package codingInterviewGuide.part4dp;

/**
 * Created by Dell on 2017-08-11.
 */
public class CardGame {
    public int win(int[] arr) {
        return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1));
    }
    //f是先取的人选择的过程
    public int f(int[] arr,int i,int j){
        if(i==j){
            return arr[i];
        }
        return Math.max(arr[i]+s(arr,i+1,j),s(arr,i,j-1)+arr[j]);
    }
    //s是后选的人选择的过程
    public int s(int[] arr,int i,int j){
        if(i==j){
            return 0;
        }
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }

}
