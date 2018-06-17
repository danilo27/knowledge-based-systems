package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Ingredient;
import com.repositories.IngredientRepo;
import com.services.IngredientSI;

@Service
public class IngredientService implements IngredientSI{
	private final IngredientRepo repo;
	@Autowired
	private IngredientService(IngredientRepo repo){
		this.repo = repo;
	}
	
	public List<Ingredient> getAll(){
        return repo.findAll();
    }
	
	public Ingredient add(Ingredient s){
		s.setId((Long)repo.count());
		return repo.save(s);
	}
	
	public void delete(Long id){
		repo.delete(repo.findOneById(id));
	}
	
	public Ingredient update(Ingredient s, Long id){
		return repo.save(s);
	}
	
	public Ingredient findOne(Long id){
		return repo.findOneById(id);
	}
}
