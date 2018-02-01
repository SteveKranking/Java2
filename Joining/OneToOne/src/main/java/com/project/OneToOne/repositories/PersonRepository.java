package com.project.OneToOne.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.OneToOne.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}