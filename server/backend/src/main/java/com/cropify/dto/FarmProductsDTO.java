package com.cropify.dto;


import com.cropify.entity.enums.FarmProductType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class FarmProductsDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private String farmProductId;
	private String farmProductName;
	private FarmProductType farmProductType;
	private String path;

	// ------------------ Constructors ----------------------
	public FarmProductsDTO() {}
	public FarmProductsDTO(String farmProductId) {
		super();
		this.farmProductId = farmProductId;
	}
	public FarmProductsDTO(String farmProductId, String farmProductName, FarmProductType farmProductType, String path) {
		super();
		this.farmProductId = farmProductId;
		this.farmProductName = farmProductName;
		this.farmProductType = farmProductType;
		this.path = path;
	}

	//-----------------------------Getter and Setters--------------------
	/**
	 * @return the farmProductId
	 */
	public String getFarmProductId() {
		return farmProductId;
	}
	public void setPath(String path){
		this.path = path;
	}
	public String getPath(){
		return this.path;
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
