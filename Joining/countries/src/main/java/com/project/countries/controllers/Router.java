package com.project.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.countries.services.ApiService;

@Controller
public class Router {
	
	private ApiService _as;
	
	public Router(ApiService _as) {
		this._as = _as;
	}
	@RequestMapping("/")
	public String showResults(Model model) {
		List<Object> results = _as.getCitiesInCountries();
		model.addAttribute("results", results);
		return "results";
	}
}