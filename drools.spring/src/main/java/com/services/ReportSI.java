package com.services;

import java.util.List;

import com.model.Patient;
import com.model.Report;

public interface ReportSI {
	public List<Report> getAll();
	public Report add(Report s);
	public void delete(Long id);
	public Report update(Report s);
	public Report findOne(Long id);
	public List<Patient> getChronics();
	public List<Patient> getAddicts();
	public List<Patient> getLows();
}

