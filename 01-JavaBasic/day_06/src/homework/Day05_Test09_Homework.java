package homework;

/**
 * @author Liu Awen
 * @create 2020-05-15 16:29
 */
//移动元素，使得奇数在数组的左边，偶数在数组的右边
class Day05_Test09_Homework{
    public static void main(String[] args){
        int[] arr = {26,67,49,38,52,66,7,71,56,87};
        int left = 0,right = arr.length-1;
        while(left<right){
            if(arr[left]%2==0 && arr[right]%2!=0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }else if(arr[left]%2!=0){
                left++;
            }else if(arr[right]%2==0){
                right--;
            }
        }

        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i] + " ");
        }
    }
}