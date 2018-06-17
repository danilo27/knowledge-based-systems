package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Terapy;
import com.services.TerapySI;

@RestController
public class TerapyController {
	private final TerapySI patService;
	@Autowired
	private TerapyController(TerapySI patService){
		this.patService = patService;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/Terapies")
	public List<Terapy> getAll(){ return patService.getAll(); }
	
	@RequestMapping(method = RequestMethod.GET, value = "/Terapy/get/{id}")
	public Terapy getOne(@PathVariable Long id){ return patService.findOne(id);}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Terapy/add")
	public Terapy add(@RequestBody Terapy Terapy){ return patService.add(Terapy);}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Terapy")
	public Terapy edit(@RequestBody Terapy Terapy){ return patService.update(Terapy);}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Terapy/{id}")
	public void delete(@PathVariable Long id){ patService.delete(id);}
}
