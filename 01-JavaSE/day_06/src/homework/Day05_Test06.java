package homework;

/**
 * @author Liu Awen
 * @create 2018-05-11 19:49
 */
//判断数组是否元素值对称
//头  尾   首尾搞
class Day05_Test06{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,4,3,2,1};

        //(1)先假设它是对称的
        boolean flag = true;

        //(2)遍历，查看数组的元素是否首尾对称
        //left表示左边的下标
        //right表示右边的下标
        for(int left=0,right=arr.length-1; left<right; left++,right--){
            if(arr[left] != arr[right]){
                flag = false;
                break;
            }
        }
        
        System.out.println(flag?"对称":"不对称");
    }
}