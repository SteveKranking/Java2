package com.project.OneToOne.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.OneToOne.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

}