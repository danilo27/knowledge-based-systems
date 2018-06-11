package com.model;

import java.util.List;

public class Disease {
	private Long id;
	private String name;
	private int type;
	private List<Symptom> symptoms;
	public Disease(Long id, String name, int type, List<Symptom> symptoms) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.symptoms = symptoms;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Symptom> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
}
