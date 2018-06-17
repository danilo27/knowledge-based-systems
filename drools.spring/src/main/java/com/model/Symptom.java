package com.model;

public class Symptom {
	private Long id;
	private String name;
	private boolean specific = false;
	public boolean isSpecific() {
		return specific;
	}
	public void setSpecific(boolean specific) {
		this.specific = specific;
	}
	public Symptom() {}
	public Symptom(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
