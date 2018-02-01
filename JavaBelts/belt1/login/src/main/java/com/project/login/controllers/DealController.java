package com.project.login.controllers;

import java.lang.reflect.Method;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.project.login.models.Deal;
import com.project.login.models.User;
import com.project.login.services.DealSerivce;
import com.project.login.services.UserService;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class DealController{
	//Member variables go here
	private DealSerivce _ds;
	private UserService _us;

	public DealController( DealSerivce _ds, UserService _us){
		this._ds = _ds;
		this._us = _us;

	}

		// user
		public static Date addDays(Date date, int days) {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);
			cal.add(Calendar.DATE, days);
					
			return cal.getTime();
		}
		
	
		@RequestMapping("/profile")
		public String yourMethod(HttpSession s, Model model){
			User user = _us.findById((Long)s.getAttribute("id"));
			if(s.getAttribute("id")!= null && user.isAdmin() == false){
				
				if(user.getDeal() != null){
					Date dueDate = addDays(user.getOwed(), user.getDueDate());
					String fullDate = dueDate.toString();
					_us.setFullDate(user, fullDate);
					model.addAttribute("user", user);
					
					model.addAttribute("due", fullDate);
					return "user";
				}
				
				return "redirect:/addUserDeal";
			}
			return "redirect:/";
		}	

		@RequestMapping("/addUserDeal")
		public String addDeal(HttpSession s, Model model){
			User user = _us.findById((Long)s.getAttribute("id"));
			if(s.getAttribute("id")!= null && user.isAdmin() == false){
				List<Deal> allDeals = _ds.getAllDeals();
				if(user.getDeal() == null){
					model.addAttribute("user", user);
					model.addAttribute("deals", allDeals);
					return "addDeal";
				}
				return "redirect:/";
			}
			return "redirect:/";
		}	

		@PostMapping("/addUserDeal") //@RequestParam("ring")Long ringid

		public String edditDeal(HttpSession s, @RequestParam("due")int dueDate, @RequestParam("deal")Long dealId){
			User user = _us.findById((Long)s.getAttribute("id"));
			Deal deal = _ds.findOne(dealId);
			

			_ds.setUser(user, deal, dueDate);
			
			return "redirect:/profile";
		}	


	//admin
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession s, Model model, @ModelAttribute("deal") Deal deal){
		ArrayList<User> allUsers = _us.all();
		User user = _us.findById((Long)s.getAttribute("id"));

		List<Deal> allDeals = _ds.getAllDeals();
		if(s.getAttribute("id")!= null && user.isAdmin()){
			model.addAttribute("deals", allDeals);
			model.addAttribute("users", allUsers);
			return "dashboard";
		}
		return "redirect:/";
	}
	@PostMapping("/newDeal")
	public String makeDeal(HttpSession s, Model model,@ModelAttribute("deal") Deal deal){
		_ds.createdeal(deal);
		return "redirect:/";
	}




	@RequestMapping("/deal/{id}/activate")
	public String delete(@PathVariable("id") Long id){
		Deal thisdeal = _ds.findOne(id);
		_ds.activate(thisdeal);
		return "redirect:/";
	}
	@RequestMapping("/deal/{id}/deactivate")
	public String activate(@PathVariable("id") Long id){
		Deal thisdeal = _ds.findOne(id);
		_ds.deactivate(thisdeal);
		return "redirect:/";
	}
	@RequestMapping("/deal/{id}/delete")
	public String deactivte(@PathVariable("id") Long id){
		Deal thisdeal = _ds.findOne(id);
		_ds.destroy(thisdeal);
		return "redirect:/";
	}

}
