package com.cropify.dto;

import com.cropify.entity.AgricultureProducts;
import com.cropify.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartAgricultureProductDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long cid;
	private String agriProdId;
	private Long farmerId;
	private Long sellerId;
	private int quantity;
	private double totalAmount;
}
