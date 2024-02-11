package com.cropify.dto;

import com.cropify.entity.FarmProducts;
import com.cropify.entity.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartFarmProductDTO {
	private FarmProducts farmProdId;
	private UserDetails farmerId;
	private UserDetails customerId;
	private int quantity;
	private double totalAmount;
}
