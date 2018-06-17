package com.model;

import java.util.ArrayList;
import java.util.List;

public class Drug {
	private Long id;
	private String naziv;
	private String type;
	private List<Ingredient> ingridients;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Ingredient> getIngridients() {
		return ingridients;
	}
	public void setIngridients(List<Ingredient> ingridients) {
		this.ingridients = ingridients;
	}
	public Drug(Long id, String naziv, String type, List<Ingredient> ingridients) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.type = type;
		this.ingridients = ingridients;
	}
	 
	public Drug(){}
	
}
