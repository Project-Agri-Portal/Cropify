package com.cropify.dto;


import com.cropify.entity.AgriProductType;

public class AgricultureProductsDTO {
	
	private String agriProductId;
	
	private String agriProductName;
	
	private AgriProductType agriProductType;
	
	
	//-----------------------------Getter and Setters--------------------
	
	/**
	 * @return the agriProductId
	 */
	public String getAgriProductId() {
		return agriProductId;
	}

	/**
	 * @param agriProductId the agriProductId to set
	 */
	public void setAgriProductId(String agriProductId) {
		this.agriProductId = agriProductId;
	}

	/**
	 * @return the agriProductName
	 */
	public String getAgriProductName() {
		return agriProductName;
	}

	/**
	 * @param agriProductName the agriProductName to set
	 */
	public void setAgriProductName(String agriProductName) {
		this.agriProductName = agriProductName;
	}

	/**
	 * @return the agriProductType
	 */
	public AgriProductType getAgriProductType() {
		return agriProductType;
	}

	/**
	 * @param agriProductType the agriProductType to set
	 */
	public void setAgriProductType(AgriProductType agriProductType) {
		this.agriProductType = agriProductType;
	}
}
