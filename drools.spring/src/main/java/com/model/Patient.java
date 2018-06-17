package com.model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	private Long id;
	private String firstname;
	private String lastname;
	private List<Ingredient> alergies;
	private List<String> drugAllergies = new ArrayList();
	private List<Terapy> terapies = new ArrayList();
	private List<String> report_warnings = new ArrayList();
	private int threatedBy = 0;
	public List<String> getReport_warnings() {
		return report_warnings;
	}
	public void setReport_warnings(List<String> report_warnings) {
		this.report_warnings = report_warnings;
	}
	public List<Terapy> getTerapies() {
		return terapies;
	}
	public void setTerapies(List<Terapy> terapies) {
		this.terapies = terapies;
	}
	public List<String> getDrugAllergies() {
		return drugAllergies;
	}
	public void setDrugAllergies(List<String> drugAllergies) {
		this.drugAllergies = drugAllergies;
	}
	 
	private List<DiseaseHistory> history;
	public Patient(Long id, String firstname, String lastname, List<Ingredient> alergies,
			List<DiseaseHistory> history) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.alergies = alergies;
		this.history = history;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Ingredient> getAlergies() {
		return alergies;
	}
	public void setAlergies(List<Ingredient> alergies) {
		this.alergies = alergies;
	}
	public List<DiseaseHistory> getHistory() {
		return history;
	}
	public void setHistory(List<DiseaseHistory> history) {
		this.history = history;
	}
	public Patient(){}
	public int getThreatedBy(){
		ArrayList<String> list = new ArrayList();
		int br=0;
		for(Terapy t : terapies){
			if(!list.contains(t.getDoctor().getUsername())){
				br++;
				list.add(t.getDoctor().getUsername());
			}
		}
		return br;
	}
}
