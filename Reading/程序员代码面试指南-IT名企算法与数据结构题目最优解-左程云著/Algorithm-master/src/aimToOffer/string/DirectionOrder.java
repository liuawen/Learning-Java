package string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Created by Dell on 2017-06-10.
 */
public class DirectionOrder {
    /**
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        char[] chars=str.toCharArray();
        Arrays.sort(chars);//全排列
        ArrayList<String> list=new ArrayList<String>();
        fullPermutation(chars,0,list);
        return list;
    }

    /**
     *
     * @param chars
     * @param index     代表对i后面的全排序
     * @return
     */
    public void fullPermutation(char[] chars,int index,ArrayList<String> list){
        if(chars.length-index==1){
            //只有一种情况
            list.add(String.valueOf(chars));
        }else{
            fullPermutation(chars,index+1,list);
            for(int i=index+1;i<chars.length;i++){
//                System.out.println("交换前  ");
//                for(char s:chars){
//                    System.out.print(s+" ");
//                }
//                System.out.println();
                swap(chars,index,i);//交换前面的
                //打印整个的状态
//                System.out.println("交换后  ");
//                for(char s:chars){
//                    System.out.print(s+" ");
//                }
                fullPermutation(chars,index+1,list);
            }
            //全部逆序
            int front=index+1,end=chars.length-1;
            while(front<end){
                swap(chars,front++,end--);
            }
            //不应该只交换最后两个，应将本次的后面几位重新调换顺序
//            swap(chars,chars.length-1,chars.length-2);
        }

    }
    public void swap(char[] chars,int a,int b){
        char temp=chars[a];
        chars[a]=chars[b];
        chars[b]=temp;
    }
}
