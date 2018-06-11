package com.model;

import java.util.List;

public class DiseaseHistory {
	private Long id;
	private List<Symptom> symptoms;
	public DiseaseHistory(Long id, List<Symptom> symptoms, List<Disease> diseases, List<Terapy> terapies) {
		super();
		this.id = id;
		this.symptoms = symptoms;
		this.diseases = diseases;
		this.terapies = terapies;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Symptom> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	public List<Terapy> getTerapies() {
		return terapies;
	}
	public void setTerapies(List<Terapy> terapies) {
		this.terapies = terapies;
	}
	private List<Disease> diseases;
	private List<Terapy> terapies;
}
