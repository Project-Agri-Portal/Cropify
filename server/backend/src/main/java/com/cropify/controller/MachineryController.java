package com.cropify.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.dto.MachineryDTO;
import com.cropify.entity.Machinery;
import com.cropify.services.MachineryService;


@RestController
@RequestMapping("/machinery")
public class MachineryController {
	
	@Autowired
	private MachineryService machineryService;
	
	@GetMapping
	public ResponseEntity<List<Machinery>> getAllMachine(){
		return ResponseEntity.status(HttpStatus.OK).body(machineryService.getAllMachine());
	}
	
	@PostMapping("/add")
	public ResponseEntity<MachineryDTO> addMachinery(@RequestBody @NotNull MachineryDTO machineryDTO) {
		System.out.println(machineryDTO);
		machineryService.addMachine(machineryDTO);
		return new ResponseEntity<>(machineryDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMachineById(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(machineryService.getMachineById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMachineById(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body("Machine " + id + " deleted");
	}
	
}
