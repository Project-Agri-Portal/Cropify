package com.cropify.dto;

import com.cropify.entity.AgricultureProducts;
import com.cropify.entity.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartAgricultureProductDTO {
	private Long cid;
	private AgricultureProducts agriProdId;
	private UserDetails farmerId;
	private UserDetails sellerId;
	private int quantity;
	private double totalAmount;
}
