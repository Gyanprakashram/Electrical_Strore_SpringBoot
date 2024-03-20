package com.wipro.electricalstore.model;

//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;

@Entity
public class State 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stateId;
	private String stateName;
	
//	@OneToMany(mappedBy = "state")
//	@JsonIgnoreProperties(value = {"state"})
//	private List<City> city;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

//	public List<City> getCity() {
//		return city;
//	}
//
//	public void setCity(List<City> city) {
//		this.city = city;
//	}

	public State(int stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		//this.city = city;
	}

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + "]";
	}

	
	
	

}
