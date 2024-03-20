package com.wipro.electricalstore.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.electricalstore.model.City;
import com.wipro.electricalstore.model.Dealer;

import com.wipro.electricalstore.model.State;

public interface DealerRepo extends JpaRepository<Dealer,Integer>
{
	//List<Dealer> findByStateStateNameAndCityCityName(String stateName,String cityName);
	List<Dealer> findByStateAndCity(State state, City city);
	Dealer findByDealerName(String dealerName);
	
//	List<Dealer> findDealerByCityName(String cityname);
	List<Dealer> findByState(State s);




}
