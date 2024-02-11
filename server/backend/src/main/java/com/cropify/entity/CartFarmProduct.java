package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartFarmProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	// Mapped with farm_products table
	@ManyToOne
	@JoinColumn(name = "farm_prod_id", nullable = false)
	private FarmProducts farmProdId;
	
	// Mapped with user_details table for farmer id
	@ManyToOne
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;
	
	// Mapped with user_details table for seller_id
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private UserDetails customerId;
		
	@Column
	private int quantity;
	
	@Column(name = "total_amount")
	private double totalAmount;
}
