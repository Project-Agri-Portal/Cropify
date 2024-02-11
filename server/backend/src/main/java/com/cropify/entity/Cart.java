package com.cropify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Cart {
	
	@Column
	private UserDetails userId;
	
	@Column
	private UserDetails sellerId;
	
	@Column
	private FarmProducts farmProducts;
	
}
