package com.project.Belt2.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Belt2.models.Semester;

@Repository 												
public interface SemesterRepository extends CrudRepository<Semester,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);

	@Query(value="SELECT 'semester' FROM students_semesters WHERE user_id = ?1", nativeQuery=true)
	ArrayList<Semester> getUsersSemesters(Long id);

}
