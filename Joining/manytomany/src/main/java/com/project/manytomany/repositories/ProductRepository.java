package com.project.manytomany.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.manytomany.models.Product;

@Repository 												
public interface ProductRepository extends CrudRepository<Product,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}