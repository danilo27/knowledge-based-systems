package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Disease;
import com.repositories.DiseasesRepo;
import com.services.DiseaseSI;

@Service
public class DiseaseService implements DiseaseSI{
	private final DiseasesRepo repo;
	@Autowired
	private DiseaseService(DiseasesRepo repo){
		this.repo = repo;
	}
	
	public List<Disease> getAll(){
        return repo.findAll();
    }
	
	public Disease add(Disease s){
		s.setId((Long)repo.count());
		return repo.save(s);
	}
	
	public void delete(Long id){
		repo.delete(repo.findOneById(id));
	}
	
	public Disease update(Disease s, Long id){
		return repo.save(s);
	}
	
	public Disease findOne(Long id){
		return repo.findOneById(id);
	}
}
