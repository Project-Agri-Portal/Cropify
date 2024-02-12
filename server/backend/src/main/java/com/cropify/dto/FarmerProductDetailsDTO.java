package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.cropify.entity.FarmProducts;
import com.cropify.entity.UserDetails;
import com.cropify.entity.enums.FarmProductsStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class FarmerProductDetailsDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long farmerProductDetailsId;
	private String farmProductId;
	private Long farmerId;
	private int quantity;
	private double price;
	private String description;
	private boolean verified;
	private LocalDate harvestDate;
	
	@Future
	private LocalDate expiryDate;
	private FarmProductsStatus farmProductStatus;
	
	//-----------------------------Getter and Setters--------------------
	public Long getFarmerProductDetailsId() {
		return farmerProductDetailsId;
	}
	public void setFarmerProductDetailsId(Long farmerProductDetailsId) {
		this.farmerProductDetailsId = farmerProductDetailsId;
	}
	public String getFarmProductId() {
		return farmProductId;
	}
	public void setFarmProductId(String farmProductId) {
		this.farmProductId = farmProductId;
	}
	public Long getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(Long farmerId) {
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
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
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
	
}
