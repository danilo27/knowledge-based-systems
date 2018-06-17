package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Ingredient;
import com.services.IngredientSI;


@RestController
public class IngredientController {
	private final IngredientSI patService;
	@Autowired
	private IngredientController(IngredientSI patService){
		this.patService = patService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Ingredients")
	public List<Ingredient> getAll(){ return patService.getAll(); }
	
	@RequestMapping(method = RequestMethod.GET, value = "/Ingredient/get/{id}")
	public Ingredient getOne(@PathVariable Long id){ return patService.findOne(id);}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Ingredient/add")
	public Ingredient add(@RequestBody Ingredient Ingredient){ return patService.add(Ingredient);}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Ingredient")
	public Ingredient edit(@RequestBody Ingredient Ingredient){ return patService.add(Ingredient);}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Ingredient/{id}")
	public void delete(@PathVariable Long id){ patService.delete(id);}
}
