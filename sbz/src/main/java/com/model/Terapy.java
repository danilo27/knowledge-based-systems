package com.model;

import java.util.List;

public class Terapy {
	private Long id;
	private List<Drug> drugs;
	private Doctor doctor;
	private Patient patient;
	public Terapy(Long id, List<Drug> drugs, Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.drugs = drugs;
		this.doctor = doctor;
		this.patient = patient;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Drug> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
