package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Disease;
import com.model.Patient;
 
public interface DiseasesRepo extends MongoRepository<Disease, Long>{
 
	public Disease findOneById(Long id);
}
