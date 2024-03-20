package com.wipro.electricalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.electricalstore.model.Product_category;

public interface ProductCatRepo extends JpaRepository<Product_category,String>
{

}
