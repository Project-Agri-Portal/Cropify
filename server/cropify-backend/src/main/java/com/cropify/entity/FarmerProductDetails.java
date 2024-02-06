package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FarmerProductDetails {

	@JoinColumn(name = "farm_prod_id", nullable = false)
	private FarmProducts farmProductId;

	@ManyToOne	// owning
	@JoinColumn(name = "farmer_id", nullable = false)
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
