package com.atguigu.bean;

public class Architect extends Designer{
	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public Architect(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment,
			double bonus, int stock) {
		super(id, name, age, salary, memberId, status, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
		return getBasicInfo() + "\t架构师\t" + getStatus() + "\t" + getBonus() +"\t" +stock+ "\t" + getEquipment();
	}
	/*
TID/ID  姓名    年龄    	工资    	职位    	奖金   		 股票
 2/4    张三丰  24      7300.0  程序员
 3/2   	 令狐冲  32      18000.0 架构师 	15000.0 2000
 4/6    赵敏    22      6800.0  程序员
 5/12   黄蓉    27      9600.0  设计师        4800.0
	 */
	public String getMemberInfo(){
		return getMemberId() + "/" + getBasicInfo() +"\t架构师\t" + getBonus() + "\t" + stock;
	}	
}
