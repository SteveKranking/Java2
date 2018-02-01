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
@RequestMapping("/category")
public class CategoryController{
	private CategoryService categoryService;
	private ProductService productService;

	public CategoryController(CategoryService categoryService, ProductService productService){
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@RequestMapping("")
	public String categorys(@ModelAttribute("category") Category category){
		return "newCategory";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult res){
		if(res.hasErrors()){
			return "category";
		}else{
			categoryService.create(category);
			return"redirect:/category/" + category.getId();
		}
	}
	@RequestMapping("/{id}")
	public String both(Model model, @PathVariable("id") long id){
		ArrayList<Product> products = productService.all();
		model.addAttribute("allProducts", products);
		model.addAttribute("id", id);

		Category category = categoryService.findById(id);
		System.out.println(category);
		model.addAttribute("products", category.getProduct());
		model.addAttribute("category", category);
		
		return "Categories";
	}

	@PostMapping("/add/{id}")
	public String append(@Valid @ModelAttribute("category") Category category, BindingResult res, @PathVariable("id") Long id, @RequestParam("product_id") Long product_id){
		category = categoryService.findById(id);
		List<Product> products= category.getProduct();
		products.add(productService.findById(product_id));
		category.setProduct(products);
		categoryService.update(category);
		return"redirect:/category/" +category.getId();
	}
	
}