package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Symptom;

@Repository
public interface SymptomRepo extends MongoRepository<Symptom, Long>{

}
