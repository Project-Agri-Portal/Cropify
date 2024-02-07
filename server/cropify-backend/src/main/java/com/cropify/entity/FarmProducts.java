package com.cropify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FarmProducts {
	@Id
	@Column(name = "farm_prod_id")
	private String farmProductId;
	
	@Column(name = "farm_prod_name")
	private String farmProductName;
	
	@Column(name = "farm_prod_type")
	@Enumerated(EnumType.STRING)
	private FarmProductType farmProductType;
	
	@OneToMany(mappedBy = "farmProductId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FarmerProductDetails> farmerProductDetails = new ArrayList<FarmerProductDetails>();
	
	//-----------------------------Constructors--------------------
		
	public FarmProducts(String farmProductId, String farmProductName, FarmProductType farmProductType,
			List<FarmerProductDetails> farmerProductDetails) {
		this.farmProductId = farmProductId;
		this.farmProductName = farmProductName;
		this.farmProductType = farmProductType;
		this.farmerProductDetails = farmerProductDetails;
	}
	
	public FarmProducts() {
		super();
	}
	
	//-----------------------------Getter and Setters--------------------

	/**
	 * @return the farmerProductDetails
	 */
	public List<FarmerProductDetails> getFarmerProductDetails() {
		return farmerProductDetails;
	}

	/**
	 * @param farmerProductDetails the farmerProductDetails to set
	 */
	public void setFarmerProductDetails(List<FarmerProductDetails> farmerProductDetails) {
		this.farmerProductDetails = farmerProductDetails;
	}

	public String getFarmProductId() {
		return farmProductId;
	}

	public void setFarmProductId(String farmProductId) {
		this.farmProductId = farmProductId;
	}

	public String getFarmProductName() {
		return farmProductName;
	}

	public void setFarmProductName(String farmProductName) {
		this.farmProductName = farmProductName;
	}

	public FarmProductType getFarmProductType() {
		return farmProductType;
	}

	public void setFarmProductType(FarmProductType farmProductType) {
		this.farmProductType = farmProductType;
	}
	
	
	
}
