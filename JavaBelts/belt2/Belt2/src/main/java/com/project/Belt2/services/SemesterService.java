package com.project.Belt2.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Belt2.repositories.SemesterRepository;
import com.project.Belt2.repositories.UserRepository;
import com.project.Belt2.models.User;
import com.project.Belt2.services.UserService;
import com.project.Belt2.repositories.UserRepository;
import javax.servlet.http.HttpSession;

import com.project.Belt2.models.Semester;

@Service
public class SemesterService {
	// Member variables / service initializations go here

	private SemesterRepository _sr;
	private UserRepository _ur;
	private UserService _us;
	

	public SemesterService(SemesterRepository _sr, UserRepository _ur, UserService _us){
		this._sr = _sr;
		this._us = _us;
		this._ur = _ur;
	}

	public List<Semester> getAllSemesters() {
		return (List<Semester>) _sr.findAll();
	}
	
	public void createSemester(Semester semester) {
		_sr.save(semester);
	}

	public ArrayList<Semester> findSemesters(Long id) {
		return  _sr.getUsersSemesters(id);
	}
	
	// Crud methods to act on services go here.
}
