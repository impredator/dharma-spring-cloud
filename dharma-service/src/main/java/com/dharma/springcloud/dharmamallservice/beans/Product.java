package com.dharma.springcloud.dharmamallservice.beans;

public class Product {

	private int id;
	private String name;
	private Double price;

	public Product() {

    }

    public Product(int id, String name, Double price) {
		super();
		this.id=id;
		this.name=name;
		this.price = price;
	}

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", id=" + id + "]";
	}

}
