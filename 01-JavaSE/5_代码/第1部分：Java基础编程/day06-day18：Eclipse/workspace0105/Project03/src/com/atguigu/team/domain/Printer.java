package com.atguigu.team.domain;

public class Printer implements Equipment{
	private String name;//名称
	private String type;//机器的类型
	
	public Printer() {
		super();
	}

	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getDescription() {
		return name + "(" + type + ")";
	}
	
	

}
