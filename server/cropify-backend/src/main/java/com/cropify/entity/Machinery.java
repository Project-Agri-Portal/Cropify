package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Machinery {
	
	@Id
	@Column(name = "machine_id")
	private String machineId;
	
	@Column(name = "machine_name", nullable = false)
	private String machineName;
	
	@Column(name = "machine_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private MachineType machineType;	
}
