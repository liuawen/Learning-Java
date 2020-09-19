package queue.useQueue.sellTicket;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 模拟创建一个顾客队列，设置不同数量的售票口，比较处理100个顾客的时间
 * 
 * @author Wangxy
 *
 */
public class TicketCounter {
	final static int PROCESS = 120;// 表示顾客从进门到走到售票口买票的时间
	final static int MAX_CASHIERS = 10;// 最大售票口数量
	final static int MAX_CUSTOMERS = 100;// 顾客数量

	public static void main(String[] args) {
		Custom customer;
		Queue<Custom> customQueue = new LinkedList<Custom>();// 顾客队列
		int[] cashierTime = new int[MAX_CASHIERS];
		int totalTime, averageTime, departs, start;
		// 模拟1-10个售票口的售票情况
		for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {
			// 初始化当前售票窗口的时间
			for (int count = 0; count < cashiers; count++) {
				cashierTime[count] = 0;
			}
			// 初始化每位顾客的抵达时间
			for (int count = 1; count <= MAX_CUSTOMERS; count++) {
				customQueue.add(new Custom(count * 15));
			}
			// 初始化总时间
			totalTime = 0;
			// 顾客依次进队，计算时间
			while (!(customQueue.isEmpty())) {
				// 将顾客分散到售票口
				for (int count = 0; count <= cashiers; count++) {
					if (!customQueue.isEmpty()) {
						customer = customQueue.remove();
						// 开始处理该顾客的时间
						if (customer.getArrivalTime() > cashierTime[count])// 当前售票口的时间
							start = customer.getArrivalTime();
						else
							start = cashierTime[count];
						// 处理完该顾客的时间
						departs = start + PROCESS;
						customer.setDepartureTime(departs);
						cashierTime[count] = departs;
						totalTime += customer.totalTime();
					}
				}
			}
			averageTime = totalTime / MAX_CUSTOMERS;
			System.out.println("售票口的数量 ：                 " + (cashiers + 1));
			System.out.println("平均处理时间 ：                 " + averageTime);

		}

	}

}
