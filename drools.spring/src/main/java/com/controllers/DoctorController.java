package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Doctor;
import com.model.User;
import com.repositories.UserRepo;
 

@RestController
public class DoctorController {
	private final UserRepo userRepo;
	@Autowired
	private DoctorController(UserRepo userRepo){
		this.userRepo = userRepo;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Doctors")
	public List<User> getAll(){ return userRepo.findAll(); }
	
	@RequestMapping(method = RequestMethod.GET, value = "/Doctor/get/{id}")
	public User getOne(@PathVariable Long id){ return userRepo.findOne(id);}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Doctor/add")
	public User add(@RequestBody User Doctor){ Doctor.setType("doctor"); Doctor.setId((Long)userRepo.count()); return userRepo.save(Doctor);}
 
	@RequestMapping(method = RequestMethod.DELETE, value = "/Doctor/{id}")
	public void delete(@PathVariable Long id){ userRepo.delete(id);}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Doctor")
	public void update(@RequestBody User doctor){ userRepo.save(doctor);}
}
