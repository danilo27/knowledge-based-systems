package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Patient;
import com.model.Symptom;
 
public interface SymptomRepo extends MongoRepository<Symptom, Long>{
	public Symptom findOneById(Long id);
}
