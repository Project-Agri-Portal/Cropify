package com.cropify.dto;

import com.cropify.entity.enums.MachineType;

public class SellerMachineDTO {

	private Long sellerMachineDetailsId;
	private String machineId;
	private String machineName;
	private int quantity;
	private int availQuantity;
	private double price;
	private String description;
	

	private int machineCount;
	
	public int getMachineCount() {
		return machineCount;
	}

	public void setMachineCount(int machineCount) {
		this.machineCount = machineCount;
	}
	
	
	public SellerMachineDTO() {
	}
	
	public SellerMachineDTO(Long sellerMachineDetailsId, String machineId, String machineName, int quantity,
			int availQuantity, double price, String description) {
		super();
		this.sellerMachineDetailsId = sellerMachineDetailsId;
		this.machineId = machineId;
		this.machineName = machineName;
		this.quantity = quantity;
		this.availQuantity = availQuantity;
		this.price = price;
		this.description = description;
	}
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAvailQuantity() {
		return availQuantity;
	}
	public void setAvailQuantity(int availQuantity) {
		this.availQuantity = availQuantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSellerMachineDetailsId() {
		return sellerMachineDetailsId;
	}

	public void setSellerMachineDetailsId(Long sellerMachineDetailsId) {
		this.sellerMachineDetailsId = sellerMachineDetailsId;
	}

	
	
	
	
	
	
}
