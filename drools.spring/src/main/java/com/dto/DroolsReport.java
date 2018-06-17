package com.dto;

import java.util.ArrayList;
import java.util.List;

import com.model.Patient;

public class DroolsReport {
	private List<Patient> patients = new ArrayList<Patient>();

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
}
