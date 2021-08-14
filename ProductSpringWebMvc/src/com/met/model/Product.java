package com.met.model;

public class Product {

	private int productNo;
	private double price;
	private int stock;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", price=" + price + ", stock=" + stock + "]";
	}
	
}
