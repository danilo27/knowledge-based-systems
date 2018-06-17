package com.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Drug;
import com.repositories.DrugRepo;
import com.services.DrugSI;

@Service
public class DrugService implements DrugSI{
	private final DrugRepo repo;
	@Autowired
	private DrugService(DrugRepo repo){
		this.repo = repo;
	}
	
	public List<Drug> getAll(){
        return repo.findAll();
    }
	
	public Drug add(Drug s){
		s.setId((Long)repo.count());
		return repo.save(s);
	}
	
	public void delete(Long id){
		repo.delete(repo.findOneById(id));
	}
	
	public Drug update(Drug s, Long id){
		return repo.save(s);
	}
	
	public Drug findOne(Long id){
		return repo.findOneById(id);
	}
}