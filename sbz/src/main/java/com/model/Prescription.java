package com.model;

public class Prescription {
	private Long id;
	private Drug drug;
	
	public Prescription() {}

	public Prescription(Long id, Drug drug) {
		super();
		this.id = id;
		this.drug = drug;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}
}
