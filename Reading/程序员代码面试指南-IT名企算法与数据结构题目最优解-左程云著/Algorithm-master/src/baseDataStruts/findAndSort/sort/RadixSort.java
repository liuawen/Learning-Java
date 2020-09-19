package findAndSort.sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基数排序，不是基于比较的，
 * @author Dell
 *
 */
public class RadixSort {
	
	/**
	 * 对十进制数进行排序
	 * 排序关键字（），基数（队列的数目）
	 */
	public static void main(String[] args) {
		int[] list={8754,6458,7851,3569,1278,4871,2486,9745,4521,4707,3164,7415,5730,2079,5784};
		
		Queue<Integer>[] queue=(LinkedList<Integer>[])(new LinkedList[10]);
		for(int i=0;i<queue.length;i++){//初始化队列，
			queue[i]=(Queue<Integer>)(new LinkedList<Integer>());
		}
		//对四位数基数排序
		for(int pos=3;pos>=0;pos--){
			//取出对应位置上的数字，放到对应的队列中
			for(int count=0;count<list.length;count++){
				String element=String.valueOf(list[count]);
				int key=Character.digit(element.charAt(pos), 10);
				queue[key].add(list[count]);
			}
			int num=0;//记录元素应该放的位置
			//将队列中的元素依次取出，放到list中
			for(int q=0;q<queue.length;q++){
				while(!queue[q].isEmpty()){
					list[num]=queue[q].remove();
					num++;
				}
			}
		}
		
		//将排好序的输出
		for(int q=0;q<list.length;q++){
			System.out.print(list[q]+"     ");
		}
	}
}
