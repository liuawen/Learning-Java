//数组元素去重
class Day05_Test10{
	public static void main(String[] args){
		int[] arr = {9,10,6,6,1,9,3,5,6,4};//有重复的元素
		
		/*
		（1）定义变量count，初始化为原数组的长度，通过某些操作，可能修改count，最终代表新数组的长度
		（2）查找是否有重复的元素，如果有count--
		*/
		int count = arr.length;//count的值，就是最终新数组的长度
		
		//（2）查找是否有重复的元素，如果有count--
		for(int i=0; i<arr.length; i++){
			//用arr[i]与它后面的元素一一比较，如果有相等的，说明重复了
			//所以j初始化为i+1
			for(int j=i+1; j<count; j++){
				if(arr[i] == arr[j]){//说明有重复的
					//把j后面的元素往前移动
					for(int k=j; k<count-1; k++){//循环的次数，需要移动的个数
						arr[k] = arr[k+1];
					}
					
					count--;
				}
			}
		}
		
		//（3）创建新数组
		int[] newArr = new int[count];
		
		//（4）复制元素，把arr的前面的count个元素复制到新数组中
		for(int i=0; i<count; i++){
			newArr[i] = arr[i];
		}
		
		//（5）显示结果
		for(int i=0; i<newArr.length; i++){
			System.out.print(newArr[i]+ " ");
		}
	}
}