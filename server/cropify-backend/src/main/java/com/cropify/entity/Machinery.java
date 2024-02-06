package com.cropify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SellerMachineryDetails> sellerMachineryDetails = new ArrayList<SellerMachineryDetails>();
	
	//-----------------------------Getter and Setters--------------------

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public MachineType getMachineType() {
		return machineType;
	}

	public void setMachineType(MachineType machineType) {
		this.machineType = machineType;
	}
	
	
}
