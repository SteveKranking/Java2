package com.project.manytomany.services;

import com.project.manytomany.models.Product;
import com.project.manytomany.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	// Member variables / service initializations go here
	private ProductRepository productRepository;
		
	public ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	public void create(Product product){
		productRepository.save(product);
	}

	public ArrayList<Product> all(){
		return (ArrayList<Product>)productRepository.findAll();
	}
	
	public Product findById(long id){
		return (Product)productRepository.findOne(id);
	}

	public void update(Product product){
		System.out.println("Test3");
		productRepository.save(product);
	}
	
	// Crud methods to act on services go here.
}