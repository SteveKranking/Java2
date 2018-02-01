package com.project.human.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/your_server")
public class Router {
	@RequestMapping("")
	public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="lname", required=false) String lname, Model model) {
		if (name != null) {
			model.addAttribute("name", name);
		} else {
			model.addAttribute("name", "Human");
		}
		if (lname != null) {
			model.addAttribute("lname", lname);
		} else {
			model.addAttribute("lname", "being");
		}
		return "index";
	}
}