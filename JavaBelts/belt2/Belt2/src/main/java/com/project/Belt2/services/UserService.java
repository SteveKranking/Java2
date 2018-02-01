package com.project.Belt2.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Belt2.models.User;
import com.project.Belt2.repositories.UserRepository;
import com.project.Belt2.models.Semester;
import com.project.Belt2.repositories.SemesterRepository;
import com.project.Belt2.services.SemesterService;

@Service
public class UserService {
	// Member variables / service initializations go here
	private UserRepository _ur;
	private BCryptPasswordEncoder bcrypt;
	private SemesterRepository _sr;
		
	public UserService(UserRepository  _ur, SemesterRepository _sr){
		this._ur = _ur;
		this.bcrypt = new BCryptPasswordEncoder();
		this._sr = _sr;
	}

	public boolean isMatch(String password, String dbpass){
		if( bcrypt.matches(password, dbpass) ){
			return true; 
		}
		return false;
	}

	public void create(User user){
		user.setPassword(bcrypt.encode(user.getPassword()));

		SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
		Date springStart = new Date();
		try {
			springStart = a.parse("01/01/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SimpleDateFormat c = new SimpleDateFormat("dd/MM/yyyy");
		Date fallStart = new Date();
		try {
			fallStart = c.parse("01/08/2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user.getCreatedAt().after(springStart) && user.getCreatedAt().before(fallStart)) {

			Semester fall1 = new Semester();
			_sr.save(fall1);
			Semester spring1 = new Semester();
			_sr.save(spring1);
			Semester fall2 = new Semester();
			_sr.save(fall2);
			Semester spring2 = new Semester();
			_sr.save(spring2);

			List<Semester> allSemesters = (List<Semester>)_sr.findAll();
			// List<Semester> semesters = user.getSemesters();
			ArrayList<Semester> semesters = new ArrayList<Semester>();
			for (Semester iSemester: allSemesters) {
				semesters.add(iSemester);
			}
			user.setSemesters(semesters);

		}
	
		
		else {
			
			Semester spring1 = new Semester();
			_sr.save(spring1);
			Semester fall1 = new Semester();
			_sr.save(fall1);
			Semester spring2 = new Semester();
			_sr.save(spring2);
			Semester fall2 = new Semester();
			_sr.save(fall2);

			List<Semester> allSemesters = (List<Semester>)_sr.findAll();
			ArrayList<Semester> semesters = new ArrayList<Semester>();
			for (Semester iSemester: allSemesters) {
				semesters.add(iSemester);
			}
			user.setSemesters(semesters);

		}

		_ur.save(user);
		
	}
	public ArrayList<User> all(){
		return (ArrayList<User>) _ur.findAll();
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
