package com.bitwise.pizzashop;

public abstract class Item {
	
	private String name;
	private double price;
	

	public Item(String name, double price) {
		this.name = name;
		this.price= price;
	}


	public abstract double getItemPrice();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
}
