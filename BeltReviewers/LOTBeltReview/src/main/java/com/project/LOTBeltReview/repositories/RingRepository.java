package com.project.LOTBeltReview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.LOTBeltReview.models.Ring;

@Repository 												
public interface RingRepository extends CrudRepository<Ring,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
