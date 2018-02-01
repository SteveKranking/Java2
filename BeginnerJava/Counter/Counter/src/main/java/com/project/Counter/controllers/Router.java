package com.project.Counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class Router {
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.isNew()) {
			session.setAttribute("counter", 0);
		} 
		int count = (int) session.getAttribute("counter");
		count += 1;
		session.setAttribute("counter", count);
		
		return "index";
	}
	
	@RequestMapping("/counter")
	public String showCounter(HttpSession session, Model model) {
		if (session.isNew()) {
			session.setAttribute("counter", 0);
		}
		model.addAttribute("counter", session.getAttribute("counter"));
		return "counter";
	}
	
	@RequestMapping("/reset")
	public String resetCounter(HttpSession session) {
		session.invalidate();
		return "forward:/";
	}
}