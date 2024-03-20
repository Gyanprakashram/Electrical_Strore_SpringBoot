package com.wipro.electricalstore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product_table
{
	@Id
	
	private String productId;
	private String pName;
	private Long price;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	 @JsonIgnore
	@JoinColumn(name="product_category_id")
	private Product_category pcatogery;
	
	@ManyToOne(cascade = CascadeType.ALL)
	 @JsonIgnore
	@JoinColumn(name="dealer_id")
	private Dealer dealer;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product_category getPcatogery() {
		return pcatogery;
	}

	public void setPcatogery(Product_category pcatogery) {
		this.pcatogery = pcatogery;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Product_table(String productId, String pName, Long price, int quantity, Product_category pcatogery,
			Dealer dealer) {
		super();
		this.productId = productId;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.pcatogery = pcatogery;
		this.dealer = dealer;
	}

	public Product_table() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product_table [productId=" + productId + ", pName=" + pName + ", price=" + price + ", quantity="
				+ quantity + ", pcatogery=" + pcatogery + ", dealer=" + dealer + "]";
	}

	
	

	
	

	
}
