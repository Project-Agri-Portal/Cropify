package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SellerAgricultureProductDetails {
	@ManyToOne	// owning
	@JoinColumn(name = "seller_id", nullable = false)
	private UserDetails sellerId;
	
	@JoinColumn(name = "seller_prod_id", nullable = false)
	private AgricultureProducts sellerAgriProductId;
	
	@Column
	private int quantity;
	
	@Column
	private double price;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	@Column(name = "seller_prod_status")
	@Enumerated(EnumType.STRING)
	private FarmProductsStatus sellerProductStatus;
	
}
