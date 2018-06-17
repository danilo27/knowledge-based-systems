package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Patient;
import com.repositories.PatientRepo;
import com.services.PatientSI;

@Service
public class PatientService implements PatientSI{
	private final PatientRepo patRepo;
	@Autowired
	private PatientService(PatientRepo repo){
		this.patRepo = repo;
	}
	
	
	public List<Patient> getAll(){
        return patRepo.findAll();
    }
	
	public Patient add(Patient patient){
		patient.setId((Long)patRepo.count());
		return patRepo.save(patient);
	}
	
	public void delete(Long id){
		patRepo.delete(patRepo.findOneById(id));
	}
	
	public Patient update(Patient patient){
		return patRepo.save(patient);
	}
	
	public Patient findOne(Long id){
		return patRepo.findOneById(id);
	}

 


	 
}
