package com.project.LOTBeltReview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.LOTBeltReview.models.Ring;
import com.project.LOTBeltReview.models.User;

import com.project.LOTBeltReview.repositories.RingRepository;


@Service
public class RingService {
	// Member variables / service initializations go here
	private RingRepository _rr;
		
	public RingService(RingRepository _rr){
		this._rr = _rr;

	}

	public void createRing(Ring ring, User user, String name)  {

		ring.setUser(user);
		ring.setRingName(name);
		_rr.save(ring);

	}
	
	public List<Ring> getAllRings() {
		return (List<Ring>) _rr.findAll();
	}

	public Ring findOne(Long id) {
		return (Ring) _rr.findOne(id);
	}
	
	// Crud methods to act on services go here.
}
