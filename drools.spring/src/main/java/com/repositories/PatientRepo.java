package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Patient;
 
public interface PatientRepo extends MongoRepository<Patient, Long>{
	public Patient findOneById(Long id);
}

