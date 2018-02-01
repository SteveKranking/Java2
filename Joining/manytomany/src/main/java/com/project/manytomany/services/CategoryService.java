package com.project.manytomany.services;

import com.project.manytomany.models.Category;
import com.project.manytomany.repositories.CategoryRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	// Member variables / service initializations go here
	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}

	public void create(Category category){
		categoryRepository.save(category);
	}

	public ArrayList<Category> all(){
		return (ArrayList<Category>)categoryRepository.findAll();
	}
	
	public Category findById(long id){
		return (Category)categoryRepository.findOne(id);
	}
	public void update(Category category){
		System.out.println("Test3");
		categoryRepository.save(category);
	}
	
	// Crud methods to act on services go here.
}