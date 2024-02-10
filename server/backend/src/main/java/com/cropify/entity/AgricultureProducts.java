package com.cropify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cropify.util.Prefixable;

@Entity
public class AgricultureProducts implements Prefixable {
	// This annotation specifies the respective field is not to be persisted
	@Transient
	private String prefix = "p";
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "customId")
	@GenericGenerator(name = "customId", strategy = "com.cropify.util.CustomIdGenerator")
	@Column(name = "agri_prod_id")
	private String agriProductId;
	
	@Column(name = "agri_prod_name")
	private String agriProductName;
	
	@Column(name = "agri_prod_type")
	@Enumerated(EnumType.STRING)
	private AgriProductType agriProductType;
	
	@OneToMany(mappedBy = "agriProductId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SellerAgricultureProductDetails> sellerAgricultureProductDetails = new ArrayList<>();
	
	//-----------------------------Constructors--------------------
	
	public AgricultureProducts(String agriProductId, String agriProductName, AgriProductType agriProductType) {
		this.agriProductId = agriProductId;
		this.agriProductName = agriProductName;
		this.agriProductType = agriProductType;
	}
	
	public AgricultureProducts() {
		
	}
	
	//-----------------------------Getter and Setters--------------------

	public String getAgriProductId() {
		return agriProductId;
	}

	public void setAgriProductId(String agriProductId) {
		this.agriProductId = agriProductId;
	}

	public String getAgriProductName() {
		return agriProductName;
	}

	public void setAgriProductName(String agriProductName) {
		this.agriProductName = agriProductName;
	}

	public AgriProductType getAgriProductType() {
		return agriProductType;
	}

	public void setAgriProductType(AgriProductType agriProductType) {
		this.agriProductType = agriProductType;
	}
	
	
	// ---------------------- Helper Methods ---------------------------------
	public void addSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.add(productDetails);
		productDetails.setAgriProductId(this);
	}
	public void removeSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.remove(productDetails);
		productDetails.setAgriProductId(null);
	}

	// ------------ Inherited methods of Prefixable interface ---------------------
	@Override
	public String getPrefix() {
		return prefix;
	}
	@Override
	public String getTableName() {
		return "agriculture_products";
	}
	@Override
	public String getIdColName() {
		return "agri_prod_id";
	}
}
