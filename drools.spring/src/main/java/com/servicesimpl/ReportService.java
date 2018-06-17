package com.servicesimpl;

import java.util.Date;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.DateUtilsDTO;
import com.dto.DroolsReport;
import com.model.Disease;
import com.model.Patient;
import com.model.Report;
import com.repositories.DiseasesRepo;
import com.repositories.PatientRepo;
import com.repositories.ReportRepo;
import com.services.DiseaseSI;
import com.services.PatientSI;
import com.services.ReportSI;
 

@Service
public class ReportService implements ReportSI{
	private final ReportRepo patRepo;
	private final KieContainer kieCont;
	private final PatientSI patService;
	private final DiseaseSI disService;
	@Autowired
	private ReportService(KieContainer kieCont, ReportRepo repo, PatientSI patService, DiseaseSI disService){
		this.patRepo = repo;
		this.kieCont = kieCont;
		this.patService = patService;
		this.disService = disService;
	}
	
 
	
	
	public List<Report> getAll(){
        return patRepo.findAll();
    }
	
	public Report add(Report Report){
		Report.setId((Long)patRepo.count());
		return patRepo.save(Report);
	}
	
	public void delete(Long id){
		patRepo.delete(patRepo.findOneById(id));
	}
	
	public Report update(Report Report){
		return patRepo.save(Report);
	}
	
	public Report findOne(Long id){
		return patRepo.findOneById(id);
	}


	public List<Patient> getChronics() {
		KieSession kieSession = kieCont.newKieSession("ExampleSession");
		DateUtilsDTO dut = new DateUtilsDTO();
		DroolsReport report = new DroolsReport();
		
		dut.setCurrent(new Date());
		kieSession.insert(dut);
		
		kieSession.insert(report);
		
		for(Patient p : patService.getAll()) {
			kieSession.insert(p);
		}
		
		for(Disease s : disService.getAll()) {
			kieSession.insert(s);
		}
		
		kieSession.getAgenda().getAgendaGroup("chronics").setFocus();
		kieSession.fireAllRules();
		 
		kieSession.dispose();
 
		if(report.getPatients().size()==0){
			return null;
		} else {
			return report.getPatients();
		}
	}


	public List<Patient> getAddicts() {
		KieSession kieSession = kieCont.newKieSession("ExampleSession");
		DateUtilsDTO dut = new DateUtilsDTO();
		DroolsReport report = new DroolsReport();
		
		dut.setCurrent(new Date());
		kieSession.insert(dut);
		
		kieSession.insert(report);
		
		for(Patient p : patService.getAll()) {
			kieSession.insert(p);
		}
		
		
		kieSession.getAgenda().getAgendaGroup("addicts").setFocus();
		kieSession.fireAllRules();
		 
	
		kieSession.dispose();
 
		if(report.getPatients().size()==0){
			return null;
		} else {
			return report.getPatients();
		}
	}


	public List<Patient> getLows() {
		KieSession kieSession = kieCont.newKieSession("ExampleSession");
		DateUtilsDTO dut = new DateUtilsDTO();
		DroolsReport report = new DroolsReport();
		
		dut.setCurrent(new Date());
		kieSession.insert(dut);
		
		kieSession.insert(report);
		
		for(Patient p : patService.getAll()) {
			kieSession.insert(p);
		}
		
		
		kieSession.getAgenda().getAgendaGroup("lows").setFocus();
		kieSession.fireAllRules();
		 
	
		kieSession.dispose();
 
		if(report.getPatients().size()==0){
			return null;
		} else {
			return report.getPatients();
		}
	}
	
	
}
