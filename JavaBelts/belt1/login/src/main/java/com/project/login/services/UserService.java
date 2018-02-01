package com.project.login.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.login.models.User;
import com.project.login.repositories.DealRepository;
import com.project.login.repositories.UserRepository;;

@Service
public class UserService {
	// Member variables / service initializations go here
	private UserRepository _ur;
	private BCryptPasswordEncoder bcrypt;
	private DealRepository _dr;
		
	public UserService(UserRepository  _ur, DealRepository _dr){
		this._ur = _ur;
		this._dr = _dr;
		this.bcrypt = new BCryptPasswordEncoder();
	}

	public boolean isMatch(String password, String dbpass){
		if( bcrypt.matches(password, dbpass) ){
			return true; 
		}
		return false;
	}

	public void create(User user){
		System.out.println("Your user is 1" + user.getPassword());
		user.setPassword(bcrypt.encode(user.getPassword()));
		System.out.println("Your user is 2" + user);
		List<User>users =(List<User>) _ur.findAll();
		if(users.size() == 0 ){
			user.setAdmin(true);
		}else{
			user.setAdmin(false);
		}
		user.setDueDate(1);
		_ur.save(user);
		
	}
	public ArrayList<User> all(){
		return (ArrayList<User>) _ur.findAll();
	}
	public void setFullDate(User user, String date){
		user.setFullDate(date);
		_ur.save(user);
	}
	public void update(User user){
		create(user);
	}
	public User findById(Long id){
		return (User) _ur.findOne(id);
	}
	public void destroy(User user){
		_ur.delete(user);
	}
	public User findByEmail(String email){
		return (User) _ur.findByEmail(email);
	}
	
	// Crud methods to act on services go here.
}
