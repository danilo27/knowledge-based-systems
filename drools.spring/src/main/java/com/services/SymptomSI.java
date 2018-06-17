package com.services;

import java.util.List;

import com.model.Symptom;

public interface SymptomSI {
	public List<Symptom> getAll();
	public Symptom add(Symptom s);
	public void delete(Long id);
	public Symptom update(Symptom s, Long id);
	public Symptom findOne(Long id);
}
