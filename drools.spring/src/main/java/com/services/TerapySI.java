package com.services;

import java.util.List;

import com.model.Terapy;

public interface TerapySI {
	public List<Terapy> getAll();
	public Terapy add(Terapy s);
	public void delete(Long id);
	public Terapy update(Terapy s);
	public Terapy findOne(Long id);
}
