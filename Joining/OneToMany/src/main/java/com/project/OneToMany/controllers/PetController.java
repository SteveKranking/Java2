package com.project.OneToMany.controllers;

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

import com.project.OneToMany.services.PetService;
import com.project.OneToMany.services.UserService;
import com.project.OneToMany.models.Pet;
import com.project.OneToMany.models.User;

@Controller
@RequestMapping("/pets")
public class PetController{
	//Member variables go here
	private PetService petService;
	private UserService userService;

	public PetController(PetService petService, UserService userService){
		this.petService= petService;
		this.userService = userService;
	}

	
	@RequestMapping("")
	public String pets(@ModelAttribute("pet") Pet pet, Model model){
		ArrayList<User> users = userService.all();
		model.addAttribute("users", users);
		return "pet";
	}	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("pet") Pet pet, BindingResult res){
		if( res.hasErrors() ){
			return "pet";
		}else{
			petService.create(pet);
			return "redirect:/pets/user/"+ pet.getUser().getId();
		}
	}

	@RequestMapping("/user/{id}")
	public String both(Model model, @PathVariable("id") long id){
		User user = userService.findById(id);
		System.out.println(user.getName());
		model.addAttribute("pets", user.getPets());
		
		return "userPet";
	}

}