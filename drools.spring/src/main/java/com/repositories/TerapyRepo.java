package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Patient;
import com.model.Terapy;
 
public interface TerapyRepo extends MongoRepository<Terapy, Long>{
	public Terapy findOneById(Long id);
}
