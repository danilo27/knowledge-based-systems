package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Disease;
import com.services.DiseaseSI;


@RestController
public class DiseaseController {
	private final DiseaseSI patService;
	@Autowired
	private DiseaseController(DiseaseSI patService){
		this.patService = patService;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/Diseases")
	public List<Disease> getAll(){ return patService.getAll(); }
	
	@RequestMapping(method = RequestMethod.GET, value = "/Disease/get/{id}")
	public Disease getOne(@PathVariable Long id){ return patService.findOne(id);}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Disease/add")
	public Disease add(@RequestBody Disease Disease){ return patService.add(Disease);}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Disease")
	public Disease edit(@RequestBody Disease Disease){ return patService.add(Disease);}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Disease/{id}")
	public void delete(@PathVariable Long id){ patService.delete(id);}
}
