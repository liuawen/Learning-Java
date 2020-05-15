package homework;

/**
 * @author Liu Awen
 * @create 2018-05-11 21:39
 */
//
class Day05_Test09{
    public static void main(String[] args){
        int[] arr = {26,67,49,38,52,66,7,71,56,87};
        //int[] arr = {23,67,49,33,53,63,7,71,53,87};

        int left = -1;
        int right = -1;

        //把i和j定义到外面的意义，每一次while循环
        //就不会导致i和j就不会还原，再上一次基础上继续找
        int i=0;
        int j=arr.length-1;
        while(true){
            //第一次循环，left就是第一个偶数的位置
            for(; i<arr.length; i++){
                if(arr[i]%2==0){
                    left = i;
                    break;
                }
            }

            for(; j>=0; j--){
                if(arr[j]%2!=0){
                    right = j;
                    break;
                }
            }
            //已经搞好了

            //要么没有偶数，要么没有奇数
            if(left==-1 || right==-1){
                break;
            }
            if(left < right){
                //交换arr[left]的偶数与arr[right]的奇数
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }else{
                break;
            }
        }

        //显示结果
        for(int k = 0; k<arr.length; k++){
            System.out.print(arr[k]+" ");
        }
    }
}