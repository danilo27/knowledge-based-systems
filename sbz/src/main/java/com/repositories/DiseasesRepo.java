package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Disease;

@Repository
public interface DiseasesRepo extends MongoRepository<Disease, Long>{

}
