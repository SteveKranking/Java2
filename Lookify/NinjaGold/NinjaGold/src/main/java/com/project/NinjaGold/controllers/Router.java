package com.project.NinjaGold.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

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
	private static ArrayList<String> passions = new ArrayList<String>();
	public Router(){

	}

	@RequestMapping("")
	public String index(HttpSession session, Model model){
		if(session.isNew()){
			session.setAttribute("gold", 0);
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("passions", passions);
		
		return "index";
	}

	@PostMapping("farm")
	public String farm(HttpSession session){
		Integer count = (Integer) session.getAttribute("gold");
		Random randomly = new Random();
		int money = 10 + randomly.nextInt(10);
		count += money;
		session.setAttribute("gold", count);
		passions.add( 0, "You went to the farm and gained " + money +" gold" );
		return "redirect:/";
	}
	@PostMapping("cave")
	public String cave(HttpSession session){
		Integer count = (Integer) session.getAttribute("gold");
		Random randomly = new Random();
		int money = 5 + randomly.nextInt(5);
		count += money;
		session.setAttribute("gold", count);
		passions.add(0, "You went to the cave and gained " + money +" gold" );
		return "redirect:/";
	}

	@PostMapping("house")
	public String house(HttpSession session){
		
		passions.add(0, "You went home and watched netflix all day." );
		return "redirect:/";
	}
	@PostMapping("reset")
	public String reset(HttpSession session){
		int count = 0;
		session.setAttribute("gold", count);
		return "redirect:/";
	}


	@PostMapping("casino")
	public String casino(HttpSession session){
		Integer count = (Integer) session.getAttribute("gold");
		if(count < 50){
			passions.add(0, "You went but didnt have da money dis is not da way!" );
			return "redirect:/";
		}
		
		Random randomly = new Random();
		int win = randomly.nextInt(100);
		if(win > 75){
			int money = 0 + randomly.nextInt(50);
			count += money;
			session.setAttribute("gold", count);
			passions.add(0, "You went to the cassino and gained " + money +" gold" );
			return "redirect:/";
		}
		int money = 10 + randomly.nextInt(40);
		count -= money;
		session.setAttribute("gold", count);
		passions.add(0, "<p class='bad'>You went to the cassino and Lost " + money +" gold. Ouch </p>" );

		return "redirect:/";
	}
}