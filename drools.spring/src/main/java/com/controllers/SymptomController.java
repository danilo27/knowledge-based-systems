package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Symptom;
import com.services.SymptomSI;


@RestController
public class SymptomController {
	private final SymptomSI patService;
	@Autowired
	private SymptomController(SymptomSI patService){
		this.patService = patService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Symptoms")
	public List<Symptom> getAll(){ return patService.getAll(); }
	
	@RequestMapping(method = RequestMethod.GET, value = "/Symptom/get/{id}")
	public Symptom getOne(@PathVariable Long id){ return patService.findOne(id);}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Symptom/add")
	public Symptom add(@RequestBody Symptom Symptom){ return patService.add(Symptom);}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Symptom")
	public Symptom edit(@RequestBody Symptom Symptom){ return patService.add(Symptom);}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Symptom/{id}")
	public void delete(@PathVariable Long id){ patService.delete(id);}
}
