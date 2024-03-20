package com.wipro.electricalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.electricalstore.model.City;

public interface CityRepo extends JpaRepository<City,Integer>
{
	public City findByCityName(String cityName);

}
