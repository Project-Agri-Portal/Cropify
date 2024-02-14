package com.cropify.dto;


import com.cropify.entity.enums.AgriProductType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class AgricultureProductsDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private String agriProductId;
	private String agriProductName;
	private AgriProductType agriProductType;
	private String imgPath;
	
	// ---------------- Constructors -------------------------------
	public AgricultureProductsDTO() {}
	public AgricultureProductsDTO(String agriProductId) {
		this.agriProductId = agriProductId;
	}
	public AgricultureProductsDTO(String agriProductId, String agriProductName, AgriProductType agriProductType,
			String imgPath) {
		this.agriProductId = agriProductId;
		this.agriProductName = agriProductName;
		this.agriProductType = agriProductType;
		this.imgPath = imgPath;
	}

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
