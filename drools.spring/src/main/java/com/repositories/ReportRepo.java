package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Patient;
import com.model.Report;

public interface ReportRepo extends MongoRepository<Report, Long>{
	public Report findOneById(Long id);
}
