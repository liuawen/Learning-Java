package com.atguigu.bean;

public class Programmer extends Employee {
	private int memberId;//团队编号     在加入到团队时，才开始分配
	private Status status = Status.FREE;
	private Equipment equipment;
	public Programmer() {
		super();
	}
	public Programmer(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment) {
		super(id, name, age, salary);
		this.memberId = memberId;
		this.status = status;
		this.equipment = equipment;
	}
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	/*
ID     	姓名      年龄    		工资     	 职位      状态      奖金     		 股票    	领用设备
 1      段誉      22        3000.0
 2      令狐冲  32        18000.0  架构师  FREE  15000.0  2000    联想T4(6000.0)
 3      任我行  23        7000.0   程序员  FREE                   戴尔(NEC17寸)
 4      张三丰  24        7300.0   程序员  FREE                   戴尔(三星 17寸)
 5      周芷若  28        10000.0  设计师  FREE  5000.0           佳能 2900(激光)
	 */
	@Override
	public String toString() {
		return getBasicInfo()  +"\t程序员\t" + status + "\t\t\t" + equipment;
	}

	/*
TID/ID  姓名    年龄    	工资    	职位    	奖金   		 股票
 2/4    张三丰  24      7300.0  程序员
 3/2   	 令狐冲  32      18000.0 架构师 	15000.0 2000
 4/6    赵敏    22      6800.0  程序员
 5/12   黄蓉    27      9600.0  设计师        4800.0
	 */
	public String getMemberInfo(){
		return memberId + "/" + getBasicInfo() +"\t程序员";
	}
}
