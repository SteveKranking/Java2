package com.project.OneToMany.repositories;

import com.project.OneToMany.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{

}