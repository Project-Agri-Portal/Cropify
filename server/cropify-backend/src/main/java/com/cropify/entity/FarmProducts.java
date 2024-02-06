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
	
	//-----------------------------Getter and Setters--------------------

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
