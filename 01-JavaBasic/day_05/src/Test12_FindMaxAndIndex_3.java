/**
 * @author Liu Awen
 * @create 2018-05-10 20:18
 */
/*
数组的相关的算法操作：
1、在数组中找最大值/最小值
2、在数组中找最大值/最小值及其下标
*/
class Test12_FindMaxAndIndex_3{
    public static void main(String[] args){
        int[] array = {4,2,-7,8,1,-7};

        //找出最小值，及其下标，但是如果最小值有两个或多个
		/*
		（1）先找出最小值
		（2）找出所有最小值的下标
		*/
        //（1）先找出最小值
        int min = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        System.out.println("最小值：" + min);

        //（2）找出所有最小值的下标
        System.out.println("最小值的下标有：");
        for(int i=0; i<array.length; i++){
            if(array[i] == min){
                System.out.print("[" + i + "]\t");
            }
        }

    }
}