package codingInterviewGuide.part4dp;

/**
 * Created by Dell on 2017-08-10.
 */
public class LeastNumExtend {
    public static int getNum(int[] arr,int aim){
        return voilence(arr,0,aim);
    }
    public static int voilence(int[] arr,int index,int aim){
        if(aim==0){return 0;}
        if(aim<0||index==arr.length){
            return -1;
        }
        int count=0,temp1=0,temp2=0;
        //有两种情况，分别递归
        temp1=voilence(arr,index+1,aim);
        temp2=voilence(arr,index+1,aim-arr[index]);
        temp2=temp2==-1?temp2:temp2+1;
        if(temp2!=-1&&temp1!=-1){
            return Math.min(temp1,temp2);
        }
        //两者都等于-1，或其中一个等于-1
        if(temp1==-1&&temp2==-1){
            return -1;
        }else{
            return temp1==-1?temp2:temp1;
        }
    }
}
