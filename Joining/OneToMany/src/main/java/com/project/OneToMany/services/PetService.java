package com.project.OneToMany.services;

import com.project.OneToMany.models.Pet;
import com.project.OneToMany.repositories.PetRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PetService {
	// Member variables / service initializations go here
	private PetRepository petRepository;
		
	public PetService(PetRepository petRepository){
		this.petRepository = petRepository;
	}

	public void create(Pet pet){
		petRepository.save(pet);
	}

	public ArrayList<Pet> all(){
		return (ArrayList<Pet>)petRepository.findAll();
	}
	
	public Pet findById(long id){
		return petRepository.findOne(id);
	}

	public void destroy(long id){
		petRepository.delete(id);
	}
}