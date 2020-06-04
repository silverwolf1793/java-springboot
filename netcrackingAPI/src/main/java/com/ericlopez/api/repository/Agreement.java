package com.ericlopez.api.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class Agreement  implements IAgreement{

	private String name = "";
	private String signedBy = "";
	private ArrayList<IProduct> products = new ArrayList<IProduct>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public ArrayList<IProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<IProduct> products) {
		this.products = products;
	}


}
