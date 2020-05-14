package banking1;

public class Account {

	private double balance;
	
	public Account(double init_balance){
		this.balance = init_balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	/**
	 * 存钱方法
	 * @param amt: 存款的钱数
	 */
	public void deposit(double amt){
		this.balance += amt;
	}
	
	/**
	 * 取钱方法
	 * @param amt: 取款的钱数
	 */
	public void withdraw(double amt){
		this.balance -= amt;
	}
	
}
