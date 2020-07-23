package banking7;

/**
 * 代表银行对象
 * @author Think Pad
 *
 */
public class Bank {
	
	//当前 Bank 中有多个 Cutomer
	private Customer[] customers;
	
	//表示 customers 变量中有多少个真正的 Customer 对象
	private int numberOfCustomer;
	
	private Bank() {
		customers = new Customer[5];
	}
	
	private static Bank instance = new Bank();
	
	public static Bank getBank(){
		return instance;
	}
	
	/**
	 * 根据传入的参数创建一个新的 Cusotmer 对象, 并把该对象赋给 customers 中指定的元素
	 * @param firstName
	 * @param lastName
	 */
	public void addCustomer(String firstName, String lastName){
		//1.根据传入的参数创建一个新的 Cusotmer 对象
		Customer cust = new Customer(firstName, lastName);
		
		//2.把 1 新创建的 Customer 对象赋给 customers 中指定的元素
		customers[numberOfCustomer] = cust;
		
		//3. 使表示 customers 变量中有多少个真正的 Customer 对象的整数 + 1
		numberOfCustomer++;
	}
	
	/**
	 * 返回 表示 customers 变量中有多少个真正的 Customer 对象的整数 
	 * @return
	 */
	public int getNumOfCustomers(){
		return numberOfCustomer;
	}
	
	/**
	 * 返回指定索引对应的 Customer 对象
	 * @param index
	 * @return
	 */
	public Customer getCustomer(int index){
		return customers[index];
	}
}
