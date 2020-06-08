package com.atguigu.bean;


public class Book {

	private int id;
	private String name;
	private String author;
	private double price;
	private int sales;
	private int stock;
	private String imgPath = "static/img/default.jpg";

	public Book() {
		super();
	}

	public Book(int id, String name, String author, double price, int sales, int stock,
			String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		if (imgPath != null) {
			this.imgPath = imgPath;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price
				+ ", sales=" + sales + ", stock=" + stock + ", imgPath=" + imgPath + "]";
	}

}
