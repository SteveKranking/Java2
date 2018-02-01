package com.project.Belt.controllers;

import java.security.Principal;
import java.util.Date;

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

import com.project.Belt.models.User;
import com.project.Belt.services.UserService;
import com.project.Belt.validators.UserValidator;
import com.project.Belt.models.Subscription;

@Controller
public class UserController{
	private UserService _us;

	private BCryptPasswordEncoder _bcrypt;
	private UserValidator _uv;


	public UserController(UserService _us, UserValidator _uv) {
		this._us = _us;		
		this._bcrypt = new BCryptPasswordEncoder();
		this._uv = _uv;

	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req, HttpSession session){	
		String url = req.getRequestURI().toString();
		if(session.getAttribute("id") != null) {
			return "redirect:/register";
		}	else {
		return "redirect:/register";
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
		if (result.hasErrors()) {
			return "register";
		} else {
			_us.createUser(user);
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
			return "redirect:/registration";
		} else {
			if (_us.isMatch(password, user.getPassword())) {
				System.out.println(_us.isMatch(password, user.getPassword()));
				session.setAttribute("id", user.getId());
				System.out.println("User in session has the following ID: " + session.getAttribute("id"));
				return "redirect:/selection";
			} else {
				return "redirect:/register";
			}
		}
	}
}
