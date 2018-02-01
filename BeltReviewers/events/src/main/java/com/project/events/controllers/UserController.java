package com.project.events.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.events.models.User;
import com.project.events.repositories.UserRepository;
import com.project.events.models.Subscription;
import com.project.events.services.SubscriptionService;
import com.project.events.services.UserService;
import com.project.events.validators.UserValidator;

@Controller
public class UserController{
	private UserService _us;
	private BCryptPasswordEncoder _bcrypt;
	private UserValidator _uv;
	private SubscriptionService _ss;
	private UserRepository _ur;

	public UserController(UserService _us, UserValidator _uv, SubscriptionService _ss, UserRepository _ur) {
		super();
		this._us = _us;		
		this._bcrypt = new BCryptPasswordEncoder();
		this._uv = _uv;
		this._ss = _ss;
		this._ur = _ur;
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req, HttpSession session){	
		String url = req.getRequestURI().toString();
		if(session.getAttribute("id") != null) {
			return "redirect:/selection";
		}	else {
		return "register";
		}
	}	
	
	@RequestMapping("/register")
	public String register(Model model, @ModelAttribute("user") User user, HttpSession session) {
		session.invalidate();
		return "register";
	}	
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		System.out.println(user.toString());
		_uv.validate(user, result);

		System.out.println(result.getAllErrors());

		if (result.hasErrors()) {
			return "redirect:/register";
		} else {
			_us.createUser(user);
			_us.saveUserWithAdminRole(user);
			session.setAttribute("id", user.getId());
			return "redirect:/selection";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
		return "redirect:/register";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {
		User user = _us.findUserByEmail(email);
		System.out.println("Here's the user we found: " + user.getFirstName());
		if (user == null) {
			return "register";
		} else {
			if (_us.isMatch(password, user.getPassword())) {
				session.setAttribute("id", user.getId());
				return "selection";
			} else {
				return "redirect:/register";
			}
		}
	}

	@RequestMapping("/selection")
	public String showDashboard(Model model, @ModelAttribute("subscription") Subscription subscription, HttpSession session) {
		if (session.getAttribute("id") != null) {
				User user = _us.findUserById((Long) session.getAttribute("id"));
				model.addAttribute("user", user);

				List<Subscription> allSubs = _ss.getAllSubscriptions();
				List<Subscription> allSubscriptions = new ArrayList<>();
				for (Subscription iSubscription : allSubs) {
						allSubscriptions.add(iSubscription);
					
				}
				model.addAttribute("allSubscriptions", allSubscriptions);
				
			return "selection";
		} else {
			return "redirect:/register";
		}
	}

	@PostMapping("/subscribe")
		public String subscribe(Subscription subscription, HttpSession session, Model model, @ModelAttribute("User") User user, BindingResult result) {

		if( result.hasErrors() ){
			return "redirect:/selection";
		}else{
		
		User subscriber= _us.findUserById((Long) session.getAttribute("id"));
		
		_ur.save(subscriber);

		return "redirect:/user/{id}";
		
		}
	}

	@RequestMapping("user/{id}")
	public String showUser(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("user") User user) {
		User currentUser = _us.findUserById(id);
		model.addAttribute("user", currentUser);
		return "showProfile";
	}

	@RequestMapping("/admin")
	public String showAll(Model model, HttpSession session, @ModelAttribute("user") User user,  @ModelAttribute("subscription") Subscription subscription) {
		if (session.getAttribute("id") != null) {
			
			List<User> allTheUsers = _us.getAllUsers();
			List<User> allUsers = new ArrayList<>();
			for (User iUser : allTheUsers) {
					allUsers.add(iUser);
				
			}

			List<Subscription> allSubs = _ss.getAllSubscriptions();
			List<Subscription> allSubscriptions = new ArrayList<>();
			for (Subscription iSubscription : allSubs) {
					allSubscriptions.add(iSubscription);
				
			}

			model.addAttribute("allUsers", allUsers);
			model.addAttribute("allSubscriptions", allSubscriptions);
			return "admin";
		} else {
			return "redirect:/register";
		}
			
		

	}

	@PostMapping("/admin")
	public String addSubscription(@ModelAttribute("subscription") Subscription subscription, BindingResult result, HttpSession session) {
		
		_ss.createSubscription(subscription);
		return "redirect:/admin";
	}

}
