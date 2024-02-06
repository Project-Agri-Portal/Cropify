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
	
	//-----------------------------Getter and Setters--------------------

	public FarmProducts getFarmProductId() {
		return farmProductId;
	}

	public void setFarmProductId(FarmProducts farmProductId) {
		this.farmProductId = farmProductId;
	}

	public UserDetails getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(UserDetails farmerId) {
		this.farmerId = farmerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(LocalDate harvestDate) {
		this.harvestDate = harvestDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public FarmProductsStatus getFarmProductStatus() {
		return farmProductStatus;
	}

	public void setFarmProductStatus(FarmProductsStatus farmProductStatus) {
		this.farmProductStatus = farmProductStatus;
	}
	
	//-----------------------------Getter and Setters--------------------
	
	
}
