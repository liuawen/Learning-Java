package com.atguigu.java1;

public class Customer {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Customer() {
		super();
	}
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//自动生成的equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	//重写的原则：比较两个对象的实体内容(即：name和age)是否相同
	//手动实现equals()的重写
//	@Override
//	public boolean equals(Object obj) {
//		
////		System.out.println("Customer equals()....");
//		if (this == obj) {
//            return true;
//        }
//		
//		if(obj instanceof Customer){
//			Customer cust = (Customer)obj;
//			//比较两个对象的每个属性是否都相同
////			if(this.age == cust.age && this.name.equals(cust.name)){
////				return true;
////			}else{
////				return false;
////			}
//			
//			//或
//			return this.age == cust.age && this.name.equals(cust.name);
//		}else{
//			return false;
//			
//		}
//		
//	}
	//手动实现
//	@Override
//	public String toString() {
//		return "Customer[name = " + name + ",age = " + age + "]"; 
//	}
	//自动实现
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
}
