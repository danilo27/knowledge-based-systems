package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Ingredient;
import com.model.Patient;
 
public interface IngredientRepo extends MongoRepository<Ingredient, Long>{
	public Ingredient findOneById(Long id);
}
