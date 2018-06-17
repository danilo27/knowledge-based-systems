package com.services;

import java.util.ArrayList;
import java.util.List;

import com.dto.DiagnoseDTO;
import com.dto.DisSympMap;
import com.dto.SymptomsForDisDTO;
import com.dto.ValidationDTO;
import com.model.Disease;

public interface DiagnoseSI {
	Disease mostProbable(DiagnoseDTO d);
	List<DisSympMap> allPossible(ArrayList<String> symptoms);
	List<String> validate(ValidationDTO v);
	SymptomsForDisDTO getSympsForDisease(String d);
}
