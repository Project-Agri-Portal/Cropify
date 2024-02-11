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
public class CartMachinery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	// Mapped with machinery table
	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false)
	private Machinery machineId;
	
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
