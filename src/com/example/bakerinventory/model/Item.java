package com.example.bakerinventory.model;

public class Item {
	
	private int id;
	private String name;
	private String brand;
	private int size;
	private String size_unit;
	private String last_check;
	private int amount;
	private int cost;
	
	public Item(){}
	
	public Item(int id, String name, String brand, int size, String size_unit,
			String last_check, int amount, int cost){
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.size_unit = size_unit;
		this.last_check = last_check;
		this.amount = amount;
		this.cost = cost;
	}

	//get & set
	
	
	@Override
	public String toString(){
		return "Item [id=" + id + ", name=" + name + ", brand=" + brand + ", size=" + size + 
				"unit=" + size_unit + ", last check-in/out=" + last_check + 
				", amount=" + amount + ", cost=" + cost+ "php]";
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSize_unit() {
		return size_unit;
	}

	public void setSize_unit(String size_unit) {
		this.size_unit = size_unit;
	}

	public String getLast_check() {
		return last_check;
	}

	public void setLast_check(String last_check) {
		this.last_check = last_check;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
