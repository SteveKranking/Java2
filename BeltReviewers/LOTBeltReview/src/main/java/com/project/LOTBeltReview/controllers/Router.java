package com.project.LOTBeltReview.controllers;

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

import com.project.LOTBeltReview.validators.UserValidator;
import com.project.LOTBeltReview.models.User;
import com.project.LOTBeltReview.services.*;
import com.project.LOTBeltReview.repositories.*;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	private UserValidator _uv;
	private UserService _us;

	public Router(UserValidator _uv, UserService _us){
		this._us=_us;
		this._uv = _uv;
	}

	@RequestMapping("index")
	public String index(){
		return "index";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		

	@RequestMapping("/register")
	public String register(Model model, @ModelAttribute("user") User user, HttpSession session) {
		session.invalidate();
		return "dashboard";
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
			return "redirect:/dashboard";
		}
	}
}
