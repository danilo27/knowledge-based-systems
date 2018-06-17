package com.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationDTO {
	private Long patientId;
	private List<String> prepisani;
	private List<String> warnings = new ArrayList<String>();
	private List<String> allergies;
	private List<String> drug_allergies;
	private List<String> drug_prepisani;
	public List<String> getDrug_allergies() {
		return drug_allergies;
	}
	public void setDrug_allergies(List<String> drug_allergies) {
		this.drug_allergies = drug_allergies;
	}
	public List<String> getDrug_prepisani() {
		return drug_prepisani;
	}
	public void setDrug_prepisani(List<String> drug_prepisani) {
		this.drug_prepisani = drug_prepisani;
	}
	public List<String> getWarnings() {
		return warnings;
	}
	public void setWarnings(List<String> warnings) {
		this.warnings = warnings;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public List<String> getPrepisani() {
		return prepisani;
	}
	public void setPrepisani(List<String> prepisani) {
		this.prepisani = prepisani;
	}
	public ValidationDTO(){}
}
