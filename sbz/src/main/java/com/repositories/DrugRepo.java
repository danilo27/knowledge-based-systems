package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Drug;

@Repository
public interface DrugRepo extends MongoRepository<Drug, Long>{

}
