package com.cropify.dto;

import com.cropify.entity.FarmProducts;
import com.cropify.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartFarmProductDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long cid;
	private String farmProdId;
	private Long farmerId;
	private Long customerId;
	private int quantity;
	private double totalAmount;
}
