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
	private String verified;
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
<<<<<<< HEAD

	/**
	 * @return the farmProductId
	 */
//	public FarmProducts getFarmProductId() {
//		return farmProductId;
//	}
//
//	/**
//	 * @param farmProductId the farmProductId to set
//	 */
//	public void setFarmProductId(FarmProducts farmProductId) {
//		this.farmProductId = farmProductId;
//	}
//
//	/**
//	 * @return the farmerId
//	 */
//	public UserDetails getFarmerId() {
//		return farmerId;
//	}
//
//	/**
//	 * @param farmerId the farmerId to set
//	 */
//	public void setFarmerId(UserDetails farmerId) {
//		this.farmerId = farmerId;
//	}
	
	

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
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
	 * @param quantity the quantity to set
	 */
=======
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
>>>>>>> cf20758329fa4bd2875a3b56f5fceb413d5f36da
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
<<<<<<< HEAD

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

	public String isVerified() {
		return verified;
	}

	public void setVerified(String verified) {
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
