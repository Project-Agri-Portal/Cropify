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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cropify.entity.enums.AgriProductType;
import com.cropify.util.Prefixable;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "agri_prod_name", nullable = false)
	private String agriProductName;
	
	@Column(name = "agri_prod_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private AgriProductType agriProductType;
	
	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] imgPath;
	
	// ------------ Relationship Mapping ------------------------------
	@JsonIgnore
	@OneToMany(mappedBy = "agriProductId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SellerAgricultureProductDetails> sellerAgricultureProductDetails = new ArrayList<>();
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "agriProdId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<CartAgricultureProduct> cartAgricultureProductList = new ArrayList<>();
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "agricultureProductId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderAgricultureProductDetails> orderAgricultureProductDetails = new ArrayList<>();
	
	//-----------------------------Constructors--------------------
	
	public AgricultureProducts() {}
	
	public AgricultureProducts(String id) {
		this.agriProductId = id;
	}
	public AgricultureProducts(String agriProductId, String agriProductName, AgriProductType agriProductType) {
		this.agriProductId = agriProductId;
		this.agriProductName = agriProductName;
		this.agriProductType = agriProductType;
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
	
	public byte[] getImgPath() {
		return imgPath;
	}

	public void setImgPath(byte[] imgPath) {
		this.imgPath = imgPath;
	}

	public List<SellerAgricultureProductDetails> getSellerAgricultureProductDetails() {
		return sellerAgricultureProductDetails;
	}
	
	public void setSellerAgricultureProductDetails(List<SellerAgricultureProductDetails> sellerAgricultureProductDetails) {
		this.sellerAgricultureProductDetails = sellerAgricultureProductDetails;
	}
//	public List<CartAgricultureProduct> getCartAgricultureProductList() {
//		return cartAgricultureProductList;
//	}
//
//	public void setCartAgricultureProductList(List<CartAgricultureProduct> cartAgricultureProductList) {
//		this.cartAgricultureProductList = cartAgricultureProductList;
//	}


//	public List<OrderAgricultureProductDetails> getOrderAgricultureProductDetails() {
//		return orderAgricultureProductDetails;
//	}
//
//	public void setOrderAgricultureProductDetails(List<OrderAgricultureProductDetails> orderAgricultureProductDetails) {
//		this.orderAgricultureProductDetails = orderAgricultureProductDetails;
//	}

	// ---------------------- Helper Methods ---------------------------------
	public void addSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.add(productDetails);
		productDetails.setAgriProductId(this);
	}
	public void removeSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.remove(productDetails);
		productDetails.setAgriProductId(null);
	}
	
//	public void addCartAgricultureProduct(CartAgricultureProduct agriProduct)
//	{
//		cartAgricultureProductList.add(agriProduct);
//		agriProduct.setAgriProdId(this);
//	}
//	public void removeCartAgricultureProduct(CartAgricultureProduct agriProduct)
//	{
//		cartAgricultureProductList.remove(agriProduct);
//		agriProduct.setAgriProdId(null);
//	}
	
//	public void addOrderAgricultureProductDetails(OrderAgricultureProductDetails product) {
//		orderAgricultureProductDetails.add(product);
//		product.setAgricultureProductId(this);
//	}
//	public void removeOrderAgricultureProductDetails(OrderAgricultureProductDetails product) {
//		orderAgricultureProductDetails.remove(product);
//		product.setAgricultureProductId(null);
//	}

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
