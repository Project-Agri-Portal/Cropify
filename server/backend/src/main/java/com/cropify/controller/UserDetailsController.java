package com.cropify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.UserDetailsDTO;
import com.cropify.services.UserDetailsService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@Validated
public class UserDetailsController {
	@Autowired
	UserDetailsService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<UserDetailsDTO>> getAllUsers()
	{
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PostMapping("/") 
	public ResponseEntity<UserDetailsDTO> createUser(@RequestBody @Valid UserDetailsDTO userDto)
	{
		UserDetailsDTO createdUserDto = userService.createUser(userDto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
}
