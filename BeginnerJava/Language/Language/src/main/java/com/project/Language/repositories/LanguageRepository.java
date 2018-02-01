package com.project.Language.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Language.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
}