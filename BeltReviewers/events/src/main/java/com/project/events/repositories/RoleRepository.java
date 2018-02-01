package com.project.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.events.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	public List<Role> findByName(String name);
	public List<Role> findAll();
}