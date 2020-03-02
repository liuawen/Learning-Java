package banking8;

public class Account {

	protected double balance;
	
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
	 * 
	 * @param amt
	 * @throws OverdraftException: 当余额不足时，抛出该异常. 
	 */
	public void withdraw(double amt) {

		if(amt > balance){
			throw new OverdraftException("资金不足", amt - balance);
		}
		
		this.balance -= amt;
	}
	
}
