package com.project.OneToMany.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.project.OneToMany.models.User;
import com.project.OneToMany.repositories.UserRepository;

@Service
public class UserService {
	// Member variables / service initializations go here
	private UserRepository userRepository;
		
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public void create(User user){
		userRepository.save(user);
	}

	public ArrayList<User> all(){
		return (ArrayList<User>)userRepository.findAll();
	}
	
	public User findById(long id){
		return userRepository.findOne(id);
	}

	public void destroy(long id){
		userRepository.delete(id);
	}

	// Crud methods to act on services go here.
}