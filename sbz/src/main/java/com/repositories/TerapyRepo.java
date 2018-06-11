package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Terapy;

@Repository
public interface TerapyRepo extends MongoRepository<Terapy, Long>{

}
