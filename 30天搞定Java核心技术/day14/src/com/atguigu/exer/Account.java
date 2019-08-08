package com.atguigu.exer;
/*
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，
 * 定义封装这些属性的方法。账号要自动生成。
	编写主类，使用银行账户类，输入、输出3个储户的上述信息。
	考虑：哪些属性可以设计成static属性。

 * 
 * 
 */
public class Account {
	
	private int id;
	private String pwd = "000000";
	private double balance;
	
	private static double interestRate;
	private static double minMoney = 1.0;
	private static int init = 1001;//用于自动生成id使用的
	
	public Account(){
		id = init++;
	}
	
	public Account(String pwd,double balance){
		id = init++;
		this.pwd = pwd;
		this.balance = balance;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public static double getInterestRate() {
		return interestRate;
	}
	public static void setInterestRate(double interestRate) {
		Account.interestRate = interestRate;
	}
	public static double getMinMoney() {
		return minMoney;
	}
	public static void setMinMoney(double minMoney) {
		Account.minMoney = minMoney;
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", pwd=" + pwd + ", balance=" + balance + "]";
	}
	
	
	
}
