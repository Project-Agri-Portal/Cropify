package com.cropify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cropify.entity.Machinery;
import com.cropify.services.MachineryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/machinery")
public class MachineryController {
	
	@Autowired
	private MachineryService machineryService;
	
	@GetMapping
	public List<Machinery> getAllMachine(){
		return machineryService.getAllMachine();
	}
	
	@PostMapping("/add")
	public void addMachinery(@RequestBody Machinery machinery) {
		System.out.println(machinery);
		machineryService.addMachine(machinery);
	}
	
//	@GetMapping("/{name}/{id}")
//	public void updateMachine(@RequestParam String name, @RequestParam String id) {
//		machineryService.updateMachine(name, id);
//	}
	
}
