package com.servicesimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Patient;
import com.model.Terapy;
import com.repositories.PatientRepo;
import com.repositories.SymptomRepo;
import com.repositories.TerapyRepo;
import com.services.PatientSI;
import com.services.TerapySI;

@Service
public class TerapyService implements TerapySI{
	private final TerapyRepo repo;
	private final PatientSI patService;
	@Autowired
	private TerapyService(TerapyRepo repo, PatientSI patService){
		this.repo = repo;
		this.patService = patService;
	}
	
	public List<Terapy> getAll(){
        return repo.findAll();
    }
	
	public Terapy add(Terapy s){
		s.setDatum(new Date());
		s.setId((Long)repo.count());
		
		Patient p = patService.findOne(s.getPatient().getId());
		p.getTerapies().add(s);
		patService.update(p);
		
		return repo.save(s);
	}
	
	public void delete(Long id){
		repo.delete(repo.findOneById(id));
	}
	
	public Terapy update(Terapy s){
		return repo.save(s);
	}
	
	public Terapy findOne(Long id){
		return repo.findOneById(id);
	}
}