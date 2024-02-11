package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartAgricultureProduct {
	// Mapped with agriculture_product table
	@ManyToOne
	@JoinColumn(name = "agri_prod_id", nullable = false)
	private AgricultureProducts agriProdId;
	
	// Mapped with user_details table for farmer id
	@ManyToOne
	@JoinColumn(name = "farmer_id", nullable = false)
	private UserDetails farmerId;
	
	// Mapped with user_details table for seller_id
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;
		
	@Column
	private int quantity;
	
	@Column(name = "total_amount")
	private double totalAmount;
}
