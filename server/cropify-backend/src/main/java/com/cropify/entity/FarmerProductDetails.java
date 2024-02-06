package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

@Entity
public class FarmerProductDetails {
	@Column(name = "farm_prod_id")
	private FarmProducts farmProductId;

	@Column(name = "farmer_id")
	private UserDetails farmerId;
	
	@Column
	private int quantity;
	@Column
	private double price;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "harvest_date")
	private LocalDate harvestDate;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	@Column(name = "farm_prod_status")
	@Enumerated(EnumType.STRING)
	private FarmProductsStatus farmProductStatus;
	
}
