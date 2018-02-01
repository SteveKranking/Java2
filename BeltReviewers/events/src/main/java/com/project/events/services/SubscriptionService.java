package com.project.events.services;

import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.events.models.Subscription;
import com.project.events.repositories.SubscriptionRepository;


@Service
public class SubscriptionService {

	private SubscriptionRepository _sr;
		
	public SubscriptionService(SubscriptionRepository _sr){
		this._sr = _sr;
	}

	
	
	public void createSubscription(Subscription subscription)  {
		
		_sr.save(subscription);
	}

	public ArrayList<Subscription> getAllSubscriptions() {
		return (ArrayList<Subscription>) _sr.findAll();
	}

	public Subscription findSubscriptionById(Long id) {
		return (Subscription) _sr.findOne(id);
	}

	public void destroy(Subscription subscription) {
		_sr.delete(subscription);
	}
	
}