package com.cropify.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	@Range(min = 8)
	private String password;
	
	@Column(name = "mobile_no", length = 10, nullable = false, unique = true)
	private long mobileNo;
	
	@Column(name = "user_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
//	@Column(nullable = false)
//	private String city;
//	@Column(nullable = false)
//	private String state;
//	@Column(nullable = false)
//	private String pincode;
//	@Column(nullable = false)
//	private String fullAddress;
	@Embedded
	private UserAddress userAddress;
	
//	if value is 0 then user/seller is not verify
//	if value is +ve then user/seller is verify
	@Column(nullable = false)
	private byte verify;

	@Column(nullable = false,unique = true)
	private long aadharNo;
	@Column(nullable = false,unique = true)
	private String panNo;
	
//	if seller has poor review or if seller is fraud
//	in such cases Admin can/has ability to block seller
//	if status is "block" then seller cannot sell any products
	@Column()
	private String status;
	
	// ------- Assigning various lists ------
	@OneToMany(mappedBy = "farmerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FarmerProductDetails> farmerProductDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SellerMachineryDetails> sellerMachineryDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SellerAgricultureProductDetails> sellerAgricultureProductDetails = new ArrayList<>();

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

	// ---------- Setters for Lists -------------

	/**
	 * @return the sellerMachineryDetails
	 */
	public List<SellerMachineryDetails> getSellerMachineryDetails() {
		return sellerMachineryDetails;
	}

	/**
	 * @param sellerMachineryDetails the sellerMachineryDetails to set
	 */
	public void setSellerMachineryDetails(List<SellerMachineryDetails> sellerMachineryDetails) {
		this.sellerMachineryDetails = sellerMachineryDetails;
	}

	/**
	 * @return the sellerAgricultureProductDetails
	 */
	public List<SellerAgricultureProductDetails> getSellerAgricultureProductDetails() {
		return sellerAgricultureProductDetails;
	}

	/**
	 * @param sellerAgricultureProductDetails the sellerAgricultureProductDetails to set
	 */
	public void setSellerAgricultureProductDetails(List<SellerAgricultureProductDetails> sellerAgricultureProductDetails) {
		this.sellerAgricultureProductDetails = sellerAgricultureProductDetails;
	}
	
	// -------------- Helper Methods for: --------------------
	// -------------- 1) farmer product details ---------
	public void addFarmerProductDetails(FarmerProductDetails productDetails) {
		farmerProductDetails.add(productDetails);
	}
	public void removeFarmerProductDetails(FarmerProductDetails productDetails) {
		farmerProductDetails.remove(productDetails);
	}
	
	// -------------- 2) seller machinery details ---------
	public void addSellerMachineryDetails(SellerMachineryDetails productDetails) {
		sellerMachineryDetails.add(productDetails);
	}
	public void removeSellerMachineryDetails(SellerMachineryDetails productDetails) {
		sellerMachineryDetails.remove(productDetails);
	}
	
	// -------------- 3) seller agri product details ---------
	public void addSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.add(productDetails);
	}
	public void removeSellerAgricultureProductDetails(SellerAgricultureProductDetails productDetails) {
		sellerAgricultureProductDetails.remove(productDetails);
	}
}
