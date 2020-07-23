package homework;

/**
 * @author Liu Awen
 * @create 2020-05-15 15:05
 */
class Day05_Test09_2{
    public static void main(String[] args){
        //int[] arr = {26,67,49,38,52,66,7,71,56,87};
        int[] arr = {23,67,49,33,53,63,7,71,53,87};
        //好多了
        for(int left = 0,right = arr.length-1; left<right; left++,right--){
            //左边是偶数，右边是奇数，交换
            if(arr[left]%2==0 && arr[right]%2!=0){//左边的偶数
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }else if(arr[left]%2!=0 && arr[right]%2!=0){//左边是奇数，右边也是奇数
                right++;//为了抵消right--，让right保持不动，等着下一次的left找到偶数与它交换
                //右边已经是奇数 右边不变 看下一个左边的值呢
            }else if(arr[left]%2==0 && arr[right]%2==0){//左边是偶数，右边也是偶数
                left--;//为了抵消left++，让left保持不动，等着下一次的right找到奇数与它交换
            }
        }

        for(int k = 0; k<arr.length; k++){
            System.out.print(arr[k]+" ");
        }
    }
}