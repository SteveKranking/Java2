package com.project.login.controllers;

import com.project.login.models.User;
import com.project.login.repositories.UserRepository;
import com.project.login.services.DealSerivce;
import com.project.login.services.UserService;
import com.project.login.validators.UserValidator;
import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController{
	private UserService _us;
	private UserValidator _uv;
	private DealSerivce _ds;

	public UserController(UserService _us, UserValidator _uv, DealSerivce _ds){
		this._us = _us;
		this._uv =_uv;
		this._ds = _ds;

	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user, HttpSession s){
		s.setAttribute("id", null);
		return "register";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession s){
		s.setAttribute("id", null);
		return "redirect:/";
	}

	@PostMapping("/register")
	public String creater(@Valid @ModelAttribute("user") User user, BindingResult res, HttpSession session){
		_uv.validate(user, res);
		if(res.hasErrors()){
			return "register";
		}else{
			System.out.println("Your user is 0" + user);
			_us.create(user);
			session.setAttribute("id", user.getId());
			return "redirect:/dashboard";
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password")String password, HttpSession session){
		User user = _us.findByEmail(email);
		if(user == null){
			return "redirect:/";
		}else{
			if( _us.isMatch(password, user.getPassword()) ){
				session.setAttribute("id", user.getId());
				return "redirect:/dashboard";

			}else{
				return "redirect:/";
			}
		}
 
	}
}
