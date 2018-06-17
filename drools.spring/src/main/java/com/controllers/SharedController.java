package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repositories.UserRepo;

@RestController

public class SharedController {
	
	
	private final UserRepo userRepo;
	@Autowired
	public SharedController(UserRepo userRepo){
		this.userRepo = userRepo;
	}
	@RequestMapping(
			value = "/login", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public String login(@RequestBody UserDTO user) throws JsonProcessingException{
		System.out.println("Login...");
		if (userRepo.findByUsername(user.getUsername()) != null){
			if(userRepo.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())){
				ObjectMapper mapper = new ObjectMapper();
				String u = mapper.writeValueAsString(userRepo.findByUsername(user.getUsername()));				
				return u;
			}
		}   
		return null;
		
	}
}
