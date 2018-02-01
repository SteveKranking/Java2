package com.project.LOTBeltReview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.LOTBeltReview.models.User;
import com.project.LOTBeltReview.models.Ring;

import com.project.LOTBeltReview.repositories.UserRepository;
import com.project.LOTBeltReview.repositories.RingRepository;


@Service
public class UserService {

	private UserRepository _ur;
	private RingRepository _rr;
	private BCryptPasswordEncoder _bcrypt;
		
	public UserService(UserRepository _ur, RingRepository _rr){
		this._ur = _ur;
		this._rr = _rr;
		this._bcrypt = new BCryptPasswordEncoder();
	}

	public boolean isMatch(String password, String dbPass) {
		if (_bcrypt.matches(password, dbPass)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void createUser(User user) {
		user.setPassword( _bcrypt.encode(user.getPassword()));
		_ur.save(user);
	}
	
	public void addRing(Long userId, Long ringId) {
		Ring ring = _rr.findOne(userId);
		User user = _ur.findOne(ringId);

		List<Ring> rings = user.getRings();
		rings.add(ring);
		user.setRings(rings);
		_ur.save(user);
	}

}