package com.project.Belt2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Belt2.models.Class;

@Repository 												
public interface ClassRepository extends CrudRepository<Class,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
