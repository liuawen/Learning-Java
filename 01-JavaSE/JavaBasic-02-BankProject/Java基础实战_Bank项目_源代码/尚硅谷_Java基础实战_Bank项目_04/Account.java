package banking4;

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
	 * @return: 返回存款是否成功
	 */
	public boolean deposit(double amt){
		this.balance += amt;
		return true;
	}
	
	/**
	 * 取钱方法
	 * @param amt: 取款的钱数
	 * @return: 返回取款是否成功
	 */
	public boolean withdraw(double amt){

		if(amt > balance){
			return false;
		}
		
		this.balance -= amt;
		return true;
	}
	
}
