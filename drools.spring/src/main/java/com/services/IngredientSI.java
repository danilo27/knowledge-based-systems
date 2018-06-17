package com.services;

import java.util.List;

import com.model.Ingredient;

public interface IngredientSI {
	public List<Ingredient> getAll();
	public Ingredient add(Ingredient s);
	public void delete(Long id);
	public Ingredient update(Ingredient s, Long id);
	public Ingredient findOne(Long id);
}
