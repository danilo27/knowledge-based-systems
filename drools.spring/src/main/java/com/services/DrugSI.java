package com.services;

import java.util.List;

import com.model.Drug;

public interface DrugSI {
	public List<Drug> getAll();
	public Drug add(Drug s);
	public void delete(Long id);
	public Drug update(Drug s, Long id);
	public Drug findOne(Long id);
}
