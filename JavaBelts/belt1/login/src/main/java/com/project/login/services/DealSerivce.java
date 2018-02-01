package com.project.login.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.login.models.Deal;
import com.project.login.models.User;
import com.project.login.repositories.DealRepository;
import com.project.login.repositories.UserRepository;

@Service
public class DealSerivce {
	// Member variables / service initializations go here

	private UserRepository _ur;
	private DealRepository _dr;
		
	public DealSerivce(UserRepository _ur, DealRepository _dr){
		this._ur = _ur;
		this._dr = _dr;
	}
	
	public List<Deal> getAllDeals(){
		return(List<Deal>)_dr.findAll();
	}
	public void createdeal(Deal deal){
		deal.setActive(true);
		_dr.save(deal);
	}
	public void destroy(Deal deal){
		_dr.delete(deal);
	}
	public Deal findOne(Long id){
		return(Deal) _dr.findOne(id);
	}
	public void deactivate(Deal deal){
		deal.setActive(false);
		_dr.save(deal);

	}
	public void activate(Deal deal){
		deal.setActive(true);
		_dr.save(deal);
	}

	public void setUser(User user, Deal deal, int date){
		Date now = new Date();
		user.setOwed(now);
		user.setDueDate(date);
		user.setDeal(deal);
		_ur.save(user);
	}
	// Crud methods to act on services go here.
}
