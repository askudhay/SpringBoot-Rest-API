package com.springboot.ex.HateoasExample.Model;

/**
 * Model Class
 * 
 * @author Udhay
 *
 */
public class Product {

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product() {
		super();
	}

	public Product(long productID, String productName) {
		super();
		this.productID = productID;
		this.productName = productName;
	}

	private long productID;
	private String productName;
}
