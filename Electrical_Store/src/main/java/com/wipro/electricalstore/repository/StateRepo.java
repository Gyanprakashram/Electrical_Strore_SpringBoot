package com.wipro.electricalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.electricalstore.model.State;

public interface StateRepo extends JpaRepository<State,Integer>
{
	public State findByStateName(String stateName);

}
