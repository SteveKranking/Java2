package com.project.Belt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Belt.models.Subscription;

@Repository 												
public interface SubscriptionRepository extends CrudRepository<Subscription, Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
