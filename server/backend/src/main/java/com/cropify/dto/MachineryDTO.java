package com.cropify.dto;


import com.cropify.entity.enums.MachineType;

public class MachineryDTO {
	
	private String machineId;
	private String machineName;
	private MachineType machineType;
	
	// ------------------ Constructors ---------------------------
	public MachineryDTO() {}
	public MachineryDTO(String machineId) {
		this.machineId = machineId;
	}
	public MachineryDTO(String machineId, String machineName, MachineType machineType) {
		this.machineId = machineId;
		this.machineName = machineName;
		this.machineType = machineType;
	}

	//-------------Getters and Setters--------------------

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
