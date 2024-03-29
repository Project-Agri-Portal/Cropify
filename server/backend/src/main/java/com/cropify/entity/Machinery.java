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

import com.cropify.entity.enums.MachineType;
import com.cropify.util.Prefixable;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Machinery implements Prefixable {
	// This annotation specifies the respective field is not to be persisted
	@Transient
	@JsonIgnore
	private String prefix = "m";
	
	@Id
	@GeneratedValue(generator = "customId")
	@GenericGenerator(name = "customId", strategy = "com.cropify.util.CustomIdGenerator")
	@Column(name = "machine_id")
	private String machineId;
	
	@Column(name = "machine_name", nullable = false)
	private String machineName;
	
	@Column(name = "machine_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private MachineType machineType;
	
	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] imgPath;
	
	// ------------ Relationship Mapping ------------------------------
//	@JsonIgnore
	@OneToMany(mappedBy = "machineryId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SellerMachineryDetails> sellerMachineryDetails = new ArrayList<SellerMachineryDetails>();
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "machineId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<CartMachinery> cartMachinery = new ArrayList<>();
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "machineId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderMachineDetails> orderMachineDetails = new ArrayList<>();

	// -------------------------- Constructors ------------------------------
	public Machinery() {}

	public Machinery(String machineId, String machineName, MachineType machineType) {
		this.machineId = machineId;
		this.machineName = machineName;
		this.machineType = machineType;
	}

	//-----------------------------Getter and Setters--------------------
	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public MachineType getMachineType() {
		return machineType;
	}

	public void setMachineType(MachineType machineType) {
		this.machineType = machineType;
	}
	
//	public List<CartMachinery> getCartMachinery() {
//		return cartMachinery;
//	}
//
//	public void setCartMachinery(List<CartMachinery> cartMachinery) {
//		this.cartMachinery = cartMachinery;
//	}

	public List<SellerMachineryDetails> getSellerMachineryDetails() {
		return sellerMachineryDetails;
	}

	public void setSellerMachineryDetails(List<SellerMachineryDetails> sellerMachineryDetails) {
		this.sellerMachineryDetails = sellerMachineryDetails;
	}

//	public List<OrderMachineDetails> getOrderMachineDetails() {
//		return orderMachineDetails;
//	}
//
//	public void setOrderMachineDetails(List<OrderMachineDetails> orderMachineDetails) {
//		this.orderMachineDetails = orderMachineDetails;
//	}

	// ---------------------- Helper Methods ---------------------------------
	public void addSellerMachineryDetails(SellerMachineryDetails machineDetails) {
		sellerMachineryDetails.add(machineDetails);
		machineDetails.setMachineryId(this);
	}
	public void removeSellerMachineryDetails(SellerMachineryDetails machineDetails) {
		sellerMachineryDetails.remove(machineDetails);
		machineDetails.setMachineryId(null);
	}
	
	// ----- b) CartMachinery List -----
//	public void addCartMachinery(CartMachinery machine) {
//		cartMachinery.add(machine);
//		machine.setMachineId(this);
//	}
//	public void removeCartMachinery(CartMachinery machine) {
//		cartMachinery.remove(machine);
//		machine.setMachineId(null);
//	}
	
//	public void addOrderMachineDetails(OrderMachineDetails machine) {
//		orderMachineDetails.add(machine);
//		machine.setMachineId(this);
//	}
//	public void removeOrderMachineDetails(OrderMachineDetails machine) {
//		orderMachineDetails.remove(machine);
//		machine.setMachineId(null);
//	}

	// ------------------ To String --------------------------------------------
	@Override
	public String toString() {
		return "Machinery [machineId=" + machineId + ", machineName=" + machineName + ", machineType=" + machineType
				+ ", sellerMachineryDetails=" + sellerMachineryDetails + "]";
	}

	// ------------ Inherited methods of Prefixable interface ---------------------
	@Override
	public String getPrefix() {
		return prefix;
	}
	@Override
	public String getTableName() {
		return "machinery";
	}
	@Override
	public String getIdColName() {
		return "machine_id";
	}

	public byte[] getImgPath() {
		return imgPath;
	}

	public void setImgPath(byte[] imgPath) {
		this.imgPath = imgPath;
	}
}

