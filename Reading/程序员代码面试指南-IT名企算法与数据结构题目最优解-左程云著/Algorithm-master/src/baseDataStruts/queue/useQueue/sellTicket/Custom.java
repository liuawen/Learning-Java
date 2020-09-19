package queue.useQueue.sellTicket;

/**
 * 顾客，到达、离开时间，排队时间
 * 
 * @author Wangxy
 *
 */
public class Custom {
	// 到达时间，离开时间
	private int arrivalTime, departureTime;

	public Custom(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int totalTime() {
		return departureTime - arrivalTime;
	}
}
