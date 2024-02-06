package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SellerMachineryDetails {

	@Column(name = "machine_id", nullable = false)
	private Machinery machineryId;

	@Column(name = "seller_id")
	private UserDetails sellerId;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(nullable = false)
	private boolean isAvailable;
	
}
