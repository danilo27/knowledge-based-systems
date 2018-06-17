package com.model;

import java.util.Date;
import java.util.List;

public class Terapy {
	private Long id;
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	private List<Drug> drugs;
	private String disease;
	private User doctor;
	private Patient patient;
	private Date datum;
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	 
	public Terapy(Long id, List<Drug> drugs, 
			String disease, User doctor, Patient patient, Date datum) {
		super();
		this.id = id;
		this.drugs = drugs;
		this.disease = disease;
		this.doctor = doctor;
		this.patient = patient;
		this.datum = datum;
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
	public User getDoctor() {
		return doctor;
	}
	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Terapy(){}
	public boolean validate(String what){
		for(Drug d : drugs){
			if(d.getType().equals(what))
				return true;
		}
		return false;
	}
}
