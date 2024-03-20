package com.wipro.electricalstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.electricalstore.model.City;
import com.wipro.electricalstore.model.Dealer;
import com.wipro.electricalstore.model.Product_category;
import com.wipro.electricalstore.model.Product_table;
import com.wipro.electricalstore.repository.CityRepo;
import com.wipro.electricalstore.repository.DealerRepo;
import com.wipro.electricalstore.repository.ProductCatRepo;
import com.wipro.electricalstore.repository.ProductTableRepo;
import com.wipro.electricalstore.repository.StateRepo;
import com.wipro.electricalstore.model.State;


@Service
public class ElectricalService
{
	
	@Autowired
	DealerRepo drepo;
	
	@Autowired
	ProductCatRepo prepo;
	
	@Autowired
	ProductTableRepo ptrepo;
	
	@Autowired
	StateRepo srepo;
	
	@Autowired
	CityRepo crepo;
	
	
	//1st method solution
	public Product_table addProduct(Product_table ptable,int dealerId,String pcatid)
	{
//		Product_table pt = ptrepo.getById(ptable.get)
		@SuppressWarnings("deprecation")
		Dealer dealer = drepo.getById(dealerId);
		@SuppressWarnings("deprecation")
		Product_category pcat = prepo.getById(pcatid);
		ptable.setDealer(dealer);
		ptable.setPcatogery(pcat);
		return ptrepo.save(ptable);
	}
	
	//2nd Store the dealer details
	public Dealer registerDealer(Dealer dealer)
	{
		
		return drepo.save(dealer);
		
	}

	//GEt details using state and city name
	public List<Dealer> getDealerByStateAndCity(String stateName,String cityName)
	{
		
		//return drepo.findByStateStateNameAndCityCityName(stateName, cityName);
		
		State state=srepo.findByStateName(stateName);
		//System.out.println(state);
		City city=crepo.findByCityName(cityName);
		//System.out.println(city);
		List<Dealer> dealer1=drepo.findByStateAndCity(state, city);
		return dealer1;
		
		
	}
	
	//GEt details using dealer name
	public List<Product_table> getProductByDealerName(String dealerName)
	{
		Dealer d=drepo.findByDealerName(dealerName);
		System.out.println(d);
		List<Product_table> pt1=ptrepo.findByDealer(d);
		return pt1;
		
	}
	
//	Get Details using State name
	public List<Dealer> getDealerByStateName(String stateName)
	{
		State s=srepo.findByStateName(stateName);
		System.out.println(s);
		List<Dealer> d1=drepo.findByState(s);
		
		return d1;
	}

}
