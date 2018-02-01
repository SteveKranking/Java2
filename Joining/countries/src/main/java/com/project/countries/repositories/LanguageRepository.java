package com.project.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
