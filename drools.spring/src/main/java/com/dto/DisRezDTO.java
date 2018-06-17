package com.dto;

import java.util.List;

public class DisRezDTO {
	private List<String> diseases;

	public List<String> getDiseases() {
		return diseases;
	}
	public DisRezDTO(){}
	public void setDiseases(List<String> diseases) {
		this.diseases = diseases;
	}

	public DisRezDTO(List<String> diseases) {
		super();
		this.diseases = diseases;
	}
}
