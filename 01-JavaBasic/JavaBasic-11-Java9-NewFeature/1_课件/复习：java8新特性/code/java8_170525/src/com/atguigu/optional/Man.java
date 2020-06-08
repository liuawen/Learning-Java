package com.atguigu.optional;

public class Man {
	
	private Girl girl;

	public Man(Girl girl) {
		super();
		this.girl = girl;
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}

	@Override
	public String toString() {
		return "Man [girl=" + girl + "]";
	}

	public Man() {
		super();
	}
	
}
