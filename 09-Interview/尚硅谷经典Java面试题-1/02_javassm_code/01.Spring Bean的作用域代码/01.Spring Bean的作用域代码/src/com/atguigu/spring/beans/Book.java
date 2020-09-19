package com.atguigu.spring.beans;

public class Book {

	private Integer id;
	private String title;
	private String author;
	private double price;
	private Integer sales;

	public Book() {
		System.out.println("Book对象被创建了");
	}

	public Book(Integer id, String title, String author, double price, Integer sales) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		System.out.println("全参的构造器被调用");
	}

	public Book(Integer id, String title, String author, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		System.out.println("不含销量的构造器被调用");
	}

	public Book(Integer id, String title, String author, Integer sales) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.sales = sales;
		System.out.println("不含价格的构造器被调用");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", sales=" + sales
				+ "]";
	}

}
