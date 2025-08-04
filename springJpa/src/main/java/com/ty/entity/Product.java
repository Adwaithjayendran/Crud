package com.ty.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	private String prodName;
	private int prodCost;
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdCost() {
		return prodCost;
	}
	public void setProdCost(int prodCost) {
		this.prodCost = prodCost;
	}
	public Product(String prodName, int prodCost) {
		super();
		this.prodName = prodName;
		this.prodCost = prodCost;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCost=" + prodCost + "]";
	}
	
	

}
