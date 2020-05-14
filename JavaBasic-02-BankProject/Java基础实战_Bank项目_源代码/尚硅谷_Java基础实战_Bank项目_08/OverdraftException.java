package banking8;

public class OverdraftException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//³à×Ö
	private double deficit;
	
	public double getDeficit() {
		return deficit;
	}
	
	public OverdraftException(String message, double deficit) {
		super(message);
		this.deficit = deficit;
	}
}
