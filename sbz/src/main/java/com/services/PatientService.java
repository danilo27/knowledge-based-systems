package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Patient;
import com.repositories.PatientRepo;

@Service
public class PatientService {
	@Autowired 
	PatientRepo patRepo;
	
	public List<Patient> getAll(){
        return patRepo.findAll();
    }
	
	public Patient addPatient(Patient patient){
		return patRepo.save(patient);
	}
	
	public void deletePatient(Long id){
		patRepo.delete(patRepo.findOneById(id));
	}
	
	public Patient updatePatient(Patient patient, Long id){
		return patRepo.save(patient);
	}
	
	public Patient findOne(Long id){
		return patRepo.findOneById(id);
	}
}
