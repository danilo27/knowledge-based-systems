package com.dto;

import java.util.ArrayList;
import java.util.List;

public class SymptomsForDisDTO {
	private List<String> general = new ArrayList();
	private List<String> specific = new ArrayList();
	public List<String> getGeneral() {
		return general;
	}
	public void setGeneral(List<String> general) {
		this.general = general;
	}
	public List<String> getSpecific() {
		return specific;
	}
	public void setSpecific(List<String> specific) {
		this.specific = specific;
	}
	public SymptomsForDisDTO(){}
}
