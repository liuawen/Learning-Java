package com.atguigu.exer3;

public class Circle extends GeometricObject {
	
	private double radius;

	public Circle() {
		super();
		radius = 1.0;
//		color = "white";
//		weight = 1.0;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public Circle(double radius,String color,double weight) {
		super(color,weight);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	//求圆的面积
	public double findArea(){
		return 3.14 * radius * radius;
	}
	//比较两个圆的半径是否相等，如相等，返回true。
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj){
			return true;
		}
		
		if(obj instanceof Circle){
			Circle c = (Circle)obj;
			return this.radius == c.radius;
		}
		
		return false;
		
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	
}
