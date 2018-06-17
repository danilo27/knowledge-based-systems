package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.model.Symptom;
import com.repositories.PatientRepo;
import com.repositories.SymptomRepo;
import com.services.SymptomSI;

@Service
public class SymptomService implements SymptomSI{
	private final SymptomRepo sympRepo;
	@Autowired
	private SymptomService(SymptomRepo repo){
		this.sympRepo = repo;
	}
	
	public List<Symptom> getAll(){
        return sympRepo.findAll();
    }
	
	public Symptom add(Symptom s){
		s.setId((Long)sympRepo.count());
		return sympRepo.save(s);
	}
	
	public void delete(Long id){
		sympRepo.delete(sympRepo.findOneById(id));
	}
	
	public Symptom update(Symptom s, Long id){
		return sympRepo.save(s);
	}
	
	public Symptom findOne(Long id){
		return sympRepo.findOneById(id);
	}
}
