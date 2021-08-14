package com.met.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity(name="invoices")
@Immutable
public class InvoiceEntry{
	
	@Id
	@Column(name="ord_no")
	private int orderNo;
	
	@Column(name="ord_date")
	private java.sql.Date orderDate;
	
	@Column(name="pno")
	private int productNo;
	
	@Column(name="qty")
	private int quantity;
	
	@Column(name="amt")
	private double amount;

	@Column(name="CUST_ID")
	private String custId;
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

}
