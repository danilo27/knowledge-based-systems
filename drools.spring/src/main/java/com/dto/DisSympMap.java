package com.dto;

public class DisSympMap {
	private String disease;
	private int numberOfSymptoms;
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public int getNumberOfSymptoms() {
		return numberOfSymptoms;
	}
	public void setNumberOfSymptoms(int numberOfSymptoms) {
		this.numberOfSymptoms = numberOfSymptoms;
	}
	public DisSympMap(){}
	public DisSympMap(String disease, int numberOfSymptoms) {
		super();
		this.disease = disease;
		this.numberOfSymptoms = numberOfSymptoms;
	}
	public DisSympMap(String disease, Number numberOfSymptoms) {
		super();
		this.disease = disease;
		this.numberOfSymptoms = numberOfSymptoms.intValue();
	}
	
}
