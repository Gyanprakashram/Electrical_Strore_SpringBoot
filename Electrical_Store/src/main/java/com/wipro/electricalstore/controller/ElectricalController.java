package com.wipro.electricalstore.controller;


import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.electricalstore.model.City;
import com.wipro.electricalstore.model.Dealer;
import com.wipro.electricalstore.model.Product_category;
import com.wipro.electricalstore.model.Product_table;
import com.wipro.electricalstore.model.State;
import com.wipro.electricalstore.repository.CityRepo;
import com.wipro.electricalstore.repository.DealerRepo;
import com.wipro.electricalstore.repository.ProductCatRepo;
import com.wipro.electricalstore.repository.StateRepo;
import com.wipro.electricalstore.service.ElectricalService;


@RestController
public class ElectricalController
{
	@Autowired
	ElectricalService eservice;

	
	@Autowired
	private StateRepo srepo;
	
	@Autowired
	private CityRepo crepo;
	
	@Autowired
	private ProductCatRepo pcrepo;
	
	@Autowired
	private DealerRepo drepo;
	
	
	
//	@Autowired
//	private Product_table ptrepo;
	
	//adding data for both state and city
	@PostMapping("AddCity")
	public ResponseEntity<String>addCity(@RequestBody City city)
	{
		
		crepo.save(city);
		return new ResponseEntity<>("Data Stored successfully",HttpStatus.OK);
	}
	
	//adding data for  state 
	@PostMapping("addState")
	public ResponseEntity<String>addState(@RequestBody State state)
	{
		srepo.save(state);
		return new ResponseEntity<>("Data Stored successfully",HttpStatus.OK);
	}
	
	//Add product category table
	@PostMapping("Addprocategory")
	public ResponseEntity<String> addProCategory(@RequestBody Product_category pcat )
	{
		
		pcrepo.save(pcat);
		return new ResponseEntity<>("Product data inserted succesfully",HttpStatus.OK);
	}
	
	//Add dealer details with StateId and CityId
	@PostMapping("/AddDealers")
	public ResponseEntity<String> AddDealer(@RequestBody Dealer dealer) 
	{
		
		
		drepo.save(dealer);
		
		return new ResponseEntity<>(" Dealer Data inserted successfully",HttpStatus.OK);
		
	}
	
	//Add product details corresponding to product category and dealer
	
		@PostMapping("addprowithdealerandcat")
		public ResponseEntity<String> AddProductDetails( @RequestParam int dealerId,@RequestParam String pcatid,@RequestBody Product_table ptable)
		{
//		
			System.out.println(ptable);
			//eservice.registerDealer(ptable);
			eservice.addProduct(ptable,dealerId,pcatid);
			
			return new ResponseEntity<>("Data saved successfully ",HttpStatus.OK);
			
		}
	
		@PostMapping("/AddDealersDetails")
		public ResponseEntity<String> registerDealer(@RequestBody Dealer dealer) 
		{

			
			eservice.registerDealer(dealer);
			
			
			return new ResponseEntity<>("Dealer Details inserted successfully",HttpStatus.OK);
			
		}
		
		
		@GetMapping("/getdealerbystateandcity")
		public ResponseEntity<?> getCityAndState(@RequestParam("stateName") String stateName,@RequestParam("cityName") String cityName) throws AccountNotFoundException
		{
		List<Dealer> dealer=eservice.getDealerByStateAndCity(stateName, cityName);
		
		if(dealer.isEmpty())
		{
			throw new AccountNotFoundException("Sorry!  no data is availabe");
		}
		
		
			return new ResponseEntity<>(dealer,HttpStatus.OK);
		
		}
	
		@GetMapping("getdeailsbyname")
		public ResponseEntity<List<Product_table>> getDetialsbyName(@RequestParam("dealerName") String dealerName) throws AccountNotFoundException
		{
			
			
			List<Product_table> ptable=eservice.getProductByDealerName(dealerName);
			if(ptable.isEmpty())
			{
				throw new AccountNotFoundException("Sorry! no data is found as "+dealerName);
			}
			return new ResponseEntity<>(ptable,HttpStatus.OK);
			
			
			//return new ResponseEntity<List<Product_table>> (eservice.getProductByDealerName(dealerName),HttpStatus.OK);	
			
		}
		
		@GetMapping("getDeailsbyState")
		public ResponseEntity<List<Dealer>> getDetailsByStateName(@RequestParam("stateName") String stateName) throws AccountNotFoundException
		{
			List<Dealer> d=eservice.getDealerByStateName(stateName);
			if(d.isEmpty())
			{
				throw new AccountNotFoundException("Sorry no data found where state name is-"+stateName);
			}
			return new ResponseEntity<>(d,HttpStatus.OK);
			
		}
		

}
