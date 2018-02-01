package com.project.OneToOne.controllers;

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

import com.project.OneToOne.models.License;
import com.project.OneToOne.models.Person;

import com.project.OneToOne.services.LicenseService;
import com.project.OneToOne.services.PersonService;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router {

	private final PersonService personService;
	private final LicenseService licenseService;
	
	public Router(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@RequestMapping("index")
	public String index(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", personService.getAllPeople());
		return "index";
	}

	@RequestMapping("/")
	public String alsoindex(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", personService.getAllPeople());
		return "index";
	}

	@RequestMapping("/newperson")
	public String NewPerson(@ModelAttribute("person") Person person) {
		return "PersonNew";
	}	

	@RequestMapping("/newlicense")
	public String NewLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", personService.getAllPeople());
		// ^ need this to add people to the license
		return "LicenseNew";
	}	

	@RequestMapping("/person/new")
	public String enterNewPerson(Model model, @ModelAttribute("person") Person person) {
		return "redirect:/PersonNew";
	}

	@PostMapping("/person/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "PersonNew";
		} else {
			personService.addPerson(person);
			return "index";			
		}
	}


	// License Stuff 
	@RequestMapping("/license/new")
	public String enterNewLicense(Model model, @ModelAttribute("license") License license) {
		return "LicenseNew";
	}

	@PostMapping("/license/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "LicenseNew";
		} else {
			licenseService.addLicense(license);
			
			return "index";			
		}
	}
			
}
