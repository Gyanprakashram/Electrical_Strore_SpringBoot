package com.wipro.electricalstore.model;

import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Product_category
{
	@Id
	private String pCategoryId;
	private String pCategoryName;
	
	@OneToMany(mappedBy = "pcatogery")
	private List<Product_table> ptable;

	public String getpCategoryId() {
		return pCategoryId;
	}

	public void setpCategoryId(String pCategoryId) {
		this.pCategoryId = pCategoryId;
	}

	public String getpCategoryName() {
		return pCategoryName;
	}

	public void setpCategoryName(String pCategoryName) {
		this.pCategoryName = pCategoryName;
	}

	public List<Product_table> getPtable() {
		return ptable;
	}

	public void setPtable(List<Product_table> ptable) {
		this.ptable = ptable;
	}

	public Product_category(String pCategoryId, String pCategoryName, List<Product_table> ptable) {
		super();
		this.pCategoryId = pCategoryId;
		this.pCategoryName = pCategoryName;
		this.ptable = ptable;
	}

	public Product_category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product_category [pCategoryId=" + pCategoryId + ", pCategoryName=" + pCategoryName + ", ptable="
				+ ptable + "]";
	}

	
	
	
	
	
	
	
	
    


}
