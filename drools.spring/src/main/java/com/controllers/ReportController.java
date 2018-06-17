package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.DiagnoseDTO;
import com.dto.DisSympMap;
import com.dto.ValidationDTO;
import com.model.Disease;
import com.model.Patient;
import com.model.Report;
import com.services.ReportSI;

@RestController
public class ReportController {
	private final ReportSI service;
	@Autowired
	private ReportController(ReportSI service){
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Reports")
	public List<Report> getAll(){ return service.getAll(); }
	
	@RequestMapping(method = RequestMethod.GET, value = "/Report/get/{id}")
	public Report getOne(@PathVariable Long id){ return service.findOne(id);}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Report/add")
	public Report add(@RequestBody Report Report){ return service.add(Report);}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Report")
	public Report edit(@RequestBody Report Report){ return service.update(Report);}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Report/{id}")
	public void delete(@PathVariable Long id){ service.delete(id);}
	
	@RequestMapping(value = "/drools/chronics", method = RequestMethod.GET)
    public List<Patient> getChronics(){ return service.getChronics(); }

    @RequestMapping(value = "/drools/addicts", method = RequestMethod.GET)
    public List<Patient> getAddicts(){ return service.getAddicts(); }

    @RequestMapping(value = "/drools/lows", method = RequestMethod.GET)
    public List<Patient> getLows(){ return service.getLows(); }
}