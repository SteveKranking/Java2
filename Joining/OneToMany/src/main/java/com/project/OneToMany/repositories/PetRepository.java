package com.project.OneToMany.repositories;

import com.project.OneToMany.models.Pet;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface PetRepository extends CrudRepository<Pet,Long>{

}