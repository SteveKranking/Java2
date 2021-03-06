package com.project.Language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Language.models.Language;
import com.project.Language.services.LanguageService;

@Controller
@RequestMapping("/")
public class Router {
	
	private final LanguageService ls;
	public Router(LanguageService ls) {
		this.ls = ls;
	}
	
	@RequestMapping("")
	public String showDashboard(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = ls.getAllLanguages();
		model.addAttribute("languages", languages);
		return "dashboard";
	}
	
	@PostMapping("/new")
	public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Language> languages = ls.getAllLanguages();
			model.addAttribute("languages", languages);
			return "dashboard";								//This is rendering off a POST route, and is BAD! We may need to implement Flash messages manually to get this right, since the redirect/render pattern doesn't seem to produce them properly based on the <form:error> tags in the template.
		} else {
			ls.addLanguage(language);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/language/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Language language = ls.findLanguageById(id);
		model.addAttribute("language", language);
		return "languages";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		ls.destroyLanguage(id);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		Language language = ls.findLanguageById(id);
		if (language != null) {
			System.out.println("Language ID we're trying to display for update: " + language.getId());
			model.addAttribute("language", language);
			return "editLanguage";
		} else {
			return "languages";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {   
		System.out.println("Here's the ID we got back from the form: " + language.getId());
		System.out.println(language);
		if (result.hasErrors()) {
			return "editLanguage";
		} else {
			ls.updateLanguage(language);
			return "languages";
		}
	}
}