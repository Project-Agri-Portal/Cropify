package com.cropify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.entity.UserDetails;
import com.cropify.services.UserDetailsService1;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

//	dependency is Service layer
	@Autowired
	private UserDetailsService1 detailsService1;
	
	public UserDetailsController() {
		System.out.println("constructor " + getClass());
	}
	
	@GetMapping
	public List<UserDetails> getAllUserDetails(){
		System.out.println("in UserDetailsController getAllUserDetails()");
		return detailsService1.getAllUsers();
	}
	
}
