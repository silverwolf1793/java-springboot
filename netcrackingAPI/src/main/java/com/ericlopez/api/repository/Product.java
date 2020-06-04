package com.ericlopez.api.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class Product implements IProduct{

	private Object parentObject;
	private ArrayList<IProduct> products;
	private String name ;
	private Number price ;
	
	public Product() {
        this.products = new ArrayList<IProduct>();
        this.name = "";
        this.price = 0.0;
    }

	public Object getParentObject() {
		return parentObject;
	}

	public void setParentObject(Object parentObject) {
		this.parentObject = parentObject;
	}

	public ArrayList<IProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<IProduct> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getPrice() {
		return price;
	}

	//this function its simple too, it just iterates over the string
	//if it finds anything but a comma or a number it discards it,
	//the comma its used for decimal placement and it uses the first
	//it finds, the others get discarded, we could easily add 
	//also the dot for decimal places, but having mixed nomenclature its
	//bad practice.
	public void setPrice(String price) {
		String integers = "";
		String decimals = "";
		boolean inDecimal = false;
		
		for (char c : price.toCharArray()) {
			if(Character.isDigit(c) && !inDecimal) 
				integers += c;
			else if (c == ',')
				inDecimal = true;
			else if(Character.isDigit(c) && inDecimal)
				decimals += c;
		}
		
		this.price = Float.parseFloat(integers+"."+decimals);
	}
	
	

}
