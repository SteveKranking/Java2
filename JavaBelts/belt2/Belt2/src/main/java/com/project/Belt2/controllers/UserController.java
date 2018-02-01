package com.project.Belt2.controllers;

import com.project.Belt2.models.User;
import com.project.Belt2.repositories.UserRepository;
import com.project.Belt2.services.SemesterService;
import com.project.Belt2.services.UserService;
import com.project.Belt2.validators.UserValidator;
import java.security.Principal;
import java.util.ArrayList;
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
public class UserController<Semester>{
	private UserService _us;
	private UserValidator _uv;
	private SemesterService _ss;

	public UserController(UserService _us, UserValidator _uv, SemesterService _ss){
		this._us = _us;
		this._uv =_uv;
		this._ss = _ss;

	}

	//login reg controller methods
	
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
			return "redirect:/register";
		}else{
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

	//dashboard controller methods

	@RequestMapping("/dashboard")
	public String dashboard(HttpSession s, Model model){
		User user = _us.findById((Long)s.getAttribute("id"));
		Long thisId = (Long)s.getAttribute("id");
		if(s.getAttribute("id")!= null){
			//show 4 semesters dropdown
			//show classes within chosen semester
			ArrayList<Semester> usersSemesters = _ss.findSemesters(thisId);
			return "dashboard";
		}

		return "redirect:/";
	}



	@RequestMapping("/addClasses")
	public String addClass(HttpSession s, Model Model) {
		User user = _us.findById((Long)s.getAttribute("id"));
		if(s.getAttribute("id")!= null){
			//show 4 semesters dropdown
			//show classes within chosen semester
			return "addClasses";
		}

		return "redirect:/";
	}
}
