package com.wipro.electricalstore.model;


//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dealer 
{
	@Id

	private int dealerId;
	private String dealerName;
	private Long phoneNo;
	private String address;
	
	@ManyToOne
     //@JsonIgnoreProperties(value = {"state","city","dealer"})
	
	@JoinColumn(name="state_id")
	private State  state;
	
	@ManyToOne
	//@JsonIgnoreProperties(value = {"state","city","dealer"})
	@JoinColumn(name="city_id")
	private City city;
	
	


	
	
	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Dealer(int dealerId, String dealerName, Long phoneNo, String address, State state, City city) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.state = state;
		this.city = city;
	}

	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", phoneNo=" + phoneNo + ", address="
				+ address + ", state=" + state + ", city=" + city + "]";
	}
	
	

	

}
