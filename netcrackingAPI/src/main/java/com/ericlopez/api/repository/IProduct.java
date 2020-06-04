package com.ericlopez.api.repository;

import java.util.ArrayList;


public interface IProduct {
	public Object getParentObject();
	public void setParentObject(Object parentObject);
	public ArrayList<IProduct> getProducts();
	public void setProducts(ArrayList<IProduct> products);
	public String getName();
	public void setName(String name);
	public Number getPrice();
	public void setPrice(String price);
}
