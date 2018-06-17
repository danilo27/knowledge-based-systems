package com.servicesimpl;

 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.DiagnoseDTO;
import com.dto.DisSympMap;
import com.dto.DroolsDTO;
import com.dto.DroolsDisSymps;
import com.dto.SymptomsForDisDTO;
import com.dto.ValidationDTO;
import com.model.Disease;
import com.model.Symptom;
import com.repositories.DiseasesRepo;
import com.repositories.PatientRepo;
import com.services.DiagnoseSI;

 
@Service
public class DiagnoseService implements DiagnoseSI{
	
	private final KieContainer kieCont;
	private final PatientRepo patRepo;
	private final DiseasesRepo disRepo;
	@Autowired
	public DiagnoseService(KieContainer kieCont,
			PatientRepo patRepo,
			DiseasesRepo disRepo
			){
		this.kieCont = kieCont;
		this.patRepo = patRepo;
		this.disRepo = disRepo;
	}
 
	public Disease mostProbable(DiagnoseDTO d) {
		KieSession kieSession = kieCont.newKieSession("ExampleSession");
		DroolsDTO drools_dto = new DroolsDTO();
		List<String> diseases = new ArrayList();
		List<Disease> diseases_objs = new ArrayList();
		drools_dto.setSymps(d.getSymps());
		System.out.println("Symps:");
		for(String s : drools_dto.getSymps()){
			System.out.println(s);
		}
		kieSession.insert(drools_dto);
		//kieSession.setGlobal("disease", new Disease());
		kieSession.getAgenda().getAgendaGroup("most_probable").setFocus();
		kieSession.fireAllRules();
		 
	
		kieSession.dispose();
		 
		if(drools_dto.getDiseases().size()==0)
			return null;
		return drools_dto.getDiseases().get(0);
		
	}

	public List<DisSympMap> allPossible(ArrayList<String> symptoms ) {
		KieSession kieSession = kieCont.newKieSession("ExampleSession");
		//DroolsDTO drools_dto = new DroolsDTO();
		DroolsDisSymps dds = new DroolsDisSymps();
		
		System.out.println("*************************");
		System.out.println("Possible diseases - Symptoms:");
		for(String symptom : symptoms) {
			System.out.println(symptom);
			kieSession.insert(symptom);
		}
		for(Disease dis : disRepo.findAll()){
			kieSession.insert(dis);
		}
		kieSession.insert(dds);
		System.out.println("**************************");
		//kieSession.insert(drools_dto);
		kieSession.getAgenda().getAgendaGroup("all_possible").setFocus();
		kieSession.fireAllRules();
		 
	
		

		System.out.println("All possible:");
		for(DisSympMap dsm : dds.getMaps()){
			System.out.println(dsm.getDisease() + " Number of symptoms: " + dsm.getNumberOfSymptoms());
		}
		
		
		kieSession.getAgenda().getAgendaGroup("all_possible_sort").setFocus();
		kieSession.fireAllRules();
//		Collections.sort(dds.getMaps(), new Comparator<DisSympMap>() {
//		    
//		    public int compare(DisSympMap a1, DisSympMap a2) {
//		        return a1.getNumberOfSymptoms() - a2.getNumberOfSymptoms();
//		    }
//
//		});
		System.out.println("*******");
		System.out.println("All possible after sort:");
		for(DisSympMap dsm : dds.getMaps()){
			System.out.println(dsm.getDisease() + " Number of symptoms: " + dsm.getNumberOfSymptoms());
		}
		System.out.println("*******");
		
		kieSession.dispose();

		return dds.getMaps();
	}

	public List<String> validate(ValidationDTO v) {
		KieSession kieSession = kieCont.newKieSession("ExampleSession");
		//ValidationDTO dto = new ValidationDTO();
		 
		 for(String s : v.getAllergies()){
			 System.out.println(s);
		 }
		 for(String s: v.getPrepisani()){
			 System.out.println(s);
		 }

		kieSession.insert(v);
 
		kieSession.getAgenda().getAgendaGroup("allergies-warning").setFocus();
		kieSession.fireAllRules();
		 
	
		kieSession.dispose();
 
		return v.getWarnings();
	}

	public SymptomsForDisDTO getSympsForDisease(String d) {
		KieSession kieSession = kieCont.newKieSession("ExampleSession");
		System.out.println("Inserting: " + d);
		kieSession.insert(d);
		SymptomsForDisDTO dto = new SymptomsForDisDTO();
		kieSession.insert(dto);
		kieSession.getAgenda().getAgendaGroup("symptoms-for-disease").setFocus();
		kieSession.fireAllRules();	 
	
		kieSession.dispose();
 
		return dto;
	}
	 
	
}

 
