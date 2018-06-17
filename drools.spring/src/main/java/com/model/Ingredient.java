package com.model;

public class Ingredient {
	private Long id;
	private String name;
	public Ingredient() {}
	public Ingredient(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Ingredient(Integer id, String name) {
		super();
		this.id = id.longValue();
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
