package com.cropify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerMachineryDTO {
	
	private String mahineId;
	private String machineName;
	private String machineType;
	private Long sellerMachineId;
	private int availQuantity;
	private String description;
	private double price;
	private int quantity;
	private String verify;
	private Long sellerId;
}
