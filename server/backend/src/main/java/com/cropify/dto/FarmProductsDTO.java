package com.cropify.dto;

import com.cropify.entity.FarmProductType;

public class FarmProductsDTO {
	
	private String farmProductId;
	
	private String farmProductName;
	
	private FarmProductType farmProductType;

	
	//-----------------------------Getter and Setters--------------------
	
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
	 * @return the farmProductName
	 */
	public String getFarmProductName() {
		return farmProductName;
	}

	/**
	 * @param farmProductName the farmProductName to set
	 */
	public void setFarmProductName(String farmProductName) {
		this.farmProductName = farmProductName;
	}

	/**
	 * @return the farmProductType
	 */
	public FarmProductType getFarmProductType() {
		return farmProductType;
	}

	/**
	 * @param farmProductType the farmProductType to set
	 */
	public void setFarmProductType(FarmProductType farmProductType) {
		this.farmProductType = farmProductType;
	}
}