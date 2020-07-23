package banking6;

public class CheckingAccount extends Account{

	//表示透支保护
	private double overdraftProtection;
	
	public CheckingAccount(double init_balance) {
		super(init_balance);
	}
	
	public CheckingAccount(double init_balance, double overdraftProtection){
		super(init_balance);
		this.overdraftProtection = overdraftProtection;
	}
	
	/**
	 * 重写 withdraw 方法； 
	 * 
	 * 此方法必须执行下列检查。如果当前余额足够弥补取款amount,则正常进行。
	 * 如果不够弥补但是存在透支保护，则尝试用overdraftProtection得值来弥补该差值（balance-amount）.
	 * 如果弥补该透支所需要的金额大于当前的保护级别。则整个交易失败，但余额未受影响。
	 * 
	 */
	@Override
	public boolean withdraw(double amt) {
		if(balance >= amt){
			balance -= amt;
		}else{
			if(overdraftProtection >= (amt - balance)){
				overdraftProtection -= (amt - balance);
				balance = 0;
			}else{
				return false;
			}
		}
		
		return true;
	}
	
}
