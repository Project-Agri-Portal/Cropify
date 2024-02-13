package com.cropify.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;

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
	private String verified;

	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate harvestDate;
	
	@Future
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	private FarmProductsStatus farmProductStatus;
	/**
	 * @return the farmerProductDetailsId
	 */
	public Long getFarmerProductDetailsId() {
		return farmerProductDetailsId;
	}
	/**
	 * @param farmerProductDetailsId the farmerProductDetailsId to set
	 */
	public void setFarmerProductDetailsId(Long farmerProductDetailsId) {
		this.farmerProductDetailsId = farmerProductDetailsId;
	}
	/**
	 * @return the farmProductId
	 */
	public String getFarmProductId() {
		return farmProductId;
	}
	/**
	 * @param farmProductId the farmProductId to set
	 */
	public void setFarmProductId(String farmProductId) {
		this.farmProductId = farmProductId;
	}
	/**
	 * @return the farmerId
	 */
	public Long getFarmerId() {
		return farmerId;
	}
	/**
	 * @param farmerId the farmerId to set
	 */
	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the verified
	 */
	public String getVerified() {
		return verified;
	}
	/**
	 * @param verified the verified to set
	 */
	public void setVerified(String verified) {
		this.verified = verified;
	}
	/**
	 * @return the harvestDate
	 */
	public LocalDate getHarvestDate() {
		return harvestDate;
	}
	/**
	 * @param harvestDate the harvestDate to set
	 */
	public void setHarvestDate(LocalDate harvestDate) {
		this.harvestDate = harvestDate;
	}
	/**
	 * @return the expiryDate
	 */
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the farmProductStatus
	 */
	public FarmProductsStatus getFarmProductStatus() {
		return farmProductStatus;
	}
	/**
	 * @param farmProductStatus the farmProductStatus to set
	 */
	public void setFarmProductStatus(FarmProductsStatus farmProductStatus) {
		this.farmProductStatus = farmProductStatus;
	}
	
	//-----------------------------Getter and Setters--------------------

	
	
}
