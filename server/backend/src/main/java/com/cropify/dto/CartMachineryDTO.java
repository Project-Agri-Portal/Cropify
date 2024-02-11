package com.cropify.dto;

import com.cropify.entity.Machinery;
import com.cropify.entity.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartMachineryDTO {
	private Machinery machineId;
	private UserDetails farmerId;
	private UserDetails sellerId;
	private int quantity;
	private double totalAmount;
}
