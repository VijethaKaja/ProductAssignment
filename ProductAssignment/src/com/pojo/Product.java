package com.pojo;

public class Product {

	private int pID;
	private String pName;
	private double price;
	private int quantity;
	private String category;

	public Product() {
		super();
	}

	public Product(int pID, String pName, double price, int quantity, String category) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pID=" + pID + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}

}