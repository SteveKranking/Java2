package com.project.Date.controllers;

import java.security.Principal;
import java.util.Date;
import java.text.SimpleDateFormat;

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
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	public Router(){

	}

	@RequestMapping("index")
	public String index(){
		return "index";
	}

	@RequestMapping("time")
	public String time(Model model){
		SimpleDateFormat dateFrmt = new SimpleDateFormat("h:mm a");

		Date time = new Date();
		model.addAttribute("time",dateFrmt.format(time));
		return "time";
	}

	@RequestMapping("date")
	public String date(Model model){
		SimpleDateFormat dateFrmt = new SimpleDateFormat("EEEE', the 'd' of 'MMMM', 'yyyy");
		Date date = new Date();
		model.addAttribute("date",dateFrmt.format(date));
		return "date";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}