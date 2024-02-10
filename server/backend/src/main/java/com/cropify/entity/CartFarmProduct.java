package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartFarmProduct {
	@Column
	private int quantity;
	
	@Column(name = "total_amount")
	private double totalAmount;
}
