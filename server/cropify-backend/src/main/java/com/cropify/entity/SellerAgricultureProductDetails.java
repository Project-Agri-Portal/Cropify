package com.cropify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class SellerAgricultureProductDetails {
	@Column(name = "seller_id")
	private UserDetails sellerId;
	
	@Column(name = "seller_prod_id")
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
