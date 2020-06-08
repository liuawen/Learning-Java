package banking7;

public class SavingAccount extends Account{

	//ÀûÂÊ
	private double interestRate;
	
	public SavingAccount(double init_balance, double interestRate) {
		super(init_balance);
		this.interestRate = interestRate;
	}

	
	
}
