package com.project.login.repositories;

import java.util.List;

import com.project.login.models.Deal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface DealRepository extends CrudRepository<Deal,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
