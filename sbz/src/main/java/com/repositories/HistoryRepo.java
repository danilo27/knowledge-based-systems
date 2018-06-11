package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.DiseaseHistory;

@Repository
public interface HistoryRepo extends MongoRepository<DiseaseHistory, Long>{
}