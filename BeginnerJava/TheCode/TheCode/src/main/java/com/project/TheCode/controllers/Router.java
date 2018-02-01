package com.project.TheCode.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class Router {
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		return "index";
	}
	
	@RequestMapping(path="/guess", method=RequestMethod.POST)
	public String guess(@RequestParam(value="guess") String guess,RedirectAttributes redirectAttributes) {
		if (guess.equals("dawey")) {
			return "redirect:/code";
		}
		redirectAttributes.addFlashAttribute("errors", "You are not ready, brudda.");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String showCode() {
		return "thecode";
	}
}