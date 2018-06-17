package com.dto;

import java.util.ArrayList;
import java.util.List;

public class DiagnoseDTO {
	private List<String> symps = new ArrayList();

	public DiagnoseDTO(List<String> symps) {
		super();
		this.symps = symps;
	}
	public DiagnoseDTO(){}
	public List<String> getSymps() {
		return symps;
	}

	public void setSymps(List<String> symps) {
		this.symps = symps;
	}
}
