package com.project.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}