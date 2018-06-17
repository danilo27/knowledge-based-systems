package com.dto;

import java.util.ArrayList;
import java.util.List;

import com.model.Disease;

public class DroolsDTO {
	private List<String> symps;
	private List<Disease> diseases = new ArrayList<Disease>();
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	public DroolsDTO(){}
	public List<String> getSymps() {
		return symps;
	}
	public void setSymps(List<String> symps) {
		this.symps = symps;
	}
	
}
