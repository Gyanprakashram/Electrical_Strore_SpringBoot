package com.wipro.electricalstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.electricalstore.model.Dealer;
import com.wipro.electricalstore.model.Product_table;

public interface ProductTableRepo extends JpaRepository<Product_table,String>
{
	List<Product_table> findByDealer(Dealer dealer);

}
