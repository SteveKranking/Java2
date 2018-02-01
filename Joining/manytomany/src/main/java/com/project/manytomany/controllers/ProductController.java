package com.project.manytomany.controllers;

import com.project.manytomany.models.Category;
import com.project.manytomany.models.Product;
import com.project.manytomany.services.CategoryService;
import com.project.manytomany.services.ProductService;
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

@Controller
@RequestMapping("/product")
public class ProductController{
	private ProductService productService;
	private CategoryService categoryService;

	public ProductController(CategoryService categoryService, ProductService productService){
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@RequestMapping("")
	public String products(@ModelAttribute("product") Product product){
		return "newProduct";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult res){
		if(res.hasErrors()){
			return "newProduct";
		}else{
			productService.create(product);
			return"redirect:/product/" +product.getId();
		}
	}
	@RequestMapping("/{id}")
	public String both(Model model, @PathVariable("id") long id){
		ArrayList<Category> categories = categoryService.all();
		model.addAttribute("allCategories", categories);
		model.addAttribute("id", id);
		
		
		Product product = productService.findById(id);
		model.addAttribute("categories", product.getCategory());
		model.addAttribute("product", product);
		
		return "Products";
	}

	@PostMapping("/add/{id}")
	public String append(@Valid @ModelAttribute("product") Product product, BindingResult res, @PathVariable("id") Long id, @RequestParam("category_id") Long category_id){
		product = productService.findById(id);
		List<Category> categories= product.getCategory();
		categories.add(categoryService.findById(category_id));
		product.setCategory(categories);
		productService.update(product);
		return"redirect:/product/" +product.getId();
	}
	
}