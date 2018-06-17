package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drools.spring.example.SampleAppService;
import com.dto.DiagnoseDTO;
import com.dto.DisSympMap;
import com.dto.SymptomsForDisDTO;
import com.dto.ValidationDTO;
import com.model.Disease;
import com.services.DiagnoseSI;
 

@RestController
public class DiagnoseController {
	
    private final DiagnoseSI service;
    @Autowired
    public DiagnoseController(DiagnoseSI service) {
		this.service = service;
	}
    
	@RequestMapping(value = "/drools/mostprobable", method = RequestMethod.POST)
    public Disease getMostProbable(@RequestBody DiagnoseDTO d){ return service.mostProbable(d); }

    @RequestMapping(value = "/drools/allpossible", method = RequestMethod.POST)
    public List<DisSympMap> getAllPossible(@RequestBody ArrayList<String> symptoms){ return service.allPossible(symptoms); }

    @RequestMapping(value = "/drools/validate", method = RequestMethod.POST)
    public List<String> validate(@RequestBody ValidationDTO v){ return service.validate(v); }
    
    @RequestMapping(value = "/drools/symptomsForDisease/{d}", method = RequestMethod.GET)
    public SymptomsForDisDTO validate(@PathVariable String d){ return service.getSympsForDisease(d); }
//    
//    @RequestMapping(value = "/drools/report", method = RequestMethod.GET)
//    public RezultatIzvestajaDTO report(){ return service.report(); }
//    
//    @RequestMapping(value = "/drools/monitor", method = RequestMethod.GET)
//    public RezultatStringDTO monitor(){ return service.monitor(); }
//
//    @RequestMapping(value = "/drools/disease", method = RequestMethod.POST)
//    public RezultatSimptomiDTO disease(@RequestBody SimptomiDTO id){ return service.bolest(id); }
    
}
