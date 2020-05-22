package com.atguigu.test06.homework04;

/*
 * 案例：

​	1、创建一个银行账户类，

​	（1）属性：账号，余额，

​	（2）get/set，

​	（3）toString()：返回：账户：xxx，余额：xxx

​	2、创建一个丈夫类

​		负责往里存钱，每次存款[0,10000)以内不等

​	3、创建一个妻子类

​		负责取钱，每次取款[0,10000)以内不等，如果余额不足，要等丈夫存够了才能取
 */
public class Test04 {
	public static void main(String[] args) {
		Account a = new Account("1122", 0);
		AccountManager am = new AccountManager(a);
		Husband h = new Husband("崔志恒",am);
		Wife w = new Wife("甄玉禄",am);
		
		h.start();
		w.start();
	}
}
class Husband extends Thread{
	private AccountManager am;

	public Husband(String name,AccountManager am) {
		super(name);
		this.am = am;
	}

	public void run(){
		while(true){
			am.save();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Wife extends Thread{
	private AccountManager am;

	public Wife(String name,AccountManager am) {
		super(name);
		this.am = am;
	}
	public void run(){
		while(true){
			am.withdraw();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class AccountManager{
	private Account account;
	
	public AccountManager(Account account) {
		super();
		this.account = account;
	}

	public synchronized void save(){
		double money = Math.random() * 10000;
		System.out.println(Thread.currentThread().getName() + "开始存钱，目前账户状态：" + account);
		System.out.println("本次存钱的数量是：" + money);
		account.setBalance(account.getBalance() + money);
		System.out.println(Thread.currentThread().getName() +  "存钱结束，目前账户状态： " + account);
		this.notify();
	}
	
	public synchronized void withdraw(){
		double money = Math.random() * 10000;
		System.out.println(Thread.currentThread().getName() + "开始取钱，目前账户状态：" + account);
		while(money > account.getBalance()){
			try {
				System.out.println("本次想取钱的数量是：" + money + "，余额不足....");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		account.setBalance(account.getBalance() - money);
		System.out.println(Thread.currentThread().getName() +  "取钱结束，目前账户状态： " + account);
	}
}

class Account{
	private String id;
	private double balance;
	public Account(String id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		//账户：xxx，余额：xxx
		return "账户： " + id +"余额：" + balance;
	}
	
}