package com.model;

import java.util.List;

public class Patient {
	private Long id;
	private String firstname;
	private String lastname;
	private List<Ingredient> alergies;
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
	
}
