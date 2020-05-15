package homework;

/**
 * @author Liu Awen
 * @create 2020-05-15 16:30
 */
class Day05_Test09_Homework2{
    public static void main(String[] args){
        int[] arr = {26,67,49,38,52,66,7,71,56,87};

        int i=0;
        int j = arr.length-1;
        while (i < j){
            if(arr[i]%2==0){//如果左边arr[i]是偶数，就与右边arr[j]交换
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

                //因为这里没有看arr[j]是奇数还是偶数，
                //所以i不移动，这样arr[i]就可以在下一次循环时，重新判断是奇数还是偶数
                j--;//交换后，arr[j]一定是偶数，所以，j往左移动一位
            }else{
                i++;//如果arr[i]是奇数，i往右移动移动，j不动
            }
        }
    }
}