package com.atguigu.java8;

public class Godness {

	private String name;

	public Godness() {
	}

	public Godness(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Godness [name=" + name + "]";
	}

}
