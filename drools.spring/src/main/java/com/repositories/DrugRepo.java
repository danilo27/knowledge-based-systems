package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Drug;
import com.model.Patient;

 
public interface DrugRepo extends MongoRepository<Drug, Long>{
	public Drug findOneById(Long id);
}
