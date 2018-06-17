package com.services;

import java.util.List;

import com.model.Patient;

public interface PatientSI {
	public List<Patient> getAll();
	public Patient add(Patient s);
	public void delete(Long id);
	public Patient update(Patient s);
	public Patient findOne(Long id);
}
