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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cropify.util.Prefixable;

@Entity
public class Machinery implements Prefixable {
	// This annotation specifies the respective field is not to be persisted
	@Transient
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
	
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SellerMachineryDetails> sellerMachineryDetails = new ArrayList<SellerMachineryDetails>();

	//---------------Constructos---------------
	
	public Machinery() {
//		super();
	}

	public Machinery(String machineId, String machineName, MachineType machineType) {
//		super();
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
	
	// ---------------------- Helper Methods ---------------------------------
	public void addSellerMachineryDetails(SellerMachineryDetails machineDetails) {
		sellerMachineryDetails.add(machineDetails);
		machineDetails.setMachineryId(this);
	}
	public void removeSellerMachineryDetails(SellerMachineryDetails machineDetails) {
		sellerMachineryDetails.remove(machineDetails);
		machineDetails.setMachineryId(null);
	}

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
}

