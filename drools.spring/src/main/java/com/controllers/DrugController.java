package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Drug;
import com.services.DrugSI;


@RestController
public class DrugController {
	private final DrugSI patService;
	@Autowired
	private DrugController(DrugSI patService){
		this.patService = patService;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/Drugs")
	public List<Drug> getAll(){ return patService.getAll(); }
	
	@RequestMapping(method = RequestMethod.GET, value = "/Drug/get/{id}")
	public Drug getOne(@PathVariable Long id){ return patService.findOne(id);}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Drug/add")
	public Drug add(@RequestBody Drug Drug){ return patService.add(Drug);}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Drug")
	public Drug edit(@RequestBody Drug Drug){ return patService.add(Drug);}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Drug/{id}")
	public void delete(@PathVariable Long id){ patService.delete(id);}
}
