package com.ericlopez.api.repository;

import java.util.ArrayList;

public interface IAgreement {	
	public String getName();
	public void setName(String name);
	public String getSignedBy() ;
	public void setSignedBy(String signedBy);
	public ArrayList<IProduct> getProducts();
	public void setProducts(ArrayList<IProduct> arrayList);
}
