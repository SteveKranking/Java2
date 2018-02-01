package com.project.OneToOne.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.OneToOne.models.Person;
import com.project.OneToOne.repositories.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

    public void addPerson (Person person) {
        personRepository.save(person);
	}
	
	public List<Person> getAllPeople() {
		return (List<Person>) personRepository.findAll();
	}

	public Person findOneById(Long id) {
		return personRepository.findOne(id);
	}

}