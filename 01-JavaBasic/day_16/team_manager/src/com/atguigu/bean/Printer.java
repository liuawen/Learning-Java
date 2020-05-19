package com.atguigu.bean;

public class Printer implements Equipment{
	private String type;
	private String name;
	public Printer(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	public Printer() {
		super();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return getDescription();
	}
	@Override
	public String getDescription() {
		//佳能 2900(激光)
		return name + "(" + type + ")";
	}
	
}
