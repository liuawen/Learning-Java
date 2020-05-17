package homework;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
class Day08_Test02{
}
class MyArrays{
    /*
    1、int  binarySearch(int[]  arr,  int  value)：
        使用二分查找法在arr数组中查找value的下标，
        如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确*/
    public int binarySearch(int[]  arr,  int  value){
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right)/2;
        //left right mid

        //left<=right
        while(left<=right){
            if(arr[mid] == value){
                return mid;
            }else if(value > arr[mid]){
                left = mid + 1;
            }else if(value <arr[mid]){
                right = mid -1;
            }
            mid = (left + right)/2;
        }
        return -1;
    }

    /*
    int  copy(int[] arr , int length)：从指定的arr数组的arr[0]
    开始复制得到一个新数组，新数组的长度为length。*/
    public int[] copy(int[] arr, int length){
        //(1)创建新数组
        int[] newArr = new int[length];

        //(2)复制元素
        for(int i =0; i<arr.length && i<newArr.length; i++){
            newArr[i] = arr[i];
        }

        return newArr;
    }

    /*
    void sort(int[] arr)：可以给arr数组从小到大排序，用冒泡排序实现
    */
    public void sort(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<arr.length-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}