package com.cropify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cropify.entity.enums.FarmProductType;
import com.cropify.util.Prefixable;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FarmProducts implements Prefixable {
	@Transient
	private String prefix = "f";
	
	@Id
	@GeneratedValue(generator = "customId")
	@GenericGenerator(name = "customId", strategy = "com.cropify.util.CustomIdGenerator")
	@Column(name = "farm_prod_id")
	private String farmProductId;
	
	@Column(name = "farm_prod_name", nullable = false)
	private String farmProductName;
	
	@Column(name = "farm_prod_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private FarmProductType farmProductType;
	
	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] imgPath;
	
	// ------------ Relationship Mapping ------------------------------
	@JsonIgnore
	@OneToMany(mappedBy = "farmProductId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FarmerProductDetails> farmerProductDetails = new ArrayList<FarmerProductDetails>();
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "farmProdId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<CartFarmProduct> cartFarmProductList = new ArrayList<>();
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "farmProdId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderFarmProductDetails> orderFarmProductDetails = new ArrayList<>();
	
	//-----------------------------Constructors--------------------
	public FarmProducts() {}
	public FarmProducts(String farmProductId) {
		this.farmProductId = farmProductId;
	}
	public FarmProducts(String farmProductId, String farmProductName, FarmProductType farmProductType) {
		this.farmProductId = farmProductId;
		this.farmProductName = farmProductName;
		this.farmProductType = farmProductType;
	}
	
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

	public byte[] getImgPath() {
		return imgPath;
	}

	public void setImgPath(byte[] imgPath) {
		this.imgPath = imgPath;
	}

	public List<FarmerProductDetails> getFarmerProductDetails() {
		return farmerProductDetails;
	}

	public void setFarmerProductDetails(List<FarmerProductDetails> farmerProductDetails) {
		this.farmerProductDetails = farmerProductDetails;
	}


//	public List<CartFarmProduct> getCartFarmProductList() {
//		return cartFarmProductList;
//	}
//
//	public void setCartFarmProductList(List<CartFarmProduct> cartFarmProductList) {
//		this.cartFarmProductList = cartFarmProductList;
//	}

//	public List<OrderFarmProductDetails> getOrderFarmProductDetails() {
//		return orderFarmProductDetails;
//	}
//
//	public void setOrderFarmProductDetails(List<OrderFarmProductDetails> orderFarmProductDetails) {
//		this.orderFarmProductDetails = orderFarmProductDetails;
//	}

//	@Override
//	public String toString() {
//		return "FarmProducts [farmProductId=" + farmProductId + ", farmProductName=" + farmProductName
//				+ ", farmProductType=" + farmProductType + ", farmerProductDetails=" + farmerProductDetails + "]";
//	}
	
	// ------------- Helper Methods ------------------------------
	public void addFarmProductDetails(FarmerProductDetails product) {
		farmerProductDetails.add(product);
		product.setFarmProductId(this);
	}
	public void removeFarmProductDetails(FarmerProductDetails product) {
		farmerProductDetails.remove(product);
		product.setFarmProductId(null);
	}
	
//	public void addCartFarmProduct(CartFarmProduct product) {
//		cartFarmProductList.add(product);
//		product.setFarmProdId(this);
//	}
//	public void removeCartFarmProduct(CartFarmProduct product) {
//		cartFarmProductList.remove(product);
//		product.setFarmProdId(null);
//	}

//	public void addOrderFarmProductDetails(OrderFarmProductDetails product) {
//		orderFarmProductDetails.add(product);
//		product.setFarmProdId(this);
//	}
//	public void removeOrderFarmProductDetails(OrderFarmProductDetails product) {
//		orderFarmProductDetails.remove(product);
//		product.setFarmProdId(null);
//	}
	// ------------ Inherited methods of Prefixable interface ---------------------
	@Override
	public String getPrefix() {
		return prefix;
	}
	@Override
	public String getTableName() {
		return "farm_products";
	}
	@Override
	public String getIdColName() {
		return "farm_prod_id";
	}
}
