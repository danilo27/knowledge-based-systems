package com.services;

import java.util.List;

import com.model.Disease;

public interface DiseaseSI {
	public List<Disease> getAll();
	public Disease add(Disease s);
	public void delete(Long id);
	public Disease update(Disease s, Long id);
	public Disease findOne(Long id);

}
